package GenericBox;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private T element;

    public Box(T element) {
        this.element = element;
    }

    public void setElement(T element){
        this.element = element;

    }
    public T getElement(){
        return this.element ;
    }


    @Override
    public String toString() {
        return this.element.getClass().getName() + ": " + this.getElement();
    }

      public int compareTo(Box<T> o) {
        return this.element.compareTo(o.element);
    }


}
