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
        over=new PrintWriter("E:/test.txt");//�����·�����ļ���
        }catch(FileNotFoundException e){throw new RuntimeException(e);} 

		// ������������
		Scanner reader = new Scanner(System.in);
		try{
		System.out.println("��������Ŀ����:");
		count = reader.nextInt();
		System.out.println("��������Ŀ��Χ:");
		fanwei = reader.nextInt();
		System.out.println("�������Ƿ��и���,0Ϊ�޸�����1Ϊ�и�����");
		fushu = reader.nextInt();
		System.out.println("�������Ƿ���г˳�����0��1�У�");
		p1 = reader.nextInt();
		}catch(Exception e){
			System.out.println("�������");
		}
		for (i = 0; i < count; i++) {
			String r1 = "";// ���и������Ҹ���Ϊnum1����������
			String r2 = "";// ���и������Ҹ���Ϊnum2����������
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
			// �ж��Ƿ��г˳���
			switch (p2) {
			case 0:j='+';
				sum = num1 + num2;
				if (num1 + num2 <= 100) {
					//System.out.println("��" + (i + 1) + "��:" + r1 + "" + jia
						//	+ "" + r2 + "=" + sum + "");
					break;
				}
			case 1:j='-';
				sum = num1 - num2;
				if (num1 - num2 < 100) {
					//System.out.println("��" + (i + 1) + "��:" + r1 + "" + jian
							//+ "" + r2 + "=" + sum + "");
				}
				break;
			case 2:j='*';
				sum = num1 * num2;
				
				switch (p1) {
				case 1:
					if (num1 * num2 <= 100) {
						//System.out.println("��" + (i + 1) + "��:" + r1 + ""
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
						//System.out.println("��" + (i + 1) + "��:" + r1 + "" + chu
							//	+ "" + r2 + "=" + sum + "");
						break;
					}
				case 0:
					i--;
					continue;
				}
				break;
			}
			over.println("��" + (i + 1) + "��:" + r1 + "" + j
					+ "" + r2 + "=" + sum + "");
			over.flush();//
		}
		System.out.println("�����ѵ���");
	}
}