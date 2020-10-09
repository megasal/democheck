package assignment5;
import java.util.Comparator;
public class DateNode implements DateInterface,Comparable<DateNode> {

	int day;
	int month;
	int year;

	public DateNode(int day, int month , int year){
		this.day = day;
		this.month= month;
		this.year = year;
	}

	public int getDay(){
		return this.day;
	}

	public int getMonth(){
		return this.month;
	}

	public int getYear(){
		return this.year;
	}
	public int compareTo(DateNode d) {
		if(this.year>d.year)
			return 1;
		else if(this.year<d.year)
			return -1;
		else if(this.month>d.month)
			return 1;
		else if(this.month<d.month)
			return -1;
		else if(this.day > d.day)
			return 1;
		else if(this.day < d.day)
			return -1;
		else
		return 0;
	}
	public String toString() {
		return ""+ day + " "+month +" "+ year;
	}
}
