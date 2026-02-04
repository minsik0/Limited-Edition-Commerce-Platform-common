package com.sparta.multi_module.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    // USER
    USER_NOT_FOUND("USER_001", "존재하지 않는 사용자 입니다"),
    INVALID_PASSWORD("USER_002", "비밀번호가 일치하지 않습니다"),
    DUPLICATE_EMAIL("USER_003", "이미 존재하는 이메일입니다"),

    // COMMON
    INVALID_REQUEST("COMMON_001", "잘못된 요청입니다"),
    INTERNAL_SERVER_ERROR("COMMON_999", "서버 오류가 발생했습니다"),

    //JWT
    EXPIRED_TOKEN("JWT_001", "JWT 토큰이 만료되었습니다."),
    INVALID_TOKEN("JWT_002", "JWT 토큰이 유효하지 않습니다."),
    INVALID_SIGNATURE("JWT_003", "JWT 서명이 유효하지 않습니다."),
    UNSUPPORTED_TOKEN("JWT_004", "지원하지 않는 JWT 토큰입니다."),
    MALFORMED_TOKEN("JWT_005", "JWT 토큰 형식이 올바르지 않습니다."),
    UNKNOWN_ERROR("JWT_006", "JWT 처리 중 알 수 없는 오류가 발생했습니다."),

    // PRODUCT
    PRODUCT_NOT_FOUND("PRODUCT_001", "존재하지 않는 상품입니다"),
    PRODUCT_NOT_OPEN_TIME("PRODUCT_002", "아직 오픈되지 않은 상품입니다"),
    INVALID_PRODUCT_STATE("PRODUCT_003", "상품 상태가 올바르지 않습니다"),
    PRODUCT_ALREADY_CLOSED("PRODUCT_004", "이미 종료된 상품입니다"),

    // OPTION
    OPTION_NOT_FOUND("OPTION_001", "존재하지 않는 상품 옵션입니다"),
    INSUFFICIENT_STOCK("OPTION_002", "재고가 부족합니다"),
    OPTION_HAS_ORDER("OPTION_003", "주문 이력이 있는 옵션은 삭제할 수 없습니다"),

    //ORDER
    ORDER_NOT_FOUND("ORDER_001", "존재하지 않는 주문입니다."),
    ORDER_ACCESS_DENIED("ORDER_002", "주문에 대한 접근 권한이 없습니다."),
    ORDER_CANNOT_CANCEL("ORDER_003", "취소할 수 없는 주문 상태입니다."),
    INVALID_ORDER_STATUS("ORDER_004", "유효하지 않은 주문 상태입니다."),

    // PAYMENT
    PAYMENT_NOT_FOUND("PAYMENT_001", "결제 정보를 찾을 수 없습니다"),
    PAYMENT_ALREADY_APPROVED("PAYMENT_002", "이미 승인된 결제입니다"),
    PAYMENT_FAILED("PAYMENT_003", "결제에 실패했습니다"),
    INVALID_PAYMENT_STATUS("PAYMENT_004", "결제 상태가 올바르지 않습니다"),
    PAYMENT_ALREADY_HIDDEN("PAYMENT_005", "이미 비활성화된 결제입니다");

    private final String code;
    private final String message;
}
