package org.okxbrokerdemo.handler.account;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPosition {

    @SerializedName("adl")
    private String adl;
    @SerializedName("availPos")
    private String availPos;
    @SerializedName("avgPx")
    private String avgPx;
    @SerializedName("cTime")
    private String cTime;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("deltaBS")
    private String deltaBS;
    @SerializedName("deltaPA")
    private String deltaPA;
    @SerializedName("gammaBS")
    private String gammaBS;
    @SerializedName("gammaPA")
    private String gammaPA;
    @SerializedName("imr")
    private String imr;
    @SerializedName("instId")
    private String instId;
    @SerializedName("instType")
    private String instType;
    @SerializedName("interest")
    private String interest;
    @SerializedName("last")
    private String last;
    @SerializedName("usdPx")
    private String usdPx;
    @SerializedName("lever")
    private String lever;
    @SerializedName("liab")
    private String liab;
    @SerializedName("liabCcy")
    private String liabCcy;
    @SerializedName("liqPx")
    private String liqPx;
    @SerializedName("markPx")
    private String markPx;
    @SerializedName("margin")
    private String margin;
    @SerializedName("mgnMode")
    private String mgnMode;
    @SerializedName("mgnRatio")
    private String mgnRatio;
    @SerializedName("mmr")
    private String mmr;
    @SerializedName("notionalUsd")
    private String notionalUsd;
    @SerializedName("optVal")
    private String optVal;
    @SerializedName("pTime")
    private String pTime;
    @SerializedName("pos")
    private String pos;
    @SerializedName("posCcy")
    private String posCcy;
    @SerializedName("posId")
    private String posId;
    @SerializedName("posSide")
    private String posSide;
    @SerializedName("thetaBS")
    private String thetaBS;
    @SerializedName("thetaPA")
    private String thetaPA;
    @SerializedName("tradeId")
    private String tradeId;
    @SerializedName("quoteBal")
    private String quoteBal;
    @SerializedName("baseBal")
    private String baseBal;
    @SerializedName("uTime")
    private String uTime;
    @SerializedName("upl")
    private String upl;
    @SerializedName("uplRatio")
    private String uplRatio;
    @SerializedName("vegaBS")
    private String vegaBS;
    @SerializedName("vegaPA")
    private String vegaPA;
}
