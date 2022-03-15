package domain;

import ptbs.Facade;

public abstract class NodeVisitor{
    public abstract void visit(Facade element);
    public abstract void visit(Product product);
    public abstract void visit(Trading trading);
}