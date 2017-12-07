package com.tnd.mokito.POJO;

import org.mockito.ArgumentMatcher;

public class DefaultTestMatcher implements ArgumentMatcher<Test> {

    public boolean matches(Test argument) {
        return "D".equalsIgnoreCase(argument.getKey());
    }

}
