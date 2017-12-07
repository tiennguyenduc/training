package com.tnd.category;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@IncludeCategory(CrazyTests.class)
//@ExcludeCategory(SmartTests.class)
@SuiteClasses( { SomeTest.class, OtherTest.class })
public class CrazyTestSuite {
    // will run SomeTest.b and OtherTest.c, but not SomeTest.a
    // when uncomment @ExcludeCategory(SmartTests.class), will run SomeTest.b, but not SomeTest.a or OtherTest.c
}