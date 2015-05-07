package org.eclipse.swt.snippets;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;

public class TestSizeComposite {
    public static void main(String[] args) throws Exception {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new GridLayout(1, false));

        TabFolder folder = new TabFolder(shell, SWT.TOP);
        folder.setLayout(new GridLayout());
        folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        TabItem item = new TabItem(folder, SWT.NONE);
        item.setText("Tab 1");

        final Composite composite = new Composite(folder, SWT.BORDER);
        composite.setLayout(new GridLayout());
        composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        Text text = new Text(composite, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
        text.setText("Tab 1");
        Button b = new Button(composite, SWT.PUSH);
        b.setText("Press");
        b.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                composite.setSize(23, 43);
            }
        });

        item.setControl(composite);

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
