package DAO.Receta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;


@Service
public class RecetaService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static class ObtenerRecetas {
        private int conteo;

        public int getConteo() {
            return conteo;
        }

        public void setConteo(int conteo) {
            this.conteo = conteo;
        }
    }

    public void obtenerRecetasDePacientesMayoresA18(Long idPaciente) {
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        List<ObtenerRecetas> resultados = jdbcTemplate.queryForList("SELECT COUNT(*) FROM recetas WHERE paciente_id = ? AND YEAR(fecha_creacion) > ?", new Object[]{idPaciente, anioActual}, ObtenerRecetas.class);

        for (ObtenerRecetas resultado : resultados) {
            System.out.println(resultado.getConteo());
        }
    }


    public static class RecetaRowMapper implements RowMapper<ObtenerRecetas> {

        @Override
        public ObtenerRecetas mapRow(ResultSet rs, int rowNum) throws SQLException {
            ObtenerRecetas obtenerRecetas = new ObtenerRecetas();
            obtenerRecetas.setConteo(rs.getInt("COUNT(*)"));
            return obtenerRecetas;
        }


    }
}
