/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.factory;

import java.util.Date;

public class DateHelper {
	public static String getTimestamp() {
		return String.valueOf(new Date().getTime());
	}
}
