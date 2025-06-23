package med.voll.api.medico;

public record DadosMedicos(
    String nome,
    String email,
    String crm, 
    Especialidade especialidade, 
    MedicoEndereco endereco) {

}
