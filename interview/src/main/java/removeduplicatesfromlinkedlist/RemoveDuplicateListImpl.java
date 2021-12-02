package removeduplicatesfromlinkedlist;

/**
 * O(n) T and O(1) S as we iterate through the linked list once
 * Given a linkedList that is sorted we walk through the list passing through the algorithm
 * the value of the previous node. If the next node has the same value as previous one then we remove the duplicate.
 * TODO: Try this with iteration and
 * TODO: also with an if to walk through the duplicates one at a time rather than all in one go in the while.
 * */
public class RemoveDuplicateListImpl implements RemoveDuplicatesFromLinkedList {
    @Override
    public LinkedListRecord removeDuplicates(LinkedListRecord list) {
        LinkedListRecord current = list;

        while(current!=null){
            LinkedListRecord next = current.next;
            while(next!=null && next.value ==current.value) next = next.next;
            current.next = next;
            current = next;
        }

        return list;
    }

}
