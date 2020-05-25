package com.rentme.utils;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum CustomerStatus {
    @JsonEnumDefaultValue ACTIVE,
    INACTIVE,
    BLOCKED
}
