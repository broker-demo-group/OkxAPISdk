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

    @SerializedName("ccy")
    private String ccy;
    @SerializedName("amt")
    private String amt;
    @SerializedName("dest")
    private String dest;
    @SerializedName("fee")
    private String fee;
    @SerializedName("toAddr")
    private String toAddr;
    @SerializedName("chain")
    private String chain;
    @SerializedName("clientId")
    private String clientId;

}
