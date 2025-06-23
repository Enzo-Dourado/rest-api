document.addEventListener('DOMContentLoaded', function() {
    
    // --- LÓGICA DAS ABAS (JÁ EXISTENTE) ---
    const btnPaciente = document.getElementById('btn-paciente');
    const btnMedico = document.getElementById('btn-medico');
    const formPaciente = document.getElementById('form-paciente');
    const formMedico = document.getElementById('form-medico');

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

    // --- NOVA LÓGICA PARA O SELETOR DE TEMA ---
    const themeDefaultBtn = document.getElementById('theme-default');
    const themeDarkBtn = document.getElementById('theme-dark');
    const themeHighContrastBtn = document.getElementById('theme-high-contrast');
    const body = document.body;

    // Função para aplicar o tema
    const setTheme = (themeName) => {
        // Remove classes de tema existentes
        body.classList.remove('dark-theme', 'high-contrast-theme');
        
        // Adiciona a nova classe de tema, se não for o padrão
        if (themeName !== 'default') {
            body.classList.add(themeName);
        }

        // Salva a preferência do usuário no localStorage
        localStorage.setItem('selectedTheme', themeName);
    };

    // Event Listeners para os botões de tema
    themeDefaultBtn.addEventListener('click', () => setTheme('default'));
    themeDarkBtn.addEventListener('click', () => setTheme('dark-theme'));
    themeHighContrastBtn.addEventListener('click', () => setTheme('high-contrast-theme'));

    // Verifica se há um tema salvo no localStorage ao carregar a página
    const savedTheme = localStorage.getItem('selectedTheme');
    if (savedTheme) {
        setTheme(savedTheme);
    }
});