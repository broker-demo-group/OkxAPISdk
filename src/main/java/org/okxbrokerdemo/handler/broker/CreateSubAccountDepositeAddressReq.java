package org.okxbrokerdemo.handler.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSubAccountDepositeAddressReq {

    private String subAcct;
    private String ccy;
    private String chain;
    private String addrType;
    private String to;
}
