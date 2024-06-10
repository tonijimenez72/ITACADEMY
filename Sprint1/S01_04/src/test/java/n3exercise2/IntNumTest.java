package n3exercise2;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.not;

public class IntNumTest {
    IntNum num1 = new IntNum(5);
    IntNum num2 = num1;
    IntNum num3 = new IntNum(5);

    @Test
    public void testSameReference() {
       assertThat(num1, is(sameInstance(num2)));
    }

    @Test
    public void testDifferentReference() {
        assertThat(num1, is(not(sameInstance(num3))));
    }
}