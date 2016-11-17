package jpl.ch03.ex07;

public class ColorAttr extends Attr{
	private ScreenColor myColor;//変換された色
	
	public ColorAttr(String name,Object value){
		super(name,value);
		decodeColor();
	}
	
	public ColorAttr(String name){
		this(name, "transparent");
	}
	
	public ColorAttr(String name,ScreenColor value){
		super(name,value.toString());
		myColor = value;
	}
	
	public Object setValue(Object newValue){
		//スーパークラスのsetValueを最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}
	
	/**値を記述ではなくScreenColorに設定する*/
	public ScreenColor setValue(ScreenColor newValue){
		//スーパークラスのsetValueを最初に行う
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}
	
	/**変換されたScreenColorオブジェクトを返す*/
	public ScreenColor getColor(){
		return myColor;
	}
	
	/**getValue()で得られる記述からScreenColorを設定する*/
	protected void decodeColor(){
		if(getValue() == null) myColor = null;
		else myColor = new ScreenColor(getValue());
	}
	
	@Override
	public String toString(){
		String rtn = super.toString();
		rtn += " ("+myColor+")";
		return rtn;
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		
		ColorAttr other = (ColorAttr)obj;
		if(myColor == null){
			if(other.getColor() != null) return false;
		} else if(!myColor.equals(other.getColor())) return false;
		
		return true;
	}
	
	@Override
	public int hashCode(){
		final int prime = 31;
		int result = 1;
		result = prime * result + ((myColor==null) ? 0: myColor.hashCode());
		
		return result;
	}
	
	public static void main(String[] args){
		ColorAttr ca = new ColorAttr("test","red");
		ColorAttr ca2 = new ColorAttr("test","red");
		ColorAttr ca3 = new ColorAttr("test");

		System.out.println("ca  --> "+ca.toString());
		System.out.println("ca2 --> "+ca2.toString());
		System.out.println("ca3 --> "+ca3.toString());
		
		System.out.println("ca = "+ca.hashCode()+", ca2 = "+ca2.hashCode()+", ca3 = "+ca3.hashCode());
		if(ca.equals(ca2)){
			System.out.println("ca equals ca2");
		} else {
			System.out.println("ca does not equals ca2");
		}
		
		if(ca.equals(ca3)){
			System.out.println("ca equals ca3");
		} else {
			System.out.println("ca does not equals ca3");
		}
		
		
	}
}
