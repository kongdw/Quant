package com.pbmgo.quotation;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.*;

/**
 * 行情抽象类
 *
 * @author David Kong
 * @date 2016/11/3.
 */
public abstract class AbstractQuotation implements IQuotation {

    private static HttpClient httpClient = HttpClients.createDefault();

    private String api;

    private List<QuotationObserver> quotationObservers;
    private List<Quote> quotes;

    private Set<String> allSubscribeStocks;

    // 股票对应的观察者列表
    private Map<String, List<QuotationObserver>> stockVsObservers;
    // 观察者对应的股票列表
    private Map<QuotationObserver, Set<String>> observerVsStocks;

    AbstractQuotation(String api) {
        this.api = api;
        quotationObservers = new ArrayList<QuotationObserver>();
        allSubscribeStocks = new HashSet<String>();
    }

    public void getQuotation() throws IOException {
        URIBuilder uriBuilder;
        HttpGet request;
        try {
            uriBuilder = new URIBuilder(api);
            Set<String> formattedStockCodes = formatStockCodes(allSubscribeStocks);
            uriBuilder.setParameters(this.formatHttpRequestParams(formattedStockCodes));
            request = new HttpGet("http://hq.sinajs.cn/?format=text&list=sh601717,sh600315");
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(5000).setConnectionRequestTimeout(3000)
                    .setSocketTimeout(5000).build();
            request.setConfig(requestConfig);
        } catch (URISyntaxException e) {
            throw new RuntimeException("URI [" + api + "] 地址格式错误，请核对!");
        }

        HttpResponse response = httpClient.execute(request);
        quotes = formatHttpResponse(response);
    }

    public void notifyObserver() {
        for (QuotationObserver obs : quotationObservers) {
            obs.update(quotes);
        }
    }

    public void registerObserver(QuotationObserver quotationObserver) {
        allSubscribeStocks.addAll(quotationObserver.subscribeStocks());
        this.quotationObservers.add(quotationObserver);
    }

    public void removeObserver(QuotationObserver quotationObserver) {
        this.quotationObservers.remove(quotationObserver);
    }

    /**
     * 解析股票编码
     */

    protected Set<String> formatStockCodes(Set<String> stockSet) {
        return stockSet;
    }

    /**
     * 转换请求参数
     */
    protected abstract List<NameValuePair> formatHttpRequestParams(Set<String> formattedStockCodes);

    /**
     * 格式化Response
     *
     * @param responseData
     * @return
     */
    protected abstract List<Quote> formatHttpResponse(String responseData);

    private List<Quote> formatHttpResponse(HttpResponse httpResponse) throws IOException {
        String charset = httpResponse.getEntity().getContentType().getValue();
        System.out.println(charset);
        return formatHttpResponse(EntityUtils.toString(httpResponse.getEntity() , "GBK"));
    }
}
