package DAO.Medico;

import com.google.gson.Gson;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoDAO medicoDAO;

    @Autowired
    public MedicoController(MedicoDAO medicoDAO) {
        this.medicoDAO = medicoDAO;
    }

    // GET /medicos - List all medicos
    @GetMapping()
    public String mostrarMedicos() {
        List<Medico> medicos = medicoDAO.buscarTodos();
        Gson gson = new Gson();
        String json = gson.toJson(medicos);
        return "showMedicos?medicos=" + json;
    }

    // GET /medicos/{id} - Get a single medico by ID
    @GetMapping("/{id}")
    public String mostrarMedico(@PathVariable Long id) {
        Medico medico = medicoDAO.buscarPorId(id);
        Gson gson = new Gson();
        String json = gson.toJson(medico);
        return "showMedico?medico=" + json;
    }

    // POST /medicos - Create a new medico
    @PostMapping()
    public String crearMedico(@RequestBody Medico medico) {
        medicoDAO.guardar(medico);
        return "redirect:/medicos";
    }

    // PUT /medicos/{id} - Update an existing medico
    @PutMapping("/{id}")
    public String editarMedico(@PathVariable Long id, @RequestBody Medico medico) {
        medico.setId(id);
        medicoDAO.editar(medico);
        return "redirect:/medicos";
    }

    // DELETE /medicos/{id} - Delete a single medico by ID
    @DeleteMapping("/{id}")
    public String eliminarMedico(@PathVariable Long id) {
        medicoDAO.eliminar(id);
        return "redirect:/medicos";
    }
}