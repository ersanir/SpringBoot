package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;




@CrossOrigin
@RestController

public class MyController {
	
	
	@RequestMapping(path = "/all")
    public String filterAll() throws IOException, JSONException
    {	InputStream is = new URL("https://www.healthcare.gov/api/glossary.json").openStream();

		try {
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			  String jsonText = "";
			  String input="";
					  while((input = rd.readLine()) != null)
					  {
					    jsonText = jsonText + input;
					  }
		  //    JSONObject json = new JSONObject(jsonText);
		      
		      return jsonText;
		}finally {
			is.close();
		}
    }


	@RequestMapping(path = "/es")
    public String filterSpanish() throws IOException, JSONException
    {	InputStream is = new URL("https://www.healthcare.gov/api/glossary.json").openStream();

		try {
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			  String jsonText = "";
			  String input="";
					  while((input = rd.readLine()) != null)
					  {
					    jsonText = jsonText + input;
					  }
		  //    JSONObject json = new JSONObject(jsonText);
		      System.out.println(new JSONObject(jsonText));
		      
		      JSONObject obj = new JSONObject(jsonText);
		      JSONArray arr = obj.getJSONArray("glossary");
		      
		      JSONArray spanish = new JSONArray();
		      JSONObject spanishobject = new JSONObject();
		      
		      for (int i = 0; i < arr.length(); i++)
		      {
		          String lang = arr.getJSONObject(i).getString("lang");
		          if("es".equals(lang)) {
		        	  spanish.put(arr.getJSONObject(i));
		        	  
		          }
		          
		      }
		      
		      spanishobject.put("glossary", spanish);
		      
		      return (spanishobject.toString());
		}finally {
			is.close();
		}
    }
	
	@RequestMapping(path = "/en")
    public String filterEnglish() throws IOException, JSONException
    {	InputStream is = new URL("https://www.healthcare.gov/api/glossary.json").openStream();

		try {
			  BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			  String jsonText = "";
			  String input="";
					  while((input = rd.readLine()) != null)
					  {
					    jsonText = jsonText + input;
					  }
		  //    JSONObject json = new JSONObject(jsonText);
		      System.out.println(new JSONObject(jsonText));
		      
		      JSONObject obj = new JSONObject(jsonText);
		      JSONArray arr = obj.getJSONArray("glossary");
		      
		      JSONArray english = new JSONArray();
		      JSONObject englishobject = new JSONObject();
		      
		      for (int i = 0; i < arr.length(); i++)
		      {
		          String lang = arr.getJSONObject(i).getString("lang");
		          if("en".equals(lang)) {
		        	  english.put(arr.getJSONObject(i));
		        	  
		          }
		          
		      }
		      
		      englishobject.put("glossary", english);
		      
		      return (englishobject.toString());
		}finally {
			is.close();
		}
    }
}

