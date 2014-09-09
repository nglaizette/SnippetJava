/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package de.vogella.rcp.editor.example.example;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * Perspective:
 * <p>
 * Created on 5 sept. 2014
 * 
 * @author glaizett
 */
public class Perspective implements IPerspectiveFactory {

    /*
     * Overridden method (non-Javadoc)
     * 
     * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
     */
    @Override
    public void createInitialLayout(IPageLayout layout) {
        layout.setFixed(true);
    }

}
