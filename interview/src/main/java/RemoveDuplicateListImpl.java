/**
 *
 * Given a linkedList that is sorted we walk through the list passing through the algorithm
 * the value of the previous node. If the next node has the same value as previous one then we remove the duplicate.
 * */
public class RemoveDuplicateListImpl implements RemoveDuplicatesFromLinkedList {
    @Override
    public LinkedListRecord removeDuplicates(LinkedListRecord list) {
        LinkedListRecord current = list;
        while(current!=null){
            if (current.next != null) {
                LinkedListRecord temp = current.next;
                if (current.value == current.next.value) {
                    current.next =temp.next;
                }
                    current = current.next;
            }

        }

        return list;
    }

}
