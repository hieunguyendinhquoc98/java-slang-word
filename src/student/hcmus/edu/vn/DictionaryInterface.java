package student.hcmus.edu.vn;

import java.util.Map;
import java.util.Set;

public interface DictionaryInterface {

    boolean isEmpty();

    int size();

    Set<Map.Entry<String, String>> lookup(String key);

    void insert(String key, String value) throws DuplicateKeyException;

    void delete(String key) throws KeyNotFoundException;

    void makeEmpty();

    String toString();
}
