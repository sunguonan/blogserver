package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sang.bean.Category;

import java.util.Date;
import java.util.List;

/**
 * @author sunGuoNan
 * @version 1.0
 */
@Mapper
public interface ColumnMapper {
    /**
     * 获取栏目信息
     *
     * @return
     */
    List<Category> getAllCategory();


    /**
     * 插入栏目信息
     *
     * @param cateName
     * @param date
     * @return
     */
    int insertCategory(@Param("cateName") String cateName, @Param("date") Date date);

    /**
     * 更新栏目
     *
     * @param id
     * @param cateName
     * @return
     */
    int updateCategory(@Param("id") Long id, @Param("cateName") String cateName);

    /**
     * 删除栏目
     *
     * @param id
     * @return
     */
    int deleteCategory(String[] id);

}
