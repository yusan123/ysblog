package com.yu.ysblog.util;

import lombok.*;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:43
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class CommonResponse {

    private String result;
    private String message;
    private Object data;


    public static CommonResponse successResp(String message, Object data) {
        return CommonResponse.builder().result("success").message(message).data(data).build();
    }

    public static CommonResponse failResp(String message, Object data) {
        return CommonResponse.builder().result("failed").message(message).data(data).build();
    }

}
