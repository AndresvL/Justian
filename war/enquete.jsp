<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Student 1e keer</title>
		<link href="/css/bootstrap.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
<body>
	<div class="col-xs-18" id="header">
		<img alt="" src="images/logo.png" style="margin: 10px;" height="80px"></img>	
	</div>
		<div class="container" id="content">
			<form action="enquete.do">
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>School</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="text" name="school" required	placeholder="Bijvoorbeeld Cornelius" autofocus>
					</div>
				</div> 
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Lesjaar</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="lesJaar">
		                <option value="1">Klas 1</option>
		                <option value="2">Klas 2</option>
		                <option value="3">Klas 3</option>
		                <option value="4">Klas 4</option>
		                <option value="5">Klas 5</option>
		                <option value="6">Klas 6</option>
		            	</select>
		            </div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<Label>Profiel</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="profiel">
		                <option value="E&M">E&M</option>
		                <option value="C&M">C&M</option>
		                <option value="N&G">N&G</option>
		                <option value="N&T">N&T</option>
		            	</select>
		            </div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Niveau</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="niveau">
		                <option value="VWO">VWO</option>
		                <option value="HAVO">HAVO</option>
		                <option value="VMBO">VMBO</option>
		            	</select>
		            </div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Geslacht</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="geslacht">
		                <option value="man">Man</option>
		                <option value="vrouw">Vrouw</option>
		            	</select>
		            </div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Wiskunde cijfer</label>
					</div>
					<div class="col-md-3">
						<input class="form-control" type="number" name="gemWisCijfer" min="1" max="10" required placeholder="Bijvoorbeeld 7">
					</div>
				</div>
				<div class="row form-group">
					<div class="col-md-2 col-md-offset-1">
						<label>Blijven zitten?</label>
					</div>
					<div class="col-md-3">
						<select class="form-control" name="blijvenZitten">
		                <option value="nee">Nee</option>
		                <option value="1">Klas 1</option>
		                <option value="2">Klas 2</option>
		                <option value="3">Klas 3</option>
		                <option value="4">Klas 4</option>
		                <option value="5">Klas 5</option>
		                <option value="6">Klas 6</option>
		            	</select>
		            </div>
				</div>
				<div class="row form-group">
					<div class="col-md-3 col-md-offset-3">
						<input type="submit" class="btn btn-default" style="width:100%;" name="button" value="Volgende ">
					</div>
				</div>		
			</form>
		</div>
		<div id="footer">
			<h6>© Direct-ACT & Justian Knobbout</h6>
		</div>
	</body>
</html>