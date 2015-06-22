<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0" />
		<title>Enquete</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
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
	      </div>
	    </nav>	
		<div class="container" id="content">
			<form action="enqueteInzicht.do">
				<div class="row">
					<div class="col-md-4 col-md-offset-1">
						<h3>Enquete - Deel 2</h3>
						<p>Vul deze kleine enquete in voordat de toets begint.</p>
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-1">
						<label>Wat is 198*12?</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="watIsRekensom" required >
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-1">
						<label>Hoe hoog is de Eiffeltoren?</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="hoogteEiffeltoren" required >
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-1">
						<label>Hoeveel mobiele telefoons zijn er in Nederland?</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="aantMobieleTelefoons" required >
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-4">
						<input type="submit" class="btn btn-default" style="width: 100%;" name="button" value="Volgende">
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