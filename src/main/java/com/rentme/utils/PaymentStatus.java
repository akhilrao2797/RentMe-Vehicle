package com.rentme.utils;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum PaymentStatus {
    @JsonEnumDefaultValue PENDING,
    FAILED,
    FREE_RIDE,
    DONE_VIA_CREDIT_CARD,
    DONE_VIA_CASH,
    DONE_VIA_UPI,
    DONE_VIA_DEBIT_CARD
}
