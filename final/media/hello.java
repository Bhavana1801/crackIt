import java.util.*;
import java.lang.*;
import java.io.*;
class example {
	example()
	{

	}
	public void printt(Patron p) {
		Patron x=p;
	System.out.println("Cust Name:"+x.pname);
		System.out.println("Cust number:"+x.pnumber);
	}
	
}
public class hello {
	public static void main(String[] args) {
		Patron temp;
		String custNumb,custName;
		Scanner in1=new Scanner(System.in);
		custName=in1.nextLine();
						System.out.println("Enter mobile number:");
						custNumb=in1.nextLine();
						System.out.println("ahh");
						temp=new Patron(custName,custNumb);
						example ex=new example();
						ex.printt(temp);
	}
}
