package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.pacientes.DadosPaciente;
import med.voll.api.pacientes.Paciente;
import med.voll.api.pacientes.PacientesRepository;

@RestController
@RequestMapping("/pacientes")

public class PacientesController {
    
    @Autowired
    private PacientesRepository repository;

    @PostMapping
    @Transactional
    public void cadastroPaciente(@RequestBody @Valid DadosPaciente dadosPaciente) {
        repository.save(new Paciente(dadosPaciente));
    }

}
