package com.graphing.model;

import java.util.ArrayList;
import java.util.List;

public class EdgeList {

    private List<Edge> edgeList;

    public EdgeList() {
        edgeList = new ArrayList<>();
    }

    public void add(Edge edge){
        if(checkUniqueEdge(edge))
            edgeList.add(edge);
    }

    public boolean checkUniqueEdge(Edge edge){
        for(Edge e: edgeList) {
            if(e.isTheSame(edge))
                return false;
        }
        return true;
    }

    public List<Edge> getEdges() {
        return edgeList;
    }
}
