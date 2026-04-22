package com.sparta.multi_module.common.Event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockDecreaseEvent {

    private UUID eventId;
    private UUID orderId;
    private UUID productId;
    private UUID optionId;
    private int quantity;

    public static StockDecreaseEvent of(UUID orderId, UUID productId, UUID optionId, int quantity) {
        return new StockDecreaseEvent(
                UUID.randomUUID(),
                orderId,
                productId,
                optionId,
                quantity
        );
    }
}
