package practice;

public class Stringpractice {

	public static void main(String[] args) {
		/*String s=new String("Rahul");
		s.concat("Keshri");
		/*System.out.println(s);*/

		
		/*StringBuffer sb=new StringBuffer("Tresi");
		sb.append("Rehana");
		System.out.println("sb");*/
		
		/*String s1=new String("Abc");
		String s2=new String("Abc");
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		
		StringBuffer sb1=new StringBuffer("Test");
		StringBuffer sb2=new StringBuffer("Test");
		System.out.println(s1==s2);
		System.out.println(sb1.equals(sb2));
		
		System.out.println("***********");
		
		String str="121";
		//char c='R';
		int i=Integer.parseInt(str,16);
		System.out.println("Actual String:"+i);*/
		
		
		final String s="today";
		s.concat("post");
		System.out.println(s);
		
		String s1= new String ("too");
		s1=s1.concat("pre");
		System.out.println(s1);
		
		
		System.out.println("*******");
		String str1="Tomi";
		String str2="Rohan";
		String abc=str1.concat(str2);
		
	
		String str5=new String("Tomi");
		
		str5=str5.concat("Rohan");
		System.out.println(str5);
		
		StringBuffer str6=new StringBuffer("Tomi");
		
		str6.append("Rohan");
		System.out.println(str6);
		
		/*//System.out.println("Address of str1 : "+System.identityHashCode(str1));
		//System.out.println("Address of str2 : "+System.identityHashCode(str2));
		System.out.println("Length of str1 : "+str1.length());
		System.out.println("Char at 5th element : "+str1.charAt(3));
		System.out.println(abc);*/
	}
	
	
		
}
