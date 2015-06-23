<%@ page import="java.util.*" %>
<%@ page import="domein.Vraag" %>
<%@ page import="DAO.VraagDAO" %>
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
		<title>Vragen Overzicht</title>
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
	     		<li class="dropdown toggle">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Vragenbeheer<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li class="disabled"><a href="#">Overzicht</a></li>
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
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Studenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="student-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="studentcode-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
	          </ul>
	        </div>
	      </div>
	    </nav>	   
		<div class='container' id="content">
			<div class="row">
				<h3>Vragen Overzicht</h3>
			</div>
			<div class="row">
				<div class="col-md-1">
					<form class="form-group">
						<div class="row">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="context" checked>Context
								</label>
							</div>
							<div class="checkbox">
								<label>
									<input type="checkbox" name="non-context" checked>Non-Context
								</label>
							</div>
						</div>
						<div class="row">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="meet" checked>Meetkunde
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="getal" checked>Getallen
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="verhoud" checked>Verhoudingen
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="verband" checked>Verbanden
								</label>
							</div>							
						</div>
					</form>
				</div>
				<div class="col-md-10 col-md-offset-1">
					<div class="tablecontent">
						<table class="table table-striped">
							<tr>
								<th>Vraag Nummer</th><th>Categorie</th><th>Rekenmachine</th><th>Afbeelding</th>
								<th>Context</th><th>Opgave</th><th>Antwoord</th>
								<th></th>
							</tr>
							<%! ArrayList<Vraag> al = new ArrayList<Vraag>(); %>
							<%	al = VraagDAO.alleVragen();
								for(int i=0; i<al.size(); i++){
								Vraag v = al.get(i);%>
							<tr>
								<th><%= v.getNummer()%></th><td><%= v.getType()%></td><td><%= v.isRekenmachine()%></td>
								<td><%= v.heeftAfbeelding()%></td>
								<td><%= v.heeftContext()%></td>
								<td><%= v.getVraagstelling()%></td><td><%= v.getAntwoord()%></td>
								<td>
									<form action="vragen-overzicht.do">
										<input type="hidden" name="vraagnummer" value="<%= v.getNummer() %>">
										<input class="btn btn-default" type="submit" value="Bekijk">
									</form>
								</td>
							</tr>
							<% } %>
						</table>
					</div>
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