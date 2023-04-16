package proxy;

public class Medico {
    private String nome;
    private boolean especialista;

    private String especialidade;

    public Medico(String nome, boolean especialista, String especialidade) {
        this.nome = nome;
        this.especialista = especialista;
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isEspecialista() {
        return especialista;
    }

    public void setEspecialista(boolean especialista) {
        this.especialista = especialista;
    }
}
