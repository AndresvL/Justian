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
			<h2>Studentcodes generen</h2>
			<br /> <label>Vul hieronder het aantal studenten in</label>
			<form action="studentcode.do">
				<input type="number"  name="aantal" required autofocus="on">
				<button  type="submit" name="button" value="code">Genereer	Codes</button>
			</form>
		</div>
		<div id = codelijst>
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%></div>
		<div class="footer">
				<h6>© Direct-ACT & Justian Knobbout</h6>
		</div>
	</div>
</body>
</html>