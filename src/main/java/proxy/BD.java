package proxy;

import java.util.HashMap;
import java.util.Map;

public class BD {
    private static Map<Integer, FichaPaciente> pacientes = new HashMap<>();

    public static FichaPaciente getFichaPaciente(Integer codigo) {
        return pacientes.get(codigo);
    }

    public static void addPaciente(FichaPaciente paciente) {
        pacientes.put(paciente.getCodigo(), paciente);
    }
}
