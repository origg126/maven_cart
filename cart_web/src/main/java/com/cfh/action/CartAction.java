package com.cfh.action;

import com.cfh.entity.Cart;
import com.cfh.entity.Product;
import com.cfh.service.ProductService;
import com.cfh.service.impl.ProductServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * @author origg123
 * @version 1.0
 * @date 2020/2/23 13:01
 */
public class CartAction {
    private String productId;
    private Map<String, Cart> cartMap;
    private String[] ids;
    private Integer[] nums;

    /**
     * test *****123
     * @return
     */
    public String changeCart() {
        ProductService service = new ProductServiceImpl();
        HttpSession session = ServletActionContext.getRequest().getSession();
        cartMap = new HashMap<>();
        if(ids != null){
            for (int i = 0; i < ids.length; i++) {
                Product product = service.queryById(ids[i]);
                Cart cart = new Cart(product.getProduct_id(), product.getName(), product.getCount(), nums[i]);
                cartMap.put(ids[i], cart);
            }
        }
        session.setAttribute("cart", cartMap);
        return SUCCESS;
    }

    public String addProduct() {
        ProductService productService = new ProductServiceImpl();
        Product product = productService.queryById(productId);
        HttpSession session = ServletActionContext.getRequest().getSession();
        Object oldCart = session.getAttribute("cart");
        HashMap<String, Cart> newCart = new HashMap<>(4);
        if (oldCart == null) {
            Cart cart = new Cart(product.getProduct_id(), product.getName(), product.getCount(), 1);
            newCart.put(productId, cart);
            session.setAttribute("cart", newCart);
        }else{
            Map<String, Cart> oCart = (Map<String, Cart>) oldCart;
            Cart cart = oCart.get(productId);
            if (cart == null) {
                oCart.put(productId, new Cart(product.getProduct_id(), product.getName(), product.getCount(), 1));
            }else{
                cart.setCount(cart.getCount() + 1);
                oCart.put(productId, cart);
            }
                session.setAttribute("cart", oCart);
        }
        cartMap = (Map<String, Cart>) session.getAttribute("cart");
        return SUCCESS;
    }

    public String[] getIds() {
        return ids;
    }

    public void setIds(String[] ids) {
        this.ids = ids;
    }

    public Integer[] getNums() {
        return nums;
    }

    public void setNums(Integer[] nums) {
        this.nums = nums;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Map<String, Cart> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<String, Cart> cartMap) {
        this.cartMap = cartMap;
    }
}




