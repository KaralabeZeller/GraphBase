package com.graphing.model;

import java.util.ArrayList;
import java.util.List;

public class NodeList {

    List<Node> nodeList;

    public NodeList() {
        this.nodeList = new ArrayList<>();
    }

    public void add(Node node) {
        if(getNode(node) == null)
            this.nodeList.add(node);
    }

    public Node getNode(Node n) {
        for(Node node: nodeList) {
            if(node.isCollision(n)) {
                return node;
            }
        }
        return null;
    }

    public Node getNode(int x, int y) {
        return getNode(new Node(x, y));
    }

    public List<Node> getNodes() {
        return nodeList;
    }

    public void clearSelection() {
        for(Node node : getNodes()) {
            node.setSelected(false);
        }
    }

    public Node getNode(String id) {

        for(Node node : nodeList) {
            if(node.getID().equals(id))
                return node;
        }
        return null;
    }
}
