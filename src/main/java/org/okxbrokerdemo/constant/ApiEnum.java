package org.okxbrokerdemo.constant;

import com.google.gson.reflect.TypeToken;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.okxbrokerdemo.handler.account.AccountBalance;
import java.lang.reflect.Type;
import java.util.List;

@Getter
@AllArgsConstructor
public enum ApiEnum {

    /**
     * acount api
     */
    QUERY_BALANCE("/api/v5/account/balance", MethodTypeEnum.GET, new TypeToken<List<AccountBalance>>(){}.getType(), false);

    private String path;
    private MethodTypeEnum methodType;
    private Type responseType;
    private boolean hasPathValue;
}
