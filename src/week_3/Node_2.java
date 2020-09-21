package week_3;

class Node_2 {
    public int item;
    public Node_2 next;
    public Node_2(int item, Node_2 next) {	// 생성자
        this.item = item;
        this.next = next;
    }
    public Node_2(int item) {		// 생성자
        this(item, null);
    }
}
