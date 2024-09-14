package DAO.Medico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public void crearMedico(String nombreCompleto, String especialidad, String numeroColegiado) {
        Medico medico = new Medico();
        medico.setNombreCompleto(nombreCompleto);
        medico.setEspecialidad(especialidad);
        medico.setNumeroColegiado(numeroColegiado);

        medicoRepository.save(medico);
    }
}