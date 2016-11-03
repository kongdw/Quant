package com.pbmgo.quotation;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * 行情接口
 *
 * @author David Kong
 * @date 2016/11/3.
 */
public interface IQuotation {

    /**
     * 获取行情数据
     *
     * @return
     */
    Map<String, QuotationModel> get(List<String> stockList) throws URISyntaxException, IOException;


}
