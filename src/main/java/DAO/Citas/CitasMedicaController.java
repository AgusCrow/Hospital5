package DAO.Citas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitasMedicaController {
    @Autowired
    private CitasMedicasService citaService;

    @GetMapping
    public List<CitasMedica> getAllCitias() {
        return citaService.getAllCitias();
    }

    @PostMapping
    public CitasMedica saveCita(@RequestBody CitasMedica cita) {
        return citaService.saveCita(cita);
    }

    @DeleteMapping("/{id}")
    public void deleteCita(@PathVariable Long id) {
        citaService.deleteCita(id);
    }
}
