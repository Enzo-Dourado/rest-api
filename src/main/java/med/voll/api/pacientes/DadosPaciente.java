package med.voll.api.pacientes;

import med.voll.api.endereco.Endereco;

public record DadosPaciente(
    String nome,
    String email,
    String telefone, 
    String cpf,
    Endereco endereco) {

}
