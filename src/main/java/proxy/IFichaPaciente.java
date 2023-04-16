package proxy;

import java.util.List;

public interface IFichaPaciente {
    List<String> obterDadosPessoais();
    List<String> obterRemedios(Medico funcionario);
}
