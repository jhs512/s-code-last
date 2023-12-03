package com.ll.scode.global.rsData.RsData;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = lombok.AccessLevel.PRIVATE)
@Getter
public class RsData<T> {
    private String resultCode;
    private String msg;
    private int statusCode;
    private T data;

    public static <T> RsData<T> of(String resultCode, T data) {
        return of(resultCode, "성공", data);
    }

    public static <T> RsData<T> of(String resultCode, String msg, T data) {
        int statusCode = Integer.parseInt(resultCode);
        return new RsData<>(resultCode, msg, statusCode, data);
    }
}
