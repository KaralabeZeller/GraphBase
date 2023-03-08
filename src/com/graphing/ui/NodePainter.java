package com.graphing.ui;

import com.graphing.model.Node;

import java.awt.*;

public class NodePainter {

    public void paintGraphPoint(Graphics g, Node node) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g2.fillOval(node.getX(), node.getY(), node.getRadius() * 2, node.getRadius()*2);
        Color color = node.isSelected() ? Color.BLUE : Color.DARK_GRAY;
        g2.setColor(color);
        g2.setStroke(new BasicStroke(4));
        g2.drawOval(node.getX(), node.getY(), node.getRadius()*2, node.getRadius()*2);
    }

}
