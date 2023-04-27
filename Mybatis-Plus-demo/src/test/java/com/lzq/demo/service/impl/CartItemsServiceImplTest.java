package com.lzq.demo.service.impl;

import com.github.javafaker.Faker;
import com.github.jsonzou.jmockdata.JMockData;
import com.lzq.demo.domain.CartItems;
import com.lzq.demo.service.CartItemsService;
import com.lzq.demo.utils.TestUtil;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Locale;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class CartItemsServiceImplTest {

    @Mock
    private CartItemsService cartItemsService;

    @InjectMocks
    private CartItemsServiceImpl cartItemsServiceImpl;

    @Mock
    private CartItems cartItems;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void test(){
        // 模拟 Product 对象
        when(cartItems.getPrice()).thenReturn(BigDecimal.valueOf(10.00));
    }

    @Test
    public void testInsertCartItems(){
        cartItemsService.save(cartItems);
        System.out.println(cartItemsService.list());
    }

    @Test
    public void testGetCartItems(){
        CartItems items = TestUtil.generate(CartItems.class);
        cartItemsService.save(items);
    }

    @Test
    public void setCartItemsServiceImpl( ) {
        CartItems cartItems = JMockData.mock(CartItems.class);
        System.out.println(cartItems.toString());
        CartItems cartItems1 = new CartItems();
        cartItems1.setCartItemId(1231);
        cartItemsService.save(cartItems1);
        System.out.println(cartItemsService.list());
    }
}
