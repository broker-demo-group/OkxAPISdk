package org.okxbrokerdemo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountTypeEnum {

    FUNDING_ACCOUNT("6"),
    TRADING_ACCOUNT("18"),
    ;

    private final String value;
}
