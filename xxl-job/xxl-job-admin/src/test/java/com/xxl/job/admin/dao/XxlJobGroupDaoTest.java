
package com.xxl.job.admin.dao;

import com.xxl.job.admin.core.model.XxlJobGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class XxlJobGroupDaoTest {

    @Resource
    private XxlJobGroupDao xxlJobGroupDao;

    @Test
    @DisplayName("Should return null when the appname does not exist")
    void findByNameWhenAppnameDoesNotExist() {
        String nonExistingAppname = "non-existing-appname";
        XxlJobGroup xxlJobGroup = xxlJobGroupDao.findByName(nonExistingAppname);
        assertNull(xxlJobGroup);
    }

    @Test
    @DisplayName("Should return the XxlJobGroup when the appname exists")
    void findByNameWhenAppnameExists() {
        XxlJobGroup xxlJobGroup = new XxlJobGroup();
        xxlJobGroup.setId(1);
        xxlJobGroup.setAppname("testApp");
        xxlJobGroup.setTitle("Test App");
        xxlJobGroup.setAddressType(0);
        xxlJobGroup.setAddressList("localhost:8080");
        xxlJobGroup.setUpdateTime(new Date());
        xxlJobGroupDao.save(xxlJobGroup);

        XxlJobGroup foundXxlJobGroup = xxlJobGroupDao.findByName("testApp");

        assertNotNull(foundXxlJobGroup);
        assertEquals(xxlJobGroup.getId(), foundXxlJobGroup.getId());
        assertEquals(xxlJobGroup.getAppname(), foundXxlJobGroup.getAppname());
        assertEquals(xxlJobGroup.getTitle(), foundXxlJobGroup.getTitle());
        assertEquals(xxlJobGroup.getAddressType(), foundXxlJobGroup.getAddressType());
        assertEquals(xxlJobGroup.getAddressList(), foundXxlJobGroup.getAddressList());
        assertEquals(xxlJobGroup.getUpdateTime(), foundXxlJobGroup.getUpdateTime());
    }

    @Test
    public void test() {
        List<XxlJobGroup> list = xxlJobGroupDao.findAll();

        List<XxlJobGroup> list2 = xxlJobGroupDao.findByAddressType(0);

        XxlJobGroup group = new XxlJobGroup();
        group.setAppname("setAppName");
        group.setTitle("setTitle");
        group.setAddressType(0);
        group.setAddressList("setAddressList");
        group.setUpdateTime(new Date());

        int ret = xxlJobGroupDao.save(group);

        XxlJobGroup group2 = xxlJobGroupDao.load(group.getId());
        group2.setAppname("setAppName2");
        group2.setTitle("setTitle2");
        group2.setAddressType(2);
        group2.setAddressList("setAddressList2");
        group2.setUpdateTime(new Date());

        int ret2 = xxlJobGroupDao.update(group2);

        int ret3 = xxlJobGroupDao.remove(group.getId());
    }
}
