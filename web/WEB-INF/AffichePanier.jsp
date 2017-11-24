<%-- 
    Document   : AffichePanier
    Created on : 14 nov. 2017, 22:34:02
    Author     : Formation16
--%>
<%@page import="java.util.Map"%>
<%@page import="com.defi.magasin.Produit"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Magasin Apiculture</title>
        <h1>Magasin Apiculture </H1>
    </head>
    <body>
                 <style>table,th,td{border : 1px solid black;border-collapse:collapse;}</style> <table style=\"width:100%\"> 
        <tr> <th>Indice/Reference </th> <th>Nom</th>    <th>Prix</th> <th>Quantite </th> <th>Commande </th>   </tr>
<% 
Map<Integer, Produit> mapproduit = (Map) session.getAttribute("listeProduit");
for(int i = 1 ; i <= mapproduit.size() ; i++){
        out.println("<tr> <th>" + mapproduit.get(i).getReference() + "</th><th>" + mapproduit.get(i).getNom() + "</th><th>" + mapproduit.get(i).getPrix() + "</th><th> " + mapproduit.get(i).getQuantiteStock() + "</th><th> " + "<a href=\"/defi-panier/AfficheProduit?panier="+ i +"\"> +1 <a> " );
}
%>
    </body>
</html>
