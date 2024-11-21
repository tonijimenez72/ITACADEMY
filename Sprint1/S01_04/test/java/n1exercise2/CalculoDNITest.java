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
        char charCode = CalculoDNI.getTrustedCharCodes(idCard);
        assertEquals(trustedCharCode, charCode, "ID card number " + idCard + " failed. Expected: " + trustedCharCode + ", Actual: " + charCode);
    }

    static Stream<Arguments> dniProvider() {
        return Stream.of(
                Arguments.of('Z', 82202888),
                Arguments.of('V', 44648008),
                Arguments.of('N', 32922764),
                Arguments.of('V', 94004145),
                Arguments.of('H', 49681697),
                Arguments.of('E', 55421880),
                Arguments.of('S', 19387267),
                Arguments.of('G', 60830197),
                Arguments.of('J', 98436448),
                Arguments.of('Y', 34730604)
        );
    }
}