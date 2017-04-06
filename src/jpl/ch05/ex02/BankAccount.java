//HistoryオブジェクトはBankAccountに関連づいているので、ネストしたクラスになるべき
//各口座に対して履歴を保持するので、staticにすべきではない

/**
 * 2/2メモ
 * BandAccount ba = new BankAccount)0
 * ba.deposit();
 * History h1 = ba.history();
 * ba.deposit();
 * History h2 = ba.history();
 * for(Action a = h1.next(); a!=null; a++){
 * 	Sysout(a);
 * }
 * ってするとどうなる？h1は、一回目のdepositだけ観れるべきなのに、２個入っている。
 * また、そのあとで、h2でループを回した時、２こちゃんと表示されない。（nextをnullまでもう走らせてしまっている）
 * 理由：同じ参照を返してしまっているだけだから。
 * historyメソッドはコピーして返す。
 * で、その時Clonnableを実現してもいいんだけど、プライベートなコピーコンストラクタを用意すればいい。
 */

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
	
	public class Action {
		private String act;
		private long amount;
		Action(String act, long amount) {
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
		private int point = 0;
		
		public History(){
			actions = new LinkedList<Action>();
		}
		
		/**
		 * コピーコンストラクタ2/2
		 */
		private History(History other) {
			actions = new LinkedList<Action>(other.actions);
		}
		
		/**
		 * 2/2 書いたは書いたけど、未定義
		 * @return
		 */
		public Action next(){
			if (point >= actions.size()) {
				return null;
			}
			return actions.get(point++);
		}
		
		public void add(Action newAct) {
			if (actions.size() == MAX) {
				actions.remove(0);
			}
			actions.add(newAct);
		}
		
		public String toString() {
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
	
	// 2/2変更
	public History history(){
		return new History(lastTenAct);
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