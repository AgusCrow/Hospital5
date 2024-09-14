package DAO.Receta;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

    @Query("SELECT r FROM Receta r WHERE r.fechaCreacion = :fecha")
    List<Receta> buscarPorFecha(@Param("fecha") Date fecha);

    @Query("SELECT COUNT(*) FROM recetas WHERE paciente_id = :idPaciente AND DATEPART(YYYY, fecha_nacimiento) > 2003")
    int buscarConteoDeRecetas(@Param("idPaciente") Long idPaciente);
}