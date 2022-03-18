package student.hcmus.edu.vn;

import java.util.Map;
import java.util.Set;

public interface DictionaryInterface {

    public boolean isEmpty();

    public int size();

    public Set<Map.Entry<String, String>> lookup(String key);

    public void insert(String key, String value) throws DuplicateKeyException;

    public void delete(String key) throws KeyNotFoundException;

    public void makeEmpty();

    public String toString();
}
