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
public class QueryBalanceRes {

    @SerializedName("availBal")
    private String availBal;
    @SerializedName("bal")
    private String bal;
    @SerializedName("ccy")
    private String ccy;
    @SerializedName("frozenBal")
    private String frozenBal;
}
