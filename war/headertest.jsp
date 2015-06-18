<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Vragen Overzicht</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
		<nav class="navbar navbar-default navbar-fixed-top" id="headernew">
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
			<div class="row">
				<h3>Vragen Overzicht</h3>
			</div>
			<div class="row">
				<div class="col-md-1">
					<form class="form-group">
						<div class="row">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="context">Context
								</label>
							</div>
							<div class="checkbox">
								<label>
									<input type="checkbox" name="non-context">Non-Context
								</label>
							</div>
						</div>
						<div class="row">
							<div class="checkbox">
								<label>
									<input type="checkbox" name="meet">Meetkunde
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="getal">Getallen
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="verhoud">Verhoudingen
								</label>
							</div>							
							<div class="checkbox">
								<label>
									<input type="checkbox" name="verband">Verbanden
								</label>
							</div>							
						</div>
					</form>
				</div>
				<div class="col-md-10 col-md-offset-1">
					<div class="tablecontent">
						<table class="table table-striped">
							<tr>
								<th>Vraag Nummer</th><th>Categorie</th><th>Rekenmachine</th><th>Afbeelding</th>
								<th>Multiple Choice</th><th>Context</th><th>Opgave</th><th>Antwoord</th>
								<th></th>
							</tr>
							<tr>
								<td>TEST</td><td>TEST</td><td>TEST</td><td>TEST</td>
								<td>TEST</td><td>TEST</td><td>TEST</td><td>TEST</td>
								<td><a href="#" class="btn btn-default vol">Bekijk</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-default navbar-fixed-bottom" id="footernew">
		  <div class="container-fluid">
		    <h6>© Direct-ACT & Justian Knobbout</h6>
		  </div>
		</nav>
	</body>
</html>