<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>Student Inlog</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="col-md-18" id="header">
			<img alt="" src="images/logo.png" style="margin: 10px;"></img>
		</div>
		<div class="container" id="content">
			<div class="row">
				<p>Duur van de toets is 120 minuten. </p>
				<p>bij het invullen van een negatief getal, een breuk of een groot getal moet je dat op de volgende manier doen.</p>
			</div>
			<div class="row">
				<table class="table col-md-10">
					<tr>
						<th>Voorbeeld</th>
						<th>Negatief getal</th>
						<th>Geen punt</th>
						<th>Breuk</th>
					</tr>
					<tr>
						<th>Goed</th>
						<td>-3,5</td>
						<td>32342,45</td>
						<td>1/8</td>
					</tr>
					<tr>
						<th>Niet goed</th>
						<td>- 3,5</td>
						<td>32.342,45</td>
						<td>1:8</td>
					</tr>
				</table>
			</div>
			<div class="row">
				<h2>Log hier in als Student</h2>
			</div>
			<div class="row">
				<div class="col-md-2">
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
			<div class="row">
				<form id="studentInlog" action="login-student.do" method="get">
	  				<div class="col-md-3">
						<input class="form-group form-control" type="number" name="code" placeholder="Voer hier uw code in" required autofocus="on">
					</div>
					<div class="col-md-2">
						<button class="btn btn-default" type="submit" name="button" value="login">login</button>
					</div>
				</form>
			</div>
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