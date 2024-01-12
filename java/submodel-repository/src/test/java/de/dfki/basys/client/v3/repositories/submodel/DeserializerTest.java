package de.dfki.basys.client.v3.repositories.submodel;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

import de.dfki.basys.clients.v3.JSON;
import de.dfki.basys.clients.v3.metamodel.part2.GetSubmodelElementsResult;

public class DeserializerTest {

	@Test
	public void testSubmodelElement() throws IOException   {
		try (InputStream in = getClass().getResourceAsStream("/GetSubmodelElementsResult.json");
				BufferedInputStream bIn = new BufferedInputStream(in)) {
			JSON.getDefault().getMapper().readValue(bIn, GetSubmodelElementsResult.class);
		}
	}
	
}
