package n3exercise1;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class IntNumTest {
    IntNum num1 = new IntNum(5);
    IntNum num2 = new IntNum(5);
    IntNum num3 = new IntNum(10);

    @Test
    public void testValuesAreEqual() {
        assertThat(num1.getNum(), is(num2.getNum()));
    }

    @Test
    public void testValuesAreNotEqual() {
       assertThat(num1.getNum(), is(not(num3.getNum())));
    }
}
