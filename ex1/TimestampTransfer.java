package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")//资源注入
	public static void main(String[] args){ //main方法
		Scanner scanner = new Scanner(System.in);//设置键盘输入 实例化调用方法
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//初始化并表明输入格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//初始化并标明输出格式
		while (scanner.hasNext()){//循环判断键盘输入
			String line = scanner.nextLine();//获取输入 赋值给line
			Date lineDate = null;//将lineDate赋值为null
			long lineTimestamp;//将时间戳类型转换为line
			try {
				lineDate = inputFormat.parse(line);//解析输入日期
				lineTimestamp = lineDate.getTime();//得到时间戳时间 单位为毫秒
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);//输出时间格式为时间to时间戳
			} catch (ParseException e) {//捕获异常
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
