package com.pbmgo.service.impl;

import com.pbmgo.service.RequestTask;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.util.Set;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public class SinaRequestTask implements RequestTask<String> {

    private final HttpClient httpClient;
    private static final String QUOTATION_API = "http://hq.sinajs.cn/";
    private final Set<String> stocks;

    public SinaRequestTask(HttpClient httpClient, Set<String> stocks) {
        this.httpClient = httpClient;
        this.stocks = stocks;
    }

    public String call() throws Exception {
        HttpGet request = new HttpGet(getURL());
        HttpResponse response = httpClient.execute(request);
        return EntityUtils.toString(response.getEntity());
    }

    private String getURL() {
        return QUOTATION_API + "format=text&list=" + StringUtils.join(stocks.toArray(), ",");
    }

}
