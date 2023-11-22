package assignment5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;


public class ShapeManipulator extends JPanel{
    public boolean isFilled;
    String currentShape;
    Color currentColor;
    static int mode;
    static Shape selectedShape;
    ShapeDrawer drawer;
    ShapeResizer resizer;
    Cloner cloner;
    int x, y;
    Singelton singelton;
    
    public ShapeManipulator(){
        currentColor = Color.BLACK;
        isFilled = false;
        mode = 1;
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseMotionHandler);
        drawer = new ShapeDrawer(this);
        resizer = new ShapeResizer(this);
        cloner = new Cloner(this);
        singelton = Singelton.ref();
    }
    
    public void changeColor(Color color){currentColor = color;}
    
    /**
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        ShapeRepository shape = new ShapeRepository();
        for(Iterator iter = shape.getIterator(); iter.hasNext();){
            Shape temp = iter.next();
            if(temp instanceof LineSegment){
                LineSegment line = (LineSegment) temp;
                g.setColor(line.getColor());
                g.drawLine(line.getXstart(), line.getYstart(), line.getXend(), line.getYend());
            }else if(temp instanceof Square){
                Square square = (Square) temp;
                g.setColor(square.getColor());
                int startPoint = square.getStartingX();
                int endPoint = square.getStartingY();
                if(square.getIsFilled())
                    g.fillRect(startPoint, endPoint, square.getLength(), square.getLength());
                else
                    g.drawRect(startPoint, endPoint, square.getLength(), square.getLength());
            }else if(temp instanceof Rectangle){
                Rectangle rect = (Rectangle) temp;
                g.setColor(rect.getColor());
                int startPoint = rect.getStartingX();
                int endPoint = rect.getStartingY();
                if(rect.getIsFilled())
                    g.fillRect(startPoint, endPoint, rect.getWidth(), rect.getHeight());
                else
                    g.drawRect(startPoint, endPoint, rect.getWidth(), rect.getHeight());
            }else if(temp instanceof Triangle){
                Triangle tri = (Triangle) temp;
                g.setColor(tri.getColor());
                int[] xPoints = tri.getXpoints();
                int[] yPoints = tri.getYpoints();
                if(tri.getIsFilled())
                    g.fillPolygon(xPoints, yPoints, 3);
                else
                    g.drawPolygon(xPoints, yPoints, 3);  
            }else if(temp instanceof Circle){
                Circle circle = (Circle) temp;
                g.setColor(circle.getColor());
                int startPoint = circle.getStartingX();
                int endPoint = circle.getStartingY();
                if(circle.getIsFilled())
                    g.fillOval(startPoint, endPoint, circle.getWidth(), circle.getHeight());
                else
                    g.drawOval(startPoint, endPoint, circle.getWidth(), circle.getHeight());
            }else if(temp instanceof BorderBox){
                //System.out.print("In Here");
                BorderBox box = (BorderBox)temp;
                //Graphics2D g2 = (Graphics2D) g;
                //g2.setPaint(Color.gray);
                //Stroke dashed = null;
                //g2.setStroke(dashed);
                //System.out.print("Border Box Dimensions in Manipulator: X1"+ box.getX1()+" Y1: "+box.getY1()+ " Width: "+box.getWidth()+" Height: "+box.getheight());
                g.drawRect(box.getX1(), box.getY1(), box.getWidth(), box.getheight());
            }
        }
        if(singelton.getShapeSelected()!=null)
        {
            if(singelton.getShapeSelected() instanceof LineSegment)
            {
                LineSegment L = (LineSegment)singelton.getShapeSelected();

                g.drawRect(L.box.getX1(), L.box.getY1(), L.box.getWidth(), L.box.getheight());
            }
            else if(singelton.getShapeSelected() instanceof Square)
            {
                Square S = (Square)singelton.getShapeSelected();
                g.drawRect(S.box.getX1(), S.box.getY1(), S.box.getWidth(), S.box.getheight());
            }
            else if(singelton.getShapeSelected() instanceof Rectangle)
            {
                Rectangle R = (Rectangle)singelton.getShapeSelected();
                g.drawRect(R.box.getX1(), R.box.getY1(), R.box.getWidth(), R.box.getheight());
            }

            else if(singelton.getShapeSelected() instanceof Circle)
            {
                Circle C = (Circle)singelton.getShapeSelected();
                g.drawRect(C.box.getX1(), C.box.getY1(), C.box.getWidth(), C.box.getheight());
            }
            else if(singelton.getShapeSelected() instanceof Triangle)
            {
                Triangle T = (Triangle)singelton.getShapeSelected();
                g.drawRect(T.box.getX1(), T.box.getY1(), T.box.getWidth(), T.box.getheight());
            }
        }
    }    
    
    public MouseListener mouseHandler = new MouseAdapter(){
        public void mouseClicked(MouseEvent e){
            if(mode == 2){
                ShapeSelector.SeLectShape(e.getX(), e.getY());
                if(singelton.getShapeSelected() == null)
                    mode = 1;
            }
            if(mode == 4){
                mode = 1;
                
                
            }
            
            if(mode == 5){
                cloner.pasteObject(e.getX(), e.getY());
            }
            System.out.println("testClicl:"+e.getY());
            repaint();
        }
        
        @Override
        public void mousePressed(MouseEvent e){
            if(mode == 1)
                drawer.initShapes(currentShape, e.getX(), e.getY(), currentColor, isFilled);
            
            if(mode == 2)
                return;
            if(mode == 3){
                x = e.getX();
                y = e.getY();
            }
            if(mode == 4){
                if(singelton.getShapeSelected() != null){
                    resizer.getPoint(singelton.getShapeSelected() ,e.getX(), e.getY());
                }
            }
                
            repaint();  
        }
        
        @Override
        public void mouseReleased(MouseEvent e){
            if(mode == 1)
                drawer.initUndoRedo();
            
            repaint();
        }
    };
    
    public MouseMotionListener mouseMotionHandler = new MouseMotionAdapter(){
        @Override
        public void mouseDragged(MouseEvent e){
            if(mode == 1)
                drawer.drawShapes(e.getX(), e.getY());

            //if(mode == 3)
            if(mode == 3){
                int dx = e.getX()-x;
                int dy = e.getY()-y;
                ShapeMover.MovingShape(e.getX(),e.getY(), dx, dy);
                repaint(); 
                x += dx;
                y += dy;               
            }
            
            if(mode == 4)
                resizer.resizeShape(e.getX(), e.getY());
            repaint();          
        }
    };
}
