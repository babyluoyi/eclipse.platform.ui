/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.ui.tests.decorators;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.TableViewer;

import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

/**
 * The DecoratorTableView is a view that tests the decorator
 * support for tables.
 */
public class DecoratorTableView extends ViewPart {
	
	TableViewer viewer;

	/**
	 * Create a new instance of the receiver.
	 */
	public DecoratorTableView() {
		super();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	public void createPartControl(Composite parent) {
		viewer = new TableViewer(parent);

		viewer.setLabelProvider(new DecoratingLabelProvider(new TestLabelProvider(), PlatformUI
				.getWorkbench().getDecoratorManager()));

		viewer.setContentProvider(new TestTableContentProvider());
		viewer.setInput(this);

		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL
				| GridData.FILL_BOTH);
		
		viewer.getControl().setLayoutData(data);

	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPart#setFocus()
	 */
	public void setFocus() {
		// XXX Auto-generated method stub

	}

}
