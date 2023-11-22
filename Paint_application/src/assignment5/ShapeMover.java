
package assignment5;

/**
 *
 * @author mahmo
 */
public class ShapeMover  {
    
    
    static BorderBox Box;
    Shape MovingShape;
    

    public static void MovingShape(int x2, int y2, int dx, int dy){
        Singelton singelton = Singelton.ref();
        if(singelton.getShapeSelected() != null){           
            if(singelton.getShapeSelected() instanceof LineSegment){
                LineSegment MovingShape = (LineSegment)singelton.getShapeSelected();
                Box = MovingShape.box;
                //Check if Pressing x and y are inside the border area
                if(x2>Box.getX1() && x2<(Box.getX1()+Box.getWidth()) && y2>Box.getY1() && y2<(Box.getY1()+Box.getheight())){
                            //Move the Line Segment with respect to x1
                            MovingShape.setXstart(MovingShape.getXstart()+dx);
                            MovingShape.setYstart(MovingShape.getYstart()+dy);
                            MovingShape.drag((MovingShape.getXend()+dx),(MovingShape.getYend()+dy));
                           
                            //Move the Box as well
                            Box.SetX1(Box.getX1()+dx);
                            Box.SetY1(Box.getY1()+dy);
                      
                 }
                else
                {
                    BorderBox.UnSelect();
                }
            }
            else if(singelton.getShapeSelected() instanceof Square){
                Square MovingShape = (Square)singelton.getShapeSelected();
                Box = MovingShape.box;
                //Check if Pressing x and y are inside the border area
                if(x2>Box.getX1() && x2<(Box.getX1()+Box.getWidth()) && y2>Box.getY1() && y2<(Box.getY1()+Box.getheight())){
                     //Move Square
                     MovingShape.setXstart(MovingShape.getStartingX()+dx);
                     MovingShape.setYstart(MovingShape.getStartingY()+dy);
                     MovingShape.setXend(MovingShape.getXend()+dx);
                     MovingShape.setYend(MovingShape.getYend()+dy);
                     //MovingShape.drag(MovingShape.getXend()+dx, MovingShape.getYend()+dy);
                     //Move Border
                     Box.SetX1(Box.getX1()+dx);
                     Box.SetY1(Box.getY1()+dy);
                 }
                else
                {
                    BorderBox.UnSelect();
                }

            }
            else if(singelton.getShapeSelected() instanceof Rectangle){
                Rectangle MovingShape = (Rectangle)singelton.getShapeSelected();
                Box = MovingShape.box;
                //Check if Pressing x and y are inside the border area
                if(x2>Box.getX1() && x2<(Box.getX1()+Box.getWidth()) && y2>Box.getY1() && y2<(Box.getY1()+Box.getheight())){
                     //Move Square
                     MovingShape.setXstart(MovingShape.getStartingX()+dx);
                     MovingShape.setYstart(MovingShape.getStartingY()+dy);
                     MovingShape.setXend(MovingShape.getXend()+dx);
                     MovingShape.setYend(MovingShape.getYend()+dy);
                     //MovingShape.drag(MovingShape.getStartingX()+MovingShape.getWidth()+dx, MovingShape.getStartingY()+MovingShape.getHeight()+dy);
                     //Move Border
                     Box.SetX1(Box.getX1()+dx);
                     Box.SetY1(Box.getY1()+dy);
                 }
                else
                {
                    BorderBox.UnSelect();
                }

                
            }
            else if(singelton.getShapeSelected() instanceof Circle){
                Circle MovingShape = (Circle)singelton.getShapeSelected();
                Box = MovingShape.box;
                if(x2>Box.getX1() && x2<(Box.getX1()+Box.getWidth()) && y2>Box.getY1() && y2<(Box.getY1()+Box.getheight())){
                     //Move Square
                     MovingShape.setXstart(MovingShape.getStartingX()+dx);
                     MovingShape.setYstart(MovingShape.getStartingY()+dy);
                     MovingShape.setXend(MovingShape.getXend()+dx);
                     MovingShape.setYend(MovingShape.getYend()+dy);
                     //System.out.print("S");
                     //System.out.println("XStart: "+ MovingShape.getXstart()+ " YStart: "+ MovingShape.getYstart()+ " XEnd: "+MovingShape.getXend()+" YEnd: "+MovingShape.getYend());
                     //MovingShape.drag(MovingShape.getStartingX()+MovingShape.getWidth()+dx, MovingShape.getStartingY()+MovingShape.getHeight()+dy);
                     //Move Border
                     Box.SetX1(Box.getX1()+dx);
                     Box.SetY1(Box.getY1()+dy);
                 }
                else
                {
                    BorderBox.UnSelect();
                }

                
            }
            else if(singelton.getShapeSelected() instanceof Triangle){
                Triangle MovingShape = (Triangle)singelton.getShapeSelected();
                Box = MovingShape.box;
                if(x2>Box.getX1() && x2<(Box.getX1()+Box.getWidth()) && y2>Box.getY1() && y2<(Box.getY1()+Box.getheight())){
                    int x[] = MovingShape.getXpoints();
                    x[0] = x[0] + dx;
                    x[1] = x[1] + dx;
                    x[2] = x[2] + dx;
                    MovingShape.setXPoints(x);
                    int y[] = MovingShape.getYpoints();
                    y[0] = y[0] + dy;
                    y[1] = y[1] + dy;
                    y[2] = y[2] + dy;
                    MovingShape.setYPoints(y);
                    Box.SetX1(Box.getX1()+dx);
                    Box.SetY1(Box.getY1()+dy);
                        
                }
                else
                {
                    BorderBox.UnSelect();
                }

            }
            
           
        }
    }
            
}
