package org.eclipse.swt.snippets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * testInTwoHalf:
 * <p>
 * Created on 6 mai 2015
 * 
 * @author glaizett
 */
public class testInTwoHalf {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final Display display = new Display();
        final Shell shell = new Shell(display, SWT.NONE);
        shell.setText("StackOverflow");
        shell.setLayout(new GridLayout(1, false));

        Group top = new Group(shell, SWT.NONE);
        top.setLayout(new GridLayout(1, false));
        top.setText("Top");

        Group bottom = new Group(shell, SWT.NONE);
        bottom.setLayout(new GridLayout(1, false));
        bottom.setText("Bottom");

        Table topTree = new Table(top, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
        topTree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        createColumnsTable(topTree);
        Tree bottomTree = new Tree(bottom, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
        createColumns(bottomTree);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();

    }

    private static void createColumns(Tree tree) {
        tree.setHeaderVisible(true);

        for (int i = 0; i < 3; i++) {
            new TreeColumn(tree, SWT.NONE).setText("Col " + i);
        }

        for (int i = 0; i < 10; i++) {
            TreeItem item = new TreeItem(tree, SWT.NONE);

            for (int j = 0; j < tree.getColumnCount(); j++) {
                item.setText(j, "Item " + i + " " + j);
            }
        }

        for (int i = 0; i < tree.getColumnCount(); i++) {
            tree.getColumn(i).pack();
        }
    }

    private static void createColumnsTable(Table tree) {
        tree.setHeaderVisible(true);

        for (int i = 0; i < 3; i++) {
            new org.eclipse.swt.widgets.TableColumn(tree, SWT.NONE).setText("Col " + i);
        }

        for (int i = 0; i < 15; i++) {
            TableItem item = new TableItem(tree, SWT.NONE);

            for (int j = 0; j < tree.getColumnCount(); j++) {
                item.setText(j, "Item " + i + " " + j);
            }
        }

        for (int i = 0; i < tree.getColumnCount(); i++) {
            tree.getColumn(i).pack();
        }
    }

}
