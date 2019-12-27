package practice;

public class Theift_New {

	public static void main(String[] args) {
		int evenamount = 0, oddamount = 0;

		int ar[] = { 800, 200, 60, 78, 50 };
		String evenString = "";
		String oddString = "";

		for (int i = 0; i < ar.length; i++) {
			if (i % 2 == 0) {
				evenamount = ar[i] + evenamount;
				evenString = evenString.concat(String.valueOf(i) + " ");
				
			} else {
				oddamount = ar[i] + oddamount;
				oddString = oddString.concat(String.valueOf(i) + " ");
			}
		}
		System.out.println("evenamount: " +evenamount + " " + "oddamount: " +oddamount);
		if (evenamount > oddamount) {
			System.out.print("thefted house_number:" + evenString);
		} else {
			System.out.print("thefted house_number:" + oddString);

		}

	}

}
