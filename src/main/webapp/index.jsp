<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="2" style="width:50%">
<tr> <td style="width:15%"></td><td style="width:16%"> Lundi</td> <td style="width:16%"> Mardi</td><td style="width:16%"> Mercredi</td><td style="width:16%"> Jeudi</td><td style="width:16%"> Vendredi</td></tr>

<% 
String[][] tabEmploi = new String[21][5];
if (request.getAttribute("tableau") != null)
	tabEmploi = (String[][])request.getAttribute("tableau");
for (int i = 0; i < 21; i++) {
	out.println("<tr>");
	out.println("<td>");
	out.print(8+(i+1)/2 + ":");
	if(i%2 == 0)
		out.println("30");
	else
		out.println("00");
	out.println("</td>");
	for (int j = 0; j < 5; j++) {
		out.println("<td>");
		if (tabEmploi[i][j] != null)
			out.println(tabEmploi[i][j]);
		out.println("</td>");
	}
	
	out.println("</tr>");
}

%>
</table>
</br></br>
<form action="emploi">
Entrez un créneau à ajouter : </br>
Jour : 
<select name="jour">
<option value=0>Lundi</option>
<option value=1>Mardi</option>
<option value=2>Mercredi</option>
<option value=3>Jeudi</option>
<option value=4>Vendredi</option>
</select></br>
Heure de début : 
<select name="heureDebut">
<option value=0>8:30</option>
<option value=1>9:00</option>
<option value=2>9:30</option>
<option value=3>10:00</option>
<option value=4>10:30</option>
<option value=5>11:00</option>
<option value=6>11:30</option>
<option value=7>12:00</option>
<option value=8>12:30</option>
<option value=9>13:00</option>
<option value=10>13:30</option>
<option value=11>14:00</option>
<option value=12>14:30</option>
<option value=13>15:00</option>
<option value=14>15:30</option>
<option value=15>16:00</option>
<option value=16>16:30</option>
<option value=17>17:00</option>
<option value=18>17:30</option>
<option value=19>18:00</option>
<option value=20>18:30</option>
</select>
</br>
Heure de fin : 
<select name="heureFin">
<option value=0>8:30</option>
<option value=1>9:00</option>
<option value=2>9:30</option>
<option value=3>10:00</option>
<option value=4>10:30</option>
<option value=5>11:00</option>
<option value=6>11:30</option>
<option value=7>12:00</option>
<option value=8>12:30</option>
<option value=9>13:00</option>
<option value=10>13:30</option>
<option value=11>14:00</option>
<option value=12>14:30</option>
<option value=13>15:00</option>
<option value=14>15:30</option>
<option value=15>16:00</option>
<option value=16>16:30</option>
<option value=17>17:00</option>
<option value=18>17:30</option>
<option value=19>18:00</option>
<option value=20>18:30</option>
</select>
</br>
Matière : <input type="text" name="matiere"/>

<button type="submit">Ajouter</button>
</form>


</body>
</html>