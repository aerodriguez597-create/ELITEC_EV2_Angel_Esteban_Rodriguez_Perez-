
package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import entity.Receta;
import util.MySqlDBConexion;

public class RecetaModel {
    public int insertaReceta(Receta receta) {
        int insertados = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = MySqlDBConexion.getConexion();
            String sql = "INSERT INTO receta(NombrePaciente, NombreMedicamento, Dosis, Frecuencia, Duracion, FechaEmision, Indicaciones, IdTipoReceta) VALUES(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);

            ps.setString(1, receta.getNombrePaciente());
            ps.setString(2, receta.getNombreMedicamento());
            ps.setString(3, receta.getDosis());
            ps.setString(4, receta.getFrecuencia());
            ps.setInt(5, receta.getDuracion());
            ps.setDate(6, java.sql.Date.valueOf(receta.getFechaEmision()));
            ps.setString(7, receta.getIndicaciones());
            ps.setInt(8, receta.getTipoReceta().getIdTipoReceta());

            System.out.println("SQL: " + ps.toString());
            insertados = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return insertados;
    }
}