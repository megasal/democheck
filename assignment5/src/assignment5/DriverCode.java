package assignment5;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import assignment5.*;

public class DriverCode {
  static PrintStream out;
  public PrintStream fileout() {
		return out;
	}
  private static String toStringLLItemNode(LinkedList<ItemNode> lst){
    Node<ItemNode> node = lst.getHead();
    String ret = "[";
    while(node!=null){
    	//System.out.println("check"+node.getData());
      ret+=("("+node.getData().getItemId()+","+node.getData().getItemName()+")");
      node = node.getNext();
    }
    ret+="]";
    return ret;
  }

  public static void main(String[] args) throws IOException {
    File file;
    out = new PrintStream(new FileOutputStream("outcheck3", false), true);
    if (args.length == 0) {
    	file =new File("C:/Users/home/eclipse-workspace/assignment5/src/assignment5/inputquery3");
   	 System.out.println(file.exists());
   } else {
	   file = new File(args[0]);
    }
    //out = new PrintStream(new FileOutputStream(paramArrayOfString[1], false), true);
    //System.out.println("gekk");
    System.setOut(out);
    //System.out.println("gekk");
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      StockMgmt stockMgmt = new StockMgmt();
      String str;
      //System.out.println("gekk");
      while ((str = bufferedReader.readLine()) != null) {
        String[] arrayOfString = str.split(" ");
        if (arrayOfString.length == 0) {
          System.err.println("Error parsing: " + str);
          return;
        }
        //System.out.println("gekk");
        int categoryId, itemId, stock, day, month, year, numItemPurchased, category, day1, day2, month1, month2, year1, year2;
        String itemName;
        LinkedList<ItemNode> retItemList;
        LinkedList<CategoryNode> retCategoryList;
        switch (arrayOfString[0].strip()) {
          case "addItem":
        	  //System.out.println("hello");
            categoryId = Integer.parseInt(arrayOfString[1].strip());
            itemId = Integer.parseInt(arrayOfString[2].strip());
            itemName = arrayOfString[3].strip();
            stock = Integer.parseInt(arrayOfString[4].strip());
            stockMgmt.addItem(categoryId, itemId, itemName, stock);
            //System.out.println(stockMgmt.categories);
            continue;
          case "addItemTransaction":
            categoryId = Integer.parseInt(arrayOfString[1].strip());
            itemId = Integer.parseInt(arrayOfString[2].strip());
            itemName = arrayOfString[3].strip();
            numItemPurchased = Integer.parseInt(arrayOfString[4].strip());
            day = Integer.parseInt(arrayOfString[5].strip());
            month = Integer.parseInt(arrayOfString[6].strip());
            year = Integer.parseInt(arrayOfString[7].strip());
            stockMgmt.addItemTransaction(categoryId, itemId, itemName, numItemPurchased, day, month, year);
            //System.out.println(stockMgmt.categories);
            continue;
          case "sortByLastDate":
            retItemList = stockMgmt.sortByLastDate();
            //System.out.println(retItemList);
            System.out.println(toStringLLItemNode(retItemList));
            continue;
          case "sortByPurchasePeriod":
            day1 = Integer.parseInt(arrayOfString[1].trim());
            month1 = Integer.parseInt(arrayOfString[2].trim());
            year1 = Integer.parseInt(arrayOfString[3].trim());
            day2 = Integer.parseInt(arrayOfString[4].trim());
            month2 = Integer.parseInt(arrayOfString[5].trim());
            year2 = Integer.parseInt(arrayOfString[6].trim());
            retItemList = stockMgmt.sortByPurchasePeriod(day1, month1, year1, day2, month2, year2);
            System.out.println(toStringLLItemNode(retItemList));
            continue;
          case "sortByStockForCategory":
            category = Integer.parseInt(arrayOfString[1].strip());
            retItemList = stockMgmt.sortByStockForCategory(category);
            System.out.println(toStringLLItemNode(retItemList));
            continue;
          case "filterByCategorySortByDate":
            category = Integer.parseInt(arrayOfString[1].strip());
            retItemList = stockMgmt.filterByCategorySortByDate(category);
            System.out.println(toStringLLItemNode(retItemList));
            continue;
          case "checkMergeSort":
            retItemList = stockMgmt.checkMergeSort();
            System.out.println(toStringLLItemNode(retItemList));
            break;
          default:
            System.err.println("Unknown command: ");
            break;
        }
        System.out.println(stockMgmt.categories);
      }
      //System.out.println(stockMgmt.categories);
    } catch (Exception exception) {
      exception.printStackTrace();
    }
  }
}