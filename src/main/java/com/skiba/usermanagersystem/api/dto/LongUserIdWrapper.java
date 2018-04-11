package com.skiba.usermanagersystem.api.dto;

public class LongUserIdWrapper {

    private String userId;

    public Long getUserId() {
        return Long.parseLong(userId);
    }
}
