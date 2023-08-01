package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lzq.demo.daoservice.TbSignService;
import com.lzq.demo.daoservice.TbUserService;
import com.lzq.demo.domain.TbSign;
import com.lzq.demo.domain.TbUser;
import com.lzq.demo.service.UserService;
import com.lzq.demo.utils.IdWorker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private TbUserService mockUserService;
    @Mock
    private TbSignService mockTbSignService;
    @Mock
    private IdWorker mockIdWorker;

    @Autowired
    private UserService userService;

    @InjectMocks
    private UserServiceImpl userServiceImplUnderTest;

    @Test
    void testTestMultiThreadCreateUser() {
        // Setup
        // Configure TbUserService.getMap(...).
        final Map<String, Object> map = Map.ofEntries(Map.entry("value", "value"));
        when(mockUserService.getMap(any(QueryWrapper.class))).thenReturn(map);

        when(mockUserService.save(new TbUser())).thenReturn(false);

        // Run the test
        userServiceImplUnderTest.testMultiThreadCreateUser();

        // Verify the results
        verify(mockUserService).save(new TbUser());
    }

    @Test
    void testTestDsTransaction() {
        // Setup
        when(mockTbSignService.save(new TbSign())).thenReturn(false);
        when(mockUserService.save(new TbUser())).thenReturn(false);

        // Run the test
        userServiceImplUnderTest.testDsTransaction();

        // Verify the results
        verify(mockTbSignService).save(new TbSign());
        verify(mockUserService).save(new TbUser());
    }

    @Test
    void testSaveOrUpdateUsers() {
        System.out.println(userService.saveOrUpdateUsers());
    }
}
