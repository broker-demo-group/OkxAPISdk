package org.okxbrokerdemo.handler.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuerySubAccountListReq {

    private String subAcct;
    private String page;
    private String limit;

}
