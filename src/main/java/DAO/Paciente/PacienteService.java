package DAO.Paciente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void crearPaciente(String nombreCompleto, Date fechaNacimiento, String genero) {
        Paciente paciente = new Paciente();
        paciente.setNombreCompleto(nombreCompleto);
        paciente.setFechaNacimiento(fechaNacimiento);
        paciente.setGenero(genero);

        pacienteRepository.save(paciente);
    }
}