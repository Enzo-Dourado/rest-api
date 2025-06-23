package med.voll.api.medico;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MedicoEndereco {

    private String logradouro;
    private String bairro;
    private long cep;
    private String uf;
    private int numero;
    private String complemento;

    public MedicoEndereco(Endereco dadosMedicos) {
        this.logradouro = dadosMedicos.logradouro();
        this.bairro = dadosMedicos.bairro();
        this.cep = dadosMedicos.cep();
        this.uf = dadosMedicos.uf();
        this.numero = dadosMedicos.numero();
        this.complemento = dadosMedicos.complemento();
    }

}

