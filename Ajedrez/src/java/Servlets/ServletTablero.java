package Servlets;

import Objects.Jugador;
import Objects.Partida;
import Objects.Pieza;
import Objects.Tablero;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
    
    /**f
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
            
            Partida p = (Partida)ses.getAttribute("partida");
                                    
            //coordenadas y valor de objeto ficha            
            String coordenada = request.getParameter("coordenadaServ");
            
            
            String tipoFichaTablero = request.getParameter("objetoNombreServ");           
            
            boolean reset = Boolean.valueOf(request.getParameter("valorPrueba"));
            
            
            if (reset){ // Si se presiona el botón de resetear partida , se reinicia el tablero
                ses.setAttribute("partida", p = new Partida(new Jugador(p.getJugadorBlanco().getNombre(),p.getJugadorBlanco().getEquipo())
                        ,new Jugador(p.getJugadorNegro().getNombre(),p.getJugadorNegro().getEquipo())));
                out.print(p.getTablero().printBoard());                
                return;
            }

            int x,y;
                       
            //out.println("Ronda: "+p.getRonda());
            
           // out.println("Coordenadas:"+coordenada+"\n Ficha:"+tipoFichaTablero);  
            
            
            ArrayList<Pieza> listaCementerioNegros = p.getJugadorBlanco().getCementerio();
            
            ArrayList<Pieza> listaCementerioBlancos = p.getJugadorNegro().getCementerio();
            
            for(Pieza piezaA: listaCementerioNegros){
                 out.println("");
                 out.println("<input type='hidden' class='valorMuertoB' name='valorMuertoB[]' value='"+piezaA.getImage()+"'>");
                 out.println("");
            }
            for(Pieza piezaB: listaCementerioBlancos){
                out.println("");
                out.println("<input type='hidden' class='valorMuertoA' name='valorMuertoA[]' value='"+piezaB.getImage()+"'>");
                out.println("");
            } 
           
            x = Integer.parseInt(Character.toString(coordenada.charAt(0)));
            
            y = Integer.parseInt(Character.toString(coordenada.charAt(1))); 
            
            p.mover(x, y);
            
            out.print(p.getTablero().printBoard());
            
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
