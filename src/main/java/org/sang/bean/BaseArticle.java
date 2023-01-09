package org.sang.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装文章字段
 *
 * @author sunGuoNan
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseArticle implements Serializable {

    private static final long serialVersionUID = -3469460028880594060L;

    /**
     * 统计总文章的条数
     */
    private Long totalCount;


}
