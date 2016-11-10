package com.pbmgo.service.impl;

import com.pbmgo.async.AsyncCallback;
import com.pbmgo.async.AsyncExecutor;
import com.pbmgo.async.AsyncResult;
import com.pbmgo.exception.RefreshQuotationException;
import com.pbmgo.service.QuotationService;
import org.apache.http.client.HttpClient;

import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public abstract class BasicQuotationService<T> implements QuotationService<T> {

    private AsyncExecutor asyncExecutor;

    private Set<String> stocks;

    private HttpClient httpClient;

    private AsyncCallback<T> asyncCallback;

    private Callable<T> task;

    public T refresh() throws RefreshQuotationException {
        AsyncResult<T> asyncResult = asyncExecutor.startProcess(task, asyncCallback);
        try {
            return asyncExecutor.endProcess(asyncResult);
        } catch (InterruptedException | ExecutionException e) {
            throw new RefreshQuotationException("刷新行情异常:", e);
        }
    }

    public void setAsyncExecutor(AsyncExecutor asyncExecutor) {
        this.asyncExecutor = asyncExecutor;
    }

    public void setStocks(Set<String> stocks) {
        this.stocks = stocks;
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setAsyncCallback(AsyncCallback<T> asyncCallback) {
        this.asyncCallback = asyncCallback;
    }

    public void setTask(Callable<T> task) {
        this.task = task;
    }
}
