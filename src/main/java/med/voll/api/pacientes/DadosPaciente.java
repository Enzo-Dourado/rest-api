package med.voll.api.pacientes;

import med.voll.api.endereco.Endereco;

public record DadosPaciente(
    String nome,
    String email,
    long telefone, 
    long cpf,
    Endereco endereco) {

}
