package paintApplication;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class inherits from MyShape and is responsible for drawing a line.
 */
public class MyLine extends MyShape implements Shape
{  
    /**
     * No parameter constructor which calls the no parameter constructor in MyShape
     */
	Rectangle2D s = new Rectangle2D.Float(); 
	Graphics2D g2;
	int width;
	int diffX, diffY;
    public MyLine()
    {
        super();
    }
    
    /** 
     * Overloaded constructor that takes coordinates and color. It passes them to the constructor in MyShape
     */
    public MyLine( int x1, int y1, int x2, int y2, Color color )
    {
        super(x1, y1, x2, y2, color);
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
    	super.setY2( getY1() + width );	
    	
    	//s.setFrame(getUpperLeftX(), getUpperLeftY(), getHeight(), getHeight());
    	g2.setColor( getColor() ); //sets the color
    	
    	if (getFill()) //determines whether fill is true or false
            g2.fill( s ); //draws a filled rectangle
        else
            g2.draw( s ); //draws a regular rectangle
    	
    	
    }
    private boolean getFill() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
     * Overrides the draw method in Myshape. It sets the gets the color from Myshape
     * and the coordinates it needs to draw from MyShape as well.
     */
    @Override
    public void draw( Graphics g )
    {
    	if(s == null)
    		s = new Rectangle2D.Float();
    	
    	
    	g2 = (Graphics2D)g;
        g.setColor( getColor() ); //sets the color
        g.drawLine( getX1(), getY1(), getX2(), getY2() ); //draws the line
    }

	@Override
	public boolean contains(Point2D arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		return s.contains(x, y);
	}

	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return s.contains(x, y, w, h);
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
	public PathIterator getPathIterator(AffineTransform at) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		return false;
	} 
} // end class MyLine