package org.eclipse.digitaltwin.basyx.v3.clientfacade.main;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class BasyxTest {

	private BasyxTest() {
		
	}
	
	
	public static BasyxTest initialize(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	public <T> void runAndAssert(Consumer<T> consumer) {
		// TODO Auto-generated method stub
		
	}
	

	public <T> void runAndAssert(Supplier<T> consumer) {
		// TODO Auto-generated method stub
		
	}
	
	public <I,R> void runAndAssert(Function<I,R> func) {
			
	}


	public <T,U,R> void runAndAssert(BiConsumer<T,U> consumer) {
		
	}
	
	public <T,U,R> void runAndAssert(BiFunction<T,U,R> func) {
	
	}
	
	public <T,U,V,R> void runAndAssert(TriFunction<T,U,V,R> func) {
		
	}


	@FunctionalInterface
	public static interface TriFunction<T,U,V,R> {
		
		R apply(T t, U u, V v);
		
	}
}