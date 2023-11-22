package assignment5;

import java.awt.Color;

public class ShapeDrawer  implements ICommand{
    ShapeManipulator manipulator;
    
    public ShapeDrawer(ShapeManipulator test){
        this.manipulator = test;
    }
    
    public void initShapes(String currentShape, int xstart, int ybegin, Color currentColor, boolean isFilled){
        ShapeFactory.getShapeToDraw(currentShape, xstart, ybegin, currentColor, isFilled);
    }
    
    public void drawShapes(int xend, int yend){
        ShapeRepository.shapes.get(ShapeRepository.shapes.size()-1).drag(xend, yend);
    }
    
    public void initUndoRedo(){
        UndoRedo.undoShape.push(ShapeRepository.shapes.get(ShapeRepository.shapes.size()-1));
        UndoRedo.redoShape.clear();
        UndoRedo.redo.clear();
        execute();
    }
    
    @Override
    public void execute(){
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
