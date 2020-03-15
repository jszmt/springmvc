package com.wugz.sss.service;

import com.wugz.sss.pojo.Resume;

import java.util.List;

public interface ResumeService {

    /**
     * @Description: 查询所有
     * @param
     * @Date: 2020/3/15 0:06
     * @Author: wuguizhen
     * @Return java.util.List<com.wugz.sss.pojo.Resume>
     * @Throws
     */
    List<Resume> findByJpql();

    /**
     * @Description: 保存方法
     * @param resume
     * @Date: 2020/3/15 11:03
     * @Author: wuguizhen
     * @Return void
     * @Throws
     */
    void save(Resume resume);

    /**
     * @Description: 删除方法
     * @param id
     * @Date: 2020/3/15 11:03
     * @Author: wuguizhen
     * @Return void
     * @Throws
     */
    void delete(Long id);
    
    /**
     * @Description: 修改方法
     * @param resume
     * @Date: 2020/3/15 11:57
     * @Author: wuguizhen
     * @Return void
     * @Throws
     */
    void update(Resume resume);
}
