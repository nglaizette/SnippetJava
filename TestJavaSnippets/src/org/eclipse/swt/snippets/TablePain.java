package org.eclipse.swt.snippets;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class TablePain {
    public static void main(String[] args) throws IOException {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        final Color red = display.getSystemColor(SWT.COLOR_RED);
        final Color blue = display.getSystemColor(SWT.COLOR_BLUE);

        final Table table = new Table(shell, SWT.H_SCROLL | SWT.VIRTUAL | SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setItemCount(1000);

        for (int x = 0; x < 3; x++) {
            final TableColumn column = new TableColumn(table, SWT.NONE);
            column.setText("col" + x);
            column.setWidth(100);
            column.setMoveable(true);
        }

        // table.addListener(SWT.SetData, new Listener() {
        // public void handleEvent(Event e) {
        // TableItem item = (TableItem) e.item;
        // int y = table.indexOf(item);
        // item.setText(new String[] { "data0", "data1", "data2" });
        // for (int x = 0; x < 3; x++) {
        // boolean isRed = ((x^y)&1)==0;
        // item.setBackground(x, isRed ? red : blue);
        // }
        // }
        // });

        // table.addListener(SWT.EraseItem, new Listener() {
        // public void handleEvent(Event event) {
        // // Selection:
        // event.detail &= ~SWT.SELECTED;
        // // Expect: selection now has no visual effect.
        // // Actual: selection remains but changes from light blue to white.
        //
        // // MouseOver:
        // event.detail &= ~SWT.HOT;
        // // Expect: mouse over now has no visual effect.
        // // Actual: behavior remains unchanged.
        // }
        // });

        shell.setSize(shell.computeSize(SWT.DEFAULT, SWT.DEFAULT).x, 300);
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
