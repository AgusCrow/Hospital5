package DAO.Citas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;


public interface CitaRepository extends JpaRepository<CitasMedica, Long> {

    @Query("SELECT c FROM CitasMedica c WHERE c.motivo = :motivo AND c.fechaHora = :fecha")
    List<CitasMedica> buscarPorMotivoYFecha(@Param("motivo") String motivo, @Param("fecha") Date fecha);
}
