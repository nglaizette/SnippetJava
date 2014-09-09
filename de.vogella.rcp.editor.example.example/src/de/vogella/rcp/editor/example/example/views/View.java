package de.vogella.rcp.editor.example.example.views;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.ViewPart;

import de.vogella.rcp.editor.example.example.model.MyModel;
import de.vogella.rcp.editor.example.example.model.Person;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view shows data obtained
 * from the model. The sample creates a dummy model on the fly, but a real implementation would
 * connect to the model available either in this or another plug-in (e.g. the workspace). The view
 * is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be presented in the view. Each
 * view can present the same model objects using different labels and icons, if needed.
 * Alternatively, a single label provider can be shared between views in order to ensure that
 * objects of the same type are presented in the same way everywhere.
 * <p>
 */

public class View extends ViewPart {

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = "de.vogella.rcp.editor.example.example.views.view";

    private ListViewer viewer;

    @Override
    public void createPartControl(Composite parent) {
        viewer = new ListViewer(parent);
        viewer.setContentProvider(ArrayContentProvider.getInstance());
        viewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                Person p = (Person) element;
                return p.getFirstName() + " " + p.getLastName();
            };
        });
        viewer.setInput(MyModel.getInstance().getPersons());
        getSite().setSelectionProvider(viewer);
        hookDoubleClickCommand();

    }

    private void hookDoubleClickCommand() {
        viewer.addDoubleClickListener(new IDoubleClickListener() {
            @Override
            public void doubleClick(DoubleClickEvent event) {
                IHandlerService handlerService = (IHandlerService) getSite().getService(
                        IHandlerService.class);
                try {
                    handlerService.executeCommand("de.vogella.rcp.editor.example.openEditor", null);
                }
                catch (Exception ex) {
                    throw new RuntimeException("de.vogella.rcp.editor.example.openEditor not found");
                }
            }
        });
    }

    @Override
    public void setFocus() {
        viewer.getControl().setFocus();
    }
}
