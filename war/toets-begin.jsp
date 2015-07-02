<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
 if (session.getAttribute("student") == null) {
%>
<jsp:forward page="login-student.jsp" />
<%
 }
%>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Toets begin</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" id="toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
		    </div>
	      </div>
	    </nav>	
		<div class="container" id="content">
			<div class="row">
				<h2>Welkom bij Justianmind</h2>
				<br />
			</div>
			<div class="row">
				<div class="col-md-12">
					<p><b>De toets bestaat uit 60 vragen.</b></p>
					<br />
					<p>Je mag je antwoorden uitwerken op een kladblad.</p>
					<p>Rekenmachine wordt gegeven wanneer deze gebruikt mag worden.</p>
					<p>Bij het invullen van een negatief getal, een breuk of een groot getal moet je dat op de volgende manier doen.</p>
					<br/>
				</div>
			</div>
			<div class="row">
				<div class="col-md-5">
					<table class="table">
						<tr>
							<th>Negatief getal</th>
							<th>Geen punt voor duizentallen</th>
							<th>Breuk</th>
						</tr>
						<tr>
							<td>-3,5</td>
							<td>32342,45</td>
							<td>1/8</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<p><b>Let op!</b> Bekijk je antwoord goed voordat je op volgende drukt, want je kan niet terug naar de vorige vraag.</p>
					<br/>
				</div>
			</div>
			<div class="row">
				<form id="studentInlog" action="toets-vraag.jsp" method="get">
					<div class="col-md-2">
						<button class="btn btn-default" type="submit" name="button" value="start">Start toets</button>
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