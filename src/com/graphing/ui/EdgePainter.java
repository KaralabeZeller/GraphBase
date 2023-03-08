package com.graphing.ui;

import com.graphing.model.Edge;
import com.graphing.model.Node;

import java.awt.*;

public class EdgePainter {

    public void paintGraphPoint(Graphics g, Edge edge) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.PINK);
        g2.setStroke(new BasicStroke(edge.getThickness()));
        g2.drawLine(edge.getNode1().getX() + edge.getNode1().getRadius(), edge.getNode1().getY()  + edge.getNode1().getRadius(), edge.getNode2().getX() + edge.getNode2().getRadius(), edge.getNode2().getY() + edge.getNode2().getRadius());
    }
}
