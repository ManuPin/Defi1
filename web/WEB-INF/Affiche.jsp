<%-- 
    Document   : Affiche
    Created on : 14 nov. 2017, 21:57:04
    Author     : Formation16
--%>
<%@page import="java.util.Map"%>
<%@page import="com.defi.magasin.Produit"%>
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
        <tr> <th>Indice/Reference </th> <th>Nom</th>    <th>Prix</th> <th>Quantite </th> <th>Commande </th>   </tr>
<% 
Map<Integer, Produit> mapproduit = (Map) session.getAttribute("listeProduit");
for(int i = 1 ; i <= mapproduit.size() ; i++){
        out.println("<tr> <th>" + mapproduit.get(i).getReference() + "</th><th>" + mapproduit.get(i).getNom() + "</th><th>" + mapproduit.get(i).getPrix() + "</th><th> " + mapproduit.get(i).getQuantiteStock() + "</th><th> " + "<a href=\"/defi-panier/AfficheProduit?panier="+ i +"\"> +1 <a> </tr>"  );
}
%>
        <h1> </h1> <h1> </h1>
           <style>table,th,td{border : 1px solid black;border-collapse:collapse;}</style> <table style=\"width:100%\"> 
        <p><tr> <th>Nom produit dans panier  </th> <th> Quantite </th>  <th> reste en stock apres commande</th>  <th> Prix unitaire</th>  <th> Prix </th>  </tr>
<%
    if ( session.getAttribute("sespanier") == null ){
    }
    else{
        Panier[] sespanier = (Panier[]) session.getAttribute("sespanier");
        float somme = 0;
        
for(int i = 1 ; i < sespanier.length ; i++){
     somme = somme + (sespanier[i].getProduit().getPrix()*sespanier[i].getQuantite());
   int rest =  mapproduit.get(i).getQuantiteStock()-sespanier[i].getQuantite();
        out.println("<tr> <th>" +  sespanier[i].getProduit().getNom()  +  "</th><th>" +   sespanier[i].getQuantite() +  "</th><th>" + rest +  "</th><th>" +  sespanier[i].getProduit().getPrix() +  "</th><th>" + sespanier[i].getProduit().getPrix()*sespanier[i].getQuantite() +"</th> </tr>" );
                                        }
           out.println("<tr> <th>" +  "Somme : "  +  "</th><th>" + "" + "</th><th>"+   ""+  "</th><th>"  +  "</th><th>" + somme + "</th> </tr>" );
 
        }
   
%>
       </p>
       <h2>  <p> 
<form action="/defi-panier/Commande" target="_blank" method="GET">
<input type="submit" value="Commande"></p></h2>
</form> 
      

<form action="/defi-panier/ResetSession") target="_blank" method="GET">
<input type="submit" value="Recommence Session"></p></h2>
</form> 
 
    </body>
</html>
