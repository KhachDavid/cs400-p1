// --== CS400 File Header Information ==--
// Name: David Khachatryan
// Email: dkhachatryan@wisc.edu
// Team: Red
// Group: CF
// TA: Xi Chen
// Lecturer: Gary

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This is a generic class that represents the behavior of a hash table
 * @param <KeyType>
 * @param <ValueType>
 */
public class HashTableMap<KeyType, ValueType> implements MapADT<KeyType, ValueType> {

  public int size;
  private LinkedList<KeyAndValue>[] keyAndValues;

  /**
   * Initialize the hash table array of linked lists that contain keys and values
   * @param capacity is the given capacity
   */
  public HashTableMap(int capacity) {
    this.size = capacity;
    this.keyAndValues = (LinkedList<KeyAndValue>[]) new LinkedList[this.size];
  }

  /**
   * Initialize with a default value of 10
   */
  public HashTableMap() {
    this.size = 10;
    this.keyAndValues =  (LinkedList<KeyAndValue>[]) new LinkedList[this.size];
  }

  /**
   * Insert the key-value pair into the hash table
   * @param key is the given key
   * @param value is the given value
   * @return true if successfully inserted in the hash table, false otherwise
   */
  @Override
  public boolean put(KeyType key, ValueType value) {

    if (key == null || value == null) {
      return false;
    }

    // Avoid inserting the same key
//    if (containsKey(key)) {
//      return false;
//    }

    // Get the index of the key in the array
    int index = Math.abs(key.hashCode()) % this.size;
    KeyAndValue kAndV = new KeyAndValue(key, value);

    try {
      // Add to the last index (Which is technically the next index
      // Because we are using a singly linked list
      keyAndValues[index].addLast(kAndV);
    }

    catch (NullPointerException e) {
      // If the linked list doesn't exist
      // It means that this is the first element
      // Being inserted in this index

      // Initialize linked list
      keyAndValues[index] = new LinkedList<>();
      keyAndValues[index].addFirst(kAndV);
    }

    // If overloaded, grow the array
    if ((float) this.size() / this.size >= 0.85 ) {
      reHash();
    }

    return true;
  }

  /**
   * @param key is the given key
   * @return the value associated with the given key
   * @throws NoSuchElementException if the given key doesn't exist
   */
  @Override
  public List<ValueType> get(KeyType key) throws NoSuchElementException {

    if (key == null) return null;

    // Get the array index of the key
    int index = Math.abs(key.hashCode()) % this.size;

    if (keyAndValues[index] == null) {
      throw new NoSuchElementException();
    }

    int counter = 0;
    List<ValueType> lst = new ArrayList<ValueType>();
    // Loop over the linked list, until the key is found
    while (keyAndValues[index].get(counter) != null) {

      if (containsNumber(key)) {
        if (keyAndValues[index].get(counter).key.equals(key)) {
          lst.add((ValueType) keyAndValues[index].get(counter).getValue(key));
          counter++;
          if (counter == keyAndValues[index].size()) break;
        }
        else{
          counter++;
          if (counter == keyAndValues[index].size()) break;
        }
      }
      else {
        lst.add((ValueType) keyAndValues[index].get(counter).getValue(key));
        counter++;
        if (counter == keyAndValues[index].size()) break;
      }
      // If the counter reaches the last element in the linked list
      // It means that the key is not here, so it is index in this array
      // is filled with other elements (f.e. there is 11 and 21, but we are looking for 31)
      //if (counter == keyAndValues[index].size() + 1) throw new NoSuchElementException();;
    }
    System.out.println(1);
    return lst;
  }

  private boolean containsNumber(KeyType key) {
    String a = (String) key;
    for (char c : a.toCharArray())
    {
      if (Character.isDigit(c))
      {
        return true;
      }
    }
    return false;
  }

  /**
   * @return the number of key-value pairs stored in this hash table
   */
  @Override
  public int size() {
    int counter = 0;
    for (LinkedList<KeyAndValue> keyAndValue : keyAndValues) {
      if (keyAndValue != null) {
        counter = counter + keyAndValue.size();
      }
    }
    return counter;
  }

  /**
   *
   * @param key is the given key
   * @return true if the key is in this hash table, false otherwise
   */
  @Override
  public boolean containsKey(KeyType key) {
    // Loop over every single linked list
    for (LinkedList<KeyAndValue> keyAndValue : keyAndValues) {
      if (keyAndValue != null) {
        // Loop over every single element in the linked list
        for (KeyAndValue kvPair : keyAndValue) {
          if (kvPair.key == key) {
            return true;
          }
        }
      }
    }
    return false;
  }

  /**
   * Remove the given key
   * @param key is the given key
   * @return the value of the given key
   */
  @Override
  public ValueType remove(KeyType key) {
    int index = Math.abs(key.hashCode()) % this.size;
    if (containsKey(key)) {
      ValueType returnValue = (ValueType) get(key); //(ValueType) keyAndValues[index].getFirst().value;

      int counter = 0;

      // Find the position of the key in the respective linked list
      while (keyAndValues[index].get(counter).key != key) {
        counter++;
        if (counter == keyAndValues[index].size()) break;
      }

      keyAndValues[index].remove(counter);
      if (keyAndValues[index].isEmpty()) keyAndValues[index] = null;

      return returnValue;
    }

    // If the key is not in the table, return null
    return null;
  }

  /**
   * Clear the hash table
   */
  @Override
  public void clear() {
    for (int i = 0; i < keyAndValues.length; i++) {
      if (keyAndValues[i] != null) {
        keyAndValues[i] = null;
      }
    }
  }

  /**
   * A callback method which is triggered when 85% of
   * the hash table is occupied
   * This method re-hashes every element and doubles the size of the table
   */
  public void reHash() {
    this.size = this.size * 2;
    LinkedList<KeyAndValue>[] keyAndValuesReplace = (LinkedList<KeyAndValue>[]) new LinkedList[this.size];
    KeyAndValue[] arr = getAllKVpairs();

    for (KeyAndValue andValue : arr) {
      int index = Math.abs(andValue.key.hashCode()) % this.size;
      try {
        keyAndValuesReplace[index].addLast(andValue);
      }

      catch (NullPointerException e) {
        keyAndValuesReplace[index] = new LinkedList<>();
        keyAndValuesReplace[index].addFirst(andValue);
      }
    }

    keyAndValues = keyAndValuesReplace;
  }

  /**
   * @return an array representation of every key-value type variable in the hash table
   */
  private KeyAndValue[] getAllKVpairs() {
    KeyAndValue[] arr = new KeyAndValue[size()];
    for (LinkedList<KeyAndValue> keyAndValue : keyAndValues) {
      if (keyAndValue != null) {
        for (KeyAndValue andValue : keyAndValue) {
          // use the add to an array method to add every element to this array
          addToAnArray(andValue, arr);
        }
      }
    }

    return arr;
  }

  /**
   * A helper method that adds a variable to the first non-null index of a given array
   * @param valueToAdd is the variable that must be added
   * @param arr is the given array
   */
  private void addToAnArray(KeyAndValue valueToAdd, KeyAndValue[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) {
        arr[i] = valueToAdd;
        return;
      }
    }
  }
}
