package n1exercise3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OutOfBoundsExceptionClassTest {

    @Test
    public void throwIndexOutOfBoundsExc() {
        OutOfBoundsExceptionClass aRamonesSongStartsLike = new OutOfBoundsExceptionClass();
        int[] array = {1, 2, 3, 4};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            aRamonesSongStartsLike.throwIndexOutOfBoundsExc(array, 5);
        });
    }
}