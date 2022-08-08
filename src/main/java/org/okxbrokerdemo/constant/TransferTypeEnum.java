package org.okxbrokerdemo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TransferEnum {

    /**
     *
     */
    TRANSFER_WITHIN_ACCOUNT("0", ""),
    MASTER_ACCOUNT_TO_SUB_ACCOUNT("1", "Only applicable to APIKey from master account"),
    SUB_ACCOUNT_TO_MASTER_ACCOUNT_FOR_MASTER_ACCOUNT("2", "Only applicable to APIKey from master account"),
    SUB_ACCOUNT_TO_MASTER_ACCOUNT_FRO_SUB_ACCOUNT("3", "Only applicable to APIKey from sub-account"),
    SUB_ACCOUNT_TO_SUB_ACCOUNT("4", "Only applicable to APIKey from sub-account, and target account needs to be another sub-account which belongs to same master account"),
    ;


    private final String value;
    private final String desc;
}
