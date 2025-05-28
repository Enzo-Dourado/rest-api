package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.pacientes.DadosPaciente;

@RestController
@RequestMapping("/pacientes")

public class PacientesController {
    
    @PostMapping
    public void cadastroPaciente(@RequestBody DadosPaciente dadosPaciente) {
        System.out.println(dadosPaciente);
    }

}
