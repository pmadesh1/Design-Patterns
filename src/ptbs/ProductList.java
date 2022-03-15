package ptbs;

import java.util.Iterator;
import java.util.Set;


public class ProductList<Product> extends java.util.ArrayList<Product> {
//    @NonNull
//    public ProductIterator getIterator() {
//        return new ProductIterator(this);
//    }

    public ProductList(java.util.List<Product> list)
    {
        this.addAll(list);
    }
    public ProductList() { }

    @Override
    public Iterator<Product> iterator() {
        return (Iterator<Product>) new ProductIterator(this);
    }
}