package com.graphing.handlers;

import com.graphing.model.Edge;
import com.graphing.model.EdgeList;
import com.graphing.model.Node;
import com.graphing.model.NodeList;

import java.awt.event.MouseEvent;

public class EdgeHandler {

    private EdgeList edges;
    private NodeList nodes;

    private Edge currentEdge;
    private Node currentNode;

    public EdgeHandler(EdgeList edges, NodeList nodes) {
        this.edges = edges;
        this.nodes = nodes;

        currentEdge = null;
        currentNode = null;
    }

    public void mouseReleased(MouseEvent e) {
        if(getCurrentNode() != null && getCurrentEdge() != null) {
            Node target = nodes.getNode(getCurrentNode());
            if (target != null) {
                getCurrentEdge().setNode2(target);
                edges.add(getCurrentEdge());
            }
        }
        currentEdge = null;
        currentNode = null;
        nodes.clearSelection();
    }

    public void mouseDragged(MouseEvent e) {
        if(getCurrentEdge() != null) {
            if(getCurrentNode() == null) {
                currentNode = new Node(e.getX(), e.getY());
                getCurrentEdge().setNode2(getCurrentNode());
            } else {
                getCurrentEdge().getNode2().setX(e.getX());
                getCurrentEdge().getNode2().setY(e.getY());
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        Node selected = nodes.getNode(e.getX(), e.getY());

        if( selected != null && getCurrentEdge() == null) {
            currentEdge = new Edge(selected);
            selected.setSelected(true);
        }
    }

    public Edge getCurrentEdge() {
        return currentEdge;
    }

    public Node getCurrentNode() {
        return currentNode;
    }
}
