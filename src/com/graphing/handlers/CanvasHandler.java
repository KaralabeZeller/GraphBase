package com.graphing.handlers;

import com.graphing.model.EdgeList;
import com.graphing.model.Node;
import com.graphing.model.NodeList;
import com.graphing.model.Tools;

import java.awt.event.MouseEvent;

public class CanvasHandler {

    private Tools.Tool tool = Tools.Tool.NODE;

    private NodeHandler nodeHandler;
    private EdgeHandler edgeHandler;
    private NodeList nodes;
    private EdgeList edges;

    public CanvasHandler() {

        nodes = new NodeList();
        edges = new EdgeList();

        nodeHandler = new NodeHandler(getNodes());
        edgeHandler = new EdgeHandler(getEdges(), getNodes());

    }

    public void mouseMovement(MouseEvent e) {
        if(tool == Tools.Tool.NODE)
            nodeHandler.mouseMovement(e);
    }

    public void mouseDragged(MouseEvent e) {
        if(tool == Tools.Tool.NODE)
            nodeHandler.mouseDragged(e);
        else if(tool == Tools.Tool.EDGE)
            edgeHandler.mouseDragged(e);
    }

    public void mousePressed(MouseEvent e) {
        if(tool == Tools.Tool.NODE)
            nodeHandler.mousePressed(e);
        else if(tool == Tools.Tool.EDGE)
            edgeHandler.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        if(tool == Tools.Tool.EDGE)
            edgeHandler.mouseReleased(e);
    }

    public NodeHandler getNodeHandler() {
        return nodeHandler;
    }

    public NodeList getNodes() {
        return nodes;
    }

    public EdgeHandler getEdgeHandler() {
        return edgeHandler;
    }

    public EdgeList getEdges() {
        return edges;
    }

    public void setMode(Tools.Tool tool) {
        this.tool = tool;
    }
}
