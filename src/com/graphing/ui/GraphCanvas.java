package com.graphing.ui;

import com.graphing.handlers.CanvasHandler;
import com.graphing.model.Edge;
import com.graphing.model.EdgeList;
import com.graphing.model.Node;
import com.graphing.model.NodeList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class GraphCanvas extends JPanel {

    NodePainter pointPainter;
    EdgePainter edgePainter;

    CanvasHandler canvasHandler;

    public GraphCanvas() {
        super();
        canvasHandler = new CanvasHandler();

        pointPainter = new NodePainter();
        edgePainter = new EdgePainter();

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                canvasHandler.mousePressed(e);
                repaint();
            }
            public void mouseReleased(MouseEvent e) {
                canvasHandler.mouseReleased(e);
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                canvasHandler.mouseDragged(e);
                repaint();
            }

            @Override
            public void mouseMoved (MouseEvent e)
            {
                canvasHandler.mouseMovement(e);
                repaint();
            }
        });
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(Edge edge: canvasHandler.getEdges().getEdges()) {
            edgePainter.paintGraphPoint(g, edge);
        }
        if(canvasHandler.getEdgeHandler().getCurrentEdge() != null && canvasHandler.getEdgeHandler().getCurrentNode() != null) {
            edgePainter.paintGraphPoint(g, canvasHandler.getEdgeHandler().getCurrentEdge());
        }
        for(Node node : canvasHandler.getNodes().getNodes()) {
            pointPainter.paintGraphPoint(g, node);
        }

    }

    public CanvasHandler getHandler() {
        return canvasHandler;
    }
}
