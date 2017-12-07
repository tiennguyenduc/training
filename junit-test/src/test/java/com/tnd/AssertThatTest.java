package com.tnd;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static com.tnd.matcher.LessThanOrEqual.lessThanOrEqual;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsCollectionContaining.hasItem;


public class AssertThatTest {

//    @Test
//    public void test() {
//
//        List<Integer> actual = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//
//        //All passed / true
//
//        //1. Test equal.
//        MatcherAssert.assertThat(actual, CoreMatchers.is(expected));
//
//        //2. Check List has this value
//        MatcherAssert.assertThat(actual, hasItems(2));
//
//        //3. Check List Size
//        //MatcherAssert.assertThat(actual, IsCollectionWithSize.hasSize(4));
//
//        MatcherAssert.assertThat(actual.size(), CoreMatchers.is(5));
//
//        //4.  List order
//
//        // Ensure Correct order
//        MatcherAssert.assertThat(actual, contains(1, 2, 3, 4, 5));
//
//        // Can be any order
//        MatcherAssert.assertThat(actual, containsInAnyOrder(5, 4, 3, 2, 1));
//
//        //5. check empty list
//        MatcherAssert.assertThat(actual, not(IsEmptyCollection.empty()));
//
//        MatcherAssert.assertThat(new ArrayList<>(), IsEmptyCollection.empty());
//
//        //6. Test numeric comparisons
//        MatcherAssert.assertThat(actual, everyItem(greaterThanOrEqualTo(1)));
//
//        MatcherAssert.assertThat(actual, everyItem(lessThan(10)));
//
//    }

    @Test
    public void verify_Strings() throws Exception {
        String name = "John Jr Dale";

        assertThat(name, startsWith("John"));
        assertThat(name, endsWith("Dale"));
        assertThat(name, containsString("Jr"));
    }

    @Test
    public void verify_collection_values() throws Exception {
        List<Double> salary = Arrays.asList(50.0, 200.0, 500.0);

        assertThat(salary, hasItem(50.00));
        assertThat(salary, hasItems(50.00, 200.00));
        assertThat(salary, not(hasItem(1.00)));
    }

    @Test
    public void verify_multiple_values() throws Exception {
        double marks = 100.00;

        assertThat(marks, either(is(100.00)).or(is(90.9)));
        assertThat(marks, both(not(99.99)).and(not(60.00)));
        assertThat(marks, anyOf(is(100.00), is(1.00), is(55.00), is(88.00), is(67.8)));
        assertThat(marks, not(anyOf(is(0.00), is(200.00))));
        assertThat(marks, not(allOf(is(1.00), is(100.00), is(30.00))));
    }

    @Test
    public void lessthanOrEquals_custom_matcher() throws Exception {
        int actualGoalScored = 2;
        assertThat(actualGoalScored, lessThanOrEqual(4));
        assertThat(actualGoalScored, lessThanOrEqual(2));

        double originalPI = 3.14;
        assertThat(originalPI, lessThanOrEqual(9.00));

        String authorName = "Sujoy";
        assertThat(authorName, lessThanOrEqual("Zachary"));
    }

}
