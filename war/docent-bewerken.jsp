<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
 if (session.getAttribute("beheerder") == null) {
%>
<jsp:forward page="login-docent.jsp" />
<%
 }
%>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Docent Bewerken</title>
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
	     		<li class="dropdown toggle">
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
		        <li><a href="login-docent.jsp">Log Uit</a></li>
	          </ul>
	        </div>
	      </div>
	    </nav>	  
		<div class='container' id="content">
			<div class="col-md-7">
				<h3>Docent bewerken</h3>
				<form action="docent-bewerken.do">
					<div class="row">
						<div class="col-md-6">
							<div id="msgs">
								<% 
								Object msgs = request.getAttribute("msgs"); 
								if (msgs != null) { 	 
									out.println(msgs); 
									out.println(); 		
								}	%>
							</div>
						</div>
					</div>
					<div class="row form-group">
						<div class="col-md-3">
							<label>Voornaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="voornaam" required value="${voornaam}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Achternaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="achternaam" required  value="${achternaam}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Email</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="email" name="email" required  value="${email}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Wachtwoord</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="password" name="wachtwoord" required  value="${wachtwoord}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Bevestig wachtwoord</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="password" name="wwbevestiging" required>
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Schoolnaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="schoolnaam" required  value="${schoolnaam}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Schoolplaats</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="schoolplaats" required  value="${schoolplaats}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3 col-md-offset-3">
							<a href="docent-overzicht.jsp" class="btn btn-danger vol">Annuleren</a>
						</div>
						<div class="col-md-3">
							<button class="btn btn-default vol" type="submit" name="next" value="next">Verder</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>© Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>