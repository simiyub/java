/**
 *
 * Given a linkedList that is sorted we walk through the list passing through the algorithm
 * the value of the previous node. If the next node has the same value as previous one then we remove the duplicate.
 * */
public class RemoveDuplicateListImpl implements RemoveDuplicatesFromLinkedList {
    @Override
    public LinkedListRecord removeDuplicates(LinkedListRecord list) {
        if(list!=null && list.next!=null){
            if(list.value == list.next.value) list.next = list.next.next;
            removeDuplicates(list.next);
        }
        return list;
    }

    public LinkedListRecord removeDuplicate(LinkedListRecord list) {
        if(list!=null){
            if(list.value == list.next.value) list.next = list.next.next;
            removeDuplicates(list.next);
        }
        return list;
    }
}
