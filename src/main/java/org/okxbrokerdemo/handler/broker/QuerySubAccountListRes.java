package org.okxbrokerdemo.handler.broker;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySubAccountListRes {


    @SerializedName("details")
    private List<DetailsDTO> details;
    @SerializedName("page")
    private String page;
    @SerializedName("totalPage")
    private String totalPage;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class DetailsDTO {

        @SerializedName("acctLv")
        private String acctLv;
        @SerializedName("label")
        private String label;
        @SerializedName("subAcct")
        private String subAcct;
        @SerializedName("ts")
        private String ts;

    }
}
