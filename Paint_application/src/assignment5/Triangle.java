package assignment5;

import java.awt.Color;

public class Triangle implements Shape {

    /**
     * @return the base
     */
    public int getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @param x1 the x1 to set
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * @param x2 the x2 to set
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * @param x3 the x3 to set
     */
    public void setX3(int x3) {
        this.x3 = x3;
    }

    /**
     * @param y1 the y1 to set
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * @param y2 the y2 to set
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * @param y3 the y3 to set
     */
    public void setY3(int y3) {
        this.y3 = y3;
    }

    /**
     * @return the x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * @return the x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * @return the x3
     */
    public int getX3() {
        return x3;
    }

    /**
     * @return the y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * @return the y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * @return the y3
     */
    public int getY3() {
        return y3;
    }
    
    private int x1;
    private int x2;
    private int x3;
    private int y1;
    private int y2;
    private int y3;
    private int base;
    private int height;
    private boolean isFilled;
    private Color color;
    public BorderBox box;

    
    Triangle(int x1, int y1, Color color, boolean isFilled){
        this.x1 = this.x2 = this.x3 = x1;
        this.y1 = this.y2 = this.y3 = y1;
        this.color = color;
        this.isFilled = isFilled;
    }
    
    public int[] getXpoints(){
        int[] x = {getX1(), getX2(), getX3()};
        return x;
    }
    public void setXPoints(int[] x){
        x1 = x[0];
        x2 = x[1];
        x3 = x[2];
    }
    public int[] getYpoints(){
        int[] y = {getY1(), getY2(), getY3()};
        return y;
    }
    public void setYPoints(int[] y){
        y1 = y[0];
        y2 = y[1];
        y3 = y[2];
    }
     static double area(int x1, int y1, int x2, int y2,int x3, int y3){
       return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/2.0);
    }
    
    public Color getColor(){ return color;}
    public boolean getIsFilled(){return isFilled;}

    @Override
    public void drag(int xend, int yend) {
        setX2(xend);
        setX3(2*(getX1())-getX2());
        setY2(yend);
        setY3(yend);
        setBase(Math.abs(x2-x3));
        setHeight(Math.abs(y1-y2));
    }
    
    public boolean checkPointInBorders(Triangle tri,int x, int y){
        boolean resize = false;
        if(x < getX3() && x > tri.box.getX1() && y < tri.box.getY2() && y > tri.box.getY1()){
            resize = true;
            ShapeResizer.corner = "left";
            
        }else if (x > getX2() && x < tri.box.getX2() && y > tri.box.getY1()&& y < tri.box.getY2()){
            resize = true;
            ShapeResizer.corner = "right";
            
        }else if(y < getY1() && y > tri.box.getY1() && x > tri.box.getX1()&& x < tri.box.getX2()){
            resize = true;
            ShapeResizer.corner = "top";
            
        }else if(y < tri.box.getY2() && y > getY2() && x > tri.box.getX1()&& x < tri.box.getX2()){
            resize = true;
            ShapeResizer.corner = "bottom";
            System.out.println("testttt");
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