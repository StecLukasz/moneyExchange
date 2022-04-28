import converter.CashConverter;
import interraction.User;
import model.NbpApi;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Main {
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DecimalFormat dt = new DecimalFormat("0.000");
    public static void main(String[] args) throws Exception {


        User user = new User();
        NbpApi nbpApi = new NbpApi();
        CashConverter cashConverter = new CashConverter();

        String currencyFromUser = user.inputCurrencyName();
        double cashAmount = user.inputCashAmount();

        double rateExchangeBid = nbpApi.getCurrencyBid(currencyFromUser);
        double rateExchangeAsk = nbpApi.getCurrencyAsk(currencyFromUser);

        System.out.print("Nazwa wybranej waluty: " + nbpApi.getCurrencyCode(currencyFromUser));
        System.out.println(" pełna nazwa: "+nbpApi.getCurrencyName(currencyFromUser));
        System.out.println(nbpApi.getCurrencyDate(currencyFromUser)+ " : "+ dt.format(nbpApi.getCurrencyBid(currencyFromUser)) + " sprzedaż");
        System.out.println(nbpApi.getCurrencyDate(currencyFromUser)+ " : "+ dt.format(nbpApi.getCurrencyAsk(currencyFromUser))+ " kupno");
        df.setRoundingMode(RoundingMode.DOWN);
        System.out.println("Przeliczona gotówka przy sprzedaży: "+ df.format(cashConverter.convertMoney(cashAmount,rateExchangeBid))+ " PLN");
        df.setRoundingMode(RoundingMode.UP);
        System.out.println("Przeliczona gotówka przy kupnie: "+ df.format(cashConverter.convertMoney(cashAmount,rateExchangeAsk))+ " PLN");
    }
}

