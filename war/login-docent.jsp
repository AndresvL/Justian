<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Student Inlog</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="col-md-18" id="header" >
			<img alt="" src="images/logo.png" style="margin: 10px;" height="80px"></img>	
		</div>
		<div class="container" id="content">
			<h2>Log hier in als Docent of Beheerder</h2>
			<div class="col-md-5">
				<div id="msgs">
					<% 
					Object msgs = request.getAttribute("msgs"); 
					if (msgs != null) { 	 
						out.println(msgs); 
						out.println(); 		
					}	%>
				</div>
				<form action="login-docent.do">
					<div class="form-group">
						<input class="form-control" type="text" name="email" placeholder="Email" required>
					</div>
					<div class="form-group">
						<input class="form-control" type="password" name="wachtwoord" placeholder="Wachtwoord" required>
					</div>
					<button class="btn btn-default" type="submit" name="button" value="login">login</button>
				</form>
			</div>
		</div>
		<div id="footer">
			<h6>© Direct-ACT & Justian Knobbout</h6>
		</div>
	</body>
</html>