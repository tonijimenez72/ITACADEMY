package n2exercise1;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.hamcrest.Matcher;
import org.hamcrest.FeatureMatcher;


public class StringLengthMatcherTest {
    @Test
    public void testStringLength() {
        StringLengthMatcher test = new StringLengthMatcher("Mordor", 8);
        assertThat(test.getString(), length(is(test.getLength())));
    }

    public static Matcher<String> length(Matcher<? super Integer> matcher) {
        return new FeatureMatcher<String, Integer>(matcher, "a String of length that", "length") {
            @Override
            protected Integer featureValueOf(String actual) {
                return actual.length();
            }
        };
    }
}