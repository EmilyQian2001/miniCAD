package miniCAD;

import java.awt.*;
import javax.swing.*;

public class CAD extends JFrame {
    public static Color[] colorArray = { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.RED,
            Color.PINK, new Color(138, 43, 226) };
    public static String[] colorName = { "black", "blue", "cyan", "green", "yellow", "red", "pink", "purple" };
    // static 便于其他类里使用
    public String[] tools = { "选定", "放大", "缩小", "加粗", "变细", "清屏" };
    Graphics g;

    public CAD() {
        setTitle("miniCAD");
        setLayout(new BorderLayout(5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        View view = new View();
        add(view, BorderLayout.CENTER);

        // menu: save and open
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("文件");
        JMenuItem item1 = new JMenuItem("打开");
        JMenuItem item2 = new JMenuItem("保存");
        // need to fill in
        item1.addActionListener(view.ls);
        item2.addActionListener(view.ls);
        menu1.add(item1);
        menu1.add(item2);
        menuBar.add(menu1);
        setJMenuBar(menuBar);

        // west: shape and color
        JPanel west = new JPanel();
        west.setPreferredSize(new Dimension(100, 800));
        west.setLayout(new GridLayout(5 + colorArray.length, 1)); // 5 shape + 4*2 color
        for (int i = 0; i < 5 + colorArray.length; i++) {
            JButton button = new JButton();
            if (i <= 4) {// shape
                button.setPreferredSize(new Dimension(80, 60));
                ImageIcon icon;
                if (i == 0) {
                    icon = new ImageIcon("image/line.png");
                    button.setActionCommand("Line");
                } else if (i == 1) {
                    icon = new ImageIcon("image/rect.png");
                    button.setActionCommand("Rect");
                } else if (i == 2) {
                    icon = new ImageIcon("image/circle.png");
                    button.setActionCommand("Circle");
                } else if (i == 3) {
                    icon = new ImageIcon("image/text.png");
                    button.setActionCommand("Text");
                } else {
                    icon = new ImageIcon("image/eraser.png");
                    button.setActionCommand("Eraser");
                }
                // 自适应图标
                Image temp = icon.getImage().getScaledInstance(80, 60, Image.SCALE_SMOOTH);
                icon = new ImageIcon(temp);
                button.setIcon(icon);
            } else {// color
                button.setPreferredSize(new Dimension(80, 60));
                button.setBackground(colorArray[i - 5]);
                button.setActionCommand(colorName[i - 5]);
            }
            button.setBorder(BorderFactory.createRaisedBevelBorder());// 凸效果
            // need to fill in
            button.addActionListener(view.ls);
            west.add(button);
        }
        add(west, BorderLayout.WEST);

        // east: function
        JPanel east = new JPanel();
        east.setPreferredSize(new Dimension(100, 800));
        east.setLayout(new GridLayout(tools.length, 1));
        for (int i = 0; i < tools.length; i++) {
            JButton button = new JButton(tools[i]);
            button.setPreferredSize(new Dimension(80, 80));
            button.setBackground(Color.LIGHT_GRAY);
            button.setActionCommand(tools[i]);
            button.setBorder(BorderFactory.createRaisedBevelBorder());// 凸效果
            // need to fill in
            button.addActionListener(view.ls);
            east.add(button);
        }
        add(east, BorderLayout.EAST);

        // other
        setVisible(true);
        g = view.getGraphics();
        view.ls.setG(g);
    }

    public static void main(String[] args) {
        CAD frame = new CAD();

    }
}