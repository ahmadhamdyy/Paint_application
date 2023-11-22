/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author mahmo
 */
public class Singelton {
    
    private static Shape SelectedShape = null;
    private static Singelton ref;
    
    public static Singelton ref()
    {
        if(ref==null)
        {
            ref = new Singelton();
        }
        return ref;
    }
    
    public void setShapeSelected(Shape SelectedShape)
    {
        this.SelectedShape = SelectedShape;
    }
    public Shape getShapeSelected()
    {
        return this.SelectedShape;
    }
    
}
