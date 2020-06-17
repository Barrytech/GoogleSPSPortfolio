// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import java.io.PrintWriter;
 


/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
   
    private ArrayList<String> facts;
    public void init() {
        facts = new ArrayList<String>();

      facts.add(" I was born and raised in Guinea, West-Africa.");
      facts.add(" I have never had McDonal's.");
      facts.add(" I will probably graduate in my junior year.");
    }




     
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // response.setContentType("text/html;");
    // response.getWriter().println("<h1>Hello Barry!</h1>");

    response.setContentType("application/json");
  
    //   ArrayList<String> facts = new ArrayList<String>();
    //   facts.add(" I was born and raised in Guinea, West-Africa.");
    //   facts.add(" I have never had McDonal's.");
    //   facts.add(" I will probably graduate in my junior year.");

    Gson gson = new Gson();

 String json = gson.toJson(facts);
 response.getWriter().println(json);

}

 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
      // read form fields
        String firstname = request.getParameter("first-name-field");
        String lastname = request.getParameter("last-name-field");
        String email = request.getParameter("email-field");
        String comments = request.getParameter("feedback");
         
        System.out.println("First name: " + firstname);
        System.out.println("Last name: " + lastname);
        System.out.println("Email: " + email);
        System.out.println("Comments: " + comments);
 
        // do some processing here...
         
        // get response writer
        PrintWriter writer = response.getWriter();
         
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2> First-Name is: " + firstname + "<br/>";      
        htmlRespone += " Last Name is: " + lastname + "<br/>";
        htmlRespone += " Email address is: " + lastname + "<br/>";
        htmlRespone += " Comment is: " + lastname + "<h2>"; 
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);

 }

//       System.out.println(" inside doPost");
//     // Get the input from the form.
//     String text = getParameter(request, "text-input", "");
//     boolean upperCase = Boolean.parseBoolean(getParameter(request, "upper-case", "false"));
//     boolean sort = Boolean.parseBoolean(getParameter(request, "sort", "false"));

//     // Convert the text to upper case.
//     if (upperCase) {
//       text = text.toUpperCase();
//     }

//     // Break the text into individual words.
//     String[] words = text.split("\\s*,\\s*");

//     // Sort the words.
//     if (sort) {
//       Arrays.sort(words);
//     }

//     // Respond with the result.
//     response.setContentType("text/html;");
//     response.getWriter().println(Arrays.toString(words));
//   }
//    private String getParameter(HttpServletRequest request, String name, String defaultValue) {
//     String value = request.getParameter(name);
//     if (value == null) {
//       return defaultValue;
//     }
//     return value;
 
}

