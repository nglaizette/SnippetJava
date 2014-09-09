/*
 * Copyright (C) 2004-@year@ by IFP-GROUP.
 * All rights reserved.
 *
 * IFP Headquarters:
 * 1 & 4, avenue de Bois-Preau
 * 92852 Rueil-Malmaison Cedex - France
 */
package fr.ng.swt.testlayout;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.forms.widgets.ExpandableComposite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;

/**
 * IFP-Group <br>
 * Infrastructure Project <br>
 * <p>
 * TableSections:
 * <p>
 * Created on 5 août 2014
 * 
 * @author glaizett
 */
public class TableSections {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        // Create the layout.
        shell.setLayout(new GridLayout());

        FormToolkit toolkit = new FormToolkit(Display.getCurrent());
        toolkit.adapt(shell);
        toolkit.paintBordersFor(shell);

        shell.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, true));

        GridLayout layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        shell.setLayout(layout);

        final ScrolledForm scrolledForm_1 = toolkit.createScrolledForm(shell);
        scrolledForm_1.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
        final GridData gridData_sf1 = new GridData(GridData.FILL, GridData.FILL, true, true);
        scrolledForm_1.setLayoutData(gridData_sf1);

        final Composite body_sf1 = scrolledForm_1.getBody();
        final GridLayout gridLayout_body_1 = new GridLayout();
        gridLayout_body_1.marginHeight = 0;
        body_sf1.setLayout(gridLayout_body_1);
        toolkit.paintBordersFor(body_sf1);
        toolkit.adapt(body_sf1);

        // section Diffuse fractures global statistics
        final Section diffuseFracturesGlobalStatistics = new Section(body_sf1,
                ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
                        | ExpandableComposite.TITLE_BAR);
        final GridData gridData_4 = new GridData(GridData.FILL, GridData.BEGINNING, true, false);
        gridData_4.heightHint = 33;
        diffuseFracturesGlobalStatistics.setLayoutData(gridData_4);
        diffuseFracturesGlobalStatistics.setText("Diffuse fractures global statistics");

        final Composite composite = toolkit.createComposite(diffuseFracturesGlobalStatistics,
                SWT.NONE);
        final GridLayout gridLayout_3 = new GridLayout();
        gridLayout_3.marginWidth = 0;
        composite.setLayout(gridLayout_3);
        diffuseFracturesGlobalStatistics.setClient(composite);
        toolkit.paintBordersFor(composite);

        Table globalTable = toolkit.createTable(composite,
                SWT.MULTI | SWT.FULL_SELECTION | toolkit.getBorderStyle());
        final GridData gridData_29 = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData_29.widthHint = 300;

        globalTable.setLayoutData(gridData_29);
        globalTable.setHeaderVisible(true);

        final TableColumn tableColumn_0 = new TableColumn(globalTable, SWT.RIGHT);
        // tableColumn_0.setWidth(88);
        tableColumn_0.setText(" Diffuse set Name ");
        tableColumn_0.pack();

        final TableColumn tableColumn_1 = new TableColumn(globalTable, SWT.NONE);
        // tableColumn_1.setWidth(45);
        tableColumn_1.setText("Number of samples");
        tableColumn_1.pack();

        final TableColumn tableColumn_2 = new TableColumn(globalTable, SWT.NONE);
        // tableColumn_2.setWidth(70);
        tableColumn_2.setText("Mean Strike (...)");
        tableColumn_2.pack();

        final TableColumn tableColumn_3 = new TableColumn(globalTable, SWT.NONE);
        // tableColumn_3.setWidth(60);
        tableColumn_3.setText("Mean Dip (...)");
        tableColumn_3.pack();

        TableColumn globalTableMeanDensityColumn = new TableColumn(globalTable, SWT.NONE);
        // tableColumn_4.setWidth(95);
        globalTableMeanDensityColumn.setText("Mean Density (...)");
        globalTableMeanDensityColumn.pack();

        // Section Well diffuse fractures
        final Section wellDiffuseFracturesSection = new Section(body_sf1,
                ExpandableComposite.TWISTIE | ExpandableComposite.EXPANDED
                        | ExpandableComposite.TITLE_BAR);
        wellDiffuseFracturesSection.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING,
                true, false));
        wellDiffuseFracturesSection.setText("Well diffuse fractures");
        final Composite compositeSelectionCriteria = toolkit.createComposite(
                wellDiffuseFracturesSection, SWT.NONE);
        final GridLayout gridLayout_2 = new GridLayout();
        gridLayout_2.marginWidth = 0;
        compositeSelectionCriteria.setLayout(gridLayout_2);
        wellDiffuseFracturesSection.setClient(compositeSelectionCriteria);

        Table wellDiffuseFractureTable = toolkit.createTable(compositeSelectionCriteria, SWT.MULTI
                | SWT.FULL_SELECTION | toolkit.getBorderStyle());
        final GridData gridData_292 = new GridData(SWT.FILL, SWT.FILL, true, true);
        gridData_29.widthHint = 300;

        // to keep to avoid big table
        wellDiffuseFractureTable.setLayoutData(gridData_292);
        wellDiffuseFractureTable.setHeaderVisible(true);

        final TableColumn tableColumn_002 = new TableColumn(wellDiffuseFractureTable, SWT.RIGHT);
        // tableColumn_0.setWidth(88);
        tableColumn_002.setText(" Well ");
        tableColumn_002.pack();

        // warning: if column order is changed, update static fields
        final TableColumn tableColumn_02 = new TableColumn(wellDiffuseFractureTable, SWT.RIGHT);
        // tableColumn_0.setWidth(88);
        tableColumn_02.setText(" Diffuse set Name ");
        tableColumn_02.pack();

        final TableColumn tableColumn_12 = new TableColumn(wellDiffuseFractureTable, SWT.NONE);
        // tableColumn_1.setWidth(45);
        tableColumn_12.setText("Number of samples");
        tableColumn_12.pack();

        final TableColumn tableColumn_22 = new TableColumn(wellDiffuseFractureTable, SWT.NONE);
        // tableColumn_2.setWidth(70);
        tableColumn_22.setText("Mean Strike (...)");
        tableColumn_22.pack();

        final TableColumn tableColumn_32 = new TableColumn(wellDiffuseFractureTable, SWT.NONE);
        // tableColumn_3.setWidth(60);
        tableColumn_32.setText("Mean Dip (...)");
        tableColumn_32.pack();

        TableColumn wellDiffuseFractureTableMeanDensityColumn = new TableColumn(
                wellDiffuseFractureTable, SWT.NONE);
        // tableColumn_4.setWidth(95);
        wellDiffuseFractureTableMeanDensityColumn.setText("Mean Density (...)");
        wellDiffuseFractureTableMeanDensityColumn.pack();

        // Section Well clusters
        Section wellCluster = new Section(body_sf1, ExpandableComposite.TWISTIE
                | ExpandableComposite.EXPANDED | ExpandableComposite.TITLE_BAR);
        wellCluster.setLayoutData(new GridData(GridData.FILL, GridData.BEGINNING, true, false));
        wellCluster.setText("Well clusters");
        final Composite compositeWellCluster = toolkit.createComposite(wellCluster, SWT.NONE);
        final GridLayout gridLayout_3333 = new GridLayout();
        gridLayout_3333.marginWidth = 0;
        compositeWellCluster.setLayout(gridLayout_3333);
        wellCluster.setClient(compositeWellCluster);

        Table wellClusterstable = toolkit.createTable(compositeWellCluster, SWT.MULTI
                | SWT.FULL_SELECTION | toolkit.getBorderStyle());
        final GridData gridData_293 = new GridData(SWT.FILL, SWT.FILL, true, true);
        // gridData_293.widthHint = 300;

        // to keep to avoid big table
        wellClusterstable.setLayoutData(gridData_29);
        wellClusterstable.setHeaderVisible(true);

        final TableColumn tableColumn_003 = new TableColumn(wellClusterstable, SWT.RIGHT);
        // tableColumn_0.setWidth(88);
        tableColumn_003.setText(" Well ");
        tableColumn_003.pack();

        // warning: if column order is changed, update static fields
        final TableColumn tableColumn_03 = new TableColumn(wellClusterstable, SWT.RIGHT);
        // tableColumn_0.setWidth(88);
        tableColumn_03.setText(" Cluster ID ");
        tableColumn_03.pack();

        final TableColumn tableColumn_13 = new TableColumn(wellClusterstable, SWT.NONE);
        // tableColumn_1.setWidth(45);
        tableColumn_13.setText(" Top (...)");
        tableColumn_13.pack();

        String angleLabel3 = "...";

        final TableColumn tableColumn_23 = new TableColumn(wellClusterstable, SWT.NONE);
        // tableColumn_2.setWidth(70);
        tableColumn_23.setText("Bottom (...)");
        tableColumn_23.pack();

        final TableColumn tableColumn_33 = new TableColumn(wellClusterstable, SWT.NONE);
        // tableColumn_3.setWidth(60);
        tableColumn_33.setText("Apparent width (...)");
        tableColumn_33.pack();

        String densityLabel3 = "...";
        final TableColumn tableColumn_43 = new TableColumn(wellClusterstable, SWT.NONE);
        // tableColumn_4.setWidth(95);
        tableColumn_43.setText("Number of samples");
        tableColumn_43.pack();

        final TableColumn tableColumn_53 = new TableColumn(wellClusterstable, SWT.NONE);
        // tableColumn_5.setWidth(95);
        tableColumn_53.setText("Mean strike (" + angleLabel3 + ")");
        tableColumn_53.pack();

        final TableColumn tableColumn_mean3 = new TableColumn(wellClusterstable, SWT.NONE);
        tableColumn_mean3.setWidth(0);
        tableColumn_mean3.setResizable(false);
        tableColumn_mean3.setText("Mean dip (" + angleLabel3 + ")");

        TableColumn wellClustersTableMeanDensityColumn = new TableColumn(wellClusterstable,
                SWT.NONE);
        wellClustersTableMeanDensityColumn.setWidth(0);
        wellClustersTableMeanDensityColumn.setResizable(false);
        wellClustersTableMeanDensityColumn.setText("Mean density (" + densityLabel3 + ")");

        for (int i = 0; i < 2; i++) {
            TableItem toto = new TableItem(globalTable, SWT.NONE);
            toto.setText(new String[] { "i", String.valueOf(i) });
        }
        for (int i = 0; i < 20; i++) {
            TableItem toto = new TableItem(wellDiffuseFractureTable, SWT.NONE);
            toto.setText(new String[] { "well", String.valueOf(i) });
        }
        for (int i = 0; i < 5; i++) {
            TableItem toto = new TableItem(wellClusterstable, SWT.NONE);
            toto.setText(new String[] { "cluster", String.valueOf(i) });
        }
        scrolledForm_1.reflow(true);

        // shell.pack();
        shell.open();
        toolkit.dispose();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

    }
}
