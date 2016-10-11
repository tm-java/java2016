/*練習1.15*/

package jpl.ch01.ex15;

import java.util.ArrayList;
import java.util.List;

public class ExSimpleLookup implements ExLookup {
	
	private List<String> names;
	private List<Object> values;
	
	public ExSimpleLookup(){
		names = new ArrayList<String>();
		values = new ArrayList<Object>();
	}

	@Override
	public Object find(String name) {
		// TODO Auto-generated method stub
		
		for(int i=0; i<names.size(); i++){
			if(names.get(i).equals(name))
				return values.get(i);
		}
		return null;//見つからなかった
	}

	@Override
	public void add(String name, Object obj) {
		// TODO Auto-generated method stub
		Object o = find(name);
		if(o==null){
			names.add(name);
			values.add(obj);
		}else;//何もしない
	}

	@Override
	public void remove(String name) {
		// TODO Auto-generated method stub
		
		Object o = find(name);
		if(o==null);//何もしない
		else {
			names.remove(name);
			values.remove(o);
		}

	}
	
	public void show(){
		for(int i=0;i<names.size();i++){
			System.out.println("name : "+names.get(i)+ "  value :"+values.get(i));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ExSimpleLookup data = new ExSimpleLookup();
		System.out.println("********initial Data********");
		data.add("No1",1);
		data.add("No2", 2);
		data.add("No3", 3);
		data.add("No4", 4);
		data.add("No5", 5);
		data.show();
		
		System.out.println("*****add \"No1\"(fail) ******");
		data.add("No1", 5);
		data.show();
		
		System.out.println("***remove \"No3\"(success)***");
		data.remove("No3");
		data.show();
		
		

	}
}
