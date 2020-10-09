package assignment5;

import java.util.Comparator;

/*
Implementation of MergeSort Algorithm :
    1. you get linked list of size <=1 you just return the list as it is already sorted
    2. Find mid node using findSplit method(Don't forget to add mid element to globalList before returning it)
    3. Create two LinkedList lt (with head = head and tail = mid) and rt (with head = mid.next and tail = tail)
    4. Now recursively MergSort lt and rt Linked lists(Maintain this order)
    5. Now merge these two lists that we got from recursive calls using given crieteria for ordering
    6. Return merged Linked list
*/

public class LLMergeSort <T extends Comparable>  {

  LinkedList<T>  globalList = new LinkedList<T>();
  
  //CALL THIS METHOD AFTER EVERY CALL OF findSplit and DO NOT MODIFY THIS METHOD
  public void adjustGlobalPointer(T node){
      globalList.add(node);
  }

  // Utility function to get the middle of the linked list
  public Node<T> findSplit(LinkedList<T>  lst) {
    //find middle node of LL :
    Node<T> middle = lst.getHead();
    //Enter your code here
    Node<T> head=lst.getHead();
    int count=0;
    while(head.getNext()!=null) {
    	//count++;
    	if(count%2!=0)
    		middle = middle.getNext();
    	count++;
    		head = head.getNext();
    		
}

    //if(count%2 == 1){
    //middle = middle.getNext();


    //!!!!!*****DO NOT REMOVE THIS METHOD CALL (change the argument apprpriately)*****!!!!!
    adjustGlobalPointer(middle.getData()); //Add object of ItemNode after finding mid in each call
    return middle;
  }


  public LinkedList<T>  MergeSort(LinkedList<T>  lst) {
    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
    //Enter your code here
	  if(lst.getSize()<=1)
		  return lst;
	  Node<T> mid=findSplit(lst);
	  Node<T> midnext=mid.getNext();
	  mid.setNext(null);
	  Node<T> head=lst.getHead();
	  LinkedList<T> left= new LinkedList<T>();
	  while(head!=null) {
	   left.add(head.getData());
	   head = head.getNext();
	  }
	  LinkedList<T> right= new LinkedList<T>();
	  right.add(midnext.getData());
	  head=head.getNext();
	  while(head.getNext()!=null) {
		   right.add(head.getData());
		   head = head.getNext();
		  }
	  LinkedList<T> sortleft= MergeSort(left);
	  LinkedList<T> sortright= MergeSort(right);
	  System.out.println("che"+ sortright);
	  
    return null;
  }
  /*private LinkedList<T> mergelists(LinkedList<T> left, LinkedList<T> right ){
	  LinkedList<T> merged= new LinkedList<T>();
	  if(left.getHead()==null || left.getSize()<1)
		  return right;
	  if(right.getHead()==null || right.getSize()<1)
		  return left;
		  Node<T> headleft=left.getHead();
		  Node<T> headright=right.getHead();
		  while(headleft!=null && headright!=null) {
			  if((headleft.getData()).compareTo(headright.getData())<0) {
			  if(compare(headleft.getData(), headright.getData())<0) {
				  merged.add(headleft.getData());
				  headleft=headleft.getNext();
			  }
			  else {
				  merged.add(headright.getData());
				  headright=headright.getNext();
			  }
				  
		  }
		  while(headleft!=null) {
			  merged.add(headleft.getData());
			  headleft=headleft.getNext();
		  }
		  while(headright!=null) {
			  merged.add(headright.getData());
			  headright=headright.getNext();
		  }
			  
		  return merged;
	  }
  }
  
  */
  public LinkedList<T>  MergeSortcomp(LinkedList<T>  lst, Comparator <T> comp) {
	    //Recursively Apply MergeSort, by calling function findSplit(..) to find middle node to split
	    //Enter your code here
		  if(lst.getSize()<=1)
			  return lst;
		 /* if(lst.getHead()==null || lst.getHead().getNext()==null)
			  return lst;*/
		  
		  //System.out.println(lst);
		  Node<T> mid=findSplit(lst);
		  Node<T> midnext=mid.getNext();
		  mid.setNext(null);
		  Node<T> head=lst.getHead();
		  //System.out.println("size"+lst.getSize());
		  LinkedList<T> left= new LinkedList<T>();
		  while(head!=null) {
			  //System.out.println("1");
		   left.add(head.getData());
		   head = head.getNext();
		  }
		  LinkedList<T> right= new LinkedList<T>();
		  //right.add(midnext.getData());
		  //head=head.getNext();
		  while(midnext!=null) {
			  //head=head.getNext();
			   right.add((midnext).getData());
			   midnext = midnext.getNext();
			  }
		  //System.out.println("right"+right);
		  LinkedList<T> sortleft= MergeSortcomp(left, comp);
		  LinkedList<T> sortright= MergeSortcomp(right,comp);
		  //System.out.println("cjeck" + sortright);
		  LinkedList<T> merged=mergelistscomp(sortleft,sortright,comp);
		  //System.out.println(""+merged);
		  return merged;
	    //return null;
	  }
	  private LinkedList<T> mergelistscomp(LinkedList<T> left, LinkedList<T> right ,Comparator <T> comp){
		  LinkedList<T> merged= new LinkedList<T>();
		  if(left.getHead()==null || left.getSize()<1)
			  return right;
		  if(right.getHead()==null || right.getSize()<1)
			  return left;
		  Node<T> headleft=left.getHead();
		  Node<T> headright=right.getHead();
		  while(headleft!=null && headright!=null) {
			  if(comp.compare(headleft.getData(),headright.getData())<0) {
				  merged.add(headleft.getData());
				  headleft=headleft.getNext();
			  }
			  else {
				  merged.add(headright.getData());
				  headright=headright.getNext();
			  }
				  
		  }
		  while(headleft!=null) {
			  merged.add(headleft.getData());
			  headleft=headleft.getNext();
		  }
		  while(headright!=null) {
			  merged.add(headright.getData());
			  headright=headright.getNext();
		  }
			  
		  return merged;
	  }
  //DO NOT CALL OR MODIFY THESE METHODS IN YOUR CALL THIS IS FOR USE IN DRIVER CODE
  public LinkedList<T> getGlobalList() {
    return this.globalList;
  }

  public void clearGlobalList(){
    globalList  = new LinkedList<>();
  }

}
