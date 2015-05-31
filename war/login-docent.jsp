<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Student Inlog</title>
<link href="css.css" rel="stylesheet">
</head>
<body>
	<div class="body">
		<div class="header">
			<img alt="" src="images/logo.png" style="margin: 10px;"></img>
		</div>
		<div class="content">
		<div id = "msgs">
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%></div>
			<h2>Log hier in als Docent of Beheerder</h2>
			<form action="login-docent.do">
				<table style="text-align: left;">
					<tr>
						<th><label>Email Adres:</label></th>
						<th><input type="text" name="email"
							placeholder="Email" required></th>
					</tr>
					<tr>
						<th><label>Wachtwoord:</label></th>
						<th><input type="password" name="wachtwoord"
							placeholder="Wachtwoord" required></th>
					</tr>
					<tr>
						<th></th>
						<th><button type="submit" name="button" value="login">login</button></th>
					</tr>

				</table>
			</form>
		</div>
		<div class="footer">
			<h6>© Direct-ACT & Justian Knobbout</h6>
		</div>
	</div>
</body>
</html>