import org.w3c.dom.*;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.*;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class RequestService {

    private final String SERVER = "http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?";

    public void sendRequest(String type, String currencyCode, String dateFrom, String dateTo) throws Exception {
        String url = SERVER + "tp=" + type + "&ccy=" + currencyCode + "&dtFrom=" + dateFrom + "&dtTo=" + dateTo;

        String urlTwo = "http://old.lb.lt/webservices/fxrates/FxRates.asmx/getFxRatesForCurrency?tp=EU&ccy=CNY&dtFrom=2018-05-01&dtTo=2018-05-08";
        URLConnection con = new URL(urlTwo).openConnection();
        con.addRequestProperty("Accept", "application/xml");
        InputStream is = con.getInputStream();
        Document xml = parse(is);
        System.out.println(xml);


    }

    public static Document parse(InputStream is) {
        Document ret = null;
        DocumentBuilderFactory domFactory;
        DocumentBuilder builder;

        try {
            domFactory = DocumentBuilderFactory.newInstance();
            domFactory.setValidating(false);
            domFactory.setNamespaceAware(false);
            builder = domFactory.newDocumentBuilder();

            ret = builder.parse(is);
        } catch (Exception ex) {
            System.out.println("unable to load XML: " + ex);
        }
        return ret;
    }
}
