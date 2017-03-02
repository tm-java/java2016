package jpl.ch14.ex06;

public class ShowTime {
	private final CountTime ct = new CountTime();
	
	public ShowTime() {
		Runnable message15 = new Runnable() {
			public void run() {
				try {
					while(true){
						if(ct.countSeconds(15)){
							System.out.println("(^^)15 seconds!");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(message15).start();
		
		Runnable message7 = new Runnable() {
			public void run() {
				try {
					while(true){
						if(ct.countSeconds(7)){
							System.out.println("(*o*)7 seconds!");
						}
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		new Thread(message7).start();
		
		Runnable secondCount = new Runnable() {
			public void run() {
				ct.oneSecond();
			}
		};
		new Thread(secondCount).start();
		
	}

	public static final void main(String[] args) {
		ShowTime st = new ShowTime();	
	}

}
