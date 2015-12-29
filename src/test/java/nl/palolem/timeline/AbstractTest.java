package nl.palolem.timeline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AbstractTest {

	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

	protected Date getDate(String str) {
		try {
			return df.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
