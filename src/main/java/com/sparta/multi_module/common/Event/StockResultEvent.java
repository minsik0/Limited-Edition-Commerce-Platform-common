package com.sparta.multi_module.common.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockResultEvent {

    private UUID eventId;
    private UUID orderId;
    private boolean success;
}
