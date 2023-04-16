package proxy;

import java.util.List;

public class FichaPacienteProxy implements IFichaPaciente {

    private FichaPaciente paciente;

    private Integer codigo;

    public FichaPacienteProxy(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public List<String> obterDadosPessoais() {
        if (this.paciente == null) {
            this.paciente = new FichaPaciente(this.codigo);
        }
        return this.paciente.obterDadosPessoais();
    }

    @Override
    public List<String> obterRemedios(Medico medico) {
        if (!medico.isEspecialista() && (!medico.getEspecialidade().trim().equals(paciente.getEspecialidade()))){
            throw new IllegalArgumentException("Médico não autorizado");
        }
        if (this.paciente == null) {
            this.paciente = new FichaPaciente(this.codigo);
        }
        return this.paciente.obterRemedios(medico);
    }
}
