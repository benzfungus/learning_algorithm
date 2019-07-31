package algorithm_structure.linked_list;

/**
 * @Author: dell
 * @Date: 2019/7/19 11:23
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;

    public DLLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }

    DLLNode dLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = getDLLLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of nodeToInsert is invalid." + "The valid inputs are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) {
            headNode.setPrevious(nodeToInsert);
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if (currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    private int getDLLLength(DLLNode headNode) {
        int count = 1;
        DLLNode currentNode = headNode;
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            count++;
        }
        return count;
    }

    DLLNode DLLDelete(DLLNode headNode, int position) {
        int size = getDLLLength(headNode);
        if (position > size || position < 1) {
            System.out.println("Position of node to delete is invalid. The valid inputs are 1 to " + (size + 1));
            return headNode;
        }
        if (position == 1) {
            DLLNode currentNode = headNode.getNext();
            currentNode.setPrevious(null);
            headNode = null;
            return currentNode;
        } else {
            DLLNode previousNode = headNode;
            int count = 1;
            while (count < position - 1) {
                previousNode = previous.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode != null){
                laterNode.setPrevious(previousNode);
            }
            currentNode = null;
        }
        return headNode;
    }


}
