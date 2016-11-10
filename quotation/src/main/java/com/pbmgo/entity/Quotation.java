package com.pbmgo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * hangq数据模型
 * @author David Kong
 * @date 2016/11/3.
 */
public class Quotation implements Serializable {
    private static final long serialVersionUID = 8621606236816207462L;
    private String code;
    private String name;
    // 成交量
    private Double turnover;
    // 今日开盘价
    private Float open;
    // 昨日收盘价
    private Float close;
    // 今日最高价
    private Float high;
    // 今日最低价
    private Float low;
    // 当前成交价
    private Float now;
    // 买一价
    private Float buy;
    // 卖一价
    private Float sell;
    private Double vol;
    private Float ask1;
    private Float ask2;
    private Float ask3;
    private Float ask4;
    private Float ask5;
    private Float ask6;
    private Float ask7;
    private Float ask8;
    private Float ask9;
    private Float ask0;
    private Float bid1;
    private Float bid2;
    private Float bid3;
    private Float bid4;
    private Float bid5;
    private Float bid6;
    private Float bid7;
    private Float bid8;
    private Float bid9;
    private Float bid0;
    private Double bid1Vol;
    private Double bid2Vol;
    private Double bid3Vol;
    private Double bid4Vol;
    private Double bid5Vol;
    private Double bid6Vol;
    private Double bid7Vol;
    private Double bid8Vol;
    private Double bid9Vol;
    private Double bid0Vol;
    private Double ask1Vol;
    private Double ask2Vol;
    private Double ask3Vol;
    private Double ask4Vol;
    private Double ask5Vol;
    private Double ask6Vol;
    private Double ask7Vol;
    private Double ask8Vol;
    private Double ask9Vol;
    private Double ask0Vol;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTurnover() {
        return turnover;
    }

    public void setTurnover(Double turnover) {
        this.turnover = turnover;
    }

    public Float getOpen() {
        return open;
    }

    public void setOpen(Float open) {
        this.open = open;
    }

    public Float getClose() {
        return close;
    }

    public void setClose(Float close) {
        this.close = close;
    }

    public Float getHigh() {
        return high;
    }

    public void setHigh(Float high) {
        this.high = high;
    }

    public Float getLow() {
        return low;
    }

    public void setLow(Float low) {
        this.low = low;
    }

    public Float getNow() {
        return now;
    }

    public void setNow(Float now) {
        this.now = now;
    }

    public Float getBuy() {
        return buy;
    }

    public void setBuy(Float buy) {
        this.buy = buy;
    }

    public Float getSell() {
        return sell;
    }

    public void setSell(Float sell) {
        this.sell = sell;
    }

    public Double getVol() {
        return vol;
    }

    public void setVol(Double vol) {
        this.vol = vol;
    }

    public Float getAsk1() {
        return ask1;
    }

    public void setAsk1(Float ask1) {
        this.ask1 = ask1;
    }

    public Float getAsk2() {
        return ask2;
    }

    public void setAsk2(Float ask2) {
        this.ask2 = ask2;
    }

    public Float getAsk3() {
        return ask3;
    }

    public void setAsk3(Float ask3) {
        this.ask3 = ask3;
    }

    public Float getAsk4() {
        return ask4;
    }

    public void setAsk4(Float ask4) {
        this.ask4 = ask4;
    }

    public Float getAsk5() {
        return ask5;
    }

    public void setAsk5(Float ask5) {
        this.ask5 = ask5;
    }

    public Float getAsk6() {
        return ask6;
    }

    public void setAsk6(Float ask6) {
        this.ask6 = ask6;
    }

    public Float getAsk7() {
        return ask7;
    }

    public void setAsk7(Float ask7) {
        this.ask7 = ask7;
    }

    public Float getAsk8() {
        return ask8;
    }

    public void setAsk8(Float ask8) {
        this.ask8 = ask8;
    }

    public Float getAsk9() {
        return ask9;
    }

    public void setAsk9(Float ask9) {
        this.ask9 = ask9;
    }

    public Float getAsk0() {
        return ask0;
    }

    public void setAsk0(Float ask0) {
        this.ask0 = ask0;
    }

    public Float getBid1() {
        return bid1;
    }

    public void setBid1(Float bid1) {
        this.bid1 = bid1;
    }

    public Float getBid2() {
        return bid2;
    }

    public void setBid2(Float bid2) {
        this.bid2 = bid2;
    }

    public Float getBid3() {
        return bid3;
    }

    public void setBid3(Float bid3) {
        this.bid3 = bid3;
    }

    public Float getBid4() {
        return bid4;
    }

    public void setBid4(Float bid4) {
        this.bid4 = bid4;
    }

    public Float getBid5() {
        return bid5;
    }

    public void setBid5(Float bid5) {
        this.bid5 = bid5;
    }

    public Float getBid6() {
        return bid6;
    }

    public void setBid6(Float bid6) {
        this.bid6 = bid6;
    }

    public Float getBid7() {
        return bid7;
    }

    public void setBid7(Float bid7) {
        this.bid7 = bid7;
    }

    public Float getBid8() {
        return bid8;
    }

    public void setBid8(Float bid8) {
        this.bid8 = bid8;
    }

    public Float getBid9() {
        return bid9;
    }

    public void setBid9(Float bid9) {
        this.bid9 = bid9;
    }

    public Float getBid0() {
        return bid0;
    }

    public void setBid0(Float bid0) {
        this.bid0 = bid0;
    }

    public Double getBid1Vol() {
        return bid1Vol;
    }

    public void setBid1Vol(Double bid1Vol) {
        this.bid1Vol = bid1Vol;
    }

    public Double getBid2Vol() {
        return bid2Vol;
    }

    public void setBid2Vol(Double bid2Vol) {
        this.bid2Vol = bid2Vol;
    }

    public Double getBid3Vol() {
        return bid3Vol;
    }

    public void setBid3Vol(Double bid3Vol) {
        this.bid3Vol = bid3Vol;
    }

    public Double getBid4Vol() {
        return bid4Vol;
    }

    public void setBid4Vol(Double bid4Vol) {
        this.bid4Vol = bid4Vol;
    }

    public Double getBid5Vol() {
        return bid5Vol;
    }

    public void setBid5Vol(Double bid5Vol) {
        this.bid5Vol = bid5Vol;
    }

    public Double getBid6Vol() {
        return bid6Vol;
    }

    public void setBid6Vol(Double bid6Vol) {
        this.bid6Vol = bid6Vol;
    }

    public Double getBid7Vol() {
        return bid7Vol;
    }

    public void setBid7Vol(Double bid7Vol) {
        this.bid7Vol = bid7Vol;
    }

    public Double getBid8Vol() {
        return bid8Vol;
    }

    public void setBid8Vol(Double bid8Vol) {
        this.bid8Vol = bid8Vol;
    }

    public Double getBid9Vol() {
        return bid9Vol;
    }

    public void setBid9Vol(Double bid9Vol) {
        this.bid9Vol = bid9Vol;
    }

    public Double getBid0Vol() {
        return bid0Vol;
    }

    public void setBid0Vol(Double bid0Vol) {
        this.bid0Vol = bid0Vol;
    }

    public Double getAsk1Vol() {
        return ask1Vol;
    }

    public void setAsk1Vol(Double ask1Vol) {
        this.ask1Vol = ask1Vol;
    }

    public Double getAsk2Vol() {
        return ask2Vol;
    }

    public void setAsk2Vol(Double ask2Vol) {
        this.ask2Vol = ask2Vol;
    }

    public Double getAsk3Vol() {
        return ask3Vol;
    }

    public void setAsk3Vol(Double ask3Vol) {
        this.ask3Vol = ask3Vol;
    }

    public Double getAsk4Vol() {
        return ask4Vol;
    }

    public void setAsk4Vol(Double ask4Vol) {
        this.ask4Vol = ask4Vol;
    }

    public Double getAsk5Vol() {
        return ask5Vol;
    }

    public void setAsk5Vol(Double ask5Vol) {
        this.ask5Vol = ask5Vol;
    }

    public Double getAsk6Vol() {
        return ask6Vol;
    }

    public void setAsk6Vol(Double ask6Vol) {
        this.ask6Vol = ask6Vol;
    }

    public Double getAsk7Vol() {
        return ask7Vol;
    }

    public void setAsk7Vol(Double ask7Vol) {
        this.ask7Vol = ask7Vol;
    }

    public Double getAsk8Vol() {
        return ask8Vol;
    }

    public void setAsk8Vol(Double ask8Vol) {
        this.ask8Vol = ask8Vol;
    }

    public Double getAsk9Vol() {
        return ask9Vol;
    }

    public void setAsk9Vol(Double ask9Vol) {
        this.ask9Vol = ask9Vol;
    }

    public Double getAsk0Vol() {
        return ask0Vol;
    }

    public void setAsk0Vol(Double ask0Vol) {
        this.ask0Vol = ask0Vol;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quotation quotation = (Quotation) o;

        return code.equals(quotation.code);

    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public String toString() {
        return "Quotation{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", turnover=" + turnover +
                ", open=" + open +
                ", close=" + close +
                ", high=" + high +
                ", low=" + low +
                ", now=" + now +
                ", buy=" + buy +
                ", sell=" + sell +
                ", vol=" + vol +
                ", ask1=" + ask1 +
                ", ask2=" + ask2 +
                ", ask3=" + ask3 +
                ", ask4=" + ask4 +
                ", ask5=" + ask5 +
                ", ask6=" + ask6 +
                ", ask7=" + ask7 +
                ", ask8=" + ask8 +
                ", ask9=" + ask9 +
                ", ask0=" + ask0 +
                ", bid1=" + bid1 +
                ", bid2=" + bid2 +
                ", bid3=" + bid3 +
                ", bid4=" + bid4 +
                ", bid5=" + bid5 +
                ", bid6=" + bid6 +
                ", bid7=" + bid7 +
                ", bid8=" + bid8 +
                ", bid9=" + bid9 +
                ", bid0=" + bid0 +
                ", bid1Vol=" + bid1Vol +
                ", bid2Vol=" + bid2Vol +
                ", bid3Vol=" + bid3Vol +
                ", bid4Vol=" + bid4Vol +
                ", bid5Vol=" + bid5Vol +
                ", bid6Vol=" + bid6Vol +
                ", bid7Vol=" + bid7Vol +
                ", bid8Vol=" + bid8Vol +
                ", bid9Vol=" + bid9Vol +
                ", bid0Vol=" + bid0Vol +
                ", ask1Vol=" + ask1Vol +
                ", ask2Vol=" + ask2Vol +
                ", ask3Vol=" + ask3Vol +
                ", ask4Vol=" + ask4Vol +
                ", ask5Vol=" + ask5Vol +
                ", ask6Vol=" + ask6Vol +
                ", ask7Vol=" + ask7Vol +
                ", ask8Vol=" + ask8Vol +
                ", ask9Vol=" + ask9Vol +
                ", ask0Vol=" + ask0Vol +
                ", date=" + date +
                '}';
    }
}
