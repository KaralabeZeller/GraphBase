package com.graphing.ui;

import javax.swing.*;
import java.awt.*;

public class GraphFrame extends JFrame {

    private GraphCanvas canvas;

    public GraphFrame() {
        super("Test");

        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new GraphCanvas();
        setJMenuBar(new GraphMenu(canvas));
        add(canvas);
        setVisible(true);

    }
}
