package com.graphing.model;

import com.graphing.utils.StringUtils;

public class Edge {

    private Node node1;
    private Node node2;

    private int thickness = 8;

    private String ID;

    public Edge(Node node1) {
        this.setNode1(node1);
        this.ID = StringUtils.generateID();
    }

    public Edge(Node node1, Node node2){
        this.setNode1(node1);
        this.setNode2(node2);
        this.ID = StringUtils.generateID();
    }

    public boolean isTheSame(Edge edge) {
        if(this.node1.equals(edge.node1) && this.node2.equals(edge.node2))
            return true;
        if(this.node1.equals(edge.node2) && this.node2.equals(edge.node1))
            return true;
        else return false;
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public int getThickness() {
        return thickness;
    }

    public void setNode2(int x, int y) {
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(ID + ";");
        buffer.append(node1.getID() + ";");
        buffer.append(node2.getID());
        return buffer.toString();
    }

    public void setID(String id) {
        this.ID = id;
    }
}
