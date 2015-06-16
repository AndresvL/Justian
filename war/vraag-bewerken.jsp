<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8 u00E0"/>
		<title>Vraag Bewerken</title>
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
		<div class='container' id="content">
			<div class="col-md-4">
				<div class="row">
					<h3>Opties</h3>
				</div>
				<form class="form-group" id='vragen'>
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
								<input type="checkbox" name="rekenmachine">Rekekenmachine
							</label>
						</div>
					</div>
					<div class="row">
						<div class="checkbox">
							<label>
								<input type="checkbox" name="multiplechoice">Multiplechoice
							</label>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-7 col-md-offset-1">
				<h3>Vraag bewerken</h3>
				<form id="vragen">
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
							<input class="form-control" type="text" name="antwoord2" required placeholder="Vul indien multiple choice">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 3</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord3" required placeholder="Vul indien multiple choice">
						</div>
					</div> 
					<div class="row form-group">
						<div class="col-md-2">
							<label>Antwoord 4</label>
						</div>
						<div class="col-md-6">
							<input class="form-control" type="text" name="antwoord4" required placeholder="Vul indien multiple choice">
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
				</form>
			</div>
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