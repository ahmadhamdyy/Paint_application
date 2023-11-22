package assignment5;


public class ShapeSelector extends ShapeManipulator{
    
    ShapeSelector(){
        int x = 0;
        int y = 0;        
    }
       
    public static void SeLectShape(int x, int y){
        Singelton ShapeSelected = Singelton.ref();
        int BorderBoxH = 0;
        int BorderBoxW = 0;
        int BorderX;
        int BorderY;
//        int selected = 0;
        BorderBox b = new BorderBox();
        Shape SelectedShape = null;
        //Loop Through Shapes Iterator
        ShapeRepository shape = new ShapeRepository();
        //If a Frame Was already made remove it
        if(ShapeSelected.getShapeSelected()!=null)
        {
            BorderBox.UnSelect();
        }
//        if(ShapeRepository.shapes.get(ShapeRepository.shapes.size()-1) instanceof BorderBox){
//            selected = 1;
//            //ShapeRepository.shapes.remove(ShapeRepository.shapes.size()-1);
//        }
            for(Iterator iter = shape.getIterator(); iter.hasPrev();){
            Shape temp = iter.prev();
            //Check for x and y
            if(temp instanceof LineSegment){
                LineSegment Line = (LineSegment)temp;
                double X1 = Math.abs(x - Line.getXstart());
                double Y1 = Math.abs(y - Line.getYstart());
                //System.out.println("X1: "+ X1+ "Y1: "+ Y1);
                double X2 = Math.abs(Line.getXend() - Line.getXstart());
                double Y2 = Math.abs(Line.getYend() - Line.getYstart());
                //System.out.println("X2: "+ X2+ "Y2: "+ Y2);
                double Theta1 = Math.atan(Y1/X1);
                double Theta2 = Math.atan(Y2/X2);
                //System.out.println("Theta 1 :"+ Theta1+" Theta 2: "+ Theta2);
                if(Math.abs(Theta1 -Theta2) < 0.05){      
                    BorderBoxH = (int)Y2;
                    BorderBoxW = (int)X2;
                    if(Line.getYend()<Line.getYstart()){
                        BorderX = Line.getXstart();
                        BorderY = Line.getYend();
                    }
                    else{
                        BorderX = Line.getXstart();
                        BorderY = Line.getYstart();
                    }
                    //TODO Vertical and Horizontal Lines More Conditions
                    //Draw Border Box;
                    //b = new BorderBox.Builder().points(BorderX, BorderY, BorderBoxW, BorderBoxH).build();
                   // b = new BorderBox();
                    b.SetWidth(BorderBoxW);
                    b.Setheight(BorderBoxH);
                    b.SetX1(BorderX);
                    b.SetY1(BorderY);
                    //System.out.print("Border Box Dimensions: X1"+ b.getX1()+" Y1: "+b.getY1()+ " Width: "+b.getWidth()+" Height: "+b.getheight());
                    Line.box = b;
                    //SelectedShape = Line;
                    ShapeSelected.setShapeSelected(Line);
                    
                    //add Border BX
                    System.out.println("Match Occurs");
                    break;
                    
                }
                
            }
            if(temp instanceof Square ){
                Square Sq = (Square)temp;
                //Two Conditions
                //Check for Positive Square
                if(Sq.getXend() > Sq.getXstart()){
                    if(x>Sq.getXstart() && x<Sq.getXend() && y>Sq.getYstart() && y<Sq.getYend()){
                        //Match Occurs
                        System.out.println("Square Found");
                        //Draw Border
                       // b = new BorderBox.Builder().points(Sq.getXstart()-10, Sq.getYstart()-10, Sq.getLength()+20, Sq.getLength()+20).build();
                        b.SetWidth(Sq.getLength()+20);
                        b.Setheight(Sq.getLength()+20);
                        b.SetX1(Sq.getXstart()-10);
                        b.SetX2(Sq.getXend() + 10);
                        b.SetY1(Sq.getYstart()-10);
                        b.SetY2(Sq.getYend()+10);
                        Sq.box = b;
                        ShapeSelected.setShapeSelected(Sq);
                        //SelectedShape = Sq;
                        //ShapeRepository.shapes.add(b);
                        break;
                    }
                }
                //Check for Negative Square
                else{
                    if(x<Sq.getXstart() && x>Sq.getXend() && y<Sq.getYstart() && y>Sq.getYend()){
                        //Match Occurs
                        System.out.println("Square Found");
                        //Draw Border
                       //  b = new BorderBox.Builder().points(Sq.getXend()-10, Sq.getYend()-10, Sq.getLength()+20, Sq.getLength()+20).build();
                        b.SetWidth(Sq.getLength()+20);
                        b.Setheight(Sq.getLength()+20);
                        b.SetX1(Sq.getXend()-10);
                        b.SetY1(Sq.getYend()-10);
                        //ShapeRepository.shapes.add(b);
                        Sq.box = b;
                        ShapeSelected.setShapeSelected(Sq);
                        //SelectedShape = Sq;
                        break;
                    }
                    
                }
            }
            if(temp instanceof Rectangle){
                Rectangle Rec = (Rectangle)temp;
                //Two Conditions
                //Check for Positive Rectangle
                if(x < (Rec.getStartingX() + Rec.getWidth()) && x>Rec.getStartingX() && y <(Rec.getStartingY() + Rec.getHeight()) && y> Rec.getStartingY()){
                    System.out.println("Rectangle Found");
                    b.SetWidth(Rec.getWidth()+20);
                    b.Setheight(Rec.getHeight()+20);
                    b.SetX1(Rec.getStartingX()-10);
                    b.SetX2(b.getX1() + Rec.getWidth()+20);
                    b.SetY1(Rec.getStartingY()-10);
                    b.SetY2(b.getY1() + Rec.getHeight()+20);
                    Rec.box = b;
                    ShapeSelected.setShapeSelected(Rec);
                    //SelectedShape = Rec;
                    
                    //ShapeRepository.shapes.add(b);
                    break;
                } 
            }
             if(temp instanceof Triangle){
            Triangle t = (Triangle) temp;
            int[] xPoints = t.getXpoints();
            int[] yPoints = t.getYpoints();
            double a = Triangle.area(xPoints[0],yPoints[0], xPoints[1],yPoints[1], xPoints[2], yPoints[2]);
            double a1 = Triangle.area(x, y, xPoints[0],yPoints[0], xPoints[1], yPoints[1]);
            double a2 = Triangle.area(x, y, xPoints[0],yPoints[0], xPoints[2], yPoints[2]);
            double a3 = Triangle.area(x, y, xPoints[2],yPoints[2], xPoints[1], yPoints[1]);
            if(a == a1 + a2 + a3){
               System.out.println("Triangle Found");
               if(yPoints[0]<yPoints[1] && xPoints[1] > xPoints[2]){
                    b.SetWidth((xPoints[1]-xPoints[2])+20);
                    b.Setheight((yPoints[1]-yPoints[0])+20);
                    b.SetX1(xPoints[2]-10);
                    b.SetX2(xPoints[1] + 10);
                    b.SetY1(yPoints[0] - 10);
                    b.SetY2(yPoints[1] + 10);
                    t.box = b;
                    ShapeSelected.setShapeSelected(t);
                    //SelectedShape = t;
                    break;}
               else if(yPoints[0]>yPoints[1]&& xPoints[1] > xPoints[2]){
                    b.SetWidth((xPoints[1]-xPoints[2])+20);
                    b.Setheight((yPoints[0]-yPoints[1])+20);
                    b.SetX1(xPoints[2]-10);
                    b.SetX2(xPoints[1]+10);
                    b.SetY1(yPoints[2]-10);
                    b.SetY2(yPoints[0]+10);
                    t.box = b;
                    ShapeSelected.setShapeSelected(t);
                    //SelectedShape = t;
                    break;
               }
               if(yPoints[0]<yPoints[1] && xPoints[2] > xPoints[1]){
                    b.SetWidth((xPoints[2]-xPoints[1])+20);
                    b.Setheight((yPoints[1]-yPoints[0])+20);
                    b.SetX1(xPoints[1]-10);
                    b.SetX2(xPoints[2]+10);
                    b.SetY1(yPoints[0] -10);
                    b.SetY2(yPoints[1]+ 10);
                    t.box = b;
                    ShapeSelected.setShapeSelected(t);
                    //SelectedShape = t;
                    break;}
               else if(yPoints[0]>yPoints[1]&& xPoints[2] > xPoints[1]){
                    b.SetWidth((xPoints[2]-xPoints[1])+20);
                    b.Setheight((yPoints[0]-yPoints[1])+20);
                    b.SetX1(xPoints[1]-10);
                    b.SetX2(xPoints[2]+10);
                    b.SetY1(yPoints[2] -10);
                    b.SetY2(yPoints[0]+10);
                    t.box = b;
                    ShapeSelected.setShapeSelected(t);
                    //SelectedShape = t;
                    break;
               }
            }
            }
              if(temp instanceof Circle){
                  Circle c = (Circle) temp;
                  if(Circle.isInside(c.xCenter(), c.yCenter(), c.radius(), x, y)){
                  System.out.println("Circle Found");
                    b.SetWidth(c.getWidth()+20);
                    b.Setheight(c.getHeight()+20);
                    b.SetX1(c.getStartingX()-10);
                    b.SetX2(c.getStartingX()+c.getWidth()+10);
                    b.SetY1(c.getStartingY()-10);
                    b.SetY2(c.getStartingY()+c.getHeight()+10);
                    c.box = b;
                    ShapeSelected.setShapeSelected(c);
                    //SelectedShape = c;
                    break;
                  }
              }
            if(temp instanceof BorderBox){
                b = (BorderBox)temp;
                continue; 
            }
            //return temp;
        }
//            if(selected==1){
//                ShapeRepository.shapes.remove(ShapeRepository.shapes.size()-1);            
//                ShapeRepository.shapes.add(b);
//            }
//            else
//                ShapeRepository.shapes.add(b);
//            if(SelectedShape == null)
//                ShapeRepository.shapes.remove(ShapeRepository.shapes.size()-1);
            
        //return SelectedShape;
                    
    }
    
}