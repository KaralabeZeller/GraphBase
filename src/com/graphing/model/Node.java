package com.graphing.model;

import com.graphing.utils.StringUtils;

public class Node {

    private int x;
    private int y;

    private String ID;

    private int radius = 10;

    private boolean selected = false;

    public Node(int x, int y) {
        this.setX(x);
        this.setY(y);
        this.ID = StringUtils.generateID();
    }

    public boolean isCollision(int x, int y) {
        int dx = this.x + radius - x;
        int dy = this.y + radius - y;
        double distance = Math.sqrt(dx * dx + dy * dy);

        //System.out.println(String.format("X: %d, Y: %d - x: %d, y: %d - dist: %f", this.x, this.y, x, y, distance));

        return distance < this.radius*4;
    }

    public boolean isCollision(Node p) {
        return isCollision(p.getX(), p.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    public void setX(int x) {
        this.x = x - radius;
    }

    public void setY(int y) {
        this.y = y - radius;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Node other = (Node) obj;

        return other.getX() == getX() && other.getY() == getY();

    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getID() + ";");
        buffer.append(x + ";");
        buffer.append(y + ";");
        buffer.append(radius);

        return buffer.toString();
    }

    public String getID() {
        return ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public void setRadius(int radius) {
        this.radius = radius; // TODO make final and set in constructor
    }
}
