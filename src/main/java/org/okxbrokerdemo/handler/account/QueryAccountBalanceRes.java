package org.okxbrokerdemo.handler.account;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@NoArgsConstructor
@Data
public class QueryAccountBalanceRes {

    @SerializedName("adjEq")
    private String adjEq;
    @SerializedName("details")
    private List<DetailsDTO> details;
    @SerializedName("imr")
    private String imr;
    @SerializedName("isoEq")
    private String isoEq;
    @SerializedName("mgnRatio")
    private String mgnRatio;
    @SerializedName("mmr")
    private String mmr;
    @SerializedName("notionalUsd")
    private String notionalUsd;
    @SerializedName("ordFroz")
    private String ordFroz;
    @SerializedName("totalEq")
    private String totalEq;
    @SerializedName("uTime")
    private String uTime;

    @NoArgsConstructor
    @Data
    public static class DetailsDTO {
        @SerializedName("availBal")
        private String availBal;
        @SerializedName("availEq")
        private String availEq;
        @SerializedName("cashBal")
        private String cashBal;
        @SerializedName("ccy")
        private String ccy;
        @SerializedName("crossLiab")
        private String crossLiab;
        @SerializedName("disEq")
        private String disEq;
        @SerializedName("eq")
        private String eq;
        @SerializedName("eqUsd")
        private String eqUsd;
        @SerializedName("frozenBal")
        private String frozenBal;
        @SerializedName("interest")
        private String interest;
        @SerializedName("isoEq")
        private String isoEq;
        @SerializedName("isoLiab")
        private String isoLiab;
        @SerializedName("isoUpl")
        private String isoUpl;
        @SerializedName("liab")
        private String liab;
        @SerializedName("maxLoan")
        private String maxLoan;
        @SerializedName("mgnRatio")
        private String mgnRatio;
        @SerializedName("notionalLever")
        private String notionalLever;
        @SerializedName("ordFrozen")
        private String ordFrozen;
        @SerializedName("twap")
        private String twap;
        @SerializedName("uTime")
        private String uTime;
        @SerializedName("upl")
        private String upl;
        @SerializedName("uplLiab")
        private String uplLiab;
        @SerializedName("stgyEq")
        private String stgyEq;
    }
}
