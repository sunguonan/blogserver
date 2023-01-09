package org.sang.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by sang on 2017/12/17.
 */
@Mapper
public interface PvMapper {

    void pvStatisticsPerDay();

    List<String> getCategories(Long uid);

    List<Integer> getDataStatistics(Long uid);
}
