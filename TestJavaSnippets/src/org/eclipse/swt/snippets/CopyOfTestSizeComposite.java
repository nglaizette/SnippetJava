package org.eclipse.swt.snippets;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CopyOfTestSizeComposite {
    public static void main(String[] args) throws Exception {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        Color systemColor = Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
        final Composite textArea = new Composite(shell, SWT.FILL);
        textArea.setLayout(new GridLayout(4, false));
        textArea.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        textArea.setBackground(systemColor);

        Label textproperty = new Label(textArea, SWT.NONE);
        textproperty.setText("Select property:");
        textproperty.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        textproperty.setBackground(systemColor);

        final Combo parameterSelectionCombobox = new Combo(textArea, SWT.BORDER);
        GridData comboGridData = new GridData();
        comboGridData.horizontalAlignment = SWT.FILL;
        comboGridData.verticalAlignment = SWT.FILL;
        comboGridData.grabExcessHorizontalSpace = true;
        comboGridData.grabExcessVerticalSpace = false;
        comboGridData.horizontalSpan = 4;
        comboGridData.minimumWidth = 400;
        parameterSelectionCombobox.setLayoutData(comboGridData);
        parameterSelectionCombobox.addSelectionListener(new SelectionAdapter() {

            @Override
            public final void widgetSelected(SelectionEvent e) {
            }

        });

        Label text = new Label(textArea, SWT.NONE);
        text.setText("a =");
        text.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        text.setBackground(systemColor);

        // DecimalFormat df = new DecimalFormat("#.##");
        // df.setDecimalFormatSymbols('.');

        final Text atext = new Text(textArea, SWT.NONE);
        atext.setText("");
        GridData aLayoutData = new GridData(SWT.FILL, SWT.FILL, false, false);
        // aLayoutData.widthHint = 100;
        atext.setLayoutData(aLayoutData);
        atext.setText(new Double(12.3).toString());
        atext.addFocusListener(new FocusListener() {
            private double oldValue;

            // private DecimalFormat df = new DecimalFormat("#.##");

            @Override
            public final void focusGained(FocusEvent e) {
                try {
                    oldValue = Double.parseDouble(atext.getText());
                }
                catch (NumberFormatException nfe) {
                    MessageDialog.openInformation(Display.getDefault().getActiveShell(),
                            "Invalid input", "This number must be decimal.");
                    atext.setText(new Double(oldValue).toString());
                }
            }

            @Override
            public final void focusLost(FocusEvent e) {
                try {
                    double value = Double.parseDouble(atext.getText());
                }
                catch (NumberFormatException nfe) {
                    MessageDialog.openInformation(Display.getDefault().getActiveShell(),
                            "Invalid input", "This number must be decimal.");
                    atext.setText(new Double(oldValue).toString());
                }

            }
        });

        // // Label qui sert à rien sauf a avoir un joli output
        // Label uselessLabel1 = kit.createLabel(textArea, "");
        // uselessLabel1.setVisible(false);

        // parameterSelectionCombobox.pack();
        // kit.adapt(parameterSelectionCombobox);
        parameterSelectionCombobox.select(0);

        Label textb = new Label(textArea, SWT.NONE);
        textb.setText("b =");
        textb.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING));
        textb.setBackground(systemColor);

        final Text btext = new Text(textArea, SWT.NONE);
        btext.setText("");
        GridData bLayoutData = new GridData(SWT.FILL, SWT.FILL, false, false);
        bLayoutData.widthHint = 100;
        btext.setLayoutData(bLayoutData);
        btext.setText(new Double(3.2).toString());
        btext.addFocusListener(new FocusListener() {
            private double oldValue;

            @Override
            public final void focusGained(FocusEvent e) {
                oldValue = Double.parseDouble(btext.getText());
            }

            @Override
            public final void focusLost(FocusEvent e) {
                try {
                    double value = Double.parseDouble(btext.getText());

                }
                catch (NumberFormatException nfe) {
                    MessageDialog.openInformation(Display.getDefault().getActiveShell(),
                            "Invalid input", "This number must be decimal.");
                    btext.setText(new Double(oldValue).toString());
                }

            }
        });

        // // Label qui sert à rien sauf a avoir un joli output
        // Label uselessLabel2 = kit.createLabel(textArea, "");
        // uselessLabel2.setVisible(false);

        final Button button = new Button(textArea, SWT.NONE);
        button.setText("Clear All");
        new Label(textArea, SWT.NONE);
        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {

                atext.setText(new Double(0).toString());
                parameterSelectionCombobox.select(0);
                btext.setText(new Double(1.3).toString());

            }
        });

        shell.setSize(300, 200);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
