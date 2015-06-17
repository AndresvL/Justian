<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Studentcode Aanmaken</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default" id="headernew">
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
	        <div id="navbar" class="navbar-collapse collapse" id="bs-example-navbar-collapse-1">
	          <ul class="nav navbar-nav navbar-right">
	            <li><a href="#">Home</a></li>
	            <li class="actief"><a href="#">Vragenbeheer</a></li>
	            <li><a href="#">Docenten</a></li>
	            <li><a href="#">Resultaten</a></li>
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
							<input class="form-control" type="number" name="aantal" required autofocus="on">
				    	</div>
					    <div class="col-md-2">
					    	<button class="btn btn-default" style="width:100%;" type="submit" name="button" value="code">Genereer	Codes</button>
					    </div>
				    </div>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-3">
						</br>
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
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>� Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>