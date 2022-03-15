package domain;
import java.util.Date;

public class Trading implements VisitableItem {


    public Trading(Date deadline) {
        this.deadline = deadline;
    }

    public Date deadline = null;

    @Override
    public void accept(NodeVisitor visitor) {
        //print accept in trading
        visitor.visit(this);
    }
}