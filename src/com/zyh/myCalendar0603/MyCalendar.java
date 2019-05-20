package com.zyh.myCalendar0603;

public class MyCalendar {
	
	//���³����������������������Ϊ����ĵڼ����
	
	public static int cptDay(int year , int month , int day){
		byte dayadd[]={1,-2,1,0,1,0,1,1,0,1,0,1};	//�����洢ÿ����������30�Ĳ�ֵ
		int daycount = 0;	//��������daycount����������ʼ��Ϊ0
			for(int i=0; i<month-1; i++)
				daycount+=(30+dayadd[i]);
			daycount+=day;
			return (month>2)?daycount+isLeap(year):daycount;
	}

	//�����ж�����Σ����귵��1��ƽ�귵��0
	
	public static int isLeap(int year){
		if((year%400==0)||((year%4==0)&&(year%100!=0)))
			return 1;
		return 0;
	}
	
	//�����������������ڼ�
	//�����˻�ķ����ɭ���㹫ʽ 
	//W= (d+2*m+3*(m+1)/5+y+y/4-y/100+y/400) mod 7 
	//�ڹ�ʽ��d��ʾ�����е�������m��ʾ�·�����y��ʾ������
	//ע�⣺�ڹ�ʽ���и���������ʽ��ͬ�ĵط��� 
	//��һ�ºͶ��¿�������һ���ʮ���º�ʮ���£����������2004-1-10����ɣ�2003-13-10�����빫ʽ���㡣 
	
	public static int getWeek(int year,int month,int day){
		if(month<3)
		{ month+=12; year--;}
		return (day+2*month+3*(month+1)/5+year+year/4-year/100+year/400)%7;
	}
	
	//���³��������������������Ϊ����ڼ��ܵ�
	
	public static int weekCount(int year,int month,int day){
		int dayCnt = cptDay(year,month,day);
		int weekminus = getWeek(year,month,day)-getWeek(year,1,1);
		int weekCnt = 0;
		if(dayCnt%7==0) weekCnt = dayCnt/7+((weekminus>0)?1:0);
		else weekCnt = dayCnt/7+((weekminus>0)?2:1);
		return weekCnt;		
	}
	
	//��ӡ������
	
	public static void printCal(int year){
		byte dayadd[]={0,1,-2,1,0,1,0,1,1,0,1,0,1}; //ͬ���ģ�ÿ��������30�Ĳ�ֵ��ע�⣬dadadd[0]��0��û�õ�
		int wkpoint = getWeek(year,1,1);			//wkpoint����ָ����ǰ���ڵ�������		
		int t = 0;									//t������Ϊһ����������������2����29�������
		int bk = 0;									//bk������¼����հ׵���Ŀ
		String week[]={"����һ","���ڶ�","������","������","������","������","������"};
		for(int i=1;i<13;i++)
		{
			t = 0;
			bk = 0;
			if((i==2)&&(isLeap(year)==1)) 
				t = 1;								//���ҽ��������2�·ݲŽ�����Ϊ1
			System.out.println("\n\n\t\t"+year+" �� "+i+" ��\n");
			for(int j=0;j<7;j++)
				System.out.print(week[j]+"\t");
			System.out.println();
			while(bk++<wkpoint)
				System.out.print('\t');
			for(int j=1;j<=(30+dayadd[i]+t);j++)
			{
				System.out.print(j+"\t");			//ѭ�����ÿ������
				if(wkpoint==6) 
					{ wkpoint = 0; System.out.print('\n');}  //��wkpoint������Ϊ6ʱ������Ϊ0��������
				else
					wkpoint++;												
			}
		}
	}
	
	public static void main(String[] args){
		String week[]={"����һ","���ڶ�","������","������","������","������","������"};
		System.out.println("����������Ǹ���ĵ�"+cptDay(2018,6,3)+"��");
		System.out.println("��һ���Ǹ���ĵ�"+weekCount(20018,6,3)+"�� "+week[getWeek(2018,6,3)]);
		printCal(2018);
	}
}
