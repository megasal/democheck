package assignment5;

public class LinkedList<T> {

  private Node<T> head;
  private Node<T> tail;

  private int size;

  public LinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public Node<T> getHead(){
  	return this.head;
  }

  public Node<T> getTail(){
    return this.tail;
  }

  public void add(T data) {
    Node<T> node = new Node<T>(data);
    node.setNext(null);

    if(head==null){
		  head = node;
		  head.setNext(null);
      tail = head;
  	}
  	else{
      tail.setNext(node);
      tail = node;
  	}

    size++;
  }

  public int getSize() {
    return size;
  }
  public Node<T> removeFirstNode() 
  { 	
      if (head == null) 
          return null; 

      // Move the head pointer to the next node 
      Node<T> temp = head; 
      head = head.next; 
      return head; 
  } 

  public String toString() {
    Node<T> current = head;
    String elements = "";
    while (current != null) {
      elements += "[" + current.getData().toString() + "]";
      current = current.getNext();
    }
    return elements;
  }

}
