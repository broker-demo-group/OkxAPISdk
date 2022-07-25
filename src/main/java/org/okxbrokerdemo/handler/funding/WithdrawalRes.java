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
public class WithdrawalRes {

    @SerializedName("amt")
    private String amt;
    @SerializedName("wdId")
    private String wdId;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("clientId")
    private String clientId;
    @SerializedName("chain")
    private String chain;

}
