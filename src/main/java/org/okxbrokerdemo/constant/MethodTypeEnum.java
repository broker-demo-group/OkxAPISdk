package org.okxbrokerdemo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MethodTypeEnum {

    GET("GET"),
    POST("POST"),
    ;

    private String value;
}
