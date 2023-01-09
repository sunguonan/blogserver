package org.sang.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.sang.bean.Article;
import org.sang.mapper.ArticleManageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sunGuoNan
 * @version 1.0
 */
@Service
@Transactional
public class ArticleManageService {
    @Autowired
    private ArticleManageMapper articleManageMapper;


    /**
     * 获取文章信息
     *
     * @param state
     * @param page
     * @param count
     * @return
     */
    public PageInfo<Article> getAllArticle(Integer state, Integer page, Integer count, String keywords, String username) {
        // 使用分页插件
        PageHelper.startPage(page, count);
        // 获得文章信息
        List<Article> allArticle = articleManageMapper.getAllArticle(state, keywords, username);
        // 返回分页后的数据
        return new PageInfo<>(allArticle);
    }


    /**
     * 获取文章内容
     *
     * @param id
     * @return
     */
    public Article getContentsArticle(String id) {
        return articleManageMapper.getContentsArticle(id);
    }

    /**
     * 删除文章信息
     *
     * @param state
     * @param aids
     * @return
     */
    public boolean deleteArticle(Integer state, Integer[] aids) {
        int isSuccess = articleManageMapper.deleteArticle(state, aids);
        return isSuccess > 0;
    }
}
