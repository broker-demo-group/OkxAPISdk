package org.okxbrokerdemo.handler.trade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryOrderDetailReq {

    private String instId;
    private String orderId;
    private String clOrdId;

}
