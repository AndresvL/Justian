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
		<title>Toets</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
		<script type="text/javascript">
		function showRekenmachine() {
		    if (document.getElementById("rekenmachine").style.display == "none") {
		    	document.getElementById("rekenmachine").style.display = "inherit";
				document.getElementById("heeftRekenmachineGebruikt").value = 'true';
		    } else {
		    	document.getElementById("rekenmachine").style.display = "none";
				document.getElementById("heeftRekenmachineGebruikt").value = 'true';
		    }
		}
		function showButton() {
			var rek = ${rekenmachine};
			if(rek.toString() == "true"){
				document.getElementById("rekenmachineButton").style.display = "inline";
			} else {
				document.getElementById("rekenmachineButton").style.display = "none";
			}
		}
		
		window.onload = showButton;
		</script>
	</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" id="toggle"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand"> <img alt=""
						src="images/logo.png" style="height: 25px"/>
					</a>
				</div>
			</div>
		</nav>
		<div class="container" id="content">
			<div class="row">
				<div class="form-group">
					<div class="col-md-12">
						<h2>Vraag ${aantal}</h2>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<div class="col-md-12">
							<div id="vraagcontext">
								<div class="row">
									<p>${context}</p>
								</div>
								<div class="row">
									<p>
										<b>${vraag}</b>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<form id="antwoord" action="toets-vraag.do" method="get">
							<div class="form-group">
							<div id="msgs">
							${msgs}
							</div>
								<div class="col-md-6">
									<input class="form-control vol" type="text" required autofocus
										name="antwoord" placeholder="Voer hier uw antwoord in">
									<input type="hidden" id="heeftRekenmachineGebruikt" name="heeftRekenmachineGebruikt" value="false">
								</div>
								<div class="col-md-6">
									<button class="btn btn-default vol" type="submit" name="button"
										value="volgende">volgende</button>
								</div>
							</div>
						</form>
					</div>
					<div class="row"  onload="showButton()">
						<div class="col-md-6 col-md-offset-6">
							<br/>
							<div class="row">
								<div class="col-md-12" id="rekenmachineButton" style="display:none;">
									<button class="btn btn-default vol" onclick="showRekenmachine()"
										value="toon">rekenmachine</button>
								</div>
							</div>
							<FORM NAME="Calc">
								<div id="rekenmachine" style="display:none;">
									<div class="row form-group">
										<div class="col-md-12">
											<INPUT TYPE="text" class="form-control vol" NAME="Input" Size="16" OnLoad="Calc.Input.value = ''">
										</div>
									</div>
									
									<div class="row bottom">
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="one" class="btn btn-default vol" VALUE="  1  " OnClick="Calc.Input.value += '1'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="two" class="btn btn-default vol" VALUE="  2  " OnCLick="Calc.Input.value += '2'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="three" class="btn btn-default vol" VALUE="  3  " OnClick="Calc.Input.value += '3'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="plus" class="btn btn-info vol" VALUE="  +  " OnClick="Calc.Input.value += ' + '">
										</div>
									</div>
									<div class="row bottom">
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="four" class="btn btn-default vol" VALUE="  4  " OnClick="Calc.Input.value += '4'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="five" class="btn btn-default vol" VALUE="  5  " OnCLick="Calc.Input.value += '5'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="six" class="btn btn-default vol" VALUE="  6  " OnClick="Calc.Input.value += '6'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="minus" class="btn btn-info vol" VALUE="  -  " OnClick="Calc.Input.value += ' - '">
										</div>
									</div>
									<div class="row bottom">
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="seven" class="btn btn-default vol" VALUE="  7  " OnClick="Calc.Input.value += '7'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="eight" class="btn btn-default vol" VALUE="  8  " OnCLick="Calc.Input.value += '8'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="nine" class="btn btn-default vol" VALUE="  9  " OnClick="Calc.Input.value += '9'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="times" class="btn btn-info vol" VALUE="  x  " OnClick="Calc.Input.value += ' * '">
										</div>
									</div>
									<div class="row bottom">
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="clear" class="btn btn-default vol" VALUE="  c  " OnClick="Calc.Input.value = ''">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="zero" class="btn btn-default vol" VALUE="  0  " OnCLick="Calc.Input.value += '0'">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="DoIt" class="btn btn-default vol" VALUE="  =  " OnClick="Calc.Input.value = eval(Calc.Input.value)">
										</div>
										<div class="col-md-3">
											<INPUT TYPE="button" NAME="div" class="btn btn-info vol" VALUE="  /  " OnClick="Calc.Input.value += ' / '">
										</div>
									</div>
								</div>
							</FORM>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<img id="ilustratie" alt="ilustratie"
						src="data:image/gif;base64,${plaatje}"></img>
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
