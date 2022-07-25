package org.okxbrokerdemo.handler.funding;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawlReq {

    @SerializedName("amt")
    private String amt;
    @SerializedName("fee")
    private String fee;
    @SerializedName("dest")
    private String dest;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("chain")
    private String chain;
    @SerializedName("toAddr")
    private String toAddr;

}
