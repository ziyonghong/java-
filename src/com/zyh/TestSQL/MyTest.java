package com.zyh.TestSQL;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyTest {
public static void main(String[] args) {
	ArrayList a=new ArrayList();
	LinkedList l=new LinkedList();
	long time=System.currentTimeMillis();
	for(int i=0;i<100000;i++){
		a.add(i);
	}
	time=System.currentTimeMillis()-time;
	System.out.println(time);
	time=System.currentTimeMillis();
	for(int i=0;i<100000;i++){
		l.add(i);
	}
	time=System.currentTimeMillis()-time;
	System.out.println(time);
}
}
