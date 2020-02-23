package com.cfh.dao;

import com.cfh.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/22 17:18
 */
public interface ProductDao {
    /**
     * 分页查询
     * @param start
     * @return
     */
    List<Product> queryAll(Integer start);

    /**
     * 查询数量
     * @return
     */
    Integer queryCount();

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Product queryById(String id);

}
