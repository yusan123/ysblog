package com.yu.ysblog.entity.dao;

import lombok.*;

/**
 * @Author yu
 * @DateTime 2021/8/7 21:04
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Tag {
    private String id;
    private String name;
}
