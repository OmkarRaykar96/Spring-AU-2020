package com.example.demo;

import java.util.*;
import javax.ws.rs.*;
import javax.websocket.server.PathParam;

@Path("/apis")
public class Employee {
	
	static HashMap<String,String> text=new HashMap<>();
	
	@GET
	@Produces("application/json")
	@Path("/display")
	public String getAllText() {
		String str="";
		
		for (String url : text.values())
            str+=url+" ";
	
		return str;
	}
	
	@POST
	@Produces("application/json")
	public String[] PostText(){
		String[] arr= {"Post","is","Working"};
		return arr;
	}
	
	@DELETE
	@Produces("application/json")
	@Path("/delete/{textContent}")
	public String deleteUser(@PathParam("textContent") String textContent){
		if(text.get(textContent)!= null) {
			text.remove(textContent);
			return "Text Removed Successfully!!!";
		}
		else {
			return "Text not in basket!!!";
		}
	}
	
	
	@PUT
	@Produces("application/json")
	@Path("/add/{textContent}")
	public String putUser(@PathParam("textContent") String textContent){
		if(text.get(textContent)!=null) {
			return "Text Already Exists!";
		}
		else {
			text.put(textContent,textContent);
			return "Text Added Sucessfully!!!";
		}
	}
}