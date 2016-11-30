package jpl.ch04.ex03;

public class ListCellImpl implements ListCell {
	
	private Object data;
	private ListCell next;
	
	protected ListCellImpl(Object data,ListCell next){
		this.data = data;
		this.next = next;
	}

	@Override
	public Object get() {
		return this.data;
	}

	@Override
	public ListCell next() {
		return this.next;
	}
	
	@Override
	public ListCell setNext(ListCell newNext) {
		ListCell oldNext = this.next;
		this.next = newNext;
		return oldNext;
	}
	
	/**dataが一致していれば、同じものとみなす*/
	public boolean equals(Object obj){
		
		if(obj instanceof ListCell){
			Object other = ((ListCell)obj).get();
			return this.data.equals(other);
		}else {
			return this.data.equals(obj);
		}
		//書き直し1回目（できた）
		/*if(this == obj) return true;
		if(obj == null) return false;
		if(this.getClass() != obj.getClass()) return false;
		
		Object other = ((ListCell)obj).get(); 
		if( this.data == null){
			if(other!=null) return false;
		} else if(!data.equals(other)) return false;
		
		return true;
		*/
		//return this.data.equals(((ListCell)obj).get());
		
		//もともとこう書いていた
		//return this.data.equals(obj);
	}
	
	/**dataのハッシュコードと一致*/
	public int hashCode(){
		/*書き直し1回目（できた）
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.data==null) ? 0 : this.data.hashCode());
		return result;
		*/
		//もともとこう書いていた
		return this.data.hashCode();
	}
	
	public String toString(){
		return this.data.toString();
	}

}
