package org.eclipse.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.ScrolledForm;

/**
 * Infrastructure Project <br>
 * <p>
 * TestSplitSreenInTwo:
 * <p>
 * Created on 6 mai 2015
 * 
 * @author glaizett
 */
public class TestSplitSreenInTwo {

    private static Shell shell;

    private static ScrolledForm scform;

    public static void main(final String[] args) {
        Display display = new Display();
        shell = new Shell(display);
        shell.setText("StackOverflow");
        shell.setLayout(new GridLayout(1, false));

        // createToolbar();
        scform = new ScrolledForm(shell);
        scform.setLayout(new GridLayout(1, false));
        scform.getBody().setLayout(new GridLayout(1, false));
        scform.setExpandHorizontal(true);
        scform.setExpandVertical(true);

        SashForm form = new SashForm(scform.getBody(), SWT.VERTICAL);
        form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createTablePart(form);
        createMessagesPart(form);
        form.setWeights(new int[] { 3, 1 });

        shell.pack();
        shell.open();
        // shell.setSize(600, 450);
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    // private static void createToolbar() {
    // ToolBar toolbar = new ToolBar(shell, SWT.FLAT | SWT.BORDER | SWT.HORIZONTAL | SWT.RIGHT);
    // toolbar.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
    //
    // String[] labels = new String[] { "A", "B", "C" };
    // for (int i = 0; i < 3; i++) {
    // ToolItem item = new ToolItem(toolbar, SWT.PUSH);
    // item.setText(labels[i]);
    // }
    // toolbar.pack();
    // }

    private static void createTablePart(SashForm parent) {
        Table table = new Table(parent, SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for (int col = 0; col < 3; col++) {
            TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText("Col " + col);
        }

        for (int row = 0; row < 20; row++) {
            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, row + " " + 0);
            item.setText(1, row + " " + 1);
            item.setText(2, row + " " + 2);
        }

        for (TableColumn col : table.getColumns()) {
            col.pack();
        }
    }

    private static void createMessagesPart(SashForm parent) {
        Text text = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
        GridData data = new GridData(SWT.FILL, SWT.END, true, false);
        data.heightHint = 50;
        text.setLayoutData(data);

        text.setText("First Message\nSecond Message\nThirdMessage\nFourth Message\nFirst Message\nSecond Message\nThirdMessage\nFourth Message");
    }
}
