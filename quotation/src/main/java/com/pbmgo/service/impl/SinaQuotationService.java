package com.pbmgo.service.impl;

import com.pbmgo.async.AsyncCallback;
import com.pbmgo.async.AsyncExecutor;
import com.pbmgo.async.AsyncResult;
import com.pbmgo.async.ThreadAsyncExecutor;
import com.pbmgo.entity.Quotation;
import com.pbmgo.service.QuotationService;
import org.apache.http.client.HttpClient;

import java.util.List;
import java.util.Set;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public class SinaQuotationService implements QuotationService<List<Quotation>> {

    private HttpClient httpClient;
    private Set<String> stocks;
    private AsyncExecutor asyncExecutor;

    public SinaQuotationService() {
        asyncExecutor = new ThreadAsyncExecutor();
    }

    public SinaQuotationService(HttpClient httpClient, Set<String> stocks) {
        this();
        this.stocks = stocks;
        this.httpClient = httpClient;
    }

    @Override
    public AsyncResult<List<Quotation>> refresh(AsyncCallback<List<Quotation>> callback){
        return asyncExecutor.startProcess(new SinaTask(httpClient, stocks),callback);
    }

    public void setHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public void setStocks(Set<String> stocks) {
        this.stocks = stocks;
    }

}
