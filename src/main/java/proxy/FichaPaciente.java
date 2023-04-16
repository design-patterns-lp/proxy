package proxy;

import java.util.Arrays;
import java.util.List;

public class FichaPaciente implements IFichaPaciente {

    private Integer codigo;
    private String nomePaciente;
    private String especialidade;
    private String remedio1;
    private String remedio2;

    public FichaPaciente(Integer codigo) {
        this.codigo = codigo;
        FichaPaciente objeto = BD.getFichaPaciente(codigo);
        this.nomePaciente = objeto.nomePaciente;
        this.especialidade = objeto.especialidade;
        this.remedio1 = objeto.remedio1;
        this.remedio2 = objeto.remedio2;
    }

    public FichaPaciente(Integer codigo, String nomePaciente, String especialidade, String remedio1, String remedio2) {
        this.codigo = codigo;
        this.nomePaciente = nomePaciente;
        this.especialidade = especialidade;
        this.remedio1 = remedio1;
        this.remedio2 = remedio2;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    @Override
    public List<String> obterDadosPessoais() {
        return Arrays.asList(this.nomePaciente, this.especialidade);
    }

    @Override
    public List<String> obterRemedios(Medico funcionario) {
        return Arrays.asList(this.remedio1, this.remedio2);
    }
}
