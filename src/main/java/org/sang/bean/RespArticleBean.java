package org.sang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 响应前端字段 -- 文章模块
 *
 * @author sunGuoNan
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespArticleBean implements Serializable {

    private static final long serialVersionUID = -864190179880119495L;
    /**
     * 统计条数
     */
    private Long totalCount;

    /**
     * 返回文章列表
     */
    private List<Article> articles;
}
