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
public class QueryAccountPositionHistoryRes {

    @SerializedName("cTime")
    private String cTime;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("closeAvgPx")
    private String closeAvgPx;
    @SerializedName("closeTotalPos")
    private String closeTotalPos;
    @SerializedName("instId")
    private String instId;
    @SerializedName("instType")
    private String instType;
    @SerializedName("lever")
    private String lever;
    @SerializedName("mgnMode")
    private String mgnMode;
    @SerializedName("openAvgPx")
    private String openAvgPx;
    @SerializedName("openMaxPos")
    private String openMaxPos;
    @SerializedName("pnl")
    private String pnl;
    @SerializedName("pnlRatio")
    private String pnlRatio;
    @SerializedName("posId")
    private String posId;
    @SerializedName("posSide")
    private String posSide;
    @SerializedName("triggerPx")
    private String triggerPx;
    @SerializedName("type")
    private String type;
    @SerializedName("uTime")
    private String uTime;
    @SerializedName("uly")
    private String uly;
}
