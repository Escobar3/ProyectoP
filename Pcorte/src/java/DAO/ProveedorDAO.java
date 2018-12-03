/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Producto;
import VO.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis
 */
public class ProveedorDAO implements IBaseDatos<Proveedor> {

    @Override
    public boolean insert(Proveedor t) throws SQLException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Proveedor(id_Proveedor,correo) values (?,?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId());
            preparedStmt.setString(2, t.getCorreo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;

    }

    @Override
    public boolean update(Proveedor t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Proveedor t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proveedor> findAll() throws SQLException {
        List<Proveedor> productos = null;
        String query = "Select * from Producto ";
        Connection connection = Conexion.getConnection();
        System.out.println("asdfsdgsgsdgsgdcdgdgv");
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id_P = 0;
            String nombre = null;
            double precio = 0.0;
            int cantidad = 0;
            while (rs.next()) {
                if (productos == null) {
                    productos = new ArrayList<Proveedor>();
                }

                Proveedor registro = new Proveedor();
                registro = new Proveedor();
                id_P = rs.getInt("id_Proveedor");
                registro.setId(id_P);
                nombre = rs.getString("correo");
                registro.setCorreo(nombre);

                registro = new Proveedor(id_P, nombre);
                productos.add(registro);
            }

            System.out.println("daoooooooooo");
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return productos;
    }
;

}
