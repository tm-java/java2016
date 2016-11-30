package jpl.ch06.ex03;

public class VerboseImpl implements Verbose {
	
	Level level;

	@Override
	public void setVerbosity(Level level) {
		this.level = level;
	}

	@Override
	public Level getVerbosity() {
		return this.level;
	}

	
	public static void main(String[] args){
		Verbose v = new VerboseImpl();
		
		for(Level l : Level.values()){
			v.setVerbosity(l);
			System.out.println(v.getVerbosity());
		}
	}
}
