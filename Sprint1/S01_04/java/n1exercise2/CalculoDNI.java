package n1exercise2;

public class CalculoDNI {
    public static char getTrustedCharCodes(int idCard) {
        String trustedCharCodes = "TRWAGMYFPDXBNJZSQVHLCKE";
        int charIndex = idCard % 23;
        char trustedCharCode = trustedCharCodes.charAt(charIndex);
        return trustedCharCode;
    }
}