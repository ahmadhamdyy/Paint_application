package assignment5;

import java.awt.Color;

public class Rectangle implements Shape {
    
    private int xstart;
    private int ystart;
    private int xend;
    private int yend;
    private int width;
    private int height;
    private boolean isFilled;
    private Color color;
    public BorderBox box;
    
    Rectangle(int xstart, int ystart, Color color, boolean isFilled){
        this.xstart = xstart;
        this.ystart = ystart;
        this.color = color;
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
    
    public int getWidth() {return width;}
    public void setWidth(int width) {this.width = width;}
    public void setXstart(int xstart){this.xstart = xstart;}
    public int getXstart(){return xend;}
    public int getYstart(){return ystart;}
    public void setYstart(int ystart){this.ystart = ystart;}
    public int getXend(){return xend;}
    public void setXend(int xend){this.xend = xend;}
    public void setYend(int yend){this.yend = yend;}
    public int getYend(){return yend;}
    public int getHeight() {return height;}
    public void setHeight(int height){this.height = height;}
    public Color getColor() {return color;}
    public boolean getIsFilled() {return isFilled;}
    
    @Override
    public void drag(int xend, int yend) {
        width = Math.abs(xend-xstart);
        height = Math.abs(yend-ystart);
        this.xend = xend;
        this.yend = yend;
      /*  if ( ((xend-xstart) < 0) && ((yend-ystart < 0)) ){
                this.xend = xstart;
                this.yend = ystart;
                xstart = xend;
                ystart = yend;
            }

        if ( ((xend-xstart) > 0) && ((yend-ystart < 0)) ){
            xstart = this
            this.xend = xend;
            this.yend = ystart;
            ystart = yend;
        }

        if ( ((xend-xstart) > 0) && ((yend-ystart > 0)) ){
            
        }

            if ( ((xend-xstart) < 0) && ((yend-ystart > 0)) )
            {
                g2d.drawRect(xend, ystart, Math.abs(xend-xstart),
                                                 Math.abs(yend-ystart));
            }*/
    }
    
    public boolean checkPointInBorders(Rectangle rect,int x, int y){
        boolean resize;
        if(x < rect.getStartingX() && x > rect.box.getX1() && y > rect.getStartingY() && y < (rect.getYend())){
            System.out.println(rect.getXstart());
            System.out.println(rect.getXend());
            resize = true;
            ShapeResizer.corner = "left";
        }else if (x > rect.getXend() && x < rect.box.getX2() && y > rect.getStartingY() && y < (rect.getYend())){
            System.out.println(rect.getXstart());
            System.out.println(rect.getXend());
            resize = true;
            ShapeResizer.corner = "right";
        }else if(y < rect.getStartingY() && y > rect.box.getY1() && x > rect.getStartingX() && x < (rect.getXend())){
            resize = true;
            ShapeResizer.corner = "top";
        }else if(y < (rect.box.getY2()) && y > (rect.getYend()) && x > rect.getStartingX() && x < (rect.getXend())){
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
