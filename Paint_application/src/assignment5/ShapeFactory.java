package assignment5;

import java.awt.Color;

public class ShapeFactory {
    public static void getShapeToDraw(String type, int xbegin, int ybegin, Color color, boolean isFilled){
        if(type.equals("line")){
            LineSegment line = new LineSegment(xbegin, ybegin, xbegin, ybegin, color);  
            ShapeRepository.shapes.add(line);
        }
        else if(type.equals("square")){
            Square square = new Square(xbegin, ybegin, color, isFilled);  
            ShapeRepository.shapes.add(square);
        }
        else if(type.equals("rectangle")){
            Rectangle rect = new Rectangle(xbegin, ybegin, color, isFilled);
            ShapeRepository.shapes.add(rect);
        }
        else if(type.equals("circle")){
            Circle circle = new Circle(xbegin, ybegin, color, isFilled);
            ShapeRepository.shapes.add(circle);
        }
        else if(type.equals("triangle")){
            Triangle tri = new Triangle(xbegin, ybegin, color, isFilled);
            ShapeRepository.shapes.add(tri);
        }
        
    }
}
