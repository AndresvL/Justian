<%@page import="javax.mail.Session"%>
<%@ page import="java.util.*" %>
<%@ page import="DAO.ToetsDAO" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
 if (session.getAttribute("docent") == null) {
%>
<jsp:forward page="login-docent.jsp" />
<%
 }
%>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Studenten Overzicht</title>
		<script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="/js/bootstrap.min.js"></script>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
		    </div>
	        <div id="navbar" class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="docent-dash.jsp">Home</a></li>
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Vragenbeheer<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="vraag-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="vraag-aanmaken.jsp">Aanmaken</a></li>
			            <li><a href="vraag-uploaden.jsp">Uploaden</a></li>
		   			</ul>
		        </li>
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Docenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="docent-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="docent-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
	     		<li class="dropdown toggle">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Studenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="student-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="studentcode-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
		        <li><a href="login-docent.jsp">Log Uit</a></li>
	          </ul>
	        </div>
	      </div>
	    </nav>	     
		<div class='container' id="content">
			<div class="row">
				<h3>Student Details</h3>
			</div>
			<div class="row">
				<div class="col-md-3">
					<div class="row">
						<div class="col-md-10">
							<label>Student Nummer:</label>
						</div>
						<div class="col-md-2">
							<p>${studentnummer}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-10">
							<label>Is blijven zitten:</label>
						</div>
						<div class="col-md-2">
							<p>${wannBlijvenZitten}</p>
						</div>
					</div>
					<div class="row">
						<div class="col-md-10">
							<label>Gem WiskundeCijfer:</label>
						</div>
						<div class="col-md-2">
							<p>${gemWiskundeCijfer}</p>
						</div>
					</div>
				</div>
				<div class="col-md-8 col-md-offset-1">
					<div class="tablecontent">
						<table class="table table-striped">
							<tr>
								<th>Toetsnummer</th>
								<th></th>
							</tr>
							<%! ArrayList<Integer> al = new ArrayList<Integer>(); %>
							<% String x = session.getAttribute("studentnummer").toString();%>
							<%	al = ToetsDAO.getAlleToetsNummers(x);
								for(int i=0; i<al.size(); i++){
								int s = al.get(i);%>
							<tr>
								<th><%= s %></th>								
								<td>
									<form action="exporteer.zip">
										<input type="hidden" name="stuNr" value="${studentnummer}">
										<input type="hidden" name="toetsNr" value="<%= s %>">
								    	<input class="btn btn-default vol" type="submit" value="Exporteer">
								    </form>
								</td>
							</tr>
							<% } %>
						</table>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3">
					<a href="student-overzicht.jsp"><button class="btn btn-danger half">Terug</button></a>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>© Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>