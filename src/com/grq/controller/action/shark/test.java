package com.grq.controller.action.shark;

import java.util.Vector;

public class test { 
	private static float totalSwallowSum = 6.0f; //统计燕子下注总额之和
	private static float totalPigeonSum = 4.5f;
	private static float totalPeafowlSum = 3.0f;
	private static float totalEagleSum = 3.5f;
	private static float totalLionSum = 5.0f;
	private static float totalPandaSum = 5.5f;
	private static float totalMonkeySum = 4.0f;
	private static float totalRabbitSum = 6.5f;
	private static float priceForPrize = 5.0f;
	public static void main(String[] args) {
		double totalSum[] = new double[]{totalSwallowSum,totalPigeonSum,totalPeafowlSum,totalEagleSum,totalLionSum, totalPandaSum,totalMonkeySum,totalRabbitSum};
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
	    		if(i == 0){
	    			System.out.println("燕子："+lessBird[i]);
	    			return "swallow"; 
	    		} else if(i == 1){
	    			System.out.println("鸽子："+lessBird[i]);
	    			return "pigeon";
	    		} else if(i == 2){
	    			System.out.println("孔雀："+lessBird[i]);
	    			return "peafowl";
	    		} else if(i == 3){
	    			System.out.println("老鹰："+lessBird[i]);
	    			return "eagle";
	    		} else{
	    			System.out.print("不应该出现的error");
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
	} */