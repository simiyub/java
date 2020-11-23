package data;

public class Sales {
    private Sale head;
    private Sale tail;
    private int saleCount=0;

    public void add(Sale sale) {


        if(head==null){
            head=sale;
        }
        else {
            Sale currentSale = head;
            Sale next = currentSale.getNext();
            if (next == sale) {
                System.out.println("Item is already in the list.");
            }
            else {
                while (next != null) {
                        currentSale = currentSale.getNext();
                }

                currentSale.setNext(sale);
            }
        }
//        Sale currentSale=head;
//        while(currentSale!=null) {
//            if (currentSale.compareTo(sale) >= 0) {
//                if (currentSale.getNext().compareTo(sale) <= 0) {
//                    Sale temp = currentSale.getNext();
//                    currentSale.setNext(sale);
//                    currentSale.getNext().setNext(temp);
//                }
//                currentSale = head;
//            }
        }
        //currentSale.setNext(sale);
        //saleCount++;
    //}

    public void print(){
        Sale currentSale = head;
        while (currentSale!=null){
            System.out.println(currentSale.getItem().name+" cost "+currentSale.getItem().getCost()+" sold at "+currentSale.getSellingPrice());
            currentSale=currentSale.getNext();
        }
    }
}
