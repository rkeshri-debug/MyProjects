import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.eclipse.jgit.api.Git;

/*
@author:rahul keshri

*/

// download file from Apache common IO

public class FileDownloadFromInternet {

	public static void main(String[] args) throws FileNotFoundException {

		String source = "ftp://ftp.arin.net/pub/stats/arin/delegated-arin-extended-latest";

		String dest = "D:\\downloadedfile.txt";
		//String gitdir="https://github.com/rkeshri-debug/automation.git";
		
		
	

		try {
			FileUtils.copyURLToFile(new URL(source), new File(dest), 10000, 10000);
			System.out.println("File downloaded successfully in location :" + dest);
		   // FileUtils.moveFileToDirectory(new File(dest), new File(gitdir), true);
		    
		    Git.cloneRepository();

		}

		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
