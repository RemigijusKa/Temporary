
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static final String TYPE_EU ="EU";

    public static void main( String[] args ) {
        String currencyCode = "cny";
        String dateFrom = "2018-05-01";
        String dateTo = "2018-05-04";

        RequestService requestService = new RequestService();
        try {
            requestService.sendRequest(TYPE_EU, currencyCode, dateFrom, dateTo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
