package com.pbmgo.service.impl;

import com.pbmgo.entity.Quotation;
import com.pbmgo.service.QuotationObserver;

import java.util.List;
import java.util.Optional;

/**
 * @author David Kong
 * @date 2016/11/10.
 */
public class TestQuotationObserver implements QuotationObserver<List<Quotation>> {
    @Override
    public void onComplete(List<Quotation> value, Optional<Exception> ex) {
        System.out.println("TestQuotationObserver.onComplete()" + value);
    }
}
