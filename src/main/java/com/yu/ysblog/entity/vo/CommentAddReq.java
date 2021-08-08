package com.yu.ysblog.entity.vo;

import lombok.*;

/**
 * @Author yu
 * @DateTime 2021/8/8 12:08
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class CommentAddReq {
    private String content;
    private String blogId;
    private String parentId;
}
