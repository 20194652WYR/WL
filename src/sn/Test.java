 package sn;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test{

	public static void main(String[] args) {
		int count = 0, fanwei = 0, fushu = 0, p1 = 0, p2;
		int num1 = 0, num2 = 0, sum = 0;
		int i;
		PrintWriter over;
        try{
        over=new PrintWriter("E:/test.txt");//输出的路径和文件名
        }catch(FileNotFoundException e){throw new RuntimeException(e);} 

		// 进行输入条件
		Scanner reader = new Scanner(System.in);
		try{
		System.out.println("请输入题目数量:");
		count = reader.nextInt();
		System.out.println("请输入题目范围:");
		fanwei = reader.nextInt();
		System.out.println("请输入是否有负数,0为无负数，1为有负数：");
		fushu = reader.nextInt();
		System.out.println("请输入是否带有乘除法，0无1有：");
		p1 = reader.nextInt();
		}catch(Exception e){
			System.out.println("输入错误");
		}
		for (i = 0; i < count; i++) {
			String r1 = "";// 如有负数，且负数为num1，则有括号
			String r2 = "";// 如有负数，且负数为num2，则有括号
			p2 = (int) (Math.random() * 4);//
			char jia = '+';
			char jian = '-';
			char cheng = '*';
			char chu = '/';
			char j=' ';
			if (fushu == 0) {
				num1 = (int) (Math.random() * fanwei);
				r1= ""+num1;
				num2 = (int) (Math.random() * fanwei);
				r2 = "" + num2;
			} else {
				num1 = (int) (Math.random() * fanwei * (Math.random() > 0.5 ? 1: -1));
				if (num1 < 0) {
					r1 = "(" + num1 + ")";
				} else {
					r1 = "" + num1;
				}
				num2 = (int) (Math.random() * fanwei * (Math.random() > 0.5 ? 1: -1));
				if (num2 < 0) {
					r2 = "(" + num2 + ")";
				} else {
					r2 = "" + num2;
				}
			}
			// 判断是否有乘除法
			switch (p2) {
			case 0:j='+';
				sum = num1 + num2;
				if (num1 + num2 <= 100) {
					//System.out.println("第" + (i + 1) + "题:" + r1 + "" + jia
						//	+ "" + r2 + "=" + sum + "");
					break;
				}
			case 1:j='-';
				sum = num1 - num2;
				if (num1 - num2 < 100) {
					//System.out.println("第" + (i + 1) + "题:" + r1 + "" + jian
							//+ "" + r2 + "=" + sum + "");
				}
				break;
			case 2:j='*';
				sum = num1 * num2;
				
				switch (p1) {
				case 1:
					if (num1 * num2 <= 100) {
						//System.out.println("第" + (i + 1) + "题:" + r1 + ""
							//	+ cheng + "" + r2 + "=" + sum + "");
						break;
					}
				case 0:
					i--;
					continue;
				}
				break;
			case 3:j='/';
				sum = num1 / num2;
				switch (p1) {
				case 1:
					if (num1 / num2 <= 100) {
						//System.out.println("第" + (i + 1) + "题:" + r1 + "" + chu
							//	+ "" + r2 + "=" + sum + "");
						break;
					}
				case 0:
					i--;
					continue;
				}
				break;
			}
			over.println("第" + (i + 1) + "题:" + r1 + "" + j
					+ "" + r2 + "=" + sum + "");
			over.flush();//
		}
		System.out.println("数据已导出");
	}
}