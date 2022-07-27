package org.okxbrokerdemo.handler.broker;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SetTradingFeeRateReq {

    @SerializedName("subAcct")
    private String subAcct;
    @SerializedName("chgType")
    private String chgType;
    @SerializedName("chgTaker")
    private String chgTaker;
    @SerializedName("chgMaker")
    private String chgMaker;
    @SerializedName("effDate")
    private String effDate;

}
