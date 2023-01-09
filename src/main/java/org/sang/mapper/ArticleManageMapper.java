package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Article;

import java.util.List;

/**
 * @author sunGuoNan
 * @version 1.0
 */
@Mapper
public interface ArticleManageMapper {

    /**
     * 获取文章信息
     *
     * @param state
     * @return
     */
    List<Article> getAllArticle(@Param("state") Integer state, @Param("keywords") String keywords, @Param("username") String username);


    /**
     * 获得文章内容
     *
     * @param id
     * @return
     */
    Article getContentsArticle(String id);

    /**
     * 删除文章信息
     *
     * @param state
     * @param aids
     * @return
     */
    int deleteArticle(@Param("state") Integer state, @Param("aids") Integer[] aids);
}
