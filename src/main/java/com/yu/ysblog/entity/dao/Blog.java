package com.yu.ysblog.entity.dao;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author yu
 * @DateTime 2021/8/7 20:24
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Blog {
    private String id;
    private String title;
    private Date createTime;
    private Date updateTime;
    private String context;
}
