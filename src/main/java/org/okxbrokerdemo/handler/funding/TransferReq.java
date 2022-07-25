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
public class TransferReq {

    @SerializedName("ccy")
    private String ccy;
    @SerializedName("amt")
    private String amt;
    @SerializedName("from")
    private String from;
    @SerializedName("to")
    private String to;
    @SerializedName("subAcct")
    private String subAcct;
    @SerializedName("type")
    private String type;
    @SerializedName("loanTrans")
    private String loanTrans;
    @SerializedName("clientId")
    private String clientId;

}
