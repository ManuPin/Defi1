<%-- 
    Document   : AfficheCommande
    Created on : 17 nov. 2017, 11:58:24
    Author     : Formation16
--%>

<%@page import="java.util.Map"%>
<%@page import="com.defi.magasin.Panier"%>
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
        <p><tr> <th>Nom produit dans panier  </th> <th> Quantite </th>  <th> Prix unitaire</th>  <th> Prix </th>  </tr>
<%
    if ( session.getAttribute("sespanier") == null ){
    }
    else{
        Panier[] sespanier = (Panier[]) session.getAttribute("sespanier");
        float somme = 0;
for(int i = 1 ; i < sespanier.length ; i++){
    somme = somme + (sespanier[i].getProduit().getPrix()*sespanier[i].getQuantite());
     out.println("<tr> <th>" +  sespanier[i].getProduit().getNom()  +  "</th><th>" + sespanier[i].getQuantite() + "</th><th>"+   sespanier[i].getProduit().getPrix() +  "</th><th>" + sespanier[i].getProduit().getPrix()*sespanier[i].getQuantite() + "</th> </tr>" );
                                        }
        out.println("<tr> <th>" +  "Somme : "  +  "</th><th>" + "" + "</th><th>"+   "" +  "</th><th>" + somme + "</th> </tr>" );
 
        }
   
%>
    </body>
</html>
