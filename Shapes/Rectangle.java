package Shapes;

public class Rectangle extends Shape{
	
	public Rectangle(double len, double wid) {
		super(len,wid);
	}
	
	@Override
	public void computeArea() {
		
		System.out.println("Area ="+length*width);
	}
	
	@Override
	public void computePerimeter()
	{
		System.out.println("Perimeter = "+2*(length*width));
		
	}
	
	@Override
	public String toString()
	{
		return "this is a Rectangle";
	}

}
