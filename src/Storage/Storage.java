package Storage;

public class Storage <T> {

    Element<T> topElement = null;

    /**
     * Constructor for a Storage instance, which is a basic Stack implementation
     */
    public Storage(){

    }

    /**
     * Adds new element, containing user defined data to the Storage and is assigned as a top element
     * @param data the new data that is added to the storage
     */
    public void add(T data){
        if(topElement == null){
            topElement = new Element<>(data);
        }
        else{
            Element<T> newlyAdded = new Element<>(data);
            newlyAdded.nextElement = topElement;
            topElement = newlyAdded;
        }
    }

    /**
     * Returns the top element`s data from the storage
     * @return T data
     */
    public T top(){
        if(topElement == null) return null;
        return topElement.data;
    }

    /**
     * Removes the top element with its data.
     * And assigns the element underneath it as top element if such element is present
     */
    public void remove(){
        if(topElement == null) return;
        if(topElement.nextElement == null){
            topElement = null;
            return;
        }
        topElement = topElement.nextElement;
    }
}
