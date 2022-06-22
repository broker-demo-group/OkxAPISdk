package org.okxbrokerdemo.service.entry;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class IndexComponents {


    @SerializedName("components")
    public List<ComponentsDTO> components;
    @SerializedName("last")
    public String last;
    @SerializedName("index")
    public String index;
    @SerializedName("ts")
    public String ts;

    @NoArgsConstructor
    @Data
    public static class ComponentsDTO {
        @SerializedName("symbol")
        public String symbol;
        @SerializedName("symPx")
        public String symPx;
        @SerializedName("wgt")
        public String wgt;
        @SerializedName("cnvPx")
        public String cnvPx;
        @SerializedName("exch")
        public String exch;
    }
}
