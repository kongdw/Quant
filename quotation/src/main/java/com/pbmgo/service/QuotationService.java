package com.pbmgo.service;

import com.pbmgo.async.AsyncCallback;
import com.pbmgo.async.AsyncResult;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public interface QuotationService<T>{

    /**
     * 刷新行情数据
     */
    AsyncResult<T> refresh(AsyncCallback<T> callback);
}
