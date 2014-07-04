package com.grq.controller.action.shark;


/**
 * 可行


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Vector;
public class test { 
	private static float totalSwallowSum = 6.0f; //统计燕子下注总额之和
	private static float totalPigeonSum = 4.6151f;
	private static float totalPeafowlSum = 3.0f;
	private static float totalEagleSum = 3.5f;
	private static float totalLionSum = 5.0f;
	private static float totalPandaSum = 5.5f;
	private static float totalMonkeySum = 4.0f;
	private static float totalRabbitSum = 6.5f;
	private static float priceForPrize = 5.0f;
	public static void main(String[] args) {
		float swallowOutScore = (float) (totalSwallowSum*0.8);
		float pigeonOutScore = (float) (totalPigeonSum*1);
		float peafowlOutScore = (float) (totalPeafowlSum*8);
		float eagleOutScore = (float) (totalEagleSum*0.5);
		float lionOutScore = (float) (totalLionSum*24);
		float pandaOutScore = (float) (totalPandaSum*8);
		float monkeyOutScore = (float) (totalMonkeySum*6);
		float rabbitOutScore = (float) (totalRabbitSum*6);		
		ArrayList<Object> totalSum = new ArrayList<Object>();		
		totalSum.add(swallowOutScore);
		totalSum.add(pigeonOutScore);
		totalSum.add(peafowlOutScore);
		totalSum.add(eagleOutScore);
		totalSum.add(lionOutScore);
		totalSum.add(pandaOutScore);
		totalSum.add(monkeyOutScore);
		totalSum.add(rabbitOutScore);
		
		ArrayList<Object> totalSumFormat = new ArrayList<Object>();//用于保存格式化后的值
		for(int i = 0; i < totalSum.size(); i++){
			BigDecimal   bd   =   new   BigDecimal((Float)totalSum.get(i));
			bd   =   bd.setScale(2,BigDecimal.ROUND_HALF_UP);//2是设置位数，BigDecimal.ROUND_HALF_UP表示四舍五入，可以选择其他舍值方式
			float bdFloat  =   bd.floatValue();
			System.out.println("bdFloat:"+pigeonOutScore); 
			totalSumFormat.add(bdFloat);
		}
		Vector<Object> less = lessThan(totalSum,priceForPrize);
	    for (int i = 0; i < less.size(); i++){ 
	    	System.out.println(less.get(i)); 
		    System.out.println("第"+i+"个");
	    }
	}
	

	private static Vector<Object> lessThan(ArrayList<Object> totalSum,float b) {
		Vector<Object> v = new Vector<Object>(totalSum.size()); 
		for(int i=0 ; i<totalSum.size() ; i++){
			if ((Float)totalSum.get(i) < b){
				v.add(totalSum.get(i));
				//System.out.println("第"+i+"个");
			}
		}
		return v;
	}

} */

/**
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Vector;

public class test { 
	private static float totalSwallowSum = 6.0f; //统计燕子下注总额之和
	private static float totalPigeonSum = 4.611f;
	private static float totalPeafowlSum = 3.0f;
	private static float totalEagleSum = 3.5f;
	private static float totalLionSum = 5.0f;
	private static float totalPandaSum = 5.5f;
	private static float totalMonkeySum = 4.0f;
	private static float totalRabbitSum = 6.5f;
	private static float priceForPrize = 5.0f;
	public static void main(String[] args) {
		float swallowOutScore =(float)(totalSwallowSum*6);
		float pigeonOutScore =totalPigeonSum*1;
		
		String parten = "#.##";
		DecimalFormat decimal = new DecimalFormat(parten);
		String str= decimal.format(pigeonOutScore);
		
		//float   ft   =   134.3435f;  
		//  int   scale   =   2;//设置位数  
		 // int   roundingMode   =   4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.  
		//  BigDecimal   bd   =   new   BigDecimal((double)pigeonOutScore);  
		 // bd   =   bd.setScale(scale,roundingMode);  
		 // pigeonOutScore   =   bd.floatValue(); 
		
		System.out.println("出分："+str+"个");
		float peafowlOutScore = totalPeafowlSum*8;
		float eagleOutScore = totalEagleSum*24;
		float lionOutScore =totalLionSum*24;
		float pandaOutScore =totalPandaSum*8;
		float monkeyOutScore =totalMonkeySum*6;
		float rabbitOutScore =totalRabbitSum*6;
				
		//double totalSum[] = new double[]{swallowOutScore,pigeonOutScore,peafowlOutScore,eagleOutScore,lionOutScore,pandaOutScore,monkeyOutScore,rabbitOutScore};
		double totalSum[] = new double[]{swallowOutScore,pigeonOutScore,totalPeafowlSum,totalEagleSum,totalLionSum, totalPandaSum,totalMonkeySum,totalRabbitSum};
		double[] less = lessThan(totalSum,priceForPrize);
		Vector<Object> v = new Vector<Object>(less.length);//用于记录可吃分奖项的索引
		for (int i = 0; i < less.length; i++){
			if(less[i] != 0){
				System.out.println(less[i]);
				System.out.println("第"+i+"个");
				v.add(i);
			}
	    }
		int index=(int)(Math.random()*v.size());//随机一个能吃分奖的索引的索引
		System.out.println(v.get(index));
		System.out.println(less[(Integer) v.get(index)]);
	}
	public static double[] lessThan(double a[],double b ){
		double[] less = new double[a.length];
	    for(int i=0 ; i<a.length ; i++){
	    	if (a[i] < b){
	    		less[i] = a[i] ;
	    	}else {
	    		less[i] = 0;
	    	}
	    }
		return less;
	}
	
}
*/

/**
 * 
import java.util.ArrayList;
public class test { 
	private static float totalSwallowSum = 3.0f; //统计燕子下注总额之和
	private static float totalPigeonSum = 3.5f;
	private static float totalPeafowlSum = 4.0f;
	private static float totalEagleSum = 4.5f;
	private static float totalLionSum = 5.0f;
	private static float totalPandaSum = 5.5f;
	private static float totalMonkeySum = 6.0f;
	private static float totalRabbitSum = 6.5f;
	private static float priceForPrize = 5.0f;
	public static void main(String[] args) {
		//ArrayList<Object> totalSum = new ArrayList<Object>();
		//totalSum.add(totalSwallowSum);
		//totalSum.add(totalPigeonSum);
		//totalSum.add(totalPeafowlSum);
		//totalSum.add(totalEagleSum);
		//totalSum.add(totalLionSum);
		//totalSum.add(totalPandaSum);
		//totalSum.add(totalMonkeySum);
		//totalSum.add(totalRabbitSum);
		double totalSum[] = new double[]{totalSwallowSum,totalPigeonSum,totalPeafowlSum,totalEagleSum,totalLionSum, totalPandaSum,totalMonkeySum,totalRabbitSum};
		ArrayList<Object> less = lessThan(totalSum,priceForPrize);
		for (int i = 0; i < less.size(); i++){
		      System.out.println(less.get(i)); 
	    }
	}
	
	public static ArrayList<Object> lessThan(double a[],double b ){
		ArrayList<Object> lessList = new ArrayList<Object>();
	    for(int i = 0; i < a.length; i++){
	    	if (a[i] < b){
	    		lessList.add(a[i]);
	    	}
	    }
		return lessList;
	}
	
}




*/
	

/**
 * 可行

import java.util.Vector;
public class test { 
	private static float totalSwallowSum = 4.0f; //统计燕子下注总额之和
	private static float totalPigeonSum =5.5f;
	private static float totalPeafowlSum = 3.0f;
	private static float totalEagleSum = 3.5f;
	private static float totalLionSum = 5.0f;
	private static float totalPandaSum = 4.5f;
	private static float totalMonkeySum = 6.0f;
	private static float totalRabbitSum = 6.5f;
	private static float priceForPrize = 5.0f;

	public static void main(String[] args) { 
		System.out.println("获取数:");
		double totalSum[] = new double[]{totalSwallowSum,totalPigeonSum,totalPeafowlSum,totalEagleSum,totalLionSum, totalPandaSum,totalMonkeySum,totalRabbitSum};
		Object[] less = lessThan(totalSum,priceForPrize);
	    for (int i = 0; i < less.length; i++){
		      System.out.println(less[i]); 
	    }
	} 
	 public static Object[] lessThan(double a[],double b ){

	        Vector<Double> v = new Vector<Double>(a.length); 
	        for(int i=0 ; i<a.length ; i++){
	            if (a[i] < b){
	        	 v.add(a[i]);
	        	}
	        }
	        return v.toArray();
	    }
}
 */



/**
public class test{
	  public static int[] drawing(int low, int high){ 
	    int[] nos= new int[6]; 
	    for(int i=0;i<=5;i++){ 
	      nos[i] = (int) ((high - low +1)* Math.random()) + low; 
	      // System.out.println(nos[i]); 
	    } 
	    return nos; 
	  }
	  public static void main(String args[]){
	   int min=3,max=5;
	   int[] a=drawing(min,max); 
	    for (int i=0; i<=5; i++){ 
	      System.out.println(a[i]); 
	    } 
	  } 

	}
*/
/**
 * 
import java.util.Scanner;
public class test { 
	public static void main(String[] args) { 
		Scanner console = new Scanner(System.in);
		int[] a = new int[5]; 
		for(int i=0;i<a.length;i++){
			System.out.println("请输入组数:");
			a[i] = console.nextInt();
		}
		System.out.println(average(a));
		} 
	public static double average(int a[]){  
		double sum = 0.0;  
		for (int i = 0; i < a.length; i++){ 
			sum += a[i];    
			}  
		return sum / a.length;
		}
	} */
/**
 * 
 * @author 泉
 *

import java.util.Arrays;
public class test{  
	public static void main(String[] args)  {   
		int[] a=new int[]{1,2,3,10,4,9,8,-4};   
		Arrays.sort(a);   
		for(int i=0;i<a.length;i++)     
			System.out.println(a[i]);    
		}
	} 
 **/
import java.util.ArrayList;

public class test{ 
	public static void main(String[] args) { 
		ArrayList<Object> totalSum = new ArrayList<Object>();		
		totalSum.add("5");//注意顺序不能弄乱
		totalSum.add("2");
		totalSum.add("3");
		totalSum.add("10");
		totalSum.add("4");
		totalSum.add("9");
		totalSum.add("-8");
		totalSum.add("-4");
		double minNum = calculationMin(totalSum);
		System.out.println(minNum);
	}

	private static double calculationMin(ArrayList<Object> sampleList) {
        try{
        	double min = Double.parseDouble(sampleList.get(0).toString());
            int totalCount = sampleList.size();
            if (totalCount > 0){
              for (int i = 0; i < totalCount; i++){
             	 double temp = Double.parseDouble(sampleList.get(i).toString());
             	 if (min > temp){
             		 min = temp;
             	 }
              }
            }
            return min;
        }catch (Exception ex) {
     	   System.out.printf("通用计算公式", "获取集合中的最小值:" + ex.getMessage());
        }
		return (Double) null;
    }
}
