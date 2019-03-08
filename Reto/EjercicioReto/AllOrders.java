
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan
 */
public class AllOrders implements Iterator {

    private Map<String, Order> data;
    Iterator ec;
    Order nextOrder;

    public AllOrders(Map<String, Order> hash) {

        //ec = hash.entrySet().iterator();
        Set set = hash.entrySet();
        ec = set.iterator();

    }

    public boolean hasNext() {
        boolean matchFound = false;

        nextOrder = null;

        while (ec.hasNext()) {
            Map.Entry tempObj = (Map.Entry) ec.next();
            nextOrder = (Order) tempObj.getValue();
            break;
        }
        if (nextOrder != null) {
        	return true;
        }else {
        	return false;
        }
        //return (nextOrder != null);
    }

    public Object next() {
        if (nextOrder == null) {
            throw new NoSuchElementException();
        } else {
            return nextOrder;
        }
    }

    public void remove() {
    }
;

}
