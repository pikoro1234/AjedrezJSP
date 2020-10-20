package Servlets;

import Objects.Jugador;
import Objects.Partida;
import Objects.Peon;
import Objects.Tablero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author jorge
 */
@WebServlet(name = "ServletTablero", urlPatterns = {"/Tablero"})
public class ServletTablero extends HttpServlet {
    
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
        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta http-equiv='Content-Type' content='text/html'; charset=UTF-8'>");
            out.println("<link rel='stylesheet' href='css/tableStyle.css'>");
            out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>");            
            out.println("<script src='http://code.jquery.com/jquery-1.9.1.js'></script>");
            out.println("<script src=\"js/customTablero.js\"></script>");                               
            out.println("<title>Servlet ServletTablero</title>");  
            out.println("</head>");                                                     
            
            HttpSession ses = request.getSession();
            
           out.println(ses.getAttribute("rand"));
           Partida p = (Partida)ses.getAttribute("partida");
            
            //nombres usuarios
            String nombre1 = request.getParameter("nombre1html");
            
            String nombre2 = request.getParameter("nombre2html");
            
            //equipos
            String t1 = request.getParameter("dato1");
            
            String t2 = request.getParameter("dato2"); 
            
            //creacion de jugadores
            Jugador jugadorUno = new Jugador(nombre1,t1); 
            
            Jugador jugadorDos = new Jugador(nombre2,t2);
                            
            //coordenadas y valor de objeto ficha            
            String coordenada = request.getParameter("coordenadaServ");
            
            String tipoFichaTablero = request.getParameter("objetoNombreServ");           
            
            boolean reset = Boolean.valueOf(request.getParameter("valorPrueba"));
            
            if (reset){ // Si se presiona el botón de resetear partida , se reinicia el tablero
                Tablero.resetTablero();
            }
            int x,y;
           //Partida p = new Partida(jugadorUno,jugadorDos);
            
            out.print(p.getTablero().printBoard()); 
            
            x = Integer.parseInt(Character.toString(coordenada.charAt(0)));
            
            y = Integer.parseInt(Character.toString(coordenada.charAt(1)));
            
            p.getTablero().getPieza(x, y).isPossibleMoving(x, y);
            
            out.println("Ronda: "+p.getRonda());
            out.println("Coordenadas:"+coordenada+"\n Ficha:"+tipoFichaTablero);
            
            p.sumarRonda();
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
