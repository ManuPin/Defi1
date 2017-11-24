/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.defi.magasin.Panier;
import com.defi.magasin.Produit;

/**
 *
 * @author Formation16
 */
public class GetPanier extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */


            //Overture si non ouverte d'une session
  HttpSession session = request.getSession(true);
  // a voir si get.attribute necessaire ....
  session.getAttribute("listeProduit");
  
  // Creation dans la servlet de la Map mapproduit en recuperant la map dans la session : listeProduit
  Map<Integer, com.defi.magasin.Produit> mapproduit = (Map) session.getAttribute("listeProduit"); 
  
  // recuperation de la reference du produit contenu dans le parametre pannier fournit dans l'URL donc request.getParametre
    String NumProduit = request.getParameter("panier");
    // passage du parametre de String en integer
   int numprod = Integer.parseInt (NumProduit);
   // a voir si on garde, quantite commande pour chaque "Clic" 
   int quantite = 1;
   
  /** test si l'attribut sespanier est dans la session, sinon il creer un tableau avec un objet par produit avec comme valeur 0 **/
        if (session.getAttribute("sespanier") == null) {
        Panier[] sespanier = new Panier[mapproduit.size()+1];
                        for(int i = 1 ; i <= mapproduit.size() ; i++){
                        sespanier[i] = new Panier(mapproduit.get(i),0);
                       }
        session.setAttribute("sespanier",sespanier);
        sespanier[numprod].setAjoutQuantite(quantite);
        
         }
        else{
             Panier[] sespanier = (Panier[]) session.getAttribute("sespanier");
            sespanier[numprod].setAjoutQuantite(quantite);
         
        }
                
         this.getServletContext().getRequestDispatcher( "/WEB-INF/Affiche.jsp").forward( request, response ); 

    }
        
}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
