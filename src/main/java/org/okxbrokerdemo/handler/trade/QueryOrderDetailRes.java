package org.okxbrokerdemo.handler.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderDetailRes {

     @SerializedName("instType")
    private String instType;
     @SerializedName("instId")
    private String instId;
     @SerializedName("ccy")
    private String ccy;
     @SerializedName("ordId")
    private String ordId;
     @SerializedName("clOrdId")
    private String clOrdId;
     @SerializedName("tag")
    private String tag;
     @SerializedName("px")
    private String px;
     @SerializedName("sz")
    private String sz;
     @SerializedName("pnl")
    private String pnl;
     @SerializedName("ordType")
    private String ordType;
     @SerializedName("side")
    private String side;
     @SerializedName("posSide")
    private String posSide;
     @SerializedName("tdMode")
    private String tdMode;
     @SerializedName("accFillSz")
    private String accFillSz;
     @SerializedName("fillPx")
    private String fillPx;
     @SerializedName("tradeId")
    private String tradeId;
     @SerializedName("fillSz")
    private String fillSz;
     @SerializedName("fillTime")
    private String fillTime;
     @SerializedName("state")
    private String state;
     @SerializedName("avgPx")
    private String avgPx;
     @SerializedName("lever")
    private String lever;
     @SerializedName("tpTriggerPx")
    private String tpTriggerPx;
     @SerializedName("tpTriggerPxType")
    private String tpTriggerPxType;
     @SerializedName("tpOrdPx")
    private String tpOrdPx;
     @SerializedName("slTriggerPx")
    private String slTriggerPx;
     @SerializedName("slTriggerPxType")
    private String slTriggerPxType;
     @SerializedName("slOrdPx")
    private String slOrdPx;
     @SerializedName("feeCcy")
    private String feeCcy;
     @SerializedName("fee")
    private String fee;
     @SerializedName("rebateCcy")
    private String rebateCcy;
     @SerializedName("rebate")
    private String rebate;
     @SerializedName("tgtCcy")
    private String tgtCcy;
     @SerializedName("category")
    private String category;
     @SerializedName("uTime")
    private String uTime;
     @SerializedName("cTime")
    private String cTime;

}
