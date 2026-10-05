package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.TipoReceta;
import util.MySqlDBConexion;

public class TipoRecetaModel {
    public List<TipoReceta> listarTipoReceta() {
        List<TipoReceta> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            conn = MySqlDBConexion.getConexion();
            String sql = "SELECT * FROM tiporeceta";
            pstm = conn.prepareStatement(sql);
            System.out.println("SQL: " + pstm.toString());
            rs = pstm.executeQuery();
            while (rs.next()) {
                TipoReceta tipoReceta = new TipoReceta();
                tipoReceta.setIdTipoReceta(rs.getInt("IdTipoReceta"));
                tipoReceta.setDescripcion(rs.getString("Descripcion"));
                lista.add(tipoReceta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return lista;
    }
}