package miniCAD;

import java.awt.*;

public class Eraser extends Shape {

    public Eraser(int x1, int x2, int y1, int y2, Color color, float width) {
        super(x1, x2, y1, y2, color, width);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(width));
        g2.setColor(Color.WHITE);
        g2.drawLine(x1, y1, x2, y2);
    }

    @Override
    public boolean isSelected(int x, int y) {
        // TODO Auto-generated method stub
        return false;
    }

}
