package org.okxbrokerdemo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AccountType {

    FUNDING_ACCOUNT("6"),
    
    ;

    private final String value;
}
