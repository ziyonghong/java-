package com.zyh.overload0410;

public class Overload {
	static int getsum(int x,int y)
	{
		return x+y;
	}
	static int getsum(int x,int y,int z)
	{
		return x+y+z;
	}
	static double getsum(double x,double y)
	{
		return x+y;
	}
	public static void main(String[] args){
		System.out.println(getsum(1,5));
		System.out.println(getsum(1,6,3));
		System.out.println(getsum(1.2,3.6));
		
		
	}
}
