package com.wugz.sss.service.impl;

import com.wugz.sss.dao.ResumeDao;
import com.wugz.sss.pojo.Resume;
import com.wugz.sss.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ResumeServiceImpl
 * @Description
 * @Author wugz
 * @Date 2020/3/14 17:33
 * @Version 1.0
 */
@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;


    @Override
    public List<Resume> findByJpql() {
        return resumeDao.findByJpql();
    }

    @Override
    public void save(Resume resume) {
        resumeDao.save(resume);
    }

    @Override
    public void delete(Long id) {
        resumeDao.deleteById(id);
    }

    @Override
    public void update(Resume resume) {
        resumeDao.save(resume);
    }
}
