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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * SetFixedSizeForGroup:
 * <p>
 * Created on 5 août 2014
 * 
 * @author glaizett
 */
public class SetFixedSizeForGroup {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(3, true));
        shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for (int i = 0; i < 3; i++) {
            createGroup(shell, i);
        }

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static void createGroup(Shell parent, int index) {
        Group group = new Group(parent, SWT.NONE);
        group.setText("Group " + index);
        group.setLayout(new GridLayout(1, false));
        group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for (int i = 0; i < index + 1; i++) {
            String text = "";
            for (int j = 0; j < index + 1; j++) {
                text += "text";
            }

            Label label = new Label(group, SWT.NONE);
            label.setText(text);
            label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        }
    }

}
