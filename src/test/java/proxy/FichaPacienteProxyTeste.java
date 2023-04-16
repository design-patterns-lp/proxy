package proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class FichaPacienteProxyTeste {

    @BeforeEach
    void setUp() {
        BD.addPaciente(new FichaPaciente(1234,"João da Silva","Ortopedia","Omeprazol","Novalgina"));
        BD.addPaciente(new FichaPaciente(1235,"Cléberson de Souza","Cardiologia","Metoprolol","Enalapril"));
    }

    @Test
    void deveRetornarDadosPessoaisPaciente() {
        FichaPacienteProxy paciente = new FichaPacienteProxy(1234);

        assertEquals(Arrays.asList("João da Silva", "Ortopedia"), paciente.obterDadosPessoais());
    }

    @Test
    void deveRetornarRemediosPaciente() {
        Medico medico = new Medico("Ana", true, "Ortopedia");
        FichaPacienteProxy paciente = new FichaPacienteProxy(1234);

        assertEquals(Arrays.asList("Omeprazol", "Novalgina"), paciente.obterRemedios(medico));
    }

    @Test
    void deveRetonarExcecaoUsuarioNaoAutorizadoConsultarRemediosPaciente() {
        try {
            Medico medico = new Medico("Joana", false, "Clinico Geral");
            FichaPacienteProxy paciente = new FichaPacienteProxy(1235);

            paciente.obterRemedios(medico);
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("Médico não autorizado", e.getMessage());
        }
    }
}