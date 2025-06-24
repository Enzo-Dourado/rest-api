package med.voll.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.pacientes.DadosListagemPaciente;
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

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(Pageable pagina) {
        return repository.findAll(pagina).map(DadosListagemPaciente:: new);
    }
}
