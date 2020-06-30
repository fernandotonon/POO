/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.aplicacao.banco.Conexao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tonon
 */
public class animais extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
              
        String animal = request.getParameter("animal");
        int quantidadeAnimais = 1;
        String nome = request.getParameter("nome");
        String raca = request.getParameter("raca");

        Animal animalEscolhido = (Animal) Class.forName(animal).newInstance();

        animalEscolhido.setNome(nome);
        animalEscolhido.setRaca(raca);
        
        String resultadosQuery = "<br><h1>Animais já adicionados:</h1>";
        try {
            Connection conn = Conexao.abrir();
            String query = "insert into animal(obj) values(?)";
            PreparedStatement prepStmt = conn.prepareStatement(query);
            prepStmt.setObject(1, animalEscolhido);
            prepStmt.executeUpdate();
            prepStmt.close();
            
            query = "select * from animal";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("idanimal");
                Animal animalDes = (Animal) rs.getObject("obj");
                
                resultadosQuery+="<br>"+animalDes.getClass().getName()+": "+animalDes.getNome()
                        +" - raça: "+animalDes.getRaca()
                        +" - emite o som: "+animalDes.emitirSom();
                System.out.println(id+" - "+animalDes.emitirSom());
            }
            st.close();
            conn.close();

            
        } catch (Exception ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet animais</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("Animal escolhido: " + animal);
            out.println("<br>Quantidade de patas: " + animalEscolhido.getQtdPatas());
            out.println("<br>Voa: " + (animalEscolhido.isVoa()?"sim":"não"));
            out.println("<br>Comestível no Ocidente: " + (animalEscolhido.isComestivelOcidente()?"sim":"não"));
            
            if(animalEscolhido.isComestivelOcidente())
                out.println("<br>Receita: " + animalEscolhido.receitaPreparo());
            
            out.println("<br>Emite o som:");
            
            for(int i=0; i<quantidadeAnimais;i++){
                out.println("<br>" + animalEscolhido.emitirSom());
            }
            
            out.println(resultadosQuery);
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(animais.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold>

}
