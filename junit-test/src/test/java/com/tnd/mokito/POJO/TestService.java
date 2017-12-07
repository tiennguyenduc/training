package com.tnd.mokito.POJO;

import java.util.Map;

public class TestService {

    private TestDAO testDAO;

    public void setTestDAO(TestDAO testDAO) {
        this.testDAO = testDAO;
    }

    public Map<String, String> get() {
        return testDAO.get();
    }

    public String getValue(String key) {
        return testDAO.get(key);
    }

    public void delete(String key) {
        testDAO.delete(key);
    }

    public void insertOrUpdate(String key, String value) {
        if (null == testDAO.get(key)) {
            testDAO.insert(key, value);
        } else {
            testDAO.update(key, value);
        }
    }

    public boolean insert(Test entry) {
        return testDAO.insert(entry);
    }

    public boolean callPrivateMethod() {
        return privateMethod();
    }

    private boolean privateMethod() {
        return false;
    }

    public boolean callStaticMethod() {
        return staticMethod();
    }

    public static boolean staticMethod() {
        return false;
    }

}
