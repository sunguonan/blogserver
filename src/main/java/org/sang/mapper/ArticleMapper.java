package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Article;

import java.util.List;

/**
 * Created by sang on 2017/12/20.
 */
@Mapper
public interface ArticleMapper {

    int addNewArticle(Article article);

    int updateArticle(Article article);

    List<Article> getAllArticle(@Param("page") Integer page, @Param("count") Integer count);
}
