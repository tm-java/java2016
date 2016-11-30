package jpl.ch05.ex02;

import static org.junit.Assert.*;

import org.junit.Test;

import jp.ne.sonet.ca2.yshibata.test.StdoutCapture;

public class BankAccountTest {

	@Test
	public void testNewBA() {
		BankAccount test = new BankAccount(12345,10);
		assertNotNull(test);
	}
	
	@Test
	public void testDeposit(){
		BankAccount test = new BankAccount(12345,10);
		test.deposit(10);
		assertEquals(20,test.getBalance());
		assertEquals("12345: deposit 10",test.lastAction().toString());
	}
	
	@Test
	public void testWithdraw(){
		BankAccount test = new BankAccount(12345,10);
		test.withdraw(10);
		assertEquals(0,test.getBalance());
		assertEquals("12345: withdraw 10",test.lastAction().toString());
	}
	
	@Test
	public void testTranseform(){
		BankAccount test = new BankAccount(12345,10);
		BankAccount other = new BankAccount(54321,10);
		test.transfer(other, new Long(10));
		assertEquals(20,test.getBalance());
		assertEquals(0,other.getBalance());
		assertEquals("12345: transfer 10",test.lastAction().toString());
		assertEquals("54321: transfer 10",other.lastAction().toString());
	}
	
	@Test
	public void testHistory(){
		BankAccount test = new BankAccount(12345,10);
		
		for(int i=0;i<=20;i++){
			test.deposit(i*10);
		}
		
		String str ="";
		for(int i=11;i<=20;i++){
			str += "12345: deposit " + (i*10);
			if(i<20) str+="\n";
		}
		
		assertEquals(str,test.history().toString());
		
	}
	
	@Test
	public void testMain(){
		
		String[] expected = new String[] {
				"*********user1 lastAction*********",
				"12345: open 10",
				"*********user1 history*********",
				"12345: deposit 1",
				"12345: withdraw 2",
				"12345: deposit 4",
				"12345: withdraw 4",
				"12345: deposit 9",
				"12345: withdraw 6",
				"12345: deposit 16",
				"12345: withdraw 8",
				"12345: deposit 10",
				"12345: transfer 10",
				"*********user1 balance*********",
				"balance : 30",
				"",
				"*********user2 history*********",
				"54321: open 10",
				"54321: withdraw 10",
				"12345: transfer 10",
				"*********user2 balance*********",
				"balance : 0"
		};
		StdoutCapture sc = new StdoutCapture();
		sc.start();
		
		BankAccount.main(new String[0]);
		
		sc.stop();
		sc.assertEquals(expected);
		
	}
	
	
	

}
