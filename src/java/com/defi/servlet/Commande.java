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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Formation16
 */
public class Commande extends HttpServlet {

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
             HttpSession session = request.getSession(true);
             session.getAttribute("listeProduit");
             Map<Integer, com.defi.magasin.Produit> mapproduit = (Map) session.getAttribute("listeProduit"); 
             session.getAttribute("sespanier");
             Panier[] sespanier = (Panier[]) session.getAttribute("sespanier");
             
        boolean commandeOk = true;

            for(int i = 1 ; i < sespanier.length ; i++){
                 int rest =  mapproduit.get(i).getQuantiteStock() - sespanier[i].getQuantite();
                 if ( 0 > rest ){ commandeOk = false;}
                                       }
  if (commandeOk == true){
         try {
          for(int i = 1 ; i < sespanier.length ; i++){
              int rest =  mapproduit.get(i).getQuantiteStock() - sespanier[i].getQuantite();
                
                mapproduit.get(i).setQuantiteRetiredDuStock(sespanier[i].getQuantite());
                 }
         } catch (Exception ex) {
                     Logger.getLogger(Commande.class.getName()).log(Level.SEVERE, null, ex);
                    this.getServletContext().getRequestDispatcher( "/WEB-INF/ProblemeStock.jsp").forward( request, response );
                                 }
                        }
        else
              {
             this.getServletContext().getRequestDispatcher( "/WEB-INF/ProblemeStock.jsp").forward( request, response ); 
              }
this.getServletContext().getRequestDispatcher( "/WEB-INF/AfficheCommande.jsp").forward( request, response );  
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
