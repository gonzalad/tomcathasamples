package org.gonzalad;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hello")
public class SampleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This is the Test Servlet");

        out.print("<br/>Principal: <em>" + request.getUserPrincipal());

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.print("<br/>Header Name: <em>" + headerName);
            String headerValue = request.getHeader(headerName);
            out.print("</em>, Header Value: <em>" + headerValue);
            out.println("</em>");
        }

        initializeSessionUUIAttribute(request);

        HttpSession session = request.getSession(false);
        if (session != null) {
            Enumeration attributeNames = session.getAttributeNames();
            while (attributeNames.hasMoreElements()) {
                String attributeName = (String) attributeNames.nextElement();
                out.print("<br/>Session Attribute Name: <em>" + attributeName);
                Object attributeValue = session.getAttribute(attributeName);
                out.print("</em>, Session Attribute Value: <em>" + attributeValue);
                out.println("</em>");
            }
        }
    }

    private void initializeSessionUUIAttribute(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("uuid") == null) {
            session.setAttribute("uuid", UUID.randomUUID().toString());
        }
    }

}