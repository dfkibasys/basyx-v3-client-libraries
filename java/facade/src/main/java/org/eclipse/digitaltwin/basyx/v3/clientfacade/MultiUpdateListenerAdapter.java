/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/
package org.eclipse.digitaltwin.basyx.v3.clientfacade;

import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.digitaltwin.aas4j.v3.model.AssetAdministrationShell;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;

public class MultiUpdateListenerAdapter implements BasyxUpdateListener {

	private final CopyOnWriteArrayList<BasyxUpdateListener> listeners;
	
	
	public MultiUpdateListenerAdapter(BasyxUpdateListener... listeners) {
		this.listeners = new CopyOnWriteArrayList<>(listeners);
	}

	@Override
	public void onDeleteShell(AssetAdministrationShell eachShell) {
		listeners.forEach(l->l.onDeleteShell(eachShell));
	}

	@Override
	public void onDeleteSubmodel(String id) {
		listeners.forEach(l->l.onDeleteSubmodel(id));
	}

	@Override
	public void onPostShell(AssetAdministrationShell shell) {
		listeners.forEach(l->l.onPostShell(shell));
	}

	@Override
	public void onUpdateShell(AssetAdministrationShell shell) {
		listeners.forEach(l->l.onUpdateShell(shell));
	}

	@Override
	public void onPostSubmodel(Submodel submodel) {
		listeners.forEach(l->l.onPostSubmodel(submodel));
	}

	@Override
	public void onUpdateSubmodel(Submodel submodel) {
		listeners.forEach(l->l.onUpdateSubmodel(submodel));
	}
}