package org.sang.service;

import org.sang.bean.Category;
import org.sang.mapper.ColumnMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sunGuoNan
 * @version 1.0
 */
@Service
public class ColumnService {

    @Autowired
    private ColumnMapper columnMapper;


    /**
     * 查询全部栏目信息
     *
     * @return
     */
    public List<Category> getAllCategory() {
        return columnMapper.getAllCategory();
    }

    /**
     * 插入一个栏目信息
     *
     * @param cateName
     * @return
     */
    public boolean insertCategory(String cateName) {
        int affected = columnMapper.insertCategory(cateName, new Date());
        return affected > 0;
    }

    /**
     * 更新一个栏目信息
     *
     * @param id
     * @param cateName
     * @return
     */
    public boolean updateCategory(Long id, String cateName) {
        int affected = columnMapper.updateCategory(id, cateName);
        return affected > 0;
    }

    /**
     * 删除栏目信息
     *
     * @param id
     * @return
     */
    public boolean deleteCategory(String[] id) {
        int affected = columnMapper.deleteCategory(id);
        return affected > 0;
    }

}
