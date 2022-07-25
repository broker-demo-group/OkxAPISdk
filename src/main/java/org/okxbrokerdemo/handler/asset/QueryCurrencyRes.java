package org.okxbrokerdemo.handler.asset;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryCurrencyRes {

    @SerializedName("canDep")
    private Boolean canDep;
    @SerializedName("canInternal")
    private Boolean canInternal;
    @SerializedName("canWd")
    private Boolean canWd;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("chain")
    private String chain;
    @SerializedName("logoLink")
    private String logoLink;
    @SerializedName("mainNet")
    private Boolean mainNet;
    @SerializedName("maxFee")
    private String maxFee;
    @SerializedName("maxWd")
    private String maxWd;
    @SerializedName("minDep")
    private String minDep;
    @SerializedName("minDepArrivalConfirm")
    private String minDepArrivalConfirm;
    @SerializedName("minFee")
    private String minFee;
    @SerializedName("minWd")
    private String minWd;
    @SerializedName("minWdUnlockConfirm")
    private String minWdUnlockConfirm;
    @SerializedName("name")
    private String name;
    @SerializedName("needTag")
    private Boolean needTag;
    @SerializedName("usedWdQuota")
    private String usedWdQuota;
    @SerializedName("wdQuota")
    private String wdQuota;
    @SerializedName("wdTickSz")
    private String wdTickSz;
}
