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
package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public class SubmodelElementElementResolver extends SubmodelElementVisitor {

	private SubmodelElement found;
	private final String[] toMatch;
	private int index = -1;

	public SubmodelElementElementResolver(String path) {
		toMatch = path.split("\\.");
	}

	@Override
	public void startCollection() {
		index++;
	}

	@Override
	public void endCollection() {
		index--;
	}
	
	@Override
	public ProcessInstruction startElement(SubmodelElement elem) {
		if (index >= toMatch.length) {
			return ProcessInstruction.SKIP;
		}
		String idShort = elem.getIdShort();
		if (Objects.equals(idShort, toMatch[index])) {
			if (index + 1 >= toMatch.length) {
				this.found = elem;
				return ProcessInstruction.STOP;
			}
			return ProcessInstruction.CONTINUE;
		}
		return ProcessInstruction.SKIP;
	}

	public Optional<SubmodelElement> result() {
		return Optional.ofNullable(found);
	}
}