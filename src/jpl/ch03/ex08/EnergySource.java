package jpl.ch03.ex08;

public abstract class EnergySource implements Cloneable {
	public abstract boolean empty();
	
	public EnergySource clone() throws CloneNotSupportedException{
		return (EnergySource) super.clone();
	}
}
