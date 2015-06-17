<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Docent Aanmaken</title>
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
		<div class='container' id="content">
			<div class="col-md-7">
				<h3>Docent aanmaken</h3>
				<form action="docentaanmaken.do">
					<div class="row form-group">
						<div class="col-md-3">
							<label>Voornaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="voornaam" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Achternaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="achternaam" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Email</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="email" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Wachtwoord</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="wachtwoord" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Bevestig wachtwoord</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="wwbevestiging" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Schoolnaam</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="schoolnaam" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3">
							<label>Schoolplaats</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="schoolplaats" required >
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3 col-md-offset-3">
							<button class="btn btn-danger vol" type="reset" name="cancel" value="cancel">Annuleren</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-default vol" type="submit" name="next" value="next">Verder</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>© Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>