package DAO.Citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasMedicasService {
    @Autowired
    private CitaRepository citaRepository;

    public List<CitasMedica> getAllCitias() {
        return citaRepository.findAll();
    }

    public CitasMedica saveCita(CitasMedica cita) {
        return citaRepository.save(cita);
    }

    public void deleteCita(Long id) {
        citaRepository.deleteById(id);
    }
}
