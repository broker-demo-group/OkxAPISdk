package org.okxbrokerdemo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum TransferTypeEnum {

    TRANSFER_WITHIN_ACCOUNT("0", ""),
    MASTER_ACCOUNT_TO_SUB_ACCOUNT("1", "Only applicable to APIKey from master account"),
    SUB_ACCOUNT_TO_MASTER_ACCOUNT_FOR_MASTER_ACCOUNT("2", "Only applicable to APIKey from master account"),
    SUB_ACCOUNT_TO_MASTER_ACCOUNT_FRO_SUB_ACCOUNT("3", "Only applicable to APIKey from sub-account"),
    SUB_ACCOUNT_TO_SUB_ACCOUNT("4", "Only applicable to APIKey from sub-account, and target account needs to be another sub-account which belongs to same master account"),
    ;


    private final String type;
    private final String desc;

    private static final Map<String, TransferTypeEnum> map = new HashMap<>();

    static {
        Arrays.stream(TransferTypeEnum.values())
                .forEach(transferTypeEnum -> map.put(transferTypeEnum.getType(), transferTypeEnum));
    }

    public static TransferTypeEnum typeOf(String value) {
        return map.get(value);
    }
}
