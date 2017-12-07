package com.tnd;

import java.util.Date;

public class MockPrivateMethodExample {

    public String getDetails() {
        return "Mock private method example: " + iAmPrivate();
    }

    private String iAmPrivate() {
        return new Date().toString();
    }

}
