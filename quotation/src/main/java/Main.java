import com.pbmgo.entity.Quotation;
import com.pbmgo.service.RequestTask;
import com.pbmgo.service.impl.SinaRequestTask;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClients;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/**
 * @author David Kong
 * @date 2016/11/9.
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        HttpClient httpClient = HttpClients.createDefault();
        Set<String> stocks = new HashSet<>();
        stocks.add("sh601717");
        RequestTask<String> requestTask = new SinaRequestTask(httpClient, stocks);
        AsyncExecutor executor = new ThreadAsyncExecutor();
        AsyncResult<String> asyncResult = executor.startProcess(requestTask,callback());
        String result = executor.endProcess(asyncResult);
        System.out.println(result);
        System.out.println(asyncResult.getValue());
    }

    private static AsyncCallback<String> callback() {
        return (value, ex) -> {
            if (ex.isPresent()) {
                log(" failed: " + ex.map(Exception::getMessage).orElse(""));
            } else {
                log(": " + formatResponseData(value));
            }
        };
    }
    private static List<Quotation> formatResponseData(String responseData) {
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
    private static void log(String msg) {
        System.out.println(String.format("[%1$-10s] - %2$s", Thread.currentThread().getName(), msg));
    }
}
