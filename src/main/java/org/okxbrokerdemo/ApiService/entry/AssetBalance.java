package org.okxbrokerdemo.ApiService.entry;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AssetBalance {

    @SerializedName("availBal")
    public String availBal;
    @SerializedName("bal")
    public String bal;
    @SerializedName("ccy")
    public String ccy;
    @SerializedName("frozenBal")
    public String frozenBal;
}
