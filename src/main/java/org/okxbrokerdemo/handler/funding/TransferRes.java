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
public class TransferRes {

    @SerializedName("transId")
    private String transId;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("clientId")
    private String clientId;
    @SerializedName("from")
    private String from;
    @SerializedName("amt")
    private String amt;
    @SerializedName("to")
    private String to;
}
