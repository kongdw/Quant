package com.pbmgo.quotation;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * 行情抽象类
 *
 * @author David Kong
 * @date 2016/11/3.
 */
public abstract class AbstractQuotation implements IQuotation {

    private static HttpClient httpClient = HttpClients.createDefault();
    private URIBuilder uriBuilder;

    protected AbstractQuotation(URI uri) {
        this.uriBuilder = new URIBuilder(uri);
    }

    public Map<String, QuotationModel> get(List<String> stockList) throws URISyntaxException, IOException {
        List<String> stockCodes = formatStockCodes(stockList);
        List<NameValuePair> nameValuePairs = formatHttpRequestParams(stockCodes);
        URI uri = uriBuilder.addParameters(nameValuePairs).build();
        String s = uri.toString().replace("%2C",",");
        HttpResponse httpResponse = httpClient.execute(new HttpGet(s));
        System.out.println(httpResponse);
        return formatHttpResponse(httpResponse);
    }

    /**
     * 解析股票编码
     */
    protected abstract List<String> formatStockCodes(List<String> stockList);

    /**
     * 转换请求参数
     */
    protected abstract List<NameValuePair> formatHttpRequestParams(List<String> stockCodes);

    /**
     * 格式化Response
     *
     * @param httpResponse
     * @return
     */
    protected abstract Map<String, QuotationModel> formatHttpResponse(HttpResponse httpResponse) throws IOException;
}
