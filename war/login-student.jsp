<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>Student Inlog</title>
		<link href="css.css" rel="stylesheet">
		
	</head>
	<body>
		<div class="body">
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%>	
			<div class="header">
				<img alt="" src="images/logo.png" style="margin: 10px;"></img>
			</div>
			<div class="content">
			<p>Duur van de toets is 120 minuten. </p>
			<p>bij het invullen van een negatief getal, een breuk of een groot getal moet je dat op de volgende manier doen.</p>
				<table id="table">
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
				<br />
				<h2>Log hier in als Student</h2>
				<form id="studentInlog" action="login-student.do" method="get">
					<input type="number" name="code" placeholder="Voer hier uw code in" required autofocus="on" alt ="Vul hier de code in die je hebt gekregen van je docent">
					<button type="submit" name="button" value="login">login</button>
				</form>
			</div>
			<div class="footer">
				<h6>© Direct-ACT & Justian Knobbout</h6>
			</div>
		</div>
	</body>
</html>