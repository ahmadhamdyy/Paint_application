/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.awt.Color;

/**
 *
 * @author mahmo
 */
public class BorderBox implements Shape{
   
    private int x1;
    private int x2;
    private int y2;
    private int y1;
    private int h1;
    private int w1;
    BorderBox(){}
    public static void UnSelect()
    {
        Singelton ShapeSelected = Singelton.ref();
        if(ShapeSelected.getShapeSelected() instanceof LineSegment)
        {
            LineSegment L = (LineSegment)ShapeSelected.getShapeSelected();
            L.box = null;
        }
        if(ShapeSelected.getShapeSelected() instanceof Square)
        {
            Square S = (Square)ShapeSelected.getShapeSelected();
            S.box = null;
        }
        if(ShapeSelected.getShapeSelected() instanceof Rectangle)
        {
            Rectangle R = (Rectangle)ShapeSelected.getShapeSelected();
            R.box = null;
        }

        if(ShapeSelected.getShapeSelected() instanceof Circle)
        {
            Circle C = (Circle)ShapeSelected.getShapeSelected();
            C.box = null;
        }
        if(ShapeSelected.getShapeSelected() instanceof Triangle)
        {
            Triangle T = (Triangle)ShapeSelected.getShapeSelected();
            T.box = null;
        }
        ShapeSelected.setShapeSelected(null);

    }
    private BorderBox(Builder builder){
        this.x1 = builder.x1;
        this.x2 = builder.x2;
        this.y1 = builder.y1;
        this.y2 = builder.y2;
        this.h1 = builder.h1;
        this.w1 = builder.w1;
    }
    
    public static class Builder{
        private int x1;
        private int x2;
        private int y2;
        private int y1;
        private int h1;
        private int w1;
        
        public Builder points(int x1, int y1, int w1, int h1){
            this.x1 = x1;
            this.h1 = h1;
            this.w1 = w1;
            y2 = y1 + h1;
            x2 = x1 + w1;
            return this;
        }
        
        public BorderBox build(){
            return new BorderBox(this);
        }
    }
    
    
    public void SetX1(int x){x1 = x;}
    public void SetX2(int x){x2 = x;}
    public void SetY1(int y){y1 = y;}
    public void SetY2(int y){y2 = y;}
    public void Setheight(int h){h1 = h;}
    public void SetWidth(int w){w1 =w;}
    public int getheight(){return h1;}
    public int getWidth(){return w1;}
    public int getX1(){return x1;}
    public int getX2(){return x2;}
    public int getY1(){return y1;}
    public int getY2(){return y2;}

    
    public void drag(int xend, int yend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
