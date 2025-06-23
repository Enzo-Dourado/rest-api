package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.medico.MedicoEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco{
    private String logradouro;
    private String bairro;
    private long cep;
    private String uf;
    private int numero;
    private String complemento;

    public Endereco(MedicoEndereco dadosMedico) {
        this.logradouro = dadosMedico.logradouro();
        this.bairro = dadosMedico.bairro();
        this.cep = dadosMedico.cep();
        this.uf = dadosMedico.uf();
        this.numero = dadosMedico.numero();
        this.complemento = dadosMedico.complemento();
    }

}
