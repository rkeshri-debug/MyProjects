/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.factory;

public class CustomWait {
	public static void appWait(long wt) {
		try {
			Thread.currentThread().sleep(wt*1000);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
