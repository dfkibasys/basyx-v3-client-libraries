package org.eclipse.digitaltwin.basyx.v3.clientfacade.util;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.dataformat.core.util.AasUtils;
import org.eclipse.digitaltwin.aas4j.v3.model.Identifiable;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;

public class BasyxIterables {

	private BasyxIterables() {		
	}
	
	public static <I, T extends Identifiable> BasyxIterable<T> getMappingIterable(Iterator<I> input, Function<I, Optional<T>> mapper) {
		return new MappingBasyxIterable<>(input, mapper);
	}
	
	public static BasyxIterable<String> getPathIterable(Submodel sm) {
		return new SubmodelElementsIterable<String>(sm, BasyxIterables::getPath);
	}
	
	private static String getPath(String path, Submodel parent, SubmodelElement sme) {
		return path;
	}
	
	public static BasyxIterable<SubmodelElement> getSubmodelElementsIterable(Submodel sm) {
		return new SubmodelElementsIterable<SubmodelElement>(sm, BasyxIterables::getSubmodel);
	}
	
	private static SubmodelElement getSubmodel(String path, Submodel parent, SubmodelElement sme) {
		return sme;
	}
	
	public static BasyxIterable<Reference> getReferenceIterable(Submodel sm) {
		return new SubmodelElementsIterable<Reference>(sm, BasyxIterables::getReference);
	}
	
	private static Reference getReference(String path, Submodel parent, SubmodelElement sme) {
		Reference parentRef = AasUtils.toReference(parent);
		return AasUtils.toReference(parentRef, sme);
	}
	
	public static <T> BasyxCollectionIterable<T> empty() {
		return new BasyxCollectionIterable<T>(List.of());
	}
	
	public static <T> BasyxCollectionIterable<T> of(List<T> list) {
		return new BasyxCollectionIterable<T>(list);
	}
	
	public static <C, T> BasyxIterable<T> fetchingIterable(ResultResolver<C, T> resolver) {
		return new FetchingBasyxIterable<C, T>(resolver);
	}
}