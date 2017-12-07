package com.tnd.mokito.POJO;

import java.util.Map;

public interface TestDAO {
    /**
     * TestDAO : get, add, modify, remove data in Map<String key, String value>
     */

    Map<String, String> get();

    String get(String key);

    boolean insert(String key, String value);

    boolean insert(Test entry);

    boolean update(String key, String value);

    void delete(String key);

}
