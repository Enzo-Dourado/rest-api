document.addEventListener('DOMContentLoaded', function() {
    
    const btnPaciente = document.getElementById('btn-paciente');
    const btnMedico = document.getElementById('btn-medico');
    const formPaciente = document.getElementById('formulario-paciente');
    const formMedico = document.getElementById('formulario-medico');

    if (btnPaciente) {
        btnPaciente.addEventListener('click', () => {
            formPaciente.classList.add('active');
            formMedico.classList.remove('active');
            btnPaciente.classList.add('active');
            btnMedico.classList.remove('active');
        });
    }

    if (btnMedico) {
        btnMedico.addEventListener('click', () => {
            formMedico.classList.add('active');
            formPaciente.classList.remove('active');
            btnMedico.classList.add('active');
            btnPaciente.classList.remove('active');
        });
    }


    const themeDefaultBtn = document.getElementById('theme-default');
    const themeDarkBtn = document.getElementById('theme-dark');
    const themeHighContrastBtn = document.getElementById('theme-high-contrast');
    const body = document.body;


    const setTheme = (themeName) => {

        body.classList.remove('dark-theme', 'high-contrast-theme');
        

        if (themeName !== 'default') {
            body.classList.add(themeName);
        }

        localStorage.setItem('selectedTheme', themeName);
    };

    themeDefaultBtn.addEventListener('click', () => setTheme('default'));
    themeDarkBtn.addEventListener('click', () => setTheme('dark-theme'));
    themeHighContrastBtn.addEventListener('click', () => setTheme('high-contrast-theme'));

    const savedTheme = localStorage.getItem('selectedTheme');
    if (savedTheme) {
        setTheme(savedTheme);
    }
});

document.addEventListener("DOMContentLoaded", () => {
  const form = document.getElementById("form-paciente");

  form.addEventListener("submit", async function (e) {
    e.preventDefault();

    const nome = document.getElementById("pac-nome").value;
    const email = document.getElementById("pac-email").value;
    const telefone = document.getElementById("pac-telefone").value;
    const cpf = document.getElementById("pac-cpf").value;
    const logradouro = document.getElementById("pac-logradouro").value;
    const bairro = document.getElementById("pac-bairro").value;
    const cep = document.getElementById("pac-cep").value;
    const cidade = document.getElementById("pac-cidade").value;
    const uf = document.getElementById("pac-uf").value;
    const numero = document.getElementById("pac-numero").value;
    const complemento = document.getElementById("pac-complemento").value;

    const paciente = {
      nome: nome,
      email: email,
      telefone: telefone,
      cpf: cpf,
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
      const resposta = await fetch("http://localhost:8080/pacientes", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(paciente)
      });

      if (resposta.ok) {
        alert("Paciente cadastrado com sucesso!");
        form.reset();
      } else {
        alert("Erro ao cadastrar paciente.");
      }
    } catch (erro) {
      console.error("Erro na requisição:", erro);
    }
  });
});
