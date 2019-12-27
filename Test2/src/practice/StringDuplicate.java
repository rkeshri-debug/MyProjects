package practice;

public class StringDuplicate {

	public static void main(String[] args) {
		String str=new String();
		str="Java Programm";
		int count=0;
		
		char[] chars=str.toCharArray();
		System.out.println("Duplicate characters are:");
		
		for(int i=0;i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(chars[i]==chars[j]){
					System.out.println(chars[j]);
					count++;
					break;
				}
			}
		}
		
		String st="Priyanaka";
		System.out.println(st.length());
		String st2=st.substring(3);
		System.out.println(st2);
		
		String str1="I am a java learner . I am working as QA learner";
		String s[]=str1.split(" ");
		
		/*for (int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}*/
		System.out.println("Duplicate words list");
		for(int i=0;i<s.length;i++){
			for(int j=i+1;j<s.length;j++){
				if(s[i].equals(s[j])){
					System.out.println(s[j]);
					count++;
					break;
				}
			}
		}

	}

}
