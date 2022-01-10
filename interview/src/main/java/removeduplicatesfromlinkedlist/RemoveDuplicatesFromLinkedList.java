package removeduplicatesfromlinkedlist;

import java.util.Objects;

/**
 * Given a sorted singly linked list, remove the duplicates and retain unique values in sorted order.
 * */
public interface RemoveDuplicatesFromLinkedList {
    public LinkedListRecord removeDuplicates(LinkedListRecord linkedListRecord);

    class LinkedListRecord {
        public int value;
        public LinkedListRecord next;

        public LinkedListRecord(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            LinkedListRecord that = (LinkedListRecord) o;
            return value == that.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }
}
