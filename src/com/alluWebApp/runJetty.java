package org.eclipse.jetty.embedded;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class runJetty extends AbstractHandler
{
    @Override
    public void handle( String target,
                        Request baseRequest,
                        HttpServletRequest request,
                        HttpServletResponse response ) throws IOException,
            ServletException
    {
        // Declare response encoding and types
        response.setContentType("text/html; charset=utf-8");

        // Declare response status code
        response.setStatus(HttpServletResponse.SC_OK);

        // Write back response
        response.getWriter().println("<!DOCTYPE html>");
        response.getWriter().println("<html>");
        response.getWriter().println("<body>");
        response.getWriter().println("<input type='text' id='myText' value='Type name here'>");
        response.getWriter().println("<button onclick='myFunction()'>Search</button>");
        response.getWriter().println("<p id=\"demo\"></p>");
        response.getWriter().println("<script>");
        response.getWriter().println("function myFunction() {");
        response.getWriter().println("var x = document.getElementById(\"myText\").value;");
        response.getWriter().println("document.getElementById(\"demo\").innerHTML = x;");
        response.getWriter().println("}");
        response.getWriter().println("/<script>");
        response.getWriter().println("/<body>");
        response.getWriter().println("/<html>");

        // Inform jetty that this request has now been handled
        baseRequest.setHandled(true);
    }

    public static void main( String[] args ) throws Exception
    {
        Server server = new Server(8081);
        server.setHandler(new runJetty());

        server.start();
        server.join();
    }
}