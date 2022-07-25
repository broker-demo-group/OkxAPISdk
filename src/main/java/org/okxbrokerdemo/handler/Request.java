package org.okxbrokerdemo.handler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.okxbrokerdemo.constant.ApiEnum;
import org.okxbrokerdemo.utils.APIKeyHolder;
import org.okxbrokerdemo.utils.AutorizationMethod;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {

    private ApiEnum apiEnum;

    private Map<String, String> queryParamMap;

    private String requestBody;

    private String pathParam;

    private Map<String, String> headerMap;

    private Boolean isSimluate;


}
