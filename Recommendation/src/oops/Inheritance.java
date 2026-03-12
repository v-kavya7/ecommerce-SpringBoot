package oops;

class Box{
	int l;
	int w;
	int h;
// if parent also has a variable  weight as in child
//	int weight
//	it can be accessed using super such as super.weight
	public Box() {
		this.l=-1;
		this.w=-1;
		this.h=-1;
	}
	public Box(int side) {
		this.l=side;
		this.w=side;
		this.h=side;
	}
	public Box(int l,int w,int h) {
		this.l=l;
		this.w=w;
		this.h=h;
	}
	Box(Box old){
		this.l=old.l;
		this.w=old.w;
		this.h=old.h;
	}
	public void exam() {
//		we use println method to print but we dont need to know internal details to be able to use this
		System.out.println("method");
		System.out.println(this.l+" "+this.w+" "+this.h);
	}
	
}
class BoxWeight extends Box{
	int weight;
	public BoxWeight() {
		this.weight=-1;
	}
	public BoxWeight(int weight) {
		this.weight=weight;
	}
	public void out() {
		System.out.println("child method");
		System.out.println(this.weight);
	}
}
public class Inheritance {
 public static void main(String[] args) {
	BoxWeight general=new BoxWeight();
	general.exam();
	Box parent=new BoxWeight(2);
	parent.exam();
}
}

