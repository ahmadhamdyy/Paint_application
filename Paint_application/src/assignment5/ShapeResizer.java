package assignment5;

public class ShapeResizer implements ICommand{
    static String corner;
    static boolean resize;
    Shape shape;
    ShapeManipulator manipulator;
    
    public ShapeResizer(ShapeManipulator s){
        manipulator = s;
    }
    
    public void getPoint(Shape shape, int x, int y){
        this.shape = shape;
        if(shape instanceof LineSegment){
            LineSegment line = (LineSegment) shape;
            resize = line.checkPointEnd(line, x, y);
        }else if(shape instanceof Rectangle){
            Rectangle rect = (Rectangle) shape;
            resize = rect.checkPointInBorders(rect, x, y);
        }else if(shape instanceof Circle){
            Circle circ =(Circle) shape;
            resize = circ.checkPointInBorders(circ, x, y);
            if(resize){
                //UndoRedo.undo.push(this);
                //Cloner.cloneObject();
                //UndoRedo.undoResize.push((Circle)Cloner.copied);
                //UndoRedo.undoResize.push(circ);
            }
        }else if(shape instanceof Triangle){
            Triangle tri = (Triangle) shape;
            resize = tri.checkPointInBorders(tri, x, y);
        }else if(shape instanceof Square){
            Square sq = (Square) shape;
            resize = sq.checkPointInBorders(sq, x, y);
        }
        
    }
    
    public Shape getShape(){
        int x = ShapeRepository.shapes.indexOf(shape);
        shape = ShapeRepository.shapes.remove(x);
        return shape;
    }
    
    public void resizeShape(int x, int y){
        if(resize){
            shape = getShape();
            if(shape instanceof LineSegment){
                LineSegment line = (LineSegment) shape;
                if(corner.equals("end")){
                    line.setXend(x);
                    line.setYend(y);
                    line.box.SetX2(x);
                    line.box.SetY2(y);
                    line.box.SetWidth(Math.abs(x - line.box.getX2()));
                    line.box.Setheight(Math.abs(y - line.box.getY2()));
                }else if(corner.equals("start")){
                    line.setXstart(x);
                    line.setYstart(y);
                    line.box.SetX1(x);
                    line.box.SetY1(y);
                    line.box.SetWidth(Math.abs(x - line.box.getX1()));
                    line.box.Setheight(Math.abs(y - line.box.getY1()));
                }
                ShapeRepository.shapes.add(line);
            }else if(shape instanceof Rectangle){
                Rectangle rect = (Rectangle) shape;
                if(corner.equals("left")){
                    if(x < rect.getXend()){
                        rect.setXstart(x);
                        rect.setWidth(Math.abs(x - rect.getXend()));
                        rect.box.SetX1(x-10);
                        rect.box.SetWidth(Math.abs(x - rect.box.getX2())+10);
                    }
                }else if(corner.equals("right")){
                    //if(x > rect.getXstart()){
                        rect.setWidth(Math.abs(x - rect.getStartingX()));
                        rect.box.SetWidth(Math.abs(x - rect.box.getX1()) + 10);
                        rect.setXend(x);
                        rect.box.SetX2(x+10);
                 //   }
                }else if(corner.equals("top")){
                    if(y < rect.getYend()){
                        rect.setYstart(y);
                        rect.setHeight(Math.abs(y - rect.getYend()));
                        rect.box.SetY1(y-10);
                        rect.box.Setheight(Math.abs(y - rect.box.getY2())+10);
                    }
                }else if(corner.equals("bottom")){
                    if(y > rect.getYstart()){
                        rect.setHeight(Math.abs(y - rect.getStartingY()));
                        rect.box.Setheight(Math.abs(y - rect.box.getY1()) + 10);
                        rect.setYend(y);
                        rect.box.SetY2(y+10);
                    }
                }
                //System.out.println(rect.getWidth());
            ShapeRepository.shapes.add(rect);
            }else if(shape instanceof Square){
                Square sq = (Square) shape;
                if(corner.equals("left")){
                    if(x < sq.getXend()){
                        sq.setXstart(x);
                        sq.setLength(Math.abs(x - sq.getXend()));
                        sq.box.SetX1(x-10);
                        sq.box.SetWidth(sq.getLength()+20);
                        sq.box.Setheight(sq.getLength()+20);
                    }
                }else if(corner.equals("right")){
                    if(x > sq.getXstart()){
                        sq.setLength(Math.abs(x - sq.getStartingX()));
                        sq.box.SetWidth(sq.getLength()+20);
                        sq.box.Setheight(sq.getLength()+20);
                        sq.setXend(x);
                        sq.box.SetX2(x+10);
                    }
                }else if(corner.equals("top")){
                    if(y < sq.getYend()){
                        sq.setYstart(y);
                        sq.setLength(Math.abs(y - sq.getYend()));
                        sq.box.SetY1(y-10);
                        sq.box.SetWidth(sq.getLength()+20);
                        sq.box.Setheight(sq.getLength()+20);
                    }
                }else if(corner.equals("bottom")){
                    if(y > sq.getYstart()){
                        sq.setLength(Math.abs(y - sq.getStartingY()));
                        sq.box.SetWidth(sq.getLength()+20);
                        sq.box.Setheight(sq.getLength()+20);
                        sq.setYend(y);
                        sq.box.SetY2(y+10);
                    }
                }
                ShapeRepository.shapes.add(sq);
            }
            else if(shape instanceof Circle){
                Circle circ = (Circle) shape;
                if(corner.equals("right")){
                    if(x > circ.getXstart()){
                        circ.setXend(x);
                        circ.box.SetX2(x+10);
                        circ.setWidth(Math.abs(x - circ.getStartingX()));
                        circ.box.SetWidth(Math.abs(x - circ.box.getX1()) +10);
                    }
                }else if(corner.equals("left")){
                    if(x < circ.getXend()){
                        circ.setXstart(x);
                        circ.setWidth(Math.abs(x - circ.getXend()));
                        circ.box.SetX1(x-10);
                        circ.box.SetWidth(Math.abs(x - circ.box.getX2())+10);
                    }
                }else if(corner.equals("bottom")){
                    if(y > circ.getYstart()){
                        circ.setYend(y);
                        circ.setHeight(Math.abs(y - circ.getYstart()));
                        circ.box.SetY2(y+10);
                        circ.box.Setheight(Math.abs(y - circ.box.getY1())+10);
                    }
                }else if(corner.equals("top")){
                    if(y < circ.getYend()){
                        circ.setYstart(y);
                        circ.setHeight(Math.abs(y - circ.getYend()));
                        circ.box.SetY1(y-10);
                        circ.box.Setheight(Math.abs(y - circ.box.getY2())+10);
                    }
                }
                ShapeRepository.shapes.add(circ);
            }else if(shape instanceof Triangle){
                Triangle tri = (Triangle) shape;
                if(corner.equals("right")){
                    if(x > tri.getX3()){
                        tri.setX2(x);
                        tri.setBase(Math.abs(x-tri.getX3()));
                        tri.setX1(Math.abs(x-tri.getBase()/2));
                        tri.box.SetX2(x+10);
                        tri.box.SetWidth(Math.abs(x-tri.box.getX1())+10);
                    }
                }else if(corner.equals("left")){
                    if(x < tri.getX2()){
                        tri.setX3(x);
                        tri.setBase(Math.abs(x-tri.getX2()));
                        tri.setX1(Math.abs(x+tri.getBase()/2));
                        tri.box.SetX1(x-10);
                        tri.box.SetWidth(Math.abs(x-tri.box.getX2())+10);
                    }
                }else if(corner.equals("top")){
                    if(y < tri.getY2()){
                        tri.setY1(y);
                        tri.box.SetY1(y-10);
                        tri.box.Setheight(Math.abs(y - tri.box.getY2())+10);
                    }
                }else if(corner.equals("bottom")){
                    if(y > tri.getY1()){
                        tri.setY2(y);
                        tri.setY3(y);
                        tri.box.SetY2(y + 10);
                        tri.box.Setheight(Math.abs(y - tri.box.getY1()) + 10);
                    }
                }
                ShapeRepository.shapes.add(tri);
            }
            manipulator.repaint();
        }
    }
    
   /* public void initUndoRedo(){
        UndoRedo.Xchanged.add();
        UndoRedo.redoShape.clear();
        UndoRedo.redo.clear();
        execute();
    }*/

    @Override
    public void execute() {
        
    }

    @Override
    public void unexecute() {
        /*Shape temp = UndoRedo.undoResize.pop();
        if(temp instanceof Circle){
            int x = ShapeRepository.shapes.indexOf(temp);
            ShapeRepository.shapes.remove(x);
            ShapeRepository.shapes.add(UndoRedo.undoResize.pop());
        }
        manipulator.repaint();*/
    }
}
