package Shapes;

public class Square extends Shape {

	public Square(double length) {
		super(length);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void computeArea() {
		System.out.println("Area ="+length*length);
	}

	@Override
	public void computePerimeter() {
		System.out.println("Perimeter ="+length*4);

	}
	
	@Override
	public String toString()
	{
		return "This is a square";
	}

}
