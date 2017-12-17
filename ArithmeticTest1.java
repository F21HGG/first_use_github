import java.io.*;
import java.util.Date;
import java.util.Random;
public class SZYS
{
  public static void main(String[] args)throws Exception
  {
    int number,score=0,operator=0;
    final int add=0, sub=1, mul=2, div=3, ran=4;
    final String operation[]={"＋","—","×","÷"};
    //十行五列的数组用于存放10条  每行分别为  随机数1 运算符 随机数2 答案 用户答案
    
    int question[][] = new int[10][5];
    int temp;             //temp 只作为减法时的转换变量 其他地方没有作用
    
    Random numberGenerator = new Random(new Date().getTime());
    if     (args[0].trim().toUpperCase().equals("+"))
      operator=add;
    else if(args[0].trim().toUpperCase().equals("-"))
      operator=sub;
    else if(args[0].trim().toUpperCase().equals("X"))
      operator=mul;
    else if(args[0].trim().toUpperCase().equals("/"))
      operator=div;
    else if(args[0].trim().toUpperCase().equals("R"))
      operator=ran;
    else if(args.length<2)
    {
        System.out.println("运算符应为+-X/R之一，请重新运行程序。");
	return;
    }
    
    number = Integer.parseInt(args[1]);    //将运算位数储存到number   int变量中

    BufferedReader keyboardIn = new BufferedReader(new InputStreamReader(System.in));
    //本条语句用于使用者可以键入答案
    for(int i=1; i<=10; i++)
    { 
      if(operator==ran)
        question[i-1][1]=numberGenerator.nextInt(4);
      else  
	question[i-1][1]=operator;                 //存入运算符
	  
      question[i-1][0]=numberGenerator.nextInt((int)Math.pow(10,number));  //运算位数在此两条中得到运用    //第一个数
      question[i-1][2]=numberGenerator.nextInt((int)Math.pow(10,number));      //第二个数
      //存入第一个与第二个随机数
	  
      //解决减法中的特殊情况
      if(question[i-1][1]==sub && question[i-1][0] < question[i-1][2])
      {
         temp = question[i-1][0];
	 question[i-1][0] = question[i-1][2];
	 question[i-1][2] = temp;
      }                                                               //通过变量temp实现减数与被减数的位置交换
      while(question[i-1][1]==div && question[i-1][2]==0)
      {
	question[i-1][2]=numberGenerator.nextInt((int)Math.pow(10,number));  //不断循环迭代除数直到while判定除数不为0  
      }
    //下面开始打印题目
      System.out.print("第"+i+"题: " + question[i-1][0] + operation[question[i-1][1]] + question[i-1][2] +" = ");     	
	
      question[i-1][4] = Integer.parseInt(keyboardIn.readLine());  //将键盘输入的储存到question[i-1][4] 中
	
	  switch (question[i-1][1])
	  {
	     case add:
               question[i-1][3] = question[i-1][0]+question[i-1][2];
               if(question[i-1][4] == question[i-1][3])
                 score += 10;
			   break;

	     case sub:
               question[i-1][3] = question[i-1][0]-question[i-1][2];
               if(question[i-1][4] == question[i-1][3])
                 score += 10;
               break;			 
	    
             case mul:
               question[i-1][3] = question[i-1][0]*question[i-1][2];
               if(question[i-1][4] == question[i-1][3])
                 score += 10;
			   break;
			   
             case div:
               question[i-1][3] = question[i-1][0]/question[i-1][2];
               if(question[i-1][4] == question[i-1][3])
                 score += 10;	
			   break;
	  }
	}
	keyboardIn.close();   //关闭键盘输入流
	
	System.out.println("你本次的练习结果为(其中倒数第二栏为标准答案，最后一栏为你的答案)：");
	for(int i=1; i<=10; i++)
        {
	  String forprint="%1$"+number+"d"+operation[question[i-1][1]] +"%2$"+number+"d = %3$"+(number+2)+"d %4$"+(number+2)+"d\n";
	  System.out.printf(forprint,question[i-1][0],question[i-1][2],question[i-1][3],question[i-1][4]);//使用格式输出
	}   	
	System.out.println("你本次练习的得分为："+score+"。");
  } 
}