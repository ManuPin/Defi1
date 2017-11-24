/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.defi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.defi.magasin.Produit;
import java.util.Map;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Formation16
 */
public class AfficheProduit extends HttpServlet {
 Produit gele = new Produit(1,"gele royale",55, 15);
 Produit miel =  new Produit(2,"miel",15, 10);
 Produit ruche = new Produit(3,"ruche 12 Cadres",1, 12) ;
 Produit ruchette = new Produit(4,"ruchette 7 Cadres",65, 8) ;
 Produit cadre = new Produit(5,"cadre", 2 , 180) ;
 Produit enfumoire = new Produit(6,"enfumoire", 20 , 20) ;
 Produit cire = new Produit(7,"cire", 20 , 200) ;
  int compteur = 0;
  int getCompteur() {
  return compteur++;
}
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
             HttpSession session = request.getSession(true);
            java.util.Map<Integer, Produit> mapproduit = new java.util.HashMap();
            mapproduit.put(1,gele);
            mapproduit.put(2,miel);
            mapproduit.put(3,ruche );
            mapproduit.put(4,ruchette );
            mapproduit.put(5,cadre );
            mapproduit.put(6,enfumoire );
            mapproduit.put(7,cire );
            
       
        session.setAttribute("listeProduit", mapproduit);
        session.getAttribute("panier");  
        
      
           if ((request.getParameter("panier") != null)){
               this.getServletContext().getRequestDispatcher( "/GetPanier").forward( request, response );     
            String NumProduit = request.getParameter("panier");
                int intindexproduit=Integer.parseInt (NumProduit);
                int PanierAjout = 1;
                out.println("<h1>Passage pannier parametre non null  " + intindexproduit + "</h1>");              
            }
           else{
              this.getServletContext().getRequestDispatcher( "/WEB-INF/Affiche.jsp").forward( request, response ); 
           }
             
        
        Produit ProduitPanier = (Produit)session.getAttribute("panier");
        
 
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
        try (PrintWriter out = response.getWriter()) {
            
             
    
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AfficheProduit " + "passage GET " + "</h1>");
            out.println("</body>");
            out.println("</html>");
   
            processRequest(request, response);
    }
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
        try (PrintWriter out = response.getWriter()) {
        
           processRequest(request, response);
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
