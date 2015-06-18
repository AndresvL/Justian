<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Vragen Overzicht</title>
<<<<<<< HEAD
=======
		<script type="text/javascript" src="/js/jquery-2.1.4.js"></script>
		<script type="text/javascript" src="/js/bootstrap.min.js"></script>
>>>>>>> origin/master
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>	
<<<<<<< HEAD
		<nav class="navbar navbar-default" id="headernew">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" id="toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
=======
		<nav class="navbar navbar-default navbar-static-top" id="headernew">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
>>>>>>> origin/master
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
<<<<<<< HEAD
	            <li><a href="#">Home</a></li>
	            <li class="actief"><a href="#">Vragenbeheer</a></li>
	            <li><a href="#">Docenten</a></li>
	            <li><a href="#">Resultaten</a></li>
	          </ul>
	        </div>
	      </div>
	    </nav>	
=======
	            <li><a href="docent-dash.jsp">Home</a></li>
	     		<li class="dropdown toggle">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Vragenbeheer<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="vraag-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li class="disabled"><a href="#">Aanmaken</a></li>
			            <li><a href="vraag-uploaden.jsp">Uploaden</a></li>
		   			</ul>
		        </li>
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Docenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="docent-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
	     		<li class="dropdown">
		        	<a class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Studenten<span class="caret"></span></a>
		          	<ul class="dropdown-menu">
			            <li><a href="student-overzicht.jsp">Overzicht</a></li>
			            <li role="separator" class="divider"></li>
			            <li><a href="studentcode-aanmaken.jsp">Aanmaken</a></li>
		   			</ul>
		        </li>
	          </ul>
	        </div>
	      </div>
	    </nav>
>>>>>>> origin/master
		<div class='container' id="content">
			<form class="form-group" action="vraag-aanmaken.do">
				<div class="col-md-4">
					<div class="row">
						<h3>Opties</h3>
					</div>
					<div class="row">
						<input type="file" name="afbeelding" accept="image/*">
   		 				<p class="help-block">Geef afbeelding indien nodig</p>
					</div>
					<div class="row">
						<select class="form-control" name="categorie">
			                <option value="meet">Meetkunde</option>
			                <option value="verband">Verbanden</option>
			                <option value="getal">Getallen</option>
			                <option value="verhoud">Verhoudingen</option>
		            	</select>
					</div>
					<div class="row">
						<div class="checkbox">
							<label>
								<input type="checkbox" name="rekenmachine" value="true">Rekenmachine
							</label>
						</div>
					</div>
					<div class="row">
						<div class="checkbox">
							<label>
								<input type="checkbox" name="multiplechoice" value="true">Multiplechoice
							</label>
						</div>
					</div>
				</div>
				<div class="col-md-7 col-md-offset-1">
					<h3>Vraag aanmaken</h3>
					<div class="row form-group">
						<div class="col-md-2">
							<label>Context</label>
						</div>
						<div class="col-md-6">
							<textarea class="form-control" name="context" required placeholder="Vul hier de context in indien aanwezig" rows="3"></textarea>
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Opgave</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="opgave" required placeholder="Vul hier de opgave in">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 1</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord1" required placeholder="Vul hier het correcte antwoord in">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 2</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord2" placeholder="Vul indien multiple choice">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 3</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord3" placeholder="Vul indien multiple choice">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 4</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord4" placeholder="Vul indien multiple choice">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-3 col-md-offset-2">
							<button class="btn btn-danger vol" type="reset" name="cancel" value="cancel">Annuleren</button>
						</div>
						<div class="col-md-3">
							<button class="btn btn-default vol" type="submit" name="next" value="next">Verder</button>
						</div>
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