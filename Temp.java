public class RequestService {

    private final String SERVER = "http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?";

    public void sendRequest(String type, String currencyCode, String dateFrom, String dateTo) throws Exception {
        String url = SERVER + "tp=" + type + "&ccy=" + currencyCode + "&dtFrom=" + dateFrom + "&dtTo=" + dateTo;

        URL xmlUrl = new URL(url);
        InputStream is = xmlUrl.openStream();
        Document doc = parse(is);

        }

    public static Document parse (InputStream is) {
        Document ret = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            ret = builder.parse(is);
        }
        catch (Exception ex) {
            System.out.println("unable to load XML: " + ex);
        }
        return ret;
    }
}
