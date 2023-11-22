package assignment5;

import java.util.Stack;

public class UndoRedo{
    public static Stack<ICommand> undo = new Stack<ICommand>();
    public static Stack<ICommand> redo = new Stack<ICommand>();
    public static Stack<Shape> undoShape = new Stack<Shape>(); 
    public static Stack<Shape> redoShape = new Stack<Shape>(); 
   // public static Stack<Integer> changedX = new Stack<Integer>();
  // public static Stack<Integer> changedY = new Stack<Integer>();
  //  public static Stack<Shape> undoResize = new Stack<Shape>(); 
    public static boolean redoPressed;
    
    public void redo(){
        if(!redoShape.isEmpty()){
            redo.peek().execute();
            undo.push(redo.pop());
        }
        else
            redoPressed = false;
    }
    
    public void undo(){
        if(!undoShape.isEmpty()){
            undo.peek().unexecute();
            redo.push(undo.pop());
        }
    }
    
}
