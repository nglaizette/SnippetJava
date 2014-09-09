package de.vogella.rcp.editor.example.example.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import de.vogella.rcp.editor.example.example.editor.MyPersonEditor;
import de.vogella.rcp.editor.example.example.editor.MyPersonEditorInput;
import de.vogella.rcp.editor.example.example.model.Person;
import de.vogella.rcp.editor.example.example.views.View;

public class CallEditor extends AbstractHandler {

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        System.out.println("Called");

        // get the view
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
        IWorkbenchPage page = window.getActivePage();
        View view = (View) page.findView(View.ID);

        // get the selection
        ISelection selection = view.getSite().getSelectionProvider().getSelection();

        if (selection != null && selection instanceof IStructuredSelection) {
            Object obj = ((IStructuredSelection) selection).getFirstElement();

            // If we had a selection lets open the editor
            if (obj != null) {
                Person person = (Person) obj;
                MyPersonEditorInput input = new MyPersonEditorInput(person.getId());

                try {
                    page.openEditor(input, MyPersonEditor.ID);
                }
                catch (PartInitException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
        return null;
    }

}
