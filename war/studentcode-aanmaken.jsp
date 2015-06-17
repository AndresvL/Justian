<html>
	<head>
		<meta charset="utf-8" />
		<title>Student Inlog</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<div class="container-fluid links" id="header">
			<div class="row">
				<div class="col-md-6">
					<img alt="" src="images/logo.png" style="margin: 10px;" height="80px"></img>				
				</div>
				<div class="col-md-6">
					<ul class="nav nav-tabs tabnav">
					  <li role="presentation"><a href="#">Home</a></li>
					  <li role="presentation" class="active"><a href="#">Vragenbeheer</a></li>
					  <li role="presentation"><a href="#">Docenten</a></li>
					  <li role="presentation"><a href="#">Resultaten</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" id="content">
			<div class="row">
					<h2>Studentcodes generen</h2>
			</div>
			<form action="studentcode.do">
				<div id="msgs">
						<% 
						Object melding = request.getAttribute("melding"); 
						if (melding != null) { 	 
							out.println(melding); 
							out.println(); 		
						}	%>
				</div>
				<div class="row">
					<div class="form-group">
						<div class="col-md-3">
				    		<label class="control-label">Aantal nieuwe studenten</label>
				    	</div>
						<div class="col-md-2">
							<input class="form-control" type="number" name="aantal" required autofocus>
				    	</div>
					    <div class="col-md-2">
					    	<button class="btn btn-default" style="width:100%;" type="submit" name="button" value="code">Genereer	Codes</button>
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
			<form id="export">
				<div class="row">
					<div class="col-md-4 col-md-offset-3">
						<button class="btn btn-default" style="width:100%;" type="submit" name="button" value="export">Exporteer codes</button>			
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