package org.okxbrokerdemo.handler.trade;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceOrderReq {

     @SerializedName("instId")
    private String instId;
     @SerializedName("tdMode")
    private String tdMode;
     @SerializedName("clOrdId")
    private String clOrdId;
     @SerializedName("side")
    private String side;
     @SerializedName("ordType")
    private String ordType;
     @SerializedName("px")
    private String px;
     @SerializedName("sz")
    private String sz;

}
