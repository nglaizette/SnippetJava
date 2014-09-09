package de.vogella.rcp.editor.example.example.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import de.vogella.rcp.editor.example.example.model.MyModel;
import de.vogella.rcp.editor.example.example.model.Person;

public class MyPersonEditor extends EditorPart {

    public static final String ID = "de.vogella.rcp.editor.example.example.personeditor";

    private Person person;

    private MyPersonEditorInput input;

    public MyPersonEditor() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void doSave(IProgressMonitor monitor) {
        // person.getAdress().setContry(text2.getText());

    }

    @Override
    public void doSaveAs() {
        // TODO Auto-generated method stub

    }

    @Override
    /**
     * Will be called before createPartControl
     */
    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        if (!(input instanceof MyPersonEditorInput)) {
            throw new RuntimeException("Wrong input");
        }

        MyPersonEditorInput newName = (MyPersonEditorInput) input;
        setSite(site);
        setInput(input);
        person = MyModel.getInstance().getPersonById(this.input.getId());
        setPartName("Person ID: " + person.getId());

    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public boolean isSaveAsAllowed() {
        return false;
    }

    @Override
    public void createPartControl(Composite parent) {
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        parent.setLayout(layout);

        Label label1 = new Label(parent, SWT.NONE);
        label1.setText("First name");

        Text text = new Text(parent, SWT.BORDER);
        text.setText(person.getFirstName());
        text.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        new Label(parent, SWT.NONE).setText("Last name:");

        Text lastname = new Text(parent, SWT.BORDER);
        lastname.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        lastname.setText(person.getLastName());

    }

    @Override
    public void setFocus() {
        // TODO Auto-generated method stub

    }

}
