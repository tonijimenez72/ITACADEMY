package n1exercise3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundsExceptionClassTest {

    @Test
    public void throwIndexOutOfBoundsExc() {
        OutOfBoundsException testArraySize = new OutOfBoundsException();
        int[] array = {2, 0, 2, 4};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            testArraySize.throwIndexOutOfBoundsException(array, 4);
        });
    }
}
