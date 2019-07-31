package algorithm_structure.linked_list;

/**
 * @Author: dell
 * @Date: 2019/7/18 17:17
 */
public class ListNode {
    private int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    int listLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    ListNode insertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        // 若链表为空，直接插入
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = listLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is  invalid. The valid inputs are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) {
            // 在链表开头插入
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            // 在链表中间或末尾插入
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    ListNode deleteNodeFromLinkedList(ListNode headNode, int position) {
        int size = listLength(headNode);
        if (position > size || position < 1) {
            System.out.println("position of node to delete is invalid. The valid inputs area 1 to " + size);
            return headNode;
        }
        if (position == 1) {
            // 删除表头结点
            ListNode currentNode = headNode.getNext();
//            headNode = null;
            return currentNode;
        }else{
            ListNode previousNode = headNode;
            int count = 1;
            while (count < position){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode);
//            currentNode = null;

        }
        return headNode;
    }

    void deleteLinkedList(ListNode head){
        ListNode auxilaryNode, iterator = head;
        while(iterator != null){
            auxilaryNode = iterator.getNext();
//            iterator =  null;
            iterator = auxilaryNode;
        }
    }
}
