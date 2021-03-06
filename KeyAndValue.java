// --== CS400 File Header Information ==--
// Name: David Khachatryan
// Email: dkhachatryan@wisc.edu
// Team: Red
// Group: CF
// TA: Xi Chen
// Lecturer: Gary

/**
 * This is a wrapper class that wraps KeyType and ValueType in one class
 * @param <KeyType>
 * @param <ValueType>
 */
public class KeyAndValue<KeyType, ValueType> {

  KeyType key;
  ValueType value;


  /**
   * Constructor method for Key And Value
   * @param key = key
   * @param value = value
   */
  public KeyAndValue(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }

  /**
   * @param value is the given value
   * @return the key for the value
   */
  KeyType getKey(ValueType value) {
    return this.key;
  }

  /**
   * @param key is the given key
   * @return the value for the key
   */
  ValueType getValue(KeyType key) {
    return this.value;
  }

}
