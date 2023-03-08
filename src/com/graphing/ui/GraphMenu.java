package com.graphing.ui;

import com.graphing.handlers.CanvasHandler;
import com.graphing.io.FileExport;
import com.graphing.io.FileImport;
import com.graphing.model.Tools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphMenu extends JMenuBar{

    JMenu fileMenu;
    JMenu toolsMenu;

    JMenuItem exportFile, importFIle;
    JMenuItem nodeTool, edgeTool;

    private final GraphCanvas canvas;

    public GraphMenu(GraphCanvas canvas) {
        super();
        this.canvas = canvas;

        fileMenu = new JMenu("File");
        toolsMenu = new JMenu("Tools");

        exportFile = new JMenuItem("Export");
        importFIle = new JMenuItem("Import");

        fileMenu.add(exportFile);
        fileMenu.add(importFIle);

        nodeTool = new JMenuItem("Node");
        edgeTool = new JMenuItem("Edge");

        toolsMenu.add(nodeTool);
        toolsMenu.add(edgeTool);

        exportFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileExport file = new FileExport(canvas.canvasHandler);
                file.write();
            }
        });

        importFIle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileImport file = new FileImport(canvas);
                file.read();
            }
        });

        edgeTool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.getHandler().setMode(Tools.Tool.EDGE);
            }
        });

        nodeTool.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.getHandler().setMode(Tools.Tool.NODE);
            }
        });

        this.add(fileMenu);
        this.add(toolsMenu);
    }
}
