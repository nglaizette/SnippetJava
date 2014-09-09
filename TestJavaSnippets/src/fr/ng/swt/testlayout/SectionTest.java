/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package fr.ng.swt.testlayout;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.Section;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * SectionTest:
 * <p>
 * Created on 5 août 2014
 * 
 * @author glaizett
 */
public class SectionTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new GridLayout());

        Button b = new Button(shell, SWT.PUSH);
        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                addSection(shell);
            }
        });
        b.setText("Add");

        addSection(shell);

        shell.setSize(300, 300);
        shell.open();
        while (!shell.isDisposed()) {
            try {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
                MessageDialog.openError(shell, "Error", e.getMessage());
            }
        }
        display.dispose();
    }

    private static void addSection(Composite parent) {
        Section section = new Section(parent, ExpandableComposite.TITLE_BAR
                | ExpandableComposite.TREE_NODE | ExpandableComposite.CLIENT_INDENT);
        section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        section.setText("Hello");
        // section.setSize(1, 1);

        // Add the check button for enabling/disabling this group
        Button enableControl = new Button(section, SWT.CHECK);
        enableControl.setText("Enable");
        section.setTextClient(enableControl);

        Composite client = new Composite(section, SWT.NONE);
        section.setClient(client);
        client.setLayout(new GridLayout());

        Button b = new Button(client, SWT.PUSH);
        b.setText("one");

        b = new Button(client, SWT.PUSH);
        b.setText("two");
        parent.layout();
    }
}
