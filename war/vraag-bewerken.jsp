<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Vraag Aanmaken</title>
<link href="css.css" rel="stylesheet">
</head>
<body>
	<div class="body">
		<div class="header">
			<img alt="" src="images/logo.png" style="margin: 10px;"></img>
			<div id="links">
				<a href="">Home</a> <a href="">Vragenbeheer</a> <a href="">Docenten</a>
				<a href="">Resultaten</a>
			</div>
		</div>
		
		<div class='opties'>
			<table id='opties'>
				<form id='vragen'>
					<tr>
							<th><button type="submit" name="image" value="image">Afbeelding</button>afbeeldingnaam.png</th>
					</tr>
					<tr>
						<th id='border'>
							<input type="radio" name="meet" value="Meetkunde">Meetkunde<br>
							<input type="radio" name="verband" value="Verbanden">Verbanden<br>
							<input type="radio" name="getal" value="Getallen">Getallen<br>
							<input type="radio" name="verhouding" value="Verhoudingen">Verhoudingen
						</th>
					</tr>
					<tr>
							<th><input type="checkbox" name="verhouding" value="Verhoudingen">Rekekenmachine</th>
					</tr>
					<tr>
							<th><input type="checkbox" name="verhouding" value="Verhoudingen">Multiple choice</th>
					</tr>
				</form>
			</table>
		</div>
		<div class="vragen">
		<h3>Vraag aanmaken</h3>
			<table style="text-align: left;">
				<form id="vragen">
					<tr>
						<th><label name="context">Context</label></th>
						<th><input type="text" id='context' name="context"
							placeholder="Vul hier de context in"></th>
					</tr>
					<tr>
						<th><label name="Opgave">Opgave</label></th>
						<th><input type="text" name="Opgave"
							placeholder="Vul hier de opgave in"></th>
					</tr>
					<tr>
						<th><label name="antwoord1">Antwoord 1</label></th>
						<th><input type="text" name="antwoord1"
							placeholder="Vul hier antwoord in"></th>
					</tr>
					<tr>
						<th><label name="antwoord2">Antwoord 2</label></th>
						<th><input type="text" name="antwoord2"
							placeholder="Vul hier multiple choice antwoord indien multiple choice"></th>
					</tr>
					<tr>
						<th><label name="antwoord3">Antwoord 3</label></th>
						<th><input type="text" name="antwoord3"
							placeholder="Vul hier multiple choice antwoord indien multiple choice"></th>
					</tr>
					<tr>
						<th><label name="antwoord4">Antwoord 4</label></th>
						<th><input type="text" name="antwoord4"
							placeholder="Vul hier multiple choice antwoord indien multiple choice"></th>
					</tr>
					<tr>
						<th><button type="reset" name="cancel" value="cancel">Annuleren</button></th>
						<th><button type="submit" name="next" value="next">Verder</button></th>
					</tr>
				</form>
			</table>
		</div>
		<div class="footer">
			<h6>© Direct-ACT & Justian Knobbout</h6>
		</div>
	</div>
</body>
</html>