package ptbs;

import domain.Product;

import java.util.ArrayList;
import java.util.Iterator;


class OfferingList<Offering> extends java.util.ArrayList<Offering> {
//    @NonNull
//    public OfferingIterator getIterator() {
//        return new OfferingIterator(this);
//    }

    @Override
    public Iterator<Offering> iterator() {
        return (Iterator<Offering>) new OfferingIterator(this);
    }
}

public class OfferingIterator extends ListIterator<Offering> {

    OfferingIterator(OfferingList list) {
        this.list = list;
        currentPosition = 0;
    }

    @Override
    void moveToHead() {
        currentPosition = 0;
    }

    @Override
    public Offering next() {
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


abstract class ListIterator<T> implements Iterator<T> {
    protected ArrayList<T> list;
    protected int currentPosition;
    abstract void moveToHead();
}
