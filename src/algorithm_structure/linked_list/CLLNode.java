package algorithm_structure.linked_list;

/**
 * @Author: dell
 * @Date: 2019/7/22 15:02
 */
public class CLLNode {
    private CLLNode next;
    private int data;

    public CLLNode(int data) {
        this.data = data;
    }

    public CLLNode getNext() {
        return next;
    }

    public void setNext(CLLNode next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    int circularListLength(CLLNode headNode) {
        int length = 0;
        CLLNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
            if (currentNode == headNode) {
                break;
            }
        }
        return length;
    }

    void printCircleListData(CLLNode headNode) {
        CLLNode cllNode = headNode;
        while (cllNode != null) {
            System.out.println(cllNode.getData() + "->");
            cllNode = cllNode.getNext();
            if (cllNode == headNode) {
                break;
            }
        }
        System.out.println("(" + cllNode.getData() + ")headNode") ;
    }

    void insertAtEndInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        nodeToInsert.setNext(headNode);
        currentNode.setNext(nodeToInsert);
    }

    void insertAtBeginInCLL(CLLNode headNode, CLLNode nodeToInsert){
        CLLNode currentNode = headNode;
        while(currentNode.getNext() != headNode){
            currentNode = currentNode.getNext();
        }
        nodeToInsert.setNext(headNode);
        currentNode.setNext(nodeToInsert);
    }

    void deletelastnodefromcll(CLLNode headNode){
        CLLNode temp = headNode;
        CLLNode currentNode = headNode;
        if (headNode == null) {
            System.out.println("List Empty");
            return;
        }
        while (currentNode.getNext() != headNode){
            temp = currentNode;
            currentNode = currentNode.getNext();
        }
        temp.setNext(headNode);

    }

    void deleteFrontNodeFromCLL(CLLNode head){
        CLLNode current = head;
        if (head == null) {
            System.out.println("List Empty");
            return;
        }
        while(current.getNext() != head){
            current = current.getNext();
        }
        current.setNext(head.getNext());

    }
}
