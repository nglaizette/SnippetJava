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
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * GridLayoutExample:
 * <p>
 * Created on 31 juil. 2014
 * 
 * @author glaizett
 */
public class GridLayoutExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        GridLayout gridLayout = new GridLayout();
        shell.setLayout(gridLayout);

        SashForm sashForm = new SashForm(shell, SWT.VERTICAL);
        sashForm.setLayout(new FillLayout());
        sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));
        Button button1 = new Button(sashForm, SWT.PUSH);
        button1.setText("B1");
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        button1.setLayoutData(gridData);

        Button button4 = new Button(sashForm, SWT.PUSH);
        button4.setText("B4");
        GridData gridData4 = new GridData();
        gridData4.horizontalAlignment = GridData.FILL;
        gridData4.verticalAlignment = GridData.FILL;
        gridData4.grabExcessHorizontalSpace = true;
        gridData4.grabExcessVerticalSpace = true;
        button4.setLayoutData(gridData4);

        sashForm.setWeights(new int[] { 2, 1 });
        shell.pack();
        shell.setSize(450, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }

}
