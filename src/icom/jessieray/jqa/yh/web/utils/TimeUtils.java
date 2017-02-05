package icom.jessieray.jqa.yh.web.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {

	public static String unixTimeToStr(int str){
		if((str+"").length()!=10)
			return "";
		long time = str*1000l;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(new Date(time));
	}
}
