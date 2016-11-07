package com.pbmgo.quotation;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

/**
 * @author David Kong
 * @date 2016/11/3.
 */
public class SinaQuotation extends AbstractQuotation {

    public static final String QUOTATION_API = "http://hq.sinajs.cn/?format=text";

    public SinaQuotation() {
        super(QUOTATION_API);
    }

    protected List<NameValuePair> formatHttpRequestParams(Set<String> formattedStocks) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String queryString = StringUtils.join(formattedStocks.toArray(), ",");
        NameValuePair param = new BasicNameValuePair("list", queryString);
        params.add(param);
        return params;
    }

    protected Set<String> formatStockCodes(Set<String> stocks) {
        Set<String> formattedStocks = new HashSet<String>(stocks.size());
        for (String s : stocks) {
            if (s.startsWith("60")) {
                formattedStocks.add("sh" + s);
            } else if (s.startsWith("00")) {
                formattedStocks.add("sz" + s);
            }
        }
        return formattedStocks;
    }

    protected List<Quote> formatHttpResponse(String responseData) {
        System.out.println(responseData);
        return null;
    }
}
