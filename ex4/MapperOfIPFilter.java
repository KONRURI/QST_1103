package No4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
//	public static void main(String[] args){
//		Scanner scanner = new Scanner(System.in);
//		while (scanner.hasNext()){
//			String line = scanner.nextLine();
//		}
//	}
//}
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//
		Date beginDate = regularFormat.parse(args[0]);
		Date endDate = regularFormat.parse(args[1]);
	
		String filePath = "C:/Users/50507/Desktop./access.log";
		FileInputStream inputStream = new FileInputStream(filePath);
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		String pattern = "(\\d+.\\d+.\\d+.\\d+) [^ ]* [^ ]* \\[([^ ]*) [^ ]*\\] \"([^ ]+) ([^ ]+) ([^ ]*)\" (\\d+) (\\d+) \"([^ ]+)\" \"(.*)\"";
		//给定的正则表达式编译并赋予给Pattern类
		Pattern r = Pattern.compile(pattern);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMMM/yyyy:ss:mm:HH", Locale.US);

		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String strIp = null;
			String strTime = null;
			Matcher m = r.matcher(line);
			if (m.find()) {
				Date date = dateFormat.parse(m.group(2));
				if (date.before(endDate) && date.after(beginDate)) {
					strIp = m.group(1);
					strTime = date.toString();

			// 对在时间区间内的数据进行输出
			System.out.println(strIp + "\t" + strTime);
				}
			}
	
		}
	}
}
