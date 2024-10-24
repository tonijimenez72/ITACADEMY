package n1exercise1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthsTest {
    static Months months;

    @BeforeEach
    void setUp() {
        months = new Months();
    }

    @Test
    void testGetMonthsSize() {
        assertEquals(12, months.getMonths().size());
    }

    @Test
    void notNull() {
        assertNotNull(months);
    }

    @Test
    void augustIsEighth() {
        assertEquals("August", months.getMonths().get(7));
    }
}