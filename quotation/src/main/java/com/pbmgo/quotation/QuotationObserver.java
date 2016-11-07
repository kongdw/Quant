package com.pbmgo.quotation;

import java.util.List;
import java.util.Set;

/**
 * @author David Kong
 * @version 1.0
 */
public interface QuotationObserver {

    void update(List<Quote> quotes);

    Set<String> subscribeStocks();
}
