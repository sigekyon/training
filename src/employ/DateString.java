package employ;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateString {
	public static String getDate14(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date);
	}
	
}
