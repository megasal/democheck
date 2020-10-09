package assignment5;

import java.util.Comparator;

public class ItemNode implements ItemInterface,Comparable<ItemNode>{
	//Comparator<ItemNode> comp;
	int counttransactions;
	int itemId;
	String itemName;
	int stock;
	Float key;
	LinkedList<PurchaseNode> purchaseTransactions=new LinkedList<>();
	public ItemNode(int itemId, String itemName, int stock){
		this.itemId = itemId;
		this.itemName = itemName;
		this.stock = stock;
		counttransactions=0;
		purchaseTransactions.add(new PurchaseNode(0,1,8,1970));
	}
	//@Override
	public int compareTo(ItemNode d1) {
	   	  return this.getItemName().compareTo(d1.getItemName());
	       //return d1.compareTo(d2);
	     }
	public int getItemId(){
		//Enter your code here
		return this.itemId;
	}

	public  String getItemName(){
		//Enter your code here
		return this.itemName;
	}

	public int getStockLeft(){
		//Enter your code here
		return this.stock;
	}

	public void addTransaction(PurchaseNode purchaseT){
		//Enter your code here
		this.stock= this.stock-purchaseT.numItemsPurchased();
		//Node<PurchaseNode> ans= new Node<PurchaseNode>(new PurchaseNode(0,1,8,1970));
		purchaseTransactions.add(purchaseT);
		counttransactions++;
		//Node<PurchaseNode> phead= purchaseTransactions.getHead();
		if(counttransactions==1)
			purchaseTransactions.removeFirstNode();
	}

	public Node<PurchaseNode> getPurchaseHead(){
		//Enter your code here
		//Node<PurchaseNode> ans= new Node<PurchaseNode>(new PurchaseNode(0,1,8,1970));
		//return null;
		return purchaseTransactions.getHead();
	}
	public String toString() {
		//return Integer.toString(itemId)+" "+itemName+" "+ stock+" " + purchaseTransactions.getTail()+" ";
		return Integer.toString(itemId)+" "+itemName+" "+ stock+" " + purchaseTransactions;
	}
/*	@Override
	public int compareTo(ItemNode o) {
		// TODO Auto-generated method stub
		return 0;
	}*/
	public void addKey(Float key) {
		this.key=key;
	}
}
