package com.example.controllers;

/**
 * Purpose: Handles HTTP exceptions
 *
 * @author Dave Noga
 * @version 1.0 8/01/16
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppExceptionHandler")
public class HTTPErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processError(request, response);
	}

	private void processError(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Analyze the servlet exception
		Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}

		// Set response content type
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		out.write("<link href ='resources/webjars/bootstrap/css/bootstrap.css' rel='stylesheet'>");

		out.write("<script src='resources/webjars/js/jquery-1.11.3.js'></script>");
		out.write("<script src='resources/webjars/bootstrap/js/bootstrap.js'></script>");
		//Message for 404 error
		if (statusCode == 404) {
			out.write("<div class='hero-unit'>");
			out.write("<div class='alert alert-block alert-error'>");
			out.write("<center>");
			out.write("<h2>Page does not exist!</h2>");
			out.write("</center>");
			out.write("</div>");
			out.write("</div>");
		}

		out.write("<html><head><title>Exception/Error Details</title></head><body>");
		//Message for 500 error
		if (statusCode != 500) {
			out.write("<center>");
			out.write("<h3>Error Details</h3>");
			out.write("<strong>Status Code</strong>:" + statusCode + "<br>");
			out.write("<strong>Requested URI</strong>:" + requestUri);
			out.write("</center>");

		} else {		//Non-specified exception
			out.write("<center>");
			out.write("<h3>Exception Details</h3>");
			out.write("<ul><li>Servlet Name:" + servletName + "</li>");
			out.write("<li>Exception Name:" + throwable.getClass().getName() + "</li>");
			out.write("<li>Requested URI:" + requestUri + "</li>");
			out.write("<li>Exception Message:" + throwable.getMessage() + "</li>");
			out.write("</ul>");
			out.write("</center>");
		}

		out.write("<br><br>");
		out.write("<center>");
		out.write("<a href='/JavaServer'>Home</a>");
		out.write("</center>");
		out.write("</body></html>");
	}

}
