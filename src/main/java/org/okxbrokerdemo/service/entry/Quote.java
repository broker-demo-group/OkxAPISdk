package org.okxbrokerdemo.service.entry;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/13  12:00 PM
 **/
@NoArgsConstructor
@Data
public class Quote {
    @SerializedName("baseCcy")
    public String baseCcy;
    @SerializedName("baseSz")
    public String baseSz;
    @SerializedName("clQReqId")
    public String clQReqId;
    @SerializedName("cnvtPx")
    public String cnvtPx;
    @SerializedName("origRfqSz")
    public String origRfqSz;
    @SerializedName("quoteCcy")
    public String quoteCcy;
    @SerializedName("quoteId")
    public String quoteId;
    @SerializedName("quoteSz")
    public String quoteSz;
    @SerializedName("quoteTime")
    public String quoteTime;
    @SerializedName("rfqSz")
    public String rfqSz;
    @SerializedName("rfqSzCcy")
    public String rfqSzCcy;
    @SerializedName("side")
    public String side;
    @SerializedName("ttlMs")
    public String ttlMs;
//    public String
}
