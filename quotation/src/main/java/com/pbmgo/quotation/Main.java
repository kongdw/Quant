package com.pbmgo.quotation;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author David Kong
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) throws IOException {
        QuotationObserver q1 = new QuotationObserver() {
            public void update(List<Quote> quotes) {
                System.out.println(quotes);
            }

            public Set<String> subscribeStocks() {
                Set<String> stocks = new HashSet<String>();
                stocks.add("601717");
                stocks.add("600315");
                stocks.add("600887");
                return stocks;
            }
        };

        IQuotation quotation = new SinaQuotation();
        quotation.registerObserver(q1);
        quotation.getQuotation();
    }

}
