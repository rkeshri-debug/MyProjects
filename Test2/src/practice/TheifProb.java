package practice;

public class TheifProb {
	public static void main(String[] args) {

		int evenamount = 0, oddamount = 0;

		int ar[] = { 10, 200, 60, 78, 50 };
		// int a1[]= new int [6];

		for (int i = 0; i < ar.length; i++) {
			if (i % 2 == 0) {
				evenamount = ar[i] + evenamount;
			} else {
				oddamount = ar[i] + oddamount;
			}
		}
		System.out.println(evenamount + " " +oddamount);
		if (evenamount > oddamount) {
			for (int i = 0; i < ar.length; i++) {
				if (i % 2 == 0) {
					System.out.print(i + " ");
				}

			}
		} else {
			System.out.print("thefted house_number:");
			for (int i = 0; i < ar.length; i++) {
				if (i % 2 == 1) {
					System.out.print(i + " ");
				}

			}
		}
	}
}
