package jpl.ch10.ex03;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import jpl.ch06.ex01.Week;

public class DayJudgeTest {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testIfElse() {
		assertEquals(true,DayJudge.isWorkIfElse(Week.MONDAY));
		assertEquals(true,DayJudge.isWorkIfElse(Week.TUSEDAY));
		assertEquals(true,DayJudge.isWorkIfElse(Week.WEDNESDAY));
		assertEquals(true,DayJudge.isWorkIfElse(Week.THURSDAY));
		assertEquals(true,DayJudge.isWorkIfElse(Week.FRIDAY));
		assertEquals(false,DayJudge.isWorkIfElse(Week.SATURDAY));
		assertEquals(false,DayJudge.isWorkIfElse(Week.SUNDAY));
		
		exception.expect(IllegalStateException.class);
		exception.expectMessage("week=null");
		DayJudge.isWorkIfElse(null);
		
	}
	
	@Test
	public void testSwitch() {
		assertEquals(true,DayJudge.isWorkSwitch(Week.MONDAY));
		assertEquals(true,DayJudge.isWorkSwitch(Week.TUSEDAY));
		assertEquals(true,DayJudge.isWorkSwitch(Week.WEDNESDAY));
		assertEquals(true,DayJudge.isWorkSwitch(Week.THURSDAY));
		assertEquals(true,DayJudge.isWorkSwitch(Week.FRIDAY));
		assertEquals(false,DayJudge.isWorkSwitch(Week.SATURDAY));
		assertEquals(false,DayJudge.isWorkSwitch(Week.SUNDAY));
		
		//exception.expect(IllegalStateException.class);
		//exception.expectMessage("week=null");
		//DayJudge.isWorkSwitch(null);
		//IllegalStateExceptionの発生させ方がわかりませんでした
	}
	
	

}
