package assignment5;

import java.util.ArrayList;

public class ShapeRepository implements Container{
    public static ArrayList<Shape> shapes = new ArrayList<Shape>();
    @Override
    public Iterator getIterator() {
        return new ShapeIterator();
    }
    private class ShapeIterator implements Iterator {
        int indexStart;
        int indexEnd = shapes.size()-1;
        @Override
        public boolean hasNext() {
            if(indexStart < ShapeRepository.shapes.size())
                return true;
            return false;
        }
      
        public boolean hasPrev() {
            if(indexEnd >= 0)
                return true;
            return false;
        }

        @Override
        public Shape next() {
            if(this.hasNext())
                return shapes.get(indexStart++);
            return null;
        }		

        @Override
        public Shape prev() {
            if(this.hasNext())
                return shapes.get(indexEnd--);
            return null;
        }
   }
}
