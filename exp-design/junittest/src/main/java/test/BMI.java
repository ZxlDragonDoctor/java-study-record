package test;

public class BMI {
	//定义属性
	private double weight;  //体重
	private double height;  //身高
	
	//getter和setter
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	//一次性设置身高和体重
	public void setParams(double w, double h) {
		this.height = h;
		this.weight = w;
	}
	
	//定义构造方法
	public BMI(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	public BMI() {
		this.height = 0.0;
		this.weight = 0.0;
	}	
	
	//定义功能方法，计算BMI，并判断所属分类
	public String getBMIType() {
		
		//1.初始化
		String result = "";
		double bmi = 0.0;
		
		if(weight>0 && height>0) {
			//2.计算bmi
			bmi = weight/(height*height);
			
			//3.根据bmi判断所属健康分类
			if(bmi<18.5){
				result = "偏瘦";
			}else if(bmi<24){
				result = "正常";
			}else if(bmi<28){
				result = "偏胖";
			}else{
				result = "肥胖";
			}
		}else{
			return "weight or height error!";
		}
		//4.返回分类
		return result;
		
	}
}