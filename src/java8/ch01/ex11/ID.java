package java8.ch01.ex11;

public interface ID {
	default void f(){
		System.out.println("I default");
	}
}
