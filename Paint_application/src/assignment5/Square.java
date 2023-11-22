package assignment5;

import java.awt.Color;

public class Square implements Shape {

    private int xstart;
    private int ystart;
    private int length;
    private int xend;
    private int yend;
    private Color color;
    private boolean isFilled;
    public BorderBox box;

    Square(int xstart, int ystart, Color color, boolean isFilled){
        this.xstart = xstart;
        this.ystart = ystart;
        this.color = color;
        length = 0;
        this.isFilled = isFilled;
    }
    
    public int getStartingX(){
        int returnedPoint = xstart;
        if ( ((xend-xstart) < 0) && ((yend-ystart < 0)) )
            returnedPoint = xend;
        if ( ((xend-xstart) < 0) && ((yend-ystart > 0)) )
            returnedPoint = xend;
        return returnedPoint;
    }
    
    public int getStartingY(){
        int returnedPoint = ystart;
        if ( ((xend-xstart) < 0) && ((yend-ystart < 0)) )
            returnedPoint = yend;
        if ( ((xend-xstart) > 0) && ((yend-ystart < 0)) )
            returnedPoint = yend;
        return returnedPoint;
    }
    
    /*public void setStartingPoint(int xstart, int ystart, int xend, int yend){
        length = Math.abs(xend - xstart); 
        if ( ((xend-xstart) < 0) && ((yend-ystart < 0)) ){
            this.xstart = xend;
            this.ystart = yend;
        }
        if ( ((xend-xstart) > 0) && ((yend-ystart < 0)) )
            this.ystart = yend;
        if ( ((xend-xstart) < 0) && ((yend-ystart > 0)) )
            this.xstart = xend;           
    }*/
    
    public int getXstart() {return xstart;}
    public void setXstart(int xstart){this.xstart = xstart;}
    public int getYstart() {return ystart;}
    public void setYstart(int ystart){this.ystart = ystart;}
    public int getXend() {return xend;}
    public void setXend(int xend){this.xend = xend;}
    public int getYend() {return yend;}
    public void setYend(int yend){this.yend = yend;}
    public int getLength() {return length;}
    public void setLength(int length){this.length = length;}
    public Color getColor(){return color;}
    public boolean getIsFilled(){return isFilled;}
    
    @Override
    public void drag(int xend, int yend){
        length = Math.abs(xend-xstart);
        this.xend = xend;
        this.yend = yend;
    }
    
    public boolean checkPointInBorders(Square sq,int x, int y){
        boolean resize = false;
        if(x < sq.getXstart() && x > sq.box.getX1() && y > sq.box.getY1() && y < (sq.box.getY2())){
            resize = true;
            ShapeResizer.corner = "left";
        }else if (x > sq.getXend() && x < sq.box.getX2() && y > sq.getYstart()&& y < (sq.getYend())){
            resize = true;
            ShapeResizer.corner = "right";
        }else if(y < sq.getStartingY() && y > sq.box.getY1() && x > sq.getXstart()&& x < (sq.getXend())){
            resize = true;
            ShapeResizer.corner = "top";
        }else if(y < (sq.box.getY2()) && y > (sq.getYend()) && x > sq.getXstart()&& x < (sq.getXend())){
            resize = true;
            ShapeResizer.corner = "bottom";
        }else
            resize = false;
        return resize;
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
