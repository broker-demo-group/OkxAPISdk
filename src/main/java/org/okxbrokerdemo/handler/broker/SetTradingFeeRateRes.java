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
public class SetTradingFeeRateRes {

    @SerializedName("subAcct")
    private String subAcct;
    @SerializedName("effTs")
    private String effTs;

}
