<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>Toets</title>
		<link href="css.css" rel="stylesheet">
	</head>
	<body>
		<div class="body">
			<div class="header">
				<img alt="" src="images/logo.png" style="margin: 10px;"></img>
			</div>
			<div class="content">
				<h2>Vraag ${vraagnummer}</h2>
				<form id="antwoord" action="toets-vraag.do" method="get">
				<table style="text-align: left;">
					<tr class="vraag+context">
						<th id="context">${context}</th>
						<th><img id="ilustratie" alt="ilustratie" src="data:image/gif;base64,${plaatje}"></img></th>
					</tr>
					<tr></tr>
					<tr id="vraagstelling">
						<th>${vraag}</th>
					</tr><br />
					<tr class="antwoord">						
						<th><input type="text" required name="antwoord" placeholder="Voer hier uw antwoord in"></th>
						<th><button type="submit" name="rekenmachine" value="toon">rekenmachine</button>
						<button type="submit" name="button" value="volgende">volgende</button></th>
					</tr>
				</table>
				</form>
			</div>
			<div class="footer">
				<h6>© Direct-ACT & Justian Knobbout</h6>
			</div>
		</div>
	</body>
</html>
