package domain;


public interface VisitableItem {
    void accept(NodeVisitor visitor);
}
