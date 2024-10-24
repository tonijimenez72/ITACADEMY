package n1exercise2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CalcDniTest {

    @ParameterizedTest
    @MethodSource("dniProvider")
    @DisplayName("Test getTrustedCharCodes() method with various ID numbers")
    void getTrustedCharCodes(char trustedCharCode, int idCard) {
        char charCode = CalcDni.getTrustedCharCodes(idCard);
        assertEquals(trustedCharCode, charCode, "ID card number " + idCard + " failed. Expected: " + trustedCharCode + ", Actual: " + charCode);
    }

    static Stream<Arguments> dniProvider() {
        return Stream.of(
                Arguments.of('V', 12769548),
                Arguments.of('Y', 58833891),
                Arguments.of('R', 27409699),
                Arguments.of('R', 67765568),
                Arguments.of('Q', 74461274),
                Arguments.of('X', 12769548),
                Arguments.of('X', 58833891),
                Arguments.of('X', 27409699),
                Arguments.of('X', 67765568),
                Arguments.of('X', 74461274)
        );
    }
}