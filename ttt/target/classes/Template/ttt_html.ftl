<html>
	<head>
		<meta charset="utf-8">
		<title>Tic Tac Toe</title>
		<link rel="stylesheet" type="text/css" href="../css/ttt.css" />
	</head>

	<body>
		<div id="tic-tac-toe">

			<h1 class="span3">Tic Tac Toe</h1>
			<form action="/playttt/iq" method="GET">
				<span id="iq">IQ: </span>
				<input type="range" name="range" id="range" min="0" max="100" value="0"/>
				<span id="value1">${iq}  </span>
				<input type="submit" name="confirm" id="confirm" value="Confirm" />
			</form>
			
			<span id="turn">You are <em id="myturn">${turn}</em>, Click "Begin" to Start!</span>
			<div id="result"><p>Game Result: ${result}</p></div>
		<table>
			<#list grid_list as gl>
			<tr>
				<form action="/playttt/11" method="POST"><td><input class="grid" name="11" type="submit" id="11" value="${gl.grid11}" onclick="turn11()"/></td></form>
				<form action="/playttt/12" method="POST"><td><input class="grid" name="12" type="submit" id="12" value="${gl.grid12}" onclick="turn12()"/></td></form>
				<form action="/playttt/13" method="POST"><td><input class="grid" name="13" type="submit" id="13" value="${gl.grid13}" onclick="turn13()"/></td></form>
			</tr>

			<tr>
				<form action="/playttt/21" method="POST"><td><input class="grid" name="21" type="submit" id="21" value="${gl.grid21}" onclick="turn21()"/></td></form>
				<form action="/playttt/22" method="POST"><td><input class="grid" name="22" type="submit" id="22" value="${gl.grid22}" onclick="turn22()"/></td></form>
				<form action="/playttt/23" method="POST"><td><input class="grid" name="23" type="submit" id="23" value="${gl.grid23}" onclick="turn23()"/></td></form>
			</tr>

			<tr>
				<form action="/playttt/31" method="POST"><td><input class="grid" name="31" type="submit" id="31" value="${gl.grid31}" onclick="turn31()"/></td></form>
				<form action="/playttt/32" method="POST"><td><input class="grid" name="32" type="submit" id="32" value="${gl.grid32}" onclick="turn32()"/></td></form>
				<form action="/playttt/33" method="POST"><td><input class="grid" name="33" type="submit" id="33" value="${gl.grid33}" onclick="turn33()"/></td></form>
			</tr>
			</#list>
		</table>
		
		<div id="button">
			<form action="/playttt/begin" method="GET"><input type="submit" id="begin" value="BEGIN" name="begin" /></form>
		</div>
		</div>
		<script>
			
			function turn11() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("11").value="X";
				}
				else{
					document.getElementById("11").value="O";
				}
				
			}
			
			function turn12() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("12").value="X";
				}
				else{
					document.getElementById("12").value="O";
				}
			}
			
			function turn13() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("13").value="X";
				}
				else{
					document.getElementById("13").value="O";
				}
			}
			
			function turn21() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("21").value="X";
				}
				else{
					document.getElementById("21").value="O";
				}
			}
			
			function turn22() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("22").value="X";
				}
				else{
					document.getElementById("22").value="O";
				}
			}
			
			function turn23() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("23").value="X";
				}
				else{
					document.getElementById("23").value="O";
				}
			}
			
			function turn31() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("31").value="X";
				}
				else{
					document.getElementById("31").value="O";
				}
			}
			
			function turn32() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("32").value="X";
				}
				else{
					document.getElementById("32").value="O";
				}
			}
			
			function turn33() {
				if (document.getElementById("myturn").innerHTML == "X"){
					document.getElementById("33").value="X";
				}
				else{
					document.getElementById("33").value="O";
				}
			}
		</script>
	</body>
</html>
