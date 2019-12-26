package Shapes;

public abstract class Shape {
	
	protected double length;
	protected double width;
	protected double heigth;
	
	
	public Shape(double length)
	{
		this.length=length;
	}
	
	public Shape(double length, double width)
	{
		this(length);
		this.width=width;
		
	}

	
	public Shape(double length, double width, double height)
	{
		this(length,width);
		this.heigth=height;
	}
	
	public abstract void computeArea();
	public abstract void computePerimeter();
	
	@Override
	public String toString()
	{
		return "Some shapes";
	}


}
