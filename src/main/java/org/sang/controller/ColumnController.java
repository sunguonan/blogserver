package org.sang.controller;

import org.sang.bean.Category;
import org.sang.bean.RespBean;
import org.sang.service.ColumnService;
import org.sang.utils.ResponseBodyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 栏目管理
 *
 * @author sunGuoNan
 * @version 1.0
 */
@RestController
@RequestMapping("admin/category")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    /**
     * 插入栏目
     *
     * @param cateName
     * @return
     */
    @PostMapping
    public ResponseEntity<RespBean> insertCategory(@RequestParam("cateName") String cateName) {
        if (cateName == null || "".equals(cateName)) {
            return ResponseEntity.status(500).body(new RespBean("error", "请输入栏目名称！"));
        }
        boolean hasSuccess = columnService.insertCategory(cateName);
        return ResponseBodyUtil.responseBody(hasSuccess, "添加成功", "添加失败");
    }

    /**
     * 删除栏目信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<RespBean> deleteCategory(@PathVariable("id") String... id) {
        boolean hasSuccess = columnService.deleteCategory(id);
        return ResponseBodyUtil.responseBody(hasSuccess, "删除成功", "删除失败");
    }


    /**
     * 更新栏目信息
     *
     * @param category
     * @return
     */
    @PutMapping
    public ResponseEntity<RespBean> updateCategory(Category category) {

        if (category.getId() == null || category.getCateName() == null) {
            throw new RuntimeException("更新异常");
        }

        boolean hasSuccess = columnService.updateCategory(category.getId(), category.getCateName());
        return ResponseBodyUtil.responseBody(hasSuccess, "更新成功", "更新失败");
    }


    /**
     * 查询全部栏目信息
     *
     * @return
     */
    @GetMapping("all")
    public List<Category> selectAllCategory() {
        return columnService.getAllCategory();
    }


}
