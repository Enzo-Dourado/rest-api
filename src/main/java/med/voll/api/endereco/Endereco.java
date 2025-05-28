package med.voll.api.endereco;

public record Endereco(
    String logradouro,
    String bairro,
    long cep,
    String uf,
    int numero,
    String complemento
    ) {  
}
