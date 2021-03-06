// --== CS400 File Header Information ==--
// Name: David Khachatryan
// Email: dkhachatryan@wisc.edu
// Team: Red
// Group: CF
// TA: Xi Chen
// Lecturer: Gary

import java.util.List;
import java.util.NoSuchElementException;

/**
 * An interface used to implement a hash table
 * @param <KeyType>
 * @param <ValueType>
 */
public interface MapADT<KeyType, ValueType> {
  public boolean put(KeyType key, ValueType value);
  public List<ValueType> get(KeyType key) throws NoSuchElementException;
  public int size();
  public boolean containsKey(KeyType key);
  public ValueType remove(KeyType key);
  public void clear();
}
