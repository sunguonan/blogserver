package org.sang.service;

import org.sang.mapper.PvMapper;
import org.sang.utils.Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PvService {
    @Resource
    private PvMapper pvMapper;

    public void pvStatisticsPerDay() {
        pvMapper.pvStatisticsPerDay();
    }

    /**
     * 获取最近七天的日期
     *
     * @return
     */
    public List<String> getCategories() {
        return pvMapper.getCategories(Util.getCurrentUser().getId());
    }

    /**
     * 获取最近七天的数据
     *
     * @return
     */
    public List<Integer> getDataStatistics() {
        return pvMapper.getDataStatistics(Util.getCurrentUser().getId());
    }
}
