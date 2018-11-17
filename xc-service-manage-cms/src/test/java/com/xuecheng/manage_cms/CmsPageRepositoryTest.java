package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.framework.domain.cms.CmsPageParam;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {
    @Autowired
    CmsPageRepository cmsPageRepository;

    /**
     * 查询所有数据
     */
    @Test
    public void testFindAll() {
        List<CmsPage> all = cmsPageRepository.findAll();
        System.out.println(all);

    }

    /**
     * 分页查询
     */
    @Test
    public void testFindPage() {
        int page=1;//从0开始
        int Size=10;
        Pageable pageable=PageRequest.of(page,Size);
        Page<CmsPage> pageRepositoryAll = cmsPageRepository.findAll(pageable);
        System.out.println(pageRepositoryAll);
    }
    /**
     * 添加
     *
     */
    @Test
    public void testInsert() {
        CmsPage cmsPage = new CmsPage();
        //设置要添加的值
        cmsPage.setSiteId("s007");
        cmsPage.setTemplateId("t007");
        cmsPage.setPageName("测试程序");
        cmsPage.setPageAliase("MongoDB的save");
        cmsPage.setPageCreateTime(new Date());

        ArrayList list = new ArrayList();

        CmsPageParam cmsPageParam = new CmsPageParam();
        cmsPageParam.setPageParamName("param1");
        cmsPageParam.setPageParamValue("value");
        list.add(cmsPageParam);

        cmsPage.setPageParams(list);
        cmsPageRepository.save(cmsPage);

    }
    /**
     * 删除用户
     */
    @Test
    public void testDelete() {
        cmsPageRepository.deleteById("5beeb68623df723eb0f4c8af");
    }
    /**
     * 更改用户
     */
    @Test
    public void testUpDate() {
        //optional 为java的1.8以后出的方法,防止出现空指针异常
        //想要得到查询的对象必须进行判断optional.isPresent(),然后optional.get()得到查询对象
        Optional<CmsPage> optional = cmsPageRepository.findById("5beeb77323df722168c05518");
        if (optional.isPresent()) {
            CmsPage cmsPage = optional.get();
            cmsPage.setPageName("此测试修改1");
            cmsPageRepository.save(cmsPage);
        }
    }
    @Test
    public void test1() {
        CmsPage pageName = cmsPageRepository.findByPageName("index_banner.html");
        System.out.println(pageName.getPageName());
    }
    
}
