package assignment5;

interface ItemInterface{

	int getItemId();
	String getItemName();
	int getStockLeft();

	Node<PurchaseNode> getPurchaseHead();

}
