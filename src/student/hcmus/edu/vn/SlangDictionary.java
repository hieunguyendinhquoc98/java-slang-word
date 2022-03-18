package student.hcmus.edu.vn;

import java.util.Map;
import java.util.Set;

public class SlangDictionary implements DictionaryInterface {

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Set<Map.Entry<String, String>> lookup(String key) {
        return null;
    }

    @Override
    public void insert(String key, String value) throws DuplicateKeyException {

    }

    @Override
    public void delete(String key) throws KeyNotFoundException {

    }

    @Override
    public void makeEmpty() {

    }
}
