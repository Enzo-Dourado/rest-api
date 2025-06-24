
document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("form-medico");

  form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const nome = document.getElementById("med-nome").value;
    const email = document.getElementById("med-email").value;
    const telefone = document.getElementById("med-telefone").value;
    const crm = document.getElementById("med-crm").value;
    const especialidade = document.getElementById("med-especialidade").value;
    const logradouro = document.getElementById("med-logradouro").value;
    const bairro = document.getElementById("med-bairro").value;
    const cep = document.getElementById("med-cep").value;
    const cidade = document.getElementById("med-cidade").value;
    const uf = document.getElementById("med-uf").value;
    const numero = document.getElementById("med-numero").value;
    const complemento = document.getElementById("med-complemento").value;

    const medico = {
      nome: nome,
      email: email,
      telefone: telefone,
      crm: crm,
      especialidade: especialidade,
      endereco: {
          logradouro: logradouro,
          bairro: bairro,
          cep: cep,
          cidade: cidade,
          uf: uf,
          numero: numero,
          complemento: complemento
      }
    };

    try {
      const resposta = await fetch("http://localhost:8080/medicos", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(medico)
      });

      if (resposta.ok) {
        alert("Médico cadastrado com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar médico.");
      }
    } catch (erro) {
      console.error("Erro na requisição:", erro);
    }
    })
});