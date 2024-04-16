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