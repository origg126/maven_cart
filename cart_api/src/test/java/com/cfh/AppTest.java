package com.cfh;

import static org.junit.Assert.assertTrue;

import com.cfh.dao.ProductDao;
import com.cfh.dao.UserDao;
import com.cfh.entity.Product;
import com.cfh.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession session = factory.openSession();
//        ProductDao dao = session.getMapper(ProductDao.class);
//        List<Product> products = dao.queryAll(2);
//        for (Product product : products) {
//            System.out.println(product);
//        }
        UserDao mapper = session.getMapper(UserDao.class);
        User admin = mapper.queryOneUser("admin");
        System.out.println(admin);

    }
}
