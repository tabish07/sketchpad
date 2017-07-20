package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


/**
 * This class inherits from MyBoundedShape and is responsible for drawing a oval.
 */
public class MyOval extends MyBoundedShape implements Shape
{ 
    /**
     * No parameter constructor which calls the no parameter constructor in MyBoundedShape.
     */
	 
		Ellipse2D s = new Ellipse2D.Float(); 
		Graphics2D g2;
		int width, height;
		int diffX, diffY;
    public MyOval()
    {
        super();
    }
    
    /** 
     * Overloaded constructor that takes coordinates, color and fill. 
     * It passes them into MyBoundedShape's constructor.
     */
    public MyOval( int x1, int y1, int x2, int y2, Color color, boolean fill )
    {
        super(x1, y1, x2, y2, color,fill);
    }
    public void setDiff(int x, int y)
    {	
    	diffX = x - Math.min(getX1(), getX2());
    	diffY = y - Math.min(getY1(), getY2());
    }
    
    public void setX1_Y1(int x, int y)
    {	
    	super.setX1( x - diffX );
    	super.setY1( y - diffY );
    	
    	super.setX2( getX1() + width );
    	super.setY2( getY1() + height );	
    	
    	//s.setFrame(getUpperLeftX(), getUpperLeftY(), getHeight(), getHeight());
    	g2.setColor( getColor() ); //sets the color
    	
    	if (getFill()) //determines whether fill is true or false
            g2.fill( s ); //draws a filled rectangle
        else
            g2.draw( s ); //draws a regular rectangle
    	
    	
    }
     
    /**
     * Overrides the draw method in MyBoundedShape. It sets the gets the color from MyBoundedShape
     * to set the color and the values it needs to draw from MyBoundedShape as well.
     */
    @Override
    public void draw( Graphics g )
    {
    	if(s == null)
    		s = new Ellipse2D.Float();
    	
    	width = getWidth();
    	height = getHeight();
    	g2 = (Graphics2D)g;
    	s.setFrame(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
    	
        g2.setColor( getColor() ); //sets the color
        if (getFill()) //determines whether fill is true or false
        	g2.fill(s); //draws a filled rectangle
        else
            g2.draw(s);  
    }
    
   
	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return s.contains(x, y);
	}

	
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return s.contains(x, y, w, h);
	}



	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform arg0, double arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}
    
} // end class MyOval