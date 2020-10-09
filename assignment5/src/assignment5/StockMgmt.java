package assignment5;
import java.util.Comparator;
public class StockMgmt implements StockMgmtInterface {
	//!!!!!!!*********DON'T CREATE YOUR OWN OBJECTS OF LLMergeSort*********!!!!!!!
	//use these only this object to sort
	LLMergeSort mergeSortobj;
	LLMergeSort othersort;
	//LinkedList<Float> key;
	//Comparator<ItemNode> comp=new Comparator<ItemNode>(); 
	/*public class itemnodecomparator implements Comparator{
	//@Override
	 public int compare(ItemNode d1, ItemNode d2) {
   	  if(d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate())==0) {
   		 // Integer d1int=d1.getItemId();
   		  //Integer d2int=d2.getItemId();
   		  //return d1int.compareTo(d2int);
   		  return d2.getItemName().compareTo(d1.getItemName());
   	  }
   	  return d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate());
       //return d1.compareTo(d2);
     }*/

	/*@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}}*/
	class datecomp implements Comparator<DateNode>{
		public int compare(DateNode d1, DateNode d2) {
			return d1.compareTo(d2);
		}
	}
	class purchasecomp implements Comparator<PurchaseNode>{
		public int compare(PurchaseNode d1, PurchaseNode d2) {
			//return d1.getDate().compareTo(d2.getDate());
			return d1.compareTo(d2);
		}
	}
	class itemnodecomp implements Comparator<ItemNode>{
		 public int compare(ItemNode d1, ItemNode d2) {
			 Node<PurchaseNode> hea1=d1.purchaseTransactions.getHead();
			 LinkedList<DateNode> date1= new LinkedList<DateNode>();
			 while (hea1!=null) {
				 date1.add(hea1.getData().getDate());
				 hea1=hea1.getNext();
			 }
			 Node<PurchaseNode> hea2=d2.purchaseTransactions.getHead();
			 LinkedList<DateNode> date2= new LinkedList<DateNode>();
			 while (hea2!=null) {
				 date2.add(hea2.getData().getDate());
				 hea2=hea2.getNext();
			 }
			
			 LinkedList<DateNode> sortedtransactions1= othersort.MergeSortcomp(date1, new datecomp());
			 LinkedList<DateNode> sortedtransactions2= othersort.MergeSortcomp(date2, new datecomp());
			 //sortedtransactions1.getTail().
			 if(sortedtransactions1.getTail().getData().compareTo(sortedtransactions2.getTail().getData())==0) {
	    	  //if(d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate())==0) {
	    		 // Integer d1int=d1.getItemId();
	    		  //Integer d2int=d2.getItemId();
	    		  //return d1int.compareTo(d2int);
	    		  return d2.getItemName().compareTo(d1.getItemName());
	    	  }
	    	  return sortedtransactions1.getTail().getData().compareTo(sortedtransactions2.getTail().getData());
	        //return d1.compareTo(d2);
	      }
	}
	class stocksort implements Comparator<ItemNode>{
		public int compare(ItemNode d1, ItemNode d2) {
			int stock1= d1.getStockLeft();
			int stock2= d2.getStockLeft();
			if(stock1>stock2)
				return -1;
			else if(stock1<stock2)
				return 1;
			else
				return -d1.compareTo(d2);
		}
	}
	class lastdatecomp implements Comparator<ItemNode>{
		public int compare(ItemNode d1, ItemNode d2) {
			 Node<PurchaseNode> hea1=d1.purchaseTransactions.getHead();
			 LinkedList<DateNode> date1= new LinkedList<DateNode>();
			 while (hea1!=null) {
				 date1.add(hea1.getData().getDate());
				 hea1=hea1.getNext();
			 }
			 Node<PurchaseNode> hea2=d2.purchaseTransactions.getHead();
			 LinkedList<DateNode> date2= new LinkedList<DateNode>();
			 while (hea2!=null) {
				 date2.add(hea2.getData().getDate());
				 hea2=hea2.getNext();
			 }
			
			 LinkedList<DateNode> sortedtransactions1= othersort.MergeSortcomp(date1, new datecomp());
			 LinkedList<DateNode> sortedtransactions2= othersort.MergeSortcomp(date2, new datecomp());
			 //sortedtransactions1.getTail().
			 if(sortedtransactions1.getTail().getData().compareTo(sortedtransactions2.getTail().getData())==0) {
	    	  //if(d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate())==0) {
	    		 // Integer d1int=d1.getItemId();
	    		  //Integer d2int=d2.getItemId();
	    		  //return d1int.compareTo(d2int);
	    		  return -d1.compareTo(d2);
	    	  }
	    	  return -sortedtransactions1.getTail().getData().compareTo(sortedtransactions2.getTail().getData());
		}
	}
/*	class keycomp implements Comparator<ItemNode>{
		public int compare(ItemNode d1, ItemNode d2) {
			
			
		}
	}*/
	LinkedList<CategoryNode> categories;
	// comp = new Comparator<ItemNode>() ;
	     /* public int compare(ItemNode d1, ItemNode d2) {
	    	  return 0;
	        //return d1.compareTo(d2);
	      }*/
	    
	//DO NOT MNODIFY THIS CONSTRUCTOR
	public StockMgmt() {

		mergeSortobj = new LLMergeSort();
		categories = new LinkedList<CategoryNode>();
		othersort=new LLMergeSort();
		categories.add(new CategoryNode(1, "mobile"));
		categories.add(new CategoryNode(2, "utensils"));
		categories.add(new CategoryNode(3, "sanitary"));
		categories.add(new CategoryNode(4, "medicalEquipment"));
		categories.add(new CategoryNode(5, "clothes"));

	}
	 //comp = new Comparator<ItemNode>(); 
		// comp = new Comparator<ItemNode>() {
		      /*public int compare(ItemNode d1, ItemNode d2) {
		    	  if(d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate())==0) {
		    		 // Integer d1int=d1.getItemId();
		    		  //Integer d2int=d2.getItemId();
		    		  //return d1int.compareTo(d2int);
		    		  return d2.getItemName().compareTo(d1.getItemName());
		    	  }
		    	  return d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate());
		        //return d1.compareTo(d2);
		      }*/
		    
	public void addItem(int categoryId, int itemId, String itemName, int stock) {
		//Your code goes here
		//System.out.println("hekk");
		Node<CategoryNode> current = categories.getHead();
		while(current.getData().getCategoryId() != categoryId) {
			current = current.getNext();
		}
		ItemNode item= new ItemNode(itemId,itemName,stock);
		LinkedList<ItemNode> itemlist=current.getData().getLinkedListOfCategory();
		itemlist.add(item);
	}

	public void addItemTransaction(int categoryId, int itemId, String itemName, int numItemPurchased, int day, int month, int year) {
		//Your code goes here
		Node<CategoryNode> current = categories.getHead();
		while(current.getData().getCategoryId() != categoryId) {
			current = current.getNext();
		}
		LinkedList<ItemNode> itemlist=current.getData().getLinkedListOfCategory();
		Node<ItemNode> itemhead= itemlist.getHead();
		while(itemhead.getData().getItemId()!=itemId) {
			itemhead=itemhead.getNext();
		}
		
		itemhead.getData().addTransaction(new PurchaseNode(numItemPurchased, day,month, year));
	}

	//Query 1
	public LinkedList<ItemNode> sortByLastDate() {
		//Your code goes here
		LinkedList<ItemNode> itemdif=new LinkedList<ItemNode>();
		Node<CategoryNode> categ= categories.getHead();
		//LinkedList<ItemNode> head =categories.getHead().getData().getLinkedListOfCategory();
		while(categ!=null) {
		//itemdif.add(categories.getHead().getData().getLinkedListOfCategory());
			LinkedList<ItemNode> head =categ.getData().getLinkedListOfCategory();
			Node<ItemNode> headitem=head.getHead();
			while(headitem!=null) {
				itemdif.add(headitem.getData());
				headitem=headitem.getNext();
			}
			categ=categ.getNext();
		}
		//System.out.println(itemdif);
		/*Comparator<ItemNode> comp = new Comparator<ItemNode>() {
		// comp = new Comparator<ItemNode>() {
		      public int compare(ItemNode d1, ItemNode d2) {
		    	  if(d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate())==0) {
		    		 // Integer d1int=d1.getItemId();
		    		  //Integer d2int=d2.getItemId();
		    		  //return d1int.compareTo(d2int);
		    		  return d2.getItemName().compareTo(d1.getItemName());
		    	  }
		    	  return d1.getPurchaseHead().getData().getDate().compareTo(d2.getPurchaseHead().getData().getDate());
		        //return d1.compareTo(d2);
		      }
		    };*/
		Comparator comp=new itemnodecomp();
		   return mergeSortobj.MergeSortcomp(itemdif, comp);
		//return null;
	}

	//Query 2
	public LinkedList<ItemNode> sortByPurchasePeriod(int day1, int month1, int year1, int day2, int month2, int year2) {
		//Your code goes here
		LinkedList<ItemNode> itemdif=new LinkedList<ItemNode>();
		Node<CategoryNode> categ= categories.getHead();
		DateNode d1= new DateNode(day1,month1, year1);
		DateNode d2= new DateNode(day2,month2,year2);
		//LinkedList<ItemNode> head =categories.getHead().getData().getLinkedListOfCategory();
		while(categ!=null) {
		//itemdif.add(categories.getHead().getData().getLinkedListOfCategory());
			LinkedList<ItemNode> head =categ.getData().getLinkedListOfCategory();
			//LinkedList<Float> key= new LinkedList<Float>();
			Node<ItemNode> headitem=head.getHead();
			while(headitem!=null) {
				Node<PurchaseNode> phead= headitem.getData().purchaseTransactions.getHead();
				DateNode lowDate = d2;
				DateNode highDate= d1;
				int itemspurch=0;
				while(phead!=null) {
				if(phead.getData().getDate().compareTo(d1)>=0 && phead.getData().getDate().compareTo(d2) <=0) {
					if(phead.getData().getDate().compareTo(d1)>=0 &&  phead.getData().getDate().compareTo(lowDate) <0)
						lowDate= phead.getData().getDate();
					if(phead.getData().getDate().compareTo(d2)<=0 &&  phead.getData().getDate().compareTo(highDate) >0)
						highDate= phead.getData().getDate();
					itemspurch+=phead.getData().numItemsPurchased();
				}
				phead=phead.getNext();
				}
				float val=itemspurch/((highDate.year-lowDate.getYear()+1));
				headitem.data.addKey(val);
				itemdif.add(headitem.getData());
				headitem=headitem.getNext();
			}
			categ=categ.getNext();
		}
		class keycomp implements Comparator<ItemNode>{
			public int compare(ItemNode d1, ItemNode d2) {
				if((d1.key).compareTo(d2.key)==0)	
					return -d1.compareTo(d2);
				return (d1.key).compareTo(d2.key);
			}
		}
		//return null;
		return mergeSortobj.MergeSortcomp(itemdif,new keycomp());
	}

	//Query 3
	public LinkedList<ItemNode> sortByStockForCategory(int category) {
		//Your code goes here
		Node<CategoryNode> current = categories.getHead();
		while(current.getData().getCategoryId() != category) {
			current = current.getNext();
		}
		LinkedList<ItemNode> itemlist= current.getData().getLinkedListOfCategory();
		return  mergeSortobj.MergeSortcomp(itemlist, new stocksort());
		//return null;
	}

	//Query 4
	public LinkedList<ItemNode> filterByCategorySortByDate(int category) {
		//Your code goes here
		Node<CategoryNode> current = categories.getHead();
		while(current.getData().getCategoryId() != category) {
			current = current.getNext();
		}
		LinkedList<ItemNode> itemlist= current.getData().getLinkedListOfCategory();
		return  mergeSortobj.MergeSortcomp(itemlist, new lastdatecomp());
		//return null;
	}

	//!!!!!*****DO NOT MODIFY THIS METHOD*****!!!!!//
	public LinkedList<ItemNode> checkMergeSort() {
		LinkedList<ItemNode> retLst = mergeSortobj.getGlobalList();
		mergeSortobj.clearGlobalList();
		return retLst;
	}
}
