package assignment5;

public class ShapeDeleter implements ICommand{
    
    ShapeManipulator manipulator;
    
    static boolean clearPressed;
    static int clearedNum;
    Singelton ShapeSelected;
    public ShapeDeleter(ShapeManipulator s){
        manipulator = s;
       ShapeSelected = Singelton.ref();
    }
    
    public void deleteSelected(){
        if(ShapeSelected.getShapeSelected() != null){
            clearPressed = false;
            int x = ShapeRepository.shapes.indexOf(ShapeSelected.getShapeSelected());
            UndoRedo.undoShape.push(ShapeRepository.shapes.get(x));
            UndoRedo.undo.push(this);
            UndoRedo.redoShape.clear();
            UndoRedo.redo.clear();
            ShapeRepository.shapes.remove(x);
            BorderBox.UnSelect();
            //ShapeManipulator.selectedShape = null;
            manipulator.repaint();
        }
    }
    
    public void clearPanel(){
        UndoRedo.undo.push(this);
        clearPressed = true;
        while(!ShapeRepository.shapes.isEmpty()){
            UndoRedo.undoShape.push(ShapeRepository.shapes.remove(0));
            clearedNum++;
        }
        ShapeManipulator.mode = 1;
        manipulator.repaint();
    }
    
    @Override
    public void execute(){
        if(clearPressed){
            while(!ShapeRepository.shapes.isEmpty()){
                UndoRedo.undoShape.push(ShapeRepository.shapes.remove(0));
                clearedNum++;
            }
        }else{
            UndoRedo.undoShape.push(UndoRedo.redoShape.pop());
            int x = ShapeRepository.shapes.indexOf(UndoRedo.undoShape.peek());
            ShapeRepository.shapes.remove(x);
        }
        manipulator.repaint();
    }

    @Override
    public void unexecute() {
        if(clearPressed){
            while(clearedNum > 0){
                UndoRedo.redoShape.push(UndoRedo.undoShape.pop());
                ShapeRepository.shapes.add(UndoRedo.redoShape.peek());
                clearedNum--;
            }
        }else{
            UndoRedo.redoShape.push(UndoRedo.undoShape.pop());
            ShapeRepository.shapes.add(UndoRedo.redoShape.peek());
        }
        manipulator.repaint();
    }
    
}
