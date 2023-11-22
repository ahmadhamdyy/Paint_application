package assignment5;

import java.awt.Color;

public class LineSegment implements Shape{

    /**
     * @param xstart the xstart to set
     */
    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    /**
     * @param xend the xend to set
     */
    public void setXend(int xend) {
        this.xend = xend;
    }

    /**
     * @param ystart the ystart to set
     */
    public void setYstart(int ystart) {
        this.ystart = ystart;
    }

    /**
     * @param yend the yend to set
     */
    public void setYend(int yend) {
        this.yend = yend;
    }
    
    private int xstart;
    private int xend;
    private int ystart;
    private int yend;
    private Color color;
    public BorderBox box;
    
    LineSegment(int xstart, int ystart, int xend, int yend, Color color){
        this.xstart = xstart;
        this.xend = xend;
        this.ystart = ystart;
        this.yend = yend;
        this.color = color;
    }
    
    @Override
    public void drag(int xend, int yend){
        this.setXend(xend);
        this.setYend(yend);
    }
    
    public int getXstart() {return xstart;}
    public int getXend() {return xend;}
    public int getYstart() {return ystart;}
    public int getYend() {return yend;}
    public Color getColor() {return color;}
    
    public boolean checkPointEnd(LineSegment line, int x, int y){
        boolean valid;
        if(Math.abs(x-line.getXend()) < 10 && Math.abs(y-line.getYend()) < 10){
            ShapeResizer.corner = "end";
            valid = true;
        }else if(Math.abs(x-line.getXstart()) < 10 && Math.abs(y-line.getYstart()) < 10){
            ShapeResizer.corner = "start";
            valid = true;
        }
        else
            valid = false;
        return valid;
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
}
