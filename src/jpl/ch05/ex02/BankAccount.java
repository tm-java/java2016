//HistoryオブジェクトはBankAccountに関連づいているので、ネストしたクラスになるべき
//各口座に対して履歴を保持するので、staticにすべきではない

package jpl.ch05.ex02;

import java.util.LinkedList;
import java.util.List;

public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History lastTenAct;//lastActを含む過去10件の処理を記録している
	
	public BankAccount(long number, long balance){
		this.number = number;
		this.balance = balance;
		lastAct = new Action("open",balance);
		lastTenAct = new History();
		lastTenAct.add(lastAct);
	}
	
	public class Action{
		private String act;
		private long amount;
		Action(String act, long amount){
			this.act = act;
			this.amount = amount;
		}
		
		public String toString() {
			return number + ": " + act + " " + amount;
		}
	}
	
	public class History{
		private List<Action> actions;
		private final int MAX = 10;
		
		public History(){
			actions = new LinkedList<Action>();
		}
		/**Actionオブジェクトを１つ返して、リストの最後では、nullを返す?*/
		public Action next(){
			return null;
		}
		public void add(Action newAct){
			if(actions.size()==MAX) {
				actions.remove(0);
			}
			actions.add(newAct);
		}
		
		public String toString(){
			String rtn = "";
			for(int i=0;i<actions.size();i++){
				rtn += actions.get(i).toString();
				if(i<(actions.size()-1)) rtn += "\n";
			}
			return rtn;
		}
	}
	
	public void deposit(long amount){
		balance += amount;
		lastAct = new Action("deposit", amount);
		lastTenAct.add(lastAct);
	}
	
	public void withdraw(long amount){
		balance -= amount;
		lastAct = new Action("withdraw", amount);
		lastTenAct.add(lastAct);
	}
	
	public void transfer(BankAccount other, Long amount){
		other.withdraw(amount);
		deposit(amount);
		lastAct = this.new Action("transfer", amount);
		lastTenAct.add(lastAct);
		other.lastAct = other.new Action("transfer", amount);
		other.lastTenAct.add(lastAct);
	}
	
	public History history(){
		return lastTenAct;
	}
	
	public long getBalance(){
		return this.balance;
	}
	
	public long getNumber(){
		return this.number;
	}
	
	public Action lastAction(){
		return lastAct;
	}

	public static void main(String[] args){
		BankAccount user1 = new BankAccount(12345,10);
		BankAccount user2 = new BankAccount(54321,10);
		System.out.println("*********user1 lastAction*********");
		System.out.println(user1.lastAction());
		for(int i=0;i<5;i++){
			user1.deposit(i*i);
			user1.withdraw(i*2);
		}
		user1.transfer(user2, new Long(10));
		System.out.println("*********user1 history*********");
		System.out.println(user1.history());
		System.out.println("*********user1 balance*********");
		System.out.println("balance : "+user1.getBalance());
		
		System.out.println();
		
		System.out.println("*********user2 history*********");
		System.out.println(user2.history());
		System.out.println("*********user2 balance*********");
		System.out.println("balance : "+user2.getBalance());
		
		
		
	}
}