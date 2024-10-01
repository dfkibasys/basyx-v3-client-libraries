package org.eclipse.digitaltwin.basyx.v3.testenvironment;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ClasspathResources {
	
	private ClasspathResources() {
		
	}
	
	public static byte[] readFromResource(String name) throws IOException {
		ByteArrayOutputStream bOut = new ByteArrayOutputStream();
		try (InputStream in = ClasspathResources.class.getResourceAsStream(name);) {
			byte[] buffer = new byte[256];
			for (int len = -1; (len = in.read(buffer)) != -1;) {
				bOut.write(buffer, 0, len);
			}
		}
		return bOut.toByteArray();
	}
}
