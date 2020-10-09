package assignment5;

public class CategoryNode implements CategoryInterface
{

	int categoryId;
	String categoryName;
	LinkedList<ItemNode> itemList;

	//DO NOT REMOVE THIS CONSTRUCTOR
	public CategoryNode(int categoryId, String categoryName){
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.itemList = new LinkedList<ItemNode>();
	}

	public int getCategoryId(){
		return this.categoryId;
	}

	public LinkedList<ItemNode> getLinkedListOfCategory(){
		return itemList;
	}

	public String getCategoryName(){
		return this.categoryName;
	}
	public String toString() {
		String out= Integer.toString(this.categoryId) +" "+ categoryName+" ";
		Node<ItemNode> head=itemList.getHead();
		while(head!=null) {
			out+=head.getData();
			head=head.getNext();
		}
		return out;
			
	}

}
