package n1exercise1;

import java.text.DecimalFormat;

public class GetTotal {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static String getTotal(Sale sale) {
        String result = "";
        DecimalFormat twoDecimals = new DecimalFormat("#,##0.00");
        try {
            sale.calculateTotal();
            result = ANSI_GREEN + "TOTAL PRICE: " + twoDecimals.format(sale.getTotalPrice()) + " €" + ANSI_RESET;
        } catch (EmptySaleException e) {
            System.out.println(ANSI_YELLOW + e.getMessage() + ANSI_RESET);
        }
        return result;
    }
}
