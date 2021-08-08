package com.yu.ysblog.entity.dao;

import lombok.*;

import java.util.Date;

/**
 * @Author yu
 * @DateTime 2021/8/8 12:02
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class Comment {
    private String id;
    private String content;
    private Date createTime;
    private String blogId;
    private String parentId;
    private String ip;
}
