<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>Student 1e keer</title>
<link href="css.css" rel="stylesheet">
</head>
<body>
	<div class="header">
		<img alt="" src="images/logo.png" style="margin: 10px;"></img>
		</div>
			<div class="vragen">
				<form action="enquete.do">
					<label>School</label><input type="text" name="school" required	placeholder="Bijvoorbeeld Cornelius"><br /> 
					<label>Lesjaar</label><input type="number" name="lesjaar" required placeholder="Bijvoorbeeld 5"><br />
					<Label>Profiel</label>
					<select name = "profiel">
	                <option value="E&M">E&M</option>
	                <option value="C&M">E&M</option>
	                <option value="N&G">N&G</option>
	                 <option value="N&T">N&T</option>
	            	</select><br /> 
					<label>Niveau</label>
					<select name = "niveau">
	                <option value="VWO">VWO</option>
	                <option value="HAVO">HAVO</option>
	                <option value="VMBO">VMBO</option>
	            	</select><br /> <label>Geslacht</label> <input type="radio" name="geslacht"	value="man" checked>Man <input type="radio" name="geslacht"	value="vrouw">Vrouw<br /> 
					<label>Wiskunde cijfer</label><input type="number" name="gemWisCijfer" required placeholder="Bijvoorbeeld 7.4"><br /> 
					<label>Blijven zitten?</label>
					<select name = "blijvenZitten">
	                <option value="klas 1">Klas 1</option>
	                <option value="klas 2">Klas 2</option>
	                <option value="klas 3">Klas 3</option>
	                <option value="klas 4">Klas 4</option>
	                <option value="klas 5">Klas 5</option>
	            	</select><br />
					<input type="submit" class = "button" name="button" value="Volgende ">		
				</form>
			</div>
		<div class="footer">
		<h6>© Direct-ACT & Justian Knobbout</h6>
	</div>

</body>
</html>