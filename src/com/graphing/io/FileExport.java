package com.graphing.io;

import com.graphing.handlers.CanvasHandler;
import com.graphing.model.Edge;
import com.graphing.model.Node;
import com.graphing.ui.GraphCanvas;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileExport {

    CanvasHandler canvas;
    FileWriter nodeFile, edgeFIle;

    public FileExport(CanvasHandler canvas) {
        this.canvas = canvas;
    }

    public void write() {
        try {
            wirteNodes(canvas.getNodeHandler().getNodes().getNodes());
            writeEdges(canvas.getEdges().getEdges());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wirteNodes(List<Node> nodes) throws IOException {

        nodeFile = new FileWriter("nodes.csv");
        for(Node node : nodes) {
            nodeFile.write(node.toString() + System.lineSeparator());
        }

        nodeFile.close();
    }

    public void writeEdges(List<Edge> edges) throws IOException {

        edgeFIle = new FileWriter("edges.csv");
        for(Edge edge : edges) {
            edgeFIle.write(edge.toString() + System.lineSeparator());
        }

        edgeFIle.close();
    }
}
