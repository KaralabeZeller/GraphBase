package com.graphing.handlers;

import com.graphing.model.Node;
import com.graphing.model.NodeList;

import java.awt.*;
import java.awt.event.MouseEvent;

public class NodeHandler {

    private NodeList nodes;
    private Node currentNode;

    public NodeHandler(NodeList nodes) {
        this.nodes = nodes;
        currentNode = new Node(0, 0);
    }

    public void mouseMovement(MouseEvent e) {
        if(!foundNode(e.getX(), e.getY())) {
            currentNode = new Node(e.getX(), e.getY());
        }
    }

    public void mouseDragged(MouseEvent e) {
        currentNode.setX(e.getX());
        currentNode.setY(e.getY());
    }

    public void mousePressed(MouseEvent e) {
        nodes.add(currentNode);
    }

    public boolean foundNode(int x, int y) {
        currentNode = nodes.getNode(x, y);
        if (currentNode != null) {
            currentNode.setSelected(true);
            return true;
        } else {
            nodes.clearSelection();
            return false;
        }
    }

    public NodeList getNodes() {
        return nodes;
    }
}
