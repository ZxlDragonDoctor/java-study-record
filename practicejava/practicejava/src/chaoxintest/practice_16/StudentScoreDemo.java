package chaoxintest.practice_16;
//编写一个程序：
//要求通过命令行参数输入 5 个学生的成绩（0~100）的整数，
//并将这 5 个数保存到文件“data.txt”中。
//然后，在从文件“data.txt”中读出这 5 个成绩，计算平均值，并在控制台窗口输出。
//要求：加入相应的异常处理。
import java.io.*;
import java.util.Scanner;

public class StudentScoreDemo {
    public static void main(String[] args) {//注意数据的输入流与输出流在使用上应当互相配套，
	  //例如：采用数据输入流（DataInputStream）读取数据输出流（DataOutputStream）存储的.
		DataOutputStream dfout  = null;
		DataInputStream din  = null;
		try {
		//从键盘输入学生成绩并写入文档
		  Scanner sc = new Scanner(System.in);
		  int s;
		  dfout=new DataOutputStream(new FileOutputStream("d:\\data.txt"));
		  System.out.println("请输入五个学生成绩（0-100间的整数）");
		  for(int i=0;i<5;i++)
		  {		s=sc.nextInt();	
			  dfout.writeInt(s);
		  }
		  if(dfout!=null) {
			  dfout.close();
		  }
		//从文件中读取学生成绩，并统计 
		 int score[]=new int[5];
		  din=new DataInputStream(new FileInputStream("d:\\data.txt"));
		   //选取与输出流配对的输入流
		  int sum=0;
		  for(int i=0;i<5;i++) {
		     score[i]=din.readInt();
		   
		  System.out.print(score[i]+",");
	    	 sum=sum+score[i];
		}
		System.out.println();
		System.out.println("平均值为："+sum/5);
	   if(din!=null){
		   din.close();//关闭输入流
	   }
	}catch(IOException e) {
		System.out.println("异常发生："+e);
	}
  }
}
