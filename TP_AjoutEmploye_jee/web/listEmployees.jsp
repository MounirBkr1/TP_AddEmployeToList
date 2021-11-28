<%@ page import="com.mnr.beans.Employe" %>
<%@ page import="java.util.List" %>

<%--
  Created by IntelliJ IDEA.
  User: pekit
  Date: 28/11/2021
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list employees</title>
</head>
    <body>
        <h1>List employees</h1>
        <!--affichage list employées-->

        <table>
            <tr><th>nom</th><th>prenom</th><th>email</th></tr>
            <%

                List<Employe> employees =  (List<Employe>)request.getAttribute("employees");
                for (Employe e : employees) {
            %>

            <tr>

                <td ><%=e.getNom()%></td>
                <td ><%=e.getPrenom()%></td>
                <td ><%=e.getEmail()%></td>
                <br>
            </tr>


            <%
            }
            %>
        </table>
    <br>
    <br>
    <br>
    <a href="index.html">retour a page d'acceuil</a>





    </body>
</html>