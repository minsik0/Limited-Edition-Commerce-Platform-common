package com.sparta.multi_module.common.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockIncreaseEvent {

    private UUID eventId;      // 멱등성 키
    private UUID orderId;
    private UUID productId;
    private UUID optionId;
    private int quantity;

    public static StockIncreaseEvent of(UUID orderId, UUID productId, UUID optionId, int quantity) {
        return new StockIncreaseEvent(UUID.randomUUID(), orderId, productId, optionId, quantity);
    }
}
