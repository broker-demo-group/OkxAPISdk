package org.okxbrokerdemo.handler.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryAccountPositionHistoryReq {

    private String instType;
    private String instId;
    private String mgnMode;
    private String type;
    private String after;
    private String before;
    private String limit;

}
