public class SimpleCollectionDemo{
  public static void main(String[] args){
  	SimpleCollection sc=new SimpleCollection();
  	
  	sc.add(new Foo1("Ò»ºÅFoo1"));
  	sc.add(new Foo2("¶þºÅFoo2"));
  	
  	Foo1 f1=(Foo1)sc.get(0);
  	f1.showName();
  	
  	Foo2 f2=(Foo2)sc.get(1);
  	f2.showName();
  }
}