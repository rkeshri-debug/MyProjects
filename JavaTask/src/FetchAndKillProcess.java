import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FetchAndKillProcess {

	public static void main(String[] args) throws IOException {
		 try {
		        String line;
		        Process p = Runtime.getRuntime().exec(
		                System.getenv("windir") + "\\system32\\" + "tasklist.exe");

		        BufferedReader input = new BufferedReader(new InputStreamReader(
		                p.getInputStream()));

		        while ((line = input.readLine()) != null) {
		            System.out.println(line); // <-- Parse data here.
		        }
		        input.close();
		    } catch (Exception err) {
		        err.printStackTrace();
		    }

		    Scanner killer = new Scanner(System.in);

		    int tokill;

		    System.out.println("Enter PID to be killed: ");

		    tokill = killer.nextInt();
		    Runtime.getRuntime().exec("taskkill /F /PID "+ tokill );
		    System.out.println(tokill + " Killed successfully..!! ");

	}

}
