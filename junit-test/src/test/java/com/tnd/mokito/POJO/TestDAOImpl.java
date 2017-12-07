package com.tnd.mokito.POJO;

import java.util.HashMap;
import java.util.Map;

public class TestDAOImpl implements TestDAO {

    private static Map<String, String> data = new HashMap<String, String>();

    public void dummy() {
        data.put("D", "Default");
    }

    public Map<String, String> get() {
        return data;
    }

    public String get(String key) {
        data.put("D", "Default");

        return data.get(key);
    }

    public boolean insert(String key, String value) {
        return data.put(key, value) != null;
    }

    public boolean insert(Test entry) {
        return data.put(entry.getKey(), entry.getValue()) != null;
    }

    public boolean update(String key, String value) {
        return data.put(key, value) != null;
    }

    public void delete(String key) {
        data.remove(key);
    }
}
