package n3exercise3;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;

public class IsArrayTest {
    Integer[] array1 = {1, 2, 3, 4};
    Integer[] array2 = {1, 2, 3, 4};
    IsArray isArray = new IsArray(array1);

    @Test
    public void testArraysAreIdentical() {
         assertThat(isArray.getArray(), arrayContaining(array2));
    }
}
