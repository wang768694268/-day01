package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 继承MongoRepository使用mongo的数据库查询方法查询
 */
public interface CmsPageRepository extends MongoRepository <CmsPage,String>{
    //自定义查询
    CmsPage findByPageName(String pageName);
}
