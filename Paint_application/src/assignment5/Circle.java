package assignment5;

import java.awt.Color;

public class Circle implements Shape {

    /**
     * @return the xstart
     */
    public int getXstart() {
        return xstart;
    }

    /**
     * @param xstart the xstart to set
     */
    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    /**
     * @return the ystart
     */
    public int getYstart() {
        return ystart;
    }

    /**
     * @param ystart the ystart to set
     */
    public void setYstart(int ystart) {
        this.ystart = ystart;
    }

    /**
     * @return the xend
     */
    public int getXend() {
        return xend;
    }

    /**
     * @param xend the xend to set
     */
    public void setXend(int xend) {
        this.xend = xend;
    }

    /**
     * @return the yend
     */
    public int getYend() {
        return yend;
    }

    /**
     * @param yend the yend to set
     */
    public void setYend(int yend) {
        this.yend = yend;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
    
    private int xstart;
    private int ystart;
    private int xend;
    private int yend;
    private int width;
    private int height;
    private int radius;
    private Color color;
    private boolean isFilled;
    public BorderBox box;

    
    Circle(int xstart, int ystart, Color color, boolean isFilled){
        this.xstart = xstart;
        this.ystart = ystart;
        this.color = color;
        this.isFilled = isFilled;
    }
    
    public int getStartingX(){
        int returnedPoint = getXstart();
        if ( ((getXend()-getXstart()) < 0) && ((getYend()-getYstart() < 0)) )
            returnedPoint = getXend();
        if ( ((getXend()-getXstart()) < 0) && ((getYend()-getYstart() > 0)) )
            returnedPoint = getXend();
        return returnedPoint;
    }
    
    public int getStartingY(){
        int returnedPoint = getYstart();
        if ( ((getXend()-getXstart()) < 0) && ((getYend()-getYstart() < 0)) )
            returnedPoint = getYend();
        if ( ((getXend()-getXstart()) > 0) && ((getYend()-getYstart() < 0)) )
            returnedPoint = getYend();
        return returnedPoint;
    }
     static boolean isInside(int xCenter, int yCenter,int rad, int x, int y)
    {
       
        if ((x - xCenter) * (x - xCenter) + (y - yCenter) * (y - yCenter) <= rad * rad)
            return true;
        else
            return false;
    }
    public int xCenter(){ return(getXstart() + getXend())/2; }
    public int yCenter(){ return(getYstart() + getYend())/2; }
    public int radius(){ return (Math.abs(getXend()-getXstart()))/2; }
    
    public int getWidth()   { return width;}
    public int getHeight()  { return height;}
    public Color getColor() { return color;}
    public boolean getIsFilled(){return isFilled;}
    

    
    public void drag(int xend, int yend) {
        setWidth(Math.abs(xend - getXstart()));
        setHeight(Math.abs(yend - getYstart()));
        radius = getWidth()/2;
        this.setXend(xend);
        this.setYend(yend);
    }
    
    public Object clone() {
	Object clone = null;
	try {
	    clone = super.clone();
	} catch (CloneNotSupportedException e) {
	    e.printStackTrace();
	}
        return clone;
    }
    
    public boolean checkPointInBorders(Circle circ,int x, int y){
        boolean resize;
            if(x > circ.getStartingX()+circ.getWidth() && x < circ.box.getX2() && y > circ.box.getY1() && y < circ.box.getY2()){
                resize = true;
                ShapeResizer.corner = "right";
            }else if(x < circ.getStartingX() && x > circ.box.getX1() && y > circ.box.getY1() && y < circ.box.getY2()){
                resize = true;
                ShapeResizer.corner = "left";
            }else if(y > circ.getStartingY()+circ.getHeight()&& y < circ.box.getY2() && x > circ.box.getX1() && x < circ.box.getX2()){
                resize = true;
                ShapeResizer.corner = "bottom";
            }else if(y < circ.getStartingY() && y > circ.box.getY1() && x > circ.box.getX1() && x < circ.box.getX2()){
                resize = true;
                ShapeResizer.corner = "top";
            }else
                resize = false;
        return resize;
    }

}