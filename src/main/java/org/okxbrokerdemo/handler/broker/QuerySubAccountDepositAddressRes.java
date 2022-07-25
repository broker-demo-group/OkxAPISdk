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
public class QuerySubAccountDepositAddressRes {

    @SerializedName("chain")
    private String chain;
    @SerializedName("ctAddr")
    private String ctAddr;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("to")
    private String to;
    @SerializedName("addr")
    private String addr;
    @SerializedName("selected")
    private Boolean selected;

}
