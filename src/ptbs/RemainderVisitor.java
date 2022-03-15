package ptbs;

import domain.Trading;
import domain.Product;
import domain.NodeVisitor;

import java.util.Iterator;
import java.util.function.Consumer;

public class RemainderVisitor extends NodeVisitor {

    @Override
    public void visit(Facade element) {
        //visiting facade
        System.out.println("Visiting Facade....");
        System.out.println("Iterating all products in Facade using iterator pattern");
        ProductIterator iterator = (ProductIterator) element.getProducts().iterator();
        while(iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    @Override
    public void visit(Product product) {
        //visiting Product
        System.out.println("Visiting product "+(product.id)+" ....");

        Iterator<Trading> iterator = product.getTrading().iterator();
        while(iterator.hasNext()) {
            iterator.next().accept(this);
        }
    }

    @Override
    public void visit(Trading trading) {

        //visiting assignment
        System.out.println("Visiting Trading with deadline:"+(trading.deadline.toString()));

        //Handle reminders based on deadline
    }
}


