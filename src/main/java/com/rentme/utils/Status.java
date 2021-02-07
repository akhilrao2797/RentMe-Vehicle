package com.rentme.utils;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Status {
    @JsonEnumDefaultValue SUBMITTED,
    COMPLETED,
    CANCELLED
}
