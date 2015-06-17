<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 Common u00E0"/>
		<title>Toets</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<div id="header">
			<img alt="" src="images/logo.png" style="margin: 10px;" height="80px"></img>
		</div>
		<div class="container" id="content">
		<div class="row">
			<h2>Vraag ${vraagnummer}</h2>
		</div>
		<div class="row">
			<table style="text-align: left;">
				<tr class="vraag+context">
					<th id="context">${context}</th>
					<th><img id="ilustratie" alt="ilustratie" src="data:image/gif;base64,${plaatje}"></img></th>
				</tr>
				<tr id="vraagstelling">
					<th>${vraag}</th>
				</tr>
			</table>
		</div>
		</br>
		<div class="row">				
			<form id="antwoord" action="toets-vraag.do" method="get">
				<div class="form-group">
					<div class="col-md-3">
						<input class="form-control" type="text" required autofocus name="antwoord" placeholder="Voer hier uw antwoord in">
					</div>
					<div class="col-md-3">
						<button class="btn btn-default" type="submit" name="rekenmachine" value="toon">rekenmachine</button>
						<button class="btn btn-default" type="submit" name="button" value="volgende">volgende</button>
					</div>
				</div>
			</form>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-18">
					<div id="footer">
						<h6>© Direct-ACT & Justian Knobbout</h6>
					</div>				
				</div>
			</div>
		</div>
	</body>
</html>
