package com.dudutou;

import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

public class TestTimeout {
	
	@Test
    public void testName() throws Exception {
		Client client = Client.create();
	    client.setConnectTimeout(0);
	    client.setReadTimeout(0);
	    
	    WebResource webResource = client.resource("http://localhost:8080/test-servlet/HelloWorld?name=miwa");
	    System.out.println("webResource: " + webResource.getURI());
	    
	    String response = webResource.get(String.class);
	    System.out.println("response: " + response);
	    
	    System.out.println("test timeout");
	    
    }

}
