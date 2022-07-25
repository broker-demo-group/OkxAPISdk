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
public class CreatSubAccountDepositAddressRes {

    @SerializedName("chain")
    private String chain;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("memo")
    private String memo;
    @SerializedName("addr")
    private String addr;
    @SerializedName("ts")
    private String ts;
}
