package java8.ch04.ex03;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Staff {
	private static long nextId = 0;
	
	private final String name;
	private StringProperty nameP = null;
	private final long id;
	private LongProperty idP = null;
	
	public Staff(String name) {
		this.name = name;
		this.id = nextId++;
	}
	
	public final String getName() {
		if (nameP == null) {
			return this.name;
		} else {
			return this.nameP.get();
		}
	}
	
	public final void setName(String name) {
		if (this.nameP == null) {
			this.nameP = new SimpleStringProperty();
		}
		this.nameP.set(name);
	}
	
	public final StringProperty getNameProperty() {
		if (this.nameP == null) {
			this.nameP = new SimpleStringProperty(this.name);
		}
		return this.nameP;
	}
	
	public final long getId() {
		if (this.idP == null) {
			return id;
		} else {
			return this.idP.get();
		}
	}
	
	public final void setId(long id) {
		if (this.idP == null) {
			this.idP = new SimpleLongProperty();
		}
		this.idP.set(id);
	}
	
	public final LongProperty getIdProperty() {
		if (this.idP == null) {
			this.idP = new SimpleLongProperty(this.id);
		}
		return this.idP;
	}
}
