package com.rentme.utils;

import java.util.HashMap;
import java.util.Map;

public class ErrorCodeMapper {
    private static Map<String, Integer> codeMapper = new HashMap<>();
    static {
        codeMapper.put("invest.InvalidUser", 279701);
        codeMapper.put("invest.InvalidCredentials", 279702);
    }

    public static int getValue(String errorMessage){
        return codeMapper.get(errorMessage);
    }
}

