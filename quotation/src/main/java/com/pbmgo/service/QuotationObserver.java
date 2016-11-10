package com.pbmgo.service;

import com.pbmgo.async.AsyncCallback;

import java.util.Optional;

/**
 * @author David Kong
 * @date 2016/11/10.
 */
public interface QuotationObserver<T> extends AsyncCallback<T> {


    @Override
    void onComplete(T value, Optional<Exception> ex);


}
