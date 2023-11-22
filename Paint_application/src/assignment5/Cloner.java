package assignment5;

public class Cloner implements ICommand{
    
    public static Shape copied;
    ShapeManipulator manipulator; 
    Singelton ShapeSelected;

    Cloner(ShapeManipulator manipulator){
        this.manipulator = manipulator;
        
    }
    
    public static void cloneObject(){
        Singelton ShapeSelected = Singelton.ref();
        if(ShapeSelected.getShapeSelected() != null){
            if(ShapeSelected.getShapeSelected() instanceof LineSegment){
                LineSegment line = (LineSegment)ShapeSelected.getShapeSelected();
                copied = (Shape) line.clone();
            }
            if(ShapeSelected.getShapeSelected() instanceof Square){
                Square sq = (Square)ShapeSelected.getShapeSelected();
                copied = (Shape) sq.clone();
            }
            if(ShapeSelected.getShapeSelected() instanceof Rectangle){
                Rectangle rect = (Rectangle)ShapeSelected.getShapeSelected();
                copied = (Shape) rect.clone();
            }
            if(ShapeSelected.getShapeSelected() instanceof Circle){
                Circle circ = (Circle)ShapeSelected.getShapeSelected();
                copied = (Shape) circ.clone();
            }
            if(ShapeSelected.getShapeSelected() instanceof Triangle){
                Triangle tri = (Triangle)ShapeSelected.getShapeSelected();
                copied = (Shape)tri.clone();
            }
        }
    }
    
    public void pasteObject(int x, int y){
        UndoRedo.undo.push(this);
        if(copied instanceof LineSegment){
            LineSegment line = (LineSegment) copied;
            line.setXstart(x);
            line.setYstart(y);
            ShapeRepository.shapes.add(line);
        }
        
        if(copied instanceof Square){
            Square sq = (Square) copied;
            sq.setXstart(x);
            sq.setXend(x+sq.getLength());
            sq.setYstart(y);
            sq.setYend(y+sq.getLength());
            ShapeRepository.shapes.add(sq);
        }
        
        if(copied instanceof Rectangle){
            Rectangle rect = (Rectangle) copied;
            rect.setXstart(x);
            rect.setXend(x+rect.getWidth());
            rect.setYstart(y);
            rect.setYend(y+rect.getHeight());
            ShapeRepository.shapes.add(rect);
        }
        
        if(copied instanceof Circle){
            Circle circ = (Circle) copied;
            circ.setXstart(x);
            circ.setXend(x+circ.getWidth());
            circ.setYstart(y);
            circ.setYend(y+circ.getHeight());
            ShapeRepository.shapes.add(circ);
        }
        
        if(copied instanceof Triangle){
            Triangle tri = (Triangle) copied;
            tri.setX1(x+tri.getBase()/2);
            tri.setX2(x+tri.getBase());
            tri.setX3(x);
            tri.setY1(y-tri.getHeight());
            tri.setY2(y);
            tri.setY3(y);
            ShapeRepository.shapes.add(tri);
        }
        UndoRedo.undoShape.push(copied);
        ShapeManipulator.mode = 1;
        BorderBox.UnSelect();
        manipulator.repaint();
    }

    @Override
    public void execute() {
        UndoRedo.undo.push(this);
        if(UndoRedo.redoPressed){
            UndoRedo.undoShape.push(UndoRedo.redoShape.pop());
            ShapeRepository.shapes.add(UndoRedo.undoShape.peek());
            UndoRedo.redoPressed = false;
            manipulator.repaint();
        }else{
            UndoRedo.redoShape.clear();
            UndoRedo.redo.clear();
        }
    }

    @Override
    public void unexecute() {
        UndoRedo.redoShape.push(UndoRedo.undoShape.pop());
        int x = ShapeRepository.shapes.indexOf(UndoRedo.redoShape.peek());
        ShapeRepository.shapes.remove(x);
        manipulator.repaint();
    }
}
