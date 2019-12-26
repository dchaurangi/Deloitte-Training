package Shapes;

public class ShapeDrawer implements Drawable {
	
	@Override
	public void draw(Shape s)
	{
		if(s instanceof Rectangle)
		{
			System.out.println("Drawing a rectangle");
		}
		
		else if( s instanceof Square)
		{
			System.out.println("Drawing a square");
		}
	}

}
