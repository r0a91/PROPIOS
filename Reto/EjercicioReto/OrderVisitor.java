
import java.util.*;

class OrderVisitor implements VisitorInterface {

    

    public OrderVisitor() {
    }

    public double visit(NonCaliforniaOrder inp_order) {
        return inp_order.getOrderAmount();
    }

    public double visit(CaliforniaOrder inp_order) {
        return inp_order.getOrderAmount()
                + inp_order.getAdditionalTax();
    }

    public double visit(OverseasOrder inp_order) {
        return inp_order.getOrderAmount()
                + inp_order.getAdditionalSH();
    }

    
}
