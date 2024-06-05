package n2exercise1;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StringLengthMatcherTest {

    @Test
    public void testStringLengthMatcherWithIncorrectLength() {
        assertThat("Mordor", new StringLengthMatcher(is(8)));
    }
