package data;

public abstract class ListItem {
    String next;
    String previous;
    String current;

    public void toNext(){
        current=next;
    }

    public void toPrevious(){
        current=previous;
    }

    public void setNext(String next){
        this.next = next;
    }

    public void setPrevious(String previous){
        this.previous=previous;
    }

    public int compareTo(ListItem item){
        return this.current.compareToIgnoreCase(item.current);
    }
}
