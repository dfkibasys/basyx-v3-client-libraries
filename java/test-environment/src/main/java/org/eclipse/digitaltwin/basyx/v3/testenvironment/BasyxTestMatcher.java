package org.eclipse.digitaltwin.basyx.v3.testenvironment;

import java.util.Iterator;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BasyxTestMatcher {

	private final ObjectMapper mapper;

	public BasyxTestMatcher(ObjectMapper mapper) {
		this.mapper = mapper;
	}

	public void assertEquals(String msg, Object expected, Object actual) {
		String errorMsg = compareJsonNodes(mapper.valueToTree(expected), mapper.valueToTree(actual), "");
		if (!errorMsg.isEmpty()) {
			Assert.fail(msg + errorMsg);
		}
	}

	private String compareJsonNodes(JsonNode node1, JsonNode node2, String path) {
		if (node1 == null || node2 == null) {
			if (node1 == null && node2 == null) {
				return "";
			} else {
				return String.format("Mismatch at %s: one node is null, the other is not", path);
			}
		}

		if (node1.isObject() && node2.isObject()) {
			Iterator<String> fieldNames = node1.fieldNames();
			while (fieldNames.hasNext()) {
				String fieldName = fieldNames.next();
				JsonNode value1 = node1.get(fieldName);
				JsonNode value2 = node2.get(fieldName);
				String newPath = path.isEmpty() ? fieldName : path + "/" + fieldName;
				String result = compareJsonNodes(value1, value2, newPath);
				if (!result.isEmpty()) {
					return result;
				}
			}
			return "";
		}  else if (node1.isArray() && node2.isArray()) {
            if (node1.size() != node2.size()) {
                return String.format("Mismatch at %s: array sizes differ (%d vs %d)", path, node1.size(), node2.size());
            }
            for (int i = 0; i < node1.size(); i++) {
                String newPath = path + "[" + i + "]";
                String result = compareJsonNodes(node1.get(i), node2.get(i), newPath);
                if (!result.isEmpty()) {
                    return result;
                }
            }
            return "";
			
		} else if (node1.isTextual() && node2.isTextual()) {
			if (!customStringCompare(node1.asText(), node2.asText())) {
				return String.format("Mismatch at %s: '%s' != '%s'", path, node1.asText(), node2.asText());
			}
			return "";
		} else {
			if (!node1.equals(node2)) {
				return String.format("Mismatch at %s: '%s' != '%s'", path, node1.toString(), node2.toString());
			}
			return "";
		}
	}

	protected boolean customStringCompare(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}
		if (str1.startsWith("$REGEX(")) {
			String value = str1.substring(7, str1.length() - 1);
			return Pattern.matches(value, str2);
		}
		return str1.equals(str2);
	}

}
