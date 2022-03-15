package domain;

import java.util.ArrayList;
import java.util.List;

import ptbs.ProductList;


public abstract class Person {
    public String name;
    int type;
    private ProductList addedProducts;

    ProductMenu productMenu;

    public abstract ProductMenu createProductMenu(int productType);
    public abstract void showProductMenu();

    public ProductList getAddedProducts() {
        return addedProducts;
    }

    public Person(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public boolean isStudent() {
        return type == 0;
    }

    public void addProduct(List<Product> products) {

        if(addedProducts == null)
            addedProducts = new ProductList(products);
        else

            addedProducts.addAll(products);
    }
}


