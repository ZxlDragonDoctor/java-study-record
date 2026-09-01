/*
 //演示Object类是所以类的直接或间接父类
 //下面编写的是一个简单的集合类，并将一些自定义的类的实例加入其中。
 //该类以Object数组来存储对象。
*/
public class SimpleCollection{
    private Object[] objArr;
    private int index=0;
    
    public SimpleCollection(){
    	objArr=new Object[10];//预设10个对象空间
    	}
    public SimpleCollection(int capacity){
    	objArr=new Object[capacity];
    	}
    public void add(Object o){
    	objArr[index]=o;
    	index++;
    	}
    public int getLength(){
    	return index;
    	}
    public Object get(int i){
    	return objArr[i];
    	}	
 
}


	
