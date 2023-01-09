package org.sang.controller;


import com.github.pagehelper.PageInfo;
import org.sang.bean.Article;
import org.sang.bean.RespArticleBean;
import org.sang.bean.RespBean;
import org.sang.service.ArticleManageService;
import org.sang.utils.GetLoginUserUtil;
import org.sang.utils.ResponseBodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * 普通用户下文章管理
 *
 * @author sunGuoNan
 * @version 1.0
 */
@RestController
@RequestMapping("/article")
public class CommonArticleManagementController {
    @Autowired
    private ArticleManageService articleManageService;


    /**
     * 查找全部文章信息 (包含 标题 最近编辑时间 )
     *
     * @param state
     * @param page
     * @param count
     * @param keywords
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<RespArticleBean> getAllArticle(
            @RequestParam(value = "state") Integer state,
            @RequestParam("page") Integer page,
            @RequestParam("count") Integer count,
            @RequestParam(value = "keywords", required = false) String keywords
    ) {
        String username = (String) GetLoginUserUtil.LOGIN_USERNAME.get("username");
        // 获取分页信息
        PageInfo<Article> allArticle = articleManageService.getAllArticle(state, page, count, keywords, username);
        // 返回前端值
        return ResponseEntity.status(200).body(new RespArticleBean(allArticle.getTotal(), allArticle.getList()));
    }

    /**
     * 获取文章内容
     *
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public ResponseEntity<Article> getContentsArticle(@PathVariable("id") String id) {
        return ResponseEntity.status(200).body(articleManageService.getContentsArticle(id));
    }

    /**
     * 删除文章信息
     *
     * @param state
     * @param aids
     * @return
     */
    @PutMapping("dustbin")
    public ResponseEntity<RespBean> deleteArticle(@RequestParam("state") Integer state, @RequestParam("aids") Integer... aids) {
        boolean isSuccess = articleManageService.deleteArticle(state, aids);
        return ResponseBodyUtil.responseBody(isSuccess, "删除成功", "删除失败");
    }

}
