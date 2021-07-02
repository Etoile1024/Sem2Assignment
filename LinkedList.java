public class LinkedList {
    private ListNode head;
    private ListNode tail;
    private Comparator comparator;

    public LinkedList(Comparator comparator) {
        head = tail = null;
        this.comparator = comparator;
    }

    public boolean isEmpty() {
        return (head==null);
    }

    public void addToHead(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            head = new ListNode(item, head);
        }
    }

    public void addToTail(Object item) {
        if (isEmpty()) {
            head = tail = new ListNode(item);
        } else {
            tail.next = new ListNode(item);
            tail =  tail.next;
        }
    }

    public Object removeFromHead() throws EmptyListException {
        Object item = null;
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        item = head.data;
        if (head == tail)      // there's only one single node
            head = tail = null;
        else
            head = head.next;
        return item;

    }

    public Object removeFromTail() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException();
        } 
        Object item = tail.data;
        if (head == tail) {   // there is only one node
            head = tail = null;
            return item;
        }
        ListNode current = head;
        while (current.next != tail)
            current = current.next;
        tail = current;
        tail.next = null;
        return item;
    }

    public String toString() {
        String s = "[ ";
        ListNode current = head;
        while (current != null) {
            s += current.data + " ";
            current = current.next;
        }
        return s + "]";
    }

    public void println() {
        ListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertInOrder (Object item) {
        if (isEmpty()) {
            head = tail = new ListNode (item);
        } else {
            if (comparator.isGreaterThanOrEqualTo(head.data, item)) {
                addToHead(item);
            } else if (comparator.isLessThanOrEqualTo(tail.data, item)) {
                addToTail(item);
            } else {
                // insert in the middle
                ListNode current = head;
                while (current.next != null) {
                    if (comparator.isGreaterThanOrEqualTo(current.next.data, item)) {
                        ListNode newNode = new ListNode(item);
                        newNode.next = current.next;
                        current.next = newNode;
                        return;
                    }
                    current = current.next;
                }
            }
        }
    }

    public void insertToken (TokenData item) {
        TokenData oldItem = null;
        boolean exist=true;
        try {
            oldItem = (TokenData)removeItem(item);
        }
        catch (ItemNotFoundException ex) {
            oldItem = item;
            exist=false;
        }
        finally {
            if(exist)
                oldItem.list.insertInOrder(item.list.head.data); // update line to exist item
            insertInOrder(oldItem);
        }
    }

    public boolean exist(Object item) {
        if(isEmpty())
            return false;
        if (comparator.isEqualTo(head.data, item))
            return true;
        else if (comparator.isEqualTo(tail.data, item))
            return true;
        ListNode current = head;
        while (current.next != null) {
            if (comparator.isEqualTo(current.next.data, item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public Object removeItem (Object item) throws ItemNotFoundException {
        if (isEmpty()) {
            throw new ItemNotFoundException();
        } 
        if (comparator.isEqualTo(head.data, item)) 
            return removeFromHead();
        else if (comparator.isEqualTo(tail.data, item)) 
            return removeFromTail();
        else {
            // remove a node in the middle
            ListNode current = head;
            while (current.next != null) {
                if (comparator.isEqualTo(current.next.data, item)) {
                    Object result = current.next.data;
                    current.next = current.next.next;
                    return result;
                }
                current = current.next;
            }
            throw new ItemNotFoundException();
        }
    }	

}
