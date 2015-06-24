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
		<title>Vragen Bewerken</title>
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
		      <a class="navbar-brand" href="login-docent.jsp">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
		    </div>
	        <div id="navbar" class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="docent-dash.jsp">Home</a></li>
	     		<li class="dropdown toggle">
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
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Studenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="student-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="studentcode-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
		        <li><a href="logout-docent.do">Log Uit</a></li>
	          </ul>
	        </div>
	      </div>
	    </nav>
		<div class='container' id="content">
			<form class="form-group" action="vraag-bewerken.do">
				<div class="col-md-4">
					<div class="row">
						<h3>Opties</h3>
					</div>
					<div class="row">
						<input type="file" name="afbeelding" accept="image/*" value="${afbeelding}">
   		 				<p class="help-block">
							<img id="ilustratie" alt="ilustratie"
								src="data:image/gif;base64,${afbeelding}"></img>
						</p>
   		 				
					</div>
					<div class="row">
						<select class="form-control" name="categorie">
			                <option value="meet">Meetkunde</option>
			                <option value="verband">Verbanden</option>
			                <option value="getal">Getallen</option>
			                <option value="verhoud">Verhoudingen</option>
		            	</select>
					</div>
					<div class="row">
						<div class="checkbox">
							<label>
								<input type="checkbox" name="rekenmachine" value="true">Rekenmachine
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-7 col-md-offset-1">
					<h3>Vraag bewerken</h3>
					<div class="row form-group">
						<div class="col-md-2">
							<label>Context</label>
						</div>
						<div class="col-md-6">
							<textarea class="form-control" name="context" rows="3" autofocus >${context}</textarea>
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Opgave</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="opgave" value="${opgave}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord" required value="${antwoord}">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3 col-md-offset-2">
							<a href="vraag-overzicht.jsp" class="btn btn-danger vol">Terug</a>
						</div>
						<div class="col-md-3">
							<button class="btn btn-default vol" type="submit" name="next" value="next">Verder</button>
						</div>
					</div>
				</div>
			</form>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>© Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>
