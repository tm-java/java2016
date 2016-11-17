package jpl.ch03.ex07;

public class ScreenColor {
	private Integer r;//0~255
	private Integer g;//0~255
	private Integer b;//0~255
	
	public static final int MAX = 255;
	
	public ScreenColor(){}
	
	public ScreenColor(int r,int g,int b){
		setR(r);
		setG(g);
		setB(b);
	}
	
	/**valueが"red""blue""green""white"の場合に値のセットを行う*/
	public ScreenColor(Object value){
		if(value.equals("red")){
			setR(MAX);setG(0);setB(0);
		} else if(value.equals("blue")){
			setR(0);setG(0);setB(MAX);
		} else if(value.equals("green")){
			setR(0);setG(MAX);setB(0);
		} else if(value.equals("white")){
			setR(MAX);setG(MAX);setB(MAX);
		} else;
	}
	
	public void setR(int r){
		if(MAX < r) this.r = MAX;
		else if(0 > r) this.r = 0;
		else this.r = r;
	}
	
	public void setG(int g){
		if(MAX < g) this.g = MAX;
		else if(0 > g) this.g = 0;
		else this.g = g;
	}
	
	public void setB(int b){
		if(MAX < b) this.b = MAX;
		else if(0 > b) this.b = 0;
		else this.b = b;
	}
	
	public Integer getR(){
		return r;
	}
	
	public Integer getG(){
		return g;
	}
	
	public Integer getB(){
		return b;
	}
	
	@Override
	public String toString(){
		if(r != null && g != null && b != null) { 
			if(r==MAX && g==MAX && b==MAX) return "white";
			if(r==MAX && g==0   && b==0  ) return "red";
			if(r==0   && g==MAX && b==0  ) return "green";
			if(r==0   && g==0   && b==MAX) return "blue";
			
			return "r : "+r+", g : "+g+", b : "+b;
		}
		return "r : "+r+", g : "+g+", b : "+b;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(getClass() != obj.getClass()) return false;
		
		ScreenColor other = (ScreenColor)obj;
		if(r == null){
			if(other.getR() != null) return false;
		} else if(!r.equals(other.getR())) return false;
		
		if(g == null){
			if(other.getG() != null) return false;
		} else if(!g.equals(other.getG())) return false;
		
		if(b == null){
			if(other.getB() != null) return false;
		} else if(!b.equals(other.getB())) return false;
		
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((r == null) ? 0 : r.hashCode());
		result = prime * result + ((g == null) ? 0 : g.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		
		return result;
	}
	
	

}
