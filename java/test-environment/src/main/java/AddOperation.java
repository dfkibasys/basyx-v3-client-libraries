import org.eclipse.digitaltwin.aas4j.v3.model.DataTypeDefXsd;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationVariable;
import org.eclipse.digitaltwin.aas4j.v3.model.Property;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultOperationVariable;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProperty;

public class AddOperation {

	public OperationVariable[] invoke(OperationVariable[] in) {
		Property prop0 = (Property) in[0].getValue();
		Property prop1 = (Property) in[1].getValue();
		int sum = Integer.parseInt(prop0.getValue()) + Integer.parseInt(prop1.getValue());
		Property sumProp = new DefaultProperty.Builder().value("" + sum).valueType(DataTypeDefXsd.INT).build();
		return new OperationVariable[] { new DefaultOperationVariable.Builder().value(sumProp).build() };
	}
}
