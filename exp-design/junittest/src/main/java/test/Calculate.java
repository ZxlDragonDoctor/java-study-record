package test;

public class Calculate {
    int a, b;
	 public void CalAdd(int a, int b){
		this.a=a;
		this.b=b;
	 }
	 public void CalAdd(){
		this.a=0;
		this.b=0;
	 }
    public int add() {
        return a + b;
    }
    public int substract() {
        return a - b;
    }
	public int multiply(){
		 return a * b;
	}
}