package com.cfh.action;

import com.cfh.entity.Product;
import com.cfh.service.ProductService;
import com.cfh.service.impl.ProductServiceImpl;

import java.util.List;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * @author origg
 * @version 1.0
 * @date 2020/2/23 11:11
 */
public class ProductAction {
    private List<Product> products;
    private Integer index;
    private Integer page;

    public String queryProducts() {
        if (index == null) {
            index = 1;
        }
        ProductService service = new ProductServiceImpl();
        products = service.queryAll(index);
        Integer count = service.queryCount();
        page = count % 2 == 0 ? count / 2 : count / 2 + 1;
        return SUCCESS;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
