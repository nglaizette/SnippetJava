/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package fr.ng.swt.testlayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * TestDeuxTiersSashForm:
 * <p>
 * Created on 31 juil. 2014
 * 
 * @author glaizett
 */
public class TestDeuxTiersSashForm {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setBackground(display.getSystemColor(0));

        GridLayout layoutShell = new GridLayout();
        shell.setLayout(layoutShell);

        Composite composite = new Composite(shell, SWT.NONE);
        RowLayout layout = new RowLayout();
        layout.type = SWT.HORIZONTAL;
        composite.setLayout(layout);
        Button button1 = new Button(composite, SWT.PUSH);
        button1.setText("Button 1");
        button1.setLayoutData(new RowData(50, 50));
        Button button2 = new Button(composite, SWT.PUSH);
        button2.setText("Button 2");
        button2.setLayoutData(new RowData(50, 40));
        Button button3 = new Button(composite, SWT.PUSH);
        button3.setText("Button 3");
        button3.setLayoutData(new RowData(50, 30));

        Button button4 = new Button(shell, SWT.PUSH);
        button4.setText("Button 4");
        // button4.setLayoutData(new RowData(50, 30));
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}
