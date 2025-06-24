package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;

public record Endereco(
    @NotBlank
    String logradouro,

    @NotBlank
    String bairro,

    @NotBlank
    String cep,

    @NotBlank
    String cidade,

    @NotBlank
    String uf,

    String numero,
    String complemento
    ) {  
}
