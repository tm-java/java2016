/**
 * switchの方が明瞭だと考える
 * （理由）
 * 短く書ける（同じような部分を重複して書かなくても良い）
 * */

package jpl.ch10.ex03;

import jpl.ch06.ex01.Week;

public class DayJudge {
	
	public static boolean isWorkIfElse(Week w) throws IllegalStateException{
		if(w == Week.MONDAY) return true;
		else if(w == Week.TUSEDAY) return true;
		else if(w == Week.WEDNESDAY) return true;
		else if(w == Week.THURSDAY) return true;
		else if(w == Week.FRIDAY) return true;
		else if(w == Week.SATURDAY) return false;
		else if(w == Week.SUNDAY) return false;
		else throw new IllegalStateException("week="+w);
	}
	
	public static boolean isWorkSwitch(Week w)throws IllegalStateException{
		switch(w){
			case MONDAY: 
			case TUSEDAY:
			case WEDNESDAY:
			case THURSDAY:
			case FRIDAY:
				return true;
			
			case SATURDAY: 
			case SUNDAY:
				return false;
			
			default:
				throw new IllegalStateException("week="+w);
		}
	}
	
	public static void main(String[] args){
		if(isWorkIfElse(Week.FRIDAY)) System.out.println("friday is work day");
		if(isWorkSwitch(Week.MONDAY)) System.out.println("monday is work day");
		if(!isWorkIfElse(Week.SATURDAY)) System.out.println("saturday is not work day");
		
	}
}
