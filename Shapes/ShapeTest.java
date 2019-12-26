package Shapes;

public class ShapeTest {
	
	public static void main(String []args)
	
	{
		Shape box = new Rectangle(20,30);
		box.computeArea();
		box.computePerimeter();
		System.out.println(box.toString());
		
		Shape box1 = new Square(20);
		box1.computeArea();
		box1.computePerimeter();
		System.out.println(box1.toString());
		
		ShapeDrawer sd= new ShapeDrawer();
		draw(sd, box);
		draw(sd, box1);
		
		
		
	
	Drawable d= new Drawable() {
	
	@Override
	public void draw(Shape s) {	
		if(s instanceof Rectangle)
		System.out.println("Drawing Shape using my drawable");
		if(s instanceof Square)
			System.out.println("Drawing Shape using my drawable");	
	}
};
	
	draw(d, box1);
	draw(new MyDrawable(), box1);
	}
	public static void draw(Drawable d, Shape s)
	{
		d.draw(s);
	}
	
	static class MyDrawable implements Drawable
	{
	@Override
	public void draw(Shape s)
	{
		if(s instanceof Rectangle) {
			System.out.println("Drawing Shape using my drawable");
			if(s instanceof Square)
				System.out.println("Drawing Shape using my drawable");		
	}
	}
}
}