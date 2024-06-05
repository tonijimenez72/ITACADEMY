package n2exercise1;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StringLengthMatcher extends TypeSafeMatcher<String> {

    private final Matcher<Integer> matcher;

    public StringLengthMatcher(Matcher<Integer> matcher) {
        this.matcher = matcher;
    }

    @Override
    protected boolean matchesSafely(String item) {
        return matcher.matches(item.length());
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a string with length ").appendDescriptionOf(matcher);
    }

}