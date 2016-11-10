package com.pbmgo.service;

import com.pbmgo.entity.Quotation;
import com.pbmgo.service.impl.SinaQuotationService;
import com.pbmgo.service.impl.TestQuotationObserver;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author David Kong
 * @date 2016/11/10.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(10);
        Set<String> stocks = new HashSet<>();
        stocks.add("sh601717");
        stocks.add("sh600315");
        stocks.add("sh600887");
        stocks.add("sh600273");
        HttpClient httpClient = HttpClients.createDefault();
        QuotationService<List<Quotation>> quotationService = new SinaQuotationService(httpClient, stocks);
        quotationService.refresh(new TestQuotationObserver());
//        scheduledExecutorService.scheduleAtFixedRate(quotationService, 10L,10L, TimeUnit.SECONDS);
//        TimeUnit.SECONDS.sleep(100);
//        scheduledExecutorService.shutdownNow();
    }
}
