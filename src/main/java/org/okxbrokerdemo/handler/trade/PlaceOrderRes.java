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
public class PlaceOrderRes {

     @SerializedName("clOrdId")
    private String clOrdId;
     @SerializedName("ordId")
    private String ordId;
     @SerializedName("tag")
    private String tag;
     @SerializedName("sCode")
    private String sCode;
     @SerializedName("sMsg")
    private String sMsg;

}
