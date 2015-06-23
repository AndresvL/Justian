<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%
 if (session.getAttribute("student") == null) {
%>
<jsp:forward page="login-docent.jsp" />
<%
 }
%>
<html>
	<head>
		<meta charset="utf-8 u00E0" />
		<title>Enquete</title>
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
		      <a class="navbar-brand" href="#">
				<img alt="" src="images/logo.png" style="height: 25px"></img>
		      </a>
		    </div>
	      </div>
	    </nav>	
		<div class="container" id="content">
			<form action="enquete.do">
				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<h3>Enquete - Deel 1</h3>
						<p>Vul deze kleine enquete in voordat de toets begint.</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>School</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="school" required placeholder="Bijvoorbeeld Cornelius" autofocus>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Lesjaar</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="lesjaar">
							<option value="1">Klas 1</option>
							<option value="2">Klas 2</option>
							<option value="3">Klas 3</option>
							<option value="4">Klas 4</option>
							<option value="5">Klas 5</option>
							<option value="6">Klas 6</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Niveau</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="niveau">
							<option value="VWO">VWO</option>
							<option value="HAVO">HAVO</option>
							<option value="VMBO">VMBO</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<Label>Profiel</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="profiel">
							<option value="E&M">E&M</option>
							<option value="C&M">C&M</option>
							<option value="N&G">N&G</option>
							<option value="N&T">N&T</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Geslacht</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="geslacht">
							<option value="man">Man</option>
							<option value="vrouw">Vrouw</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Wiskunde cijfer</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="number" name="gemWisCijfer" min="1" max="10" required placeholder="Bijvoorbeeld 7">
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Blijven zitten?</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="blijvenZitten">
							<option value="nee">Nee</option>
							<option value="1">Klas 1</option>
							<option value="2">Klas 2</option>
							<option value="3">Klas 3</option>
							<option value="4">Klas 4</option>
							<option value="5">Klas 5</option>
							<option value="6">Klas 6</option>
						</select>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-3">
						<input type="submit" class="btn btn-default" style="width: 100%;" name="button" value="Volgende ">
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