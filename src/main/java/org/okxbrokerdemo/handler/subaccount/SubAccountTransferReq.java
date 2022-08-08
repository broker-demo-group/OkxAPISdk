package org.okxbrokerdemo.handler.subaccount;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubAccountTransferReq {

    @SerializedName("ccy")
    private String ccy;
    @SerializedName("amt")
    private String amt;
    @SerializedName("from")
    private String from;
    @SerializedName("to")
    private String to;
    @SerializedName("fromSubAccount")
    private String fromSubAccount;
    @SerializedName("toSubAccount")
    private String toSubAccount;
}
