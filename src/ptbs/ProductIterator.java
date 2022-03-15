package ptbs;

import domain.Product;

public class ProductIterator extends ListIterator<Product> {

    public ProductIterator(ProductList list) {
        this.list = list;
        currentPosition = -1;
    }

    @Override
    void moveToHead() {
        currentPosition = 0;
    }

    @Override
    public Product next() {
        if(currentPosition<list.size())
            return list.get(++currentPosition);
        return null;
    }

    @Override
    public boolean hasNext() {
        return currentPosition<list.size()-1;
    }

    @Override
    public void remove() {
        if(currentPosition<list.size())
            list.remove(currentPosition);
    }
}
