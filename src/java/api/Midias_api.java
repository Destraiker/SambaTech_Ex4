/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import Control.MidiasControl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.Midias;

/**
 *
 * @author Home
 */
@WebServlet(name = "Midias", urlPatterns = {"/Midias"})
public class Midias_api extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void Cadastro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String result = null;

            /* TODO output your page here. You may use following sample code. */
            String Nome = request.getParameter("Nome");
            String URL = request.getParameter("URL");
            String Duracao = request.getParameter("Duracao");

            MidiasControl midia = new MidiasControl();

            result = midia.NovaMidia(Nome, URL, Duracao);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Midias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Resposta: " + result + "</h1>");
            out.println("</body>");
            out.println("</html>");

        }
    }

    protected void Listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String result = null;
            MidiasControl midia_control = new MidiasControl();
            Midias midia = new Midias();
            ArrayList<Midias> lista_midias = new ArrayList();
            if (request.getParameter("Midia") != null) {
                Integer midia_id = Integer.parseInt(request.getParameter("Midia"));

                lista_midias.add(midia_control.ListarMidia(midia_id));
            } else {
                lista_midias = midia_control.ListarMidias();
            }
            System.out.println(lista_midias.size());
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Midias</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Midias Cadastradas: </h1>");
            out.println("<table border='1'><thead><tr>"
                    + "<th>Id</th><th>Nome</th><th>URL</th><th>Duração</th>"
                    + "</tr></thead><tbody>");
            if(lista_midias.get(0) == null){
                out.println("<tr>"
                        + "<td COLSPAN='4'>Nenhuma Midia encontrada</td>"
                        + "</tr>");
            }else if (lista_midias.size() == 1) {
                out.println("<tr>"
                        + "<td>" + lista_midias.get(0).getId() + "</td>"
                        + "<td>" + lista_midias.get(0).getNome() + "</td>"
                        + "<td>" + lista_midias.get(0).getURL() + "</td>"
                        + "<td>" + lista_midias.get(0).getDuracao() + "</td>"
                        + "</tr>");
            } else {
                for (int i = 0; i < lista_midias.size(); i++) {
                    out.println("<tr>"
                            + "<td>" + lista_midias.get(i).getId() + "</td>"
                            + "<td>" + lista_midias.get(i).getNome() + "</td>"
                            + "<td>" + lista_midias.get(i).getURL() + "</td>"
                            + "<td>" + lista_midias.get(i).getDuracao() + "</td>"
                            + "</tr>");
                }
            }
            out.println("</tbody></table>");
            out.println("</body>");
            out.println("</html>");

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
        Listar(request, response);
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
        Cadastro(request, response);
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
