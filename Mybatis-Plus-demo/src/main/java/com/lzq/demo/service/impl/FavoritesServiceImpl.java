package com.lzq.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzq.demo.domain.Favorites;
import com.lzq.demo.service.FavoritesService;
import com.lzq.demo.mapper.FavoritesMapper;
import org.springframework.stereotype.Service;

/**
* @author lin
* @description 针对表【favorites】的数据库操作Service实现
* @createDate 2023-04-22 21:24:01
*/
@Service
public class FavoritesServiceImpl extends ServiceImpl<FavoritesMapper, Favorites>
    implements FavoritesService{

}




