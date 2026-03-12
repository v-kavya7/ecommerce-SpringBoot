package oops;

class Shape{
//    if final cannot be overrideen
	void area() {
		System.out.println("shapes");
	}
}
class Circle extends Shape{
	@Override
	void area() {
		System.out.println("circle");
	}
}
class Triangle  extends Shape{
	@Override
	//if method is not same as in parent class annotation gives error
	void area() {
		System.out.println("Triangle");
	}
}
class Square extends Shape{
	void area() {
		System.out.println("square");
	}
}
public class polymorphism {
public static void main(String[] args) {
	Shape sh=new Shape();
	Circle cir=new Circle();
//	Triangle tri=new Triangle();
	Square sq=new Square();
	Shape obj=new Square();
	sh.area();
	sq.area();
	cir.area();
	obj.area();
	
}
}
