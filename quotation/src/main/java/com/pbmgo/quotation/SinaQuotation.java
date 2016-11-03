package com.pbmgo.quotation;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author David Kong
 * @date 2016/11/3.
 */
public class SinaQuotation extends AbstractQuotation {

    public static final String QUOTATION_API = "http://hq.sinajs.cn/?format=text";

    public SinaQuotation() throws URISyntaxException {
        super(URI.create(QUOTATION_API));
    }

    protected List<String> formatStockCodes(List<String> stockList) {
        List<String> formatted = new ArrayList<String>(stockList.size());
        for (String s : stockList) {
            if (s.startsWith("60")) {
                formatted.add("sh" + s);
            } else if (s.startsWith("00")) {
                formatted.add("sz" + s);
            }
        }
        return formatted;
    }

    protected List<NameValuePair> formatHttpRequestParams(List<String> formattedStocks) {
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        String queryString = StringUtils.join(formattedStocks.toArray(), ",");
        NameValuePair param = new BasicNameValuePair("list", queryString);
        params.add(param);
        return params;
    }

    protected Map<String, QuotationModel> formatHttpResponse(HttpResponse httpResponse) throws IOException {
        InputStreamReader isr = new InputStreamReader(httpResponse.getEntity().getContent());
        BufferedReader reader = new BufferedReader(isr);
        System.out.println(reader.readLine());
        return null;
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        IQuotation quotation = new SinaQuotation();
        quotation.get(Arrays.asList("601717","600887"));
    }
}
