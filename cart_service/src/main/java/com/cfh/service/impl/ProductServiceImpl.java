package com.cfh.service.impl;

import com.cfh.dao.ProductDao;
import com.cfh.entity.Product;
import com.cfh.service.ProductService;
import com.cfh.util.MybatisUtil;

import java.util.List;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 17:57
 */
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> queryAll(Integer page) {
        ProductDao dao = MybatisUtil.getMapper(ProductDao.class);
        List<Product> products = dao.queryAll((page - 1) * 2);
        MybatisUtil.close();
        return products;
    }

    @Override
    public Integer queryCount() {
        ProductDao mapper = MybatisUtil.getMapper(ProductDao.class);
        Integer integer = mapper.queryCount();
        MybatisUtil.close();
        return integer;
    }

    @Override
    public Product queryById(String id) {
        ProductDao mapper = MybatisUtil.getMapper(ProductDao.class);
        Product product = mapper.queryById(id);
        MybatisUtil.close();
        return product;
    }
}
