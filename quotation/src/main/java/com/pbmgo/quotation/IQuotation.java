package com.pbmgo.quotation;

import java.io.IOException;

/**
 * 行情接口
 *
 * @author David Kong
 * @date 2016/11/3.
 */
public interface IQuotation {


    void getQuotation() throws IOException;

    /**
     * 通知观察者
     * @return
     */
    void notifyObserver();


    void registerObserver(QuotationObserver quotationObserver);


    void removeObserver(QuotationObserver quotationObserver);
}
