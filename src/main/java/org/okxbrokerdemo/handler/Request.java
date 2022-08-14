package org.okxbrokerdemo.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.okxbrokerdemo.constant.ApiEnum;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private ApiEnum apiEnum;

    @Builder.Default
    private Map<String, String> queryParamMap = new HashMap<>();

    private String requestBody;

    private String pathParam;

    @Builder.Default
    private Map<String, String> headerMap = new HashMap<>();

    private Boolean isSimluate;


}
