package com.pbmgo.service.impl;

import com.pbmgo.entity.Quotation;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * @author David Kong
 * @date 2016/11/8.
 */
public class SinaTask implements Callable<List<Quotation>> {

    private final HttpClient httpClient;
    private static final String QUOTATION_API = "http://hq.sinajs.cn/";
    private final Set<String> stocks;

    public SinaTask(HttpClient httpClient, Set<String> stocks) {
        this.httpClient = httpClient;
        this.stocks = stocks;
    }

    public List<Quotation> call() throws IOException {
        HttpGet request = new HttpGet(getURL());
        HttpResponse response = httpClient.execute(request);
        return formatResponseData(response);
    }

    private String getURL() {
        return QUOTATION_API + "format=text&list=" + StringUtils.join(stocks.toArray(), ",");
    }

    private static List<Quotation> formatResponseData(HttpResponse response) throws IOException {
        String responseData = EntityUtils.toString(response.getEntity());
        List<Quotation> quotations = new ArrayList<Quotation>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String[] lines = responseData.split("\n");
        for (String line : lines) {
            String[] columns = line.split(",");
            Quotation quotation = new Quotation();
            quotation.setCode(columns[0].split("=")[0]);
            quotation.setName(columns[0].split("=")[1]);
            quotation.setOpen(Float.valueOf(columns[1]));
            quotation.setClose(Float.valueOf(columns[2]));
            quotation.setNow(Float.valueOf(columns[3]));
            quotation.setHigh(Float.valueOf(columns[4]));
            quotation.setLow(Float.valueOf(columns[5]));
            quotation.setBuy(Float.valueOf(columns[6]));
            quotation.setSell(Float.valueOf(columns[7]));
            quotation.setTurnover(Double.valueOf(columns[8]));
            quotation.setVol(Double.valueOf(columns[9]));
            quotation.setBid1Vol(Double.valueOf(columns[10]));
            quotation.setBid1(Float.valueOf(columns[11]));
            quotation.setBid2Vol(Double.valueOf(columns[12]));
            quotation.setBid2(Float.valueOf(columns[13]));
            quotation.setBid3Vol(Double.valueOf(columns[14]));
            quotation.setBid3(Float.valueOf(columns[15]));
            quotation.setBid4Vol(Double.valueOf(columns[16]));
            quotation.setBid4(Float.valueOf(columns[17]));
            quotation.setBid5Vol(Double.valueOf(columns[18]));
            quotation.setBid5(Float.valueOf(columns[19]));
            quotation.setAsk1Vol(Double.valueOf(columns[20]));
            quotation.setAsk1(Float.valueOf(columns[21]));
            quotation.setAsk2Vol(Double.valueOf(columns[22]));
            quotation.setAsk2(Float.valueOf(columns[23]));
            quotation.setAsk3Vol(Double.valueOf(columns[24]));
            quotation.setAsk3(Float.valueOf(columns[25]));
            quotation.setAsk4Vol(Double.valueOf(columns[26]));
            quotation.setAsk4(Float.valueOf(columns[27]));
            quotation.setAsk5Vol(Double.valueOf(columns[28]));
            quotation.setAsk5(Float.valueOf(columns[29]));
            String s = columns[30] + " " + columns[31];
            try {
                quotation.setDate(dateFormat.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            quotations.add(quotation);
        }
        return quotations;
    }

}
