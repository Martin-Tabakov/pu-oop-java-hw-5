package Storage;

public class Element <T>{
    Element<T> nextElement = null;
    T data;
    public Element(T data){
        this.data = data;
    }
}
