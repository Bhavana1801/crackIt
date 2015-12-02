import java.util.*;
class palindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		allmethods obj = new allmethods(str);
		String cmpstr = obj.getComplemented(str);
		String revstr = obj.reverse(cmpstr);
		ArrayList<String> strlist = obj.substrings(str);
		ArrayList<String> revstrlist = obj.substrings(revstr);
		obj.checkLists(strlist,revstrlist);
	}
}
class allmethods {
	String str;
	allmethods(String str) {
		this.str = str;
	}
	public String reverse(String str) {
		String str1="";
		for (String part : str.split(" ")) {
    		str1 = str1+ new StringBuilder(part).reverse().toString();		
		}
		return str1;
	}
	public String getComplemented(String str) {
		String str1="";
		String str2;
		int i =0;
		while(i<str.length()) {
			str2 = str.charAt(i)+"";
			if(str2.equals("A")) {
				str1 = str1+str2.replace('A', 'T');
			}
			if(str2.equals("C")) {
				str1 = str1+str2.replace('C','G');
			}
			if(str2.equals("G")) {
				str1 = str1+str2.replace('G','C');
			}
			if(str2.equals("T")){
				str1 = str1+str2.replace('T','A');
			}
			i++;
		}
		return str1;
	}
	public ArrayList<String> substrings(String str) {
		String sub;
		ArrayList<String> sublist = new ArrayList<>();
		int length = str.length();
		for( int c = 0 ; c < length ; c++ )
      	{
         	for(int i = 1 ; i <= length - c ; i++ )
         	{
            	sub = str.substring(c, c+i);
            	sublist.add(sub);
         	}
      	}
      	return sublist;
	}
	public void checkLists(ArrayList<String>list1,ArrayList<String>list2) {
		ArrayList<String> list = new ArrayList<>();
		ArrayList<String> listFinal = new ArrayList<>();
		int i =0;
		int max = 2;
		while(i<list2.size()) {
			if(list1.contains(list2.get(i))) {
				int len = list2.get(i).length();
				if(len>=max) {
					max = len;
				}
				list.add(list2.get(i));
			}
			i++;
		}
		i =0;
		while(i<list.size()) {
			int len = list.get(i).length();
			if(len==max) {
				listFinal.add(list.get(i));
			}
			i++;
		}
		if(listFinal.size() == 0) {
			System.out.println("No reverse palindromic substrings available");
		}
		else{
			Collections.sort(listFinal);
			for(i =0; i<listFinal.size();i++) {
				System.out.println(listFinal.get(i));
			}
		}
	}
}