package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.DadosMedicos;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController
@RequestMapping("/medicos")

public class MedicosController {

    @Autowired
    private MedicoRepository repository;
    
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedicos dadosMedicos) {
        repository.save(new Medico(dadosMedicos));
    }


    @GetMapping
    public Page<DadosListagemMedico> listarMedico(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagina) {
        return repository.findAll(pagina).map(DadosListagemMedico:: new);
    }


    @PutMapping
    @Transactional
    public void atualizacaoMedico(@RequestBody @Valid Dados) {

    }
}
