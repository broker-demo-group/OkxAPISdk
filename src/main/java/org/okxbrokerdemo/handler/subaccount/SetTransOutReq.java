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
public class SetTransOutReq {

    @SerializedName("subAcct")
    private String subAcct;
    @SerializedName("canTransOut")
    private Boolean canTransOut;

}
