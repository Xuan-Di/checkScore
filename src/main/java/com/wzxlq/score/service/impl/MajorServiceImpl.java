package com.wzxlq.score.service.impl;

import com.wzxlq.score.entity.Major;
import com.wzxlq.score.dao.MajorDao;
import com.wzxlq.score.service.MajorService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (Major)表服务实现类
 *
 * @author makejava
 * @since 2020-02-27 22:00:50
 */
@Service("majorService")
@CacheConfig(cacheNames = "grades3")
public class MajorServiceImpl implements MajorService {
    @Resource
    private MajorDao majorDao;

    @Override
    @Cacheable
    public List<Major> queryAllByMajorAndGrade(String majorName, String grade) {
        return majorDao.queryAllByMajorAndGrade(majorName, grade);
    }

    @Override
    public void insertMajor(ArrayList<Major> majorList) {
        majorDao.insertMajor(majorList);
    }

    @Override
    public Integer queryIsExist(String majorName, String term) {
        return majorDao.queryIsExist(majorName,term);
    }
}