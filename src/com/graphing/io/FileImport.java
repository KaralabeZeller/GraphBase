package com.graphing.io;

import com.graphing.model.Edge;
import com.graphing.model.EdgeList;
import com.graphing.model.Node;
import com.graphing.model.NodeList;
import com.graphing.ui.GraphCanvas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileImport {

    private final GraphCanvas canvas;
    File nodeFile, edgeFile;

    public FileImport(GraphCanvas canvas) {
        this.canvas = canvas;
    }

    public void read() {
        try {
            readNodes(canvas.getHandler().getNodes());
            readEdges(canvas.getHandler().getEdges());
            canvas.repaint();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readNodes(NodeList nodes) throws FileNotFoundException {
        nodeFile = new File("nodes.csv");
        Scanner scanner = new Scanner(nodeFile);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String parts[] = line.split(";");
            Node node = new Node(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
            node.setID(parts[0]);
            node.setRadius(Integer.parseInt(parts[3]));

            nodes.add(node);
        }

        scanner.close();
    }

    private void readEdges(EdgeList edges) throws FileNotFoundException {
        edgeFile = new File("edges.csv");
        Scanner scanner = new Scanner(edgeFile);

        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String parts[] = line.split(";");
            Edge edge = new Edge(canvas.getHandler().getNodes().getNode(parts[1]), canvas.getHandler().getNodes().getNode(parts[2]));
            edge.setID(parts[0]);

            edges.add(edge);
        }

        scanner.close();
    }
}
