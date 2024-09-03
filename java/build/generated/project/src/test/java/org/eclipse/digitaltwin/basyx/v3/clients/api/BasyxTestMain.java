package org.eclipse.digitaltwin.basyx.v3.clients.api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.digitaltwin.aas4j.v3.model.DataTypeDefXsd;
import org.eclipse.digitaltwin.aas4j.v3.model.Key;
import org.eclipse.digitaltwin.aas4j.v3.model.KeyTypes;
import org.eclipse.digitaltwin.aas4j.v3.model.LangStringNameType;
import org.eclipse.digitaltwin.aas4j.v3.model.LangStringTextType;
import org.eclipse.digitaltwin.aas4j.v3.model.ModellingKind;
import org.eclipse.digitaltwin.aas4j.v3.model.Operation;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationVariable;
import org.eclipse.digitaltwin.aas4j.v3.model.Property;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.aas4j.v3.model.SpecificAssetId;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElementCollection;
import org.eclipse.digitaltwin.aas4j.v3.model.builder.OperationBuilder;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultKey;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultLangStringNameType;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultLangStringTextType;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultOperation;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultOperationVariable;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProperty;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultReference;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSpecificAssetId;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodel;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodelElementCollection;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.collect.Lists;

public class BasyxTestMain {

	
	public static void main(String[] args) throws JsonProcessingException {
		AssetAdministrationShellBasicDiscoveryApi api = new AssetAdministrationShellBasicDiscoveryApi("http://localhost:8091");
		System.out.println(JSON.getDefault().getMapper().writeValueAsString(api.getDescription()));

//		SpecificAssetId globalAssetId1 = new DefaultSpecificAssetId.Builder().name("type").value("heizung").build();
//		api.postAllAssetLinksById("http://www.aas.org/aasid/11111", List.of(globalAssetId1));
		System.out.println(JSON.getDefault().getMapper().writeValueAsString(api.getAllShellIdsByAssetLinks(null, null, null)));
//		SpecificAssetId globalAssetId2 = new DefaultSpecificAssetId.Builder().name("globalAssetId").value("org::aas::2").build();
//		api.postAllAssetLinksById("http://www.aas.org/aasid/2", List.of(globalAssetId2));
//		SpecificAssetId globalAssetId3 = new DefaultSpecificAssetId.Builder().name("globalAssetId").value("org::aas::3").build();
//		api.postAllAssetLinksById("http://www.aas.org/aasid/3", List.of(globalAssetId3));
//		
//		List<SpecificAssetId> ids = api.getAllAssetLinksById("http://www.aas.org/aasid/2");
//		System.out.println(ids);
		
		
		
//		Submodel sm = create();
//		System.out.println(JSON.getDefault().getMapper().writeValueAsString(sm));
	}
	
	public static Submodel create() {
		List<LangStringTextType> description = new ArrayList<LangStringTextType>();
		description.add(new DefaultLangStringTextType.Builder().language("de-DE")
				.text("Test")
				.build());
		List<LangStringNameType> displayName = new ArrayList<LangStringNameType>();
		displayName.add(new DefaultLangStringNameType.Builder().language("de-DE")
				.text("Test")
				.build());
		List<Key> refKeys = new ArrayList<Key>();
		refKeys.add(new DefaultKey.Builder().value("123")
				.build());

		SubmodelElement sme1 = new DefaultProperty.Builder()
				.value("123")
				.idShort("test")
				.build();
		Operation square = createInvokableOperation();
		List<SubmodelElement> smeList = Lists.newArrayList(sme1, square);

		Submodel submodel = new DefaultSubmodel.Builder().category("TestCategory")
				.description(description)
				.displayName(displayName)
				.id("Example")
				.idShort("example")
				.kind(ModellingKind.INSTANCE)
				.semanticId(new DefaultReference.Builder().keys(refKeys)
						.build())
				.submodelElements(smeList)
				.build();

		return submodel;
	}

	private static Operation createInvokableOperation() {
		return new InvokableOperation.Builder()
				.idShort("squareOperation")
				.inputVariables(createIntOperationVariable("input"))
				.outputVariables(createIntOperationVariable("result"))
				.invokable(BasyxTestMain::square)
				.build();
	}
	


	private static OperationVariable createOperationVariable(Property val) {
		return new DefaultOperationVariable.Builder().value(val).build();
	}

	private static DefaultOperationVariable createIntOperationVariable(String idShort) {
		return new DefaultOperationVariable.Builder().value(new DefaultProperty.Builder().idShort(idShort).valueType(DataTypeDefXsd.INT).build()).build();
	}
	
	private static OperationVariable[] square(OperationVariable[] inputs) {
		Property in = (Property) inputs[0].getValue();
		Integer val = Integer.valueOf(in.getValue());
		Integer squared = val * val;
		in.setValue(squared.toString());
		in.setIdShort("result");
		return new OperationVariable[] { createOperationVariable(in) };
	}
	
//	public static void doTest() {
//		SubmodelRepositoryApi smRepoApi = new SubmodelRepositoryApi("http://localhost:8081");
//		cleanupSubmodels(smRepoApi);
//		Submodel sm = newSubmodel();
//		putSubmodel(smRepoApi, sm);
//		Submodel resolved = smRepoApi.getSubmodelById(sm.getId(), null, null);
//		System.out.println(resolved.getIdShort());
//		resolved.setIdShort("_1_");
//		smRepoApi.putSubmodelById(resolved.getId(), resolved);
//		resolved = smRepoApi.getSubmodelById(sm.getId(), null, null);
//		System.out.println(resolved.getIdShort());
//		System.out.println(smRepoApi.getDescription());
//		
//		
//		Property prop = new DefaultProperty.Builder().idShort("Prop1").value("12").valueType(DataTypeDefXsd.INTEGER).build();
//		
//		System.out.println(JSON.getDefault().getMapper().writeValueAsString(prop));
//		
//		SubmodelElement elem = smRepoApi.postSubmodelElement(sm.getId(), prop);
//		System.out.println(elem instanceof Property);
//		System.out.println(elem.equals(prop));
//
//		
//	}

	private static Submodel newSubmodel() {
		SubmodelElementCollection col = new DefaultSubmodelElementCollection.Builder().idShort("col").build();
		return new DefaultSubmodel.Builder().id("http://sm.org/sm/1").idShort("1").submodelElements(List.of(col)).build();
	}

	private static void putSubmodel(SubmodelRepositoryApi smRepoApi, Submodel sm) throws JsonProcessingException {
		Submodel posted = smRepoApi.postSubmodel(sm);
		System.out.println("Posted " + posted.equals(sm)); 

		System.out.println(JSON.getDefault().getMapper().writeValueAsString(posted));
	}

	private static void cleanupSubmodels(SubmodelRepositoryApi smRepoApi) {

		GetSubmodelsResult gsResult = smRepoApi.getAllSubmodels(null, null, Integer.MAX_VALUE, null, null, null);
		List<Submodel> submodels = gsResult.getResult();
		System.out.println("Got " + submodels.size() + " submodels.");
		for (Submodel sm : submodels) {
			String id = sm.getId();
			System.out.println(id);
			smRepoApi.deleteSubmodel(id);
			System.out.println("Submodel " + id + " deleted!");
		}
	}
	
	/**
	 * Invokable variant of the DefaultOperation
	 * 
	 * @author schnicke
	 *
	 */
	public static class InvokableOperation extends DefaultOperation {
		private Function<OperationVariable[], OperationVariable[]> invokable;
		
		/**
		 * Invokes the operation with the passed arguments
		 * 
		 * @param arguments
		 * @return
		 */
		public OperationVariable[] invoke(OperationVariable[] arguments) {
			return invokable.apply(arguments);
		}

		/**
		 * Sets the function to call on operation invocation
		 * 
		 * @param invokable
		 */
		public void setInvokable(Function<OperationVariable[], OperationVariable[]> invokable) {
			this.invokable = invokable;
		}

		public static class Builder extends OperationBuilder<InvokableOperation, Builder> {

			@Override
			protected Builder getSelf() {
				return this;
			}

			@Override
			protected InvokableOperation newBuildingInstance() {
				return new InvokableOperation();
			}

			public Builder invokable(Function<OperationVariable[], OperationVariable[]> invokable) {
				getBuildingInstance().setInvokable(invokable);
				return getSelf();
			}
		}
	}
}
