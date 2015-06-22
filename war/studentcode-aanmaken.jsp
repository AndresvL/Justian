<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8 u00E0" />
<title>Studentcode Aanmaken</title>
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
				<button type="button" class="navbar-toggle collapsed toggle"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"> <img alt=""
					src="images/logo.png" style="height: 25px"></img>
				</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="docent-dash.jsp">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Vragenbeheer<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="vraag-overzicht.jsp">Overzicht</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="vraag-aanmaken.jsp">Aanmaken</a></li>
							<li><a href="vraag-uploaden.jsp">Uploaden</a></li>
						</ul></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Docenten<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="docent-overzicht.jsp">Overzicht</a></li>
							<li role="separator" class="divider"></li>
							<li><a href="docent-aanmaken.jsp">Aanmaken</a></li>
						</ul></li>
					<li class="dropdown toggle"><a class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Studenten<span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="student-overzicht.jsp">Overzicht</a></li>
							<li role="separator" class="divider"></li>
							<li class="disabled"><a href="#">Aanmaken</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container" id="content">
		<div class="row">
			<h2>Studentcodes generen</h2>
		</div>
		<form action="studentcode.do">
			<div class="row">
				<div class="form-group">
					<div class="col-md-3">
						<label class="control-label">Aantal nieuwe studenten</label>
					</div>
					<div class="col-md-2">
						<input class="form-control" type="number" name="aantal" required
							autofocus="on">
					</div>
					<div class="col-md-2">
						<button class="btn btn-default" style="width: 100%;" type="submit"
							name="button" value="code">Genereer Codes</button>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<div class="form-control" id="codeLijst">
						<p>Studentcodes:</p>
						<% Object msgs = request.getAttribute("msgs"); 
							if (msgs != null) { 	 
								out.print(msgs);	
							}%>
					</div>
				</div>
			</div>
		</form>
		<form action="studentcodes.zip">
			<div class="row">
				<div class="col-md-4 col-md-offset-3">
					<input class="btn btn-default" style="width: 100%;" type="submit"
						name="button" value="export studentnummers">
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