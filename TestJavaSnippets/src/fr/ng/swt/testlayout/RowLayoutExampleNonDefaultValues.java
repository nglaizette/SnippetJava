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
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * LayoutExample:
 * <p>
 * Created on 31 juil. 2014
 * 
 * @author glaizett
 */
public class RowLayoutExampleNonDefaultValues {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        // Create the layout.
        RowLayout rowLayout = new RowLayout();
        // Optionally set layout fields.
        rowLayout.wrap = false;
        rowLayout.pack = false;
        rowLayout.justify = true;
        rowLayout.type = SWT.VERTICAL;
        rowLayout.marginLeft = 5;
        rowLayout.marginTop = 5;
        rowLayout.marginRight = 5;
        rowLayout.marginBottom = 5;
        rowLayout.spacing = 0;
        // Set the layout into the composite.
        shell.setLayout(rowLayout);
        // Create the children of the composite.
        new Button(shell, SWT.PUSH).setText("Button 1");
        new Button(shell, SWT.PUSH).setText("Wide Button 2");
        new Button(shell, SWT.PUSH).setText("Button 3");
        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }
}
