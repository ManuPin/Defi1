<%-- 
    Document   : ProblemeStock
    Created on : 16 nov. 2017, 12:29:42
    Author     : Formation16
--%>
<%@page import="com.defi.magasin.Produit"%>
<%@page import="com.defi.magasin.Panier"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Magasin Apiculture</title>
        
    </head>
    <body>
        <h1>Magasin Apiculture </H1>
        <h1> Probleme de stock</h1>        <h1> Nous n'avons pas assez de stock pour votre commande </h1>        <h1> Veuillez reformuler votre commande </h1>    
 <% 
Map<Integer, Produit> mapproduit = (Map) session.getAttribute("listeProduit");

%>
        <h1> </h1> <h1> </h1>
           <style>table,th,td{border : 1px solid black;border-collapse:collapse;}</style> <table style=\"width:100%\"> 
        <p><tr> <th>Nom produit dans panier  </th> <th> Quantite </th>  <th> reste en stock apres commande</th>    </tr>
<%
    if ( session.getAttribute("sespanier") == null ){
    }
    else{
        Panier[] sespanier = (Panier[]) session.getAttribute("sespanier");
for(int i = 1 ; i < sespanier.length ; i++){
   int rest =  mapproduit.get(i).getQuantiteStock()-sespanier[i].getQuantite();
        out.println("<tr> <th>" +  sespanier[i].getProduit().getNom()  +  "</th><th>" +   sespanier[i].getQuantite() +  "</th><th>" + rest + "</th> </tr>" );
                                        }
    
        }
   
%>
<form action="/defi-panier/ResetSession") target="_blank" method="GET">
<input type="submit" value="Reset Session"></p></h2>
</form> 
    </body>
</html>
