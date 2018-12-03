/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import DAO.*;
import VO.*;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis
 */
public class ProveedorServlet extends HttpServlet {

    ProveedorDAO proveedor;
    private List<Proveedor> listProdutos;
    List<Proveedor> inven = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        this.proveedor = new ProveedorDAO();

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
        doPost(request, response);
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
        String txtValop = request.getParameter("txtValOpe");
        JSONArray varJsonArrayP = new JSONArray();
        response.setContentType("text/html");
        PrintWriter escritor = response.getWriter();

        String idp = request.getParameter("idp");
        String correo = request.getParameter("pcorreo");

        System.out.println(txtValop);
        if (txtValop != null) {
            System.out.println("  botn");
            if (txtValop.equalsIgnoreCase("GU")) {
                int idP = Integer.parseInt(idp);

                Proveedor pro = new Proveedor(idP, correo);

                try {
                    proveedor.insert(pro);
                } catch (SQLException ex) {
                    Logger.getLogger(ProveedorServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else if (txtValop.equalsIgnoreCase("MU")) {
                try {
                    System.out.println(txtValop);
                    inven = proveedor.findAll();
                } catch (SQLException ex) {
                    Logger.getLogger(InventarioServlet2.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (inven != null) {
                    JSONArray varJObjectLista = metGetLista(inven, varJsonArrayP);
                    escritor.print(varJObjectLista);
                } else {
                    JSONArray varJObjectLista = new JSONArray();
                    escritor.print("null");
                }
            }
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

    public JSONArray metGetLista(List<Proveedor> in, JSONArray varJsonArrayP) {

        JSONObject varJsonObjectResultado = new JSONObject();
        try {
            for (int i = 0; i < in.size(); i++) {
                JSONObject varJsonObjectP = new JSONObject();

                System.out.println("------------------------");
                Proveedor p = in.get(i);
                varJsonObjectP.put("id", p.getId());
                varJsonObjectP.put("correo", p.getCorreo());
                varJsonArrayP.add(varJsonObjectP);
                varJsonObjectP = (JSONObject) varJsonArrayP.get(i);
                System.out.println("-------------------");
                System.out.println(varJsonObjectP.toJSONString());
                System.out.println("-----------------------------");
                System.out.println(varJsonArrayP.get(i));

            }
            varJsonObjectResultado.put("Result", "OK");
            varJsonObjectResultado.put("Records", varJsonArrayP);
        } catch (Exception e) {
            e.printStackTrace();
            varJsonObjectResultado.put("Result", "ERROR");
            varJsonObjectResultado.put("Message", e.getMessage());
        }
        return varJsonArrayP;
    }

}
