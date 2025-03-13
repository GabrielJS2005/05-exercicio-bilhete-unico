import java.util.Random;

public class BilheteUnico {

    // criando uma constante
    static final double TARIFABASE = 5.20;

    double saldo;
    long numeroBilhete;
    Usuario usuario;

    public BilheteUnico(String nome, long cpf, String perfil) {

        Random random = new Random();
        numeroBilhete = random.nextLong(1000, 10000);

        usuario = new Usuario(cpf, nome, perfil);

    }

    // método para carregar o bilhete
    public double carregarBilhete(double valor) {

      saldo += valor;

      return(saldo);

    }

    // Método para consultar o saldo do bilhete
    public double consultarSaldo() {

        return(saldo);

    }

    // Método para passar na catraca
    public String passarCatraca() {

        double debito = TARIFABASE / 2;

        if (usuario.perfil.equalsIgnoreCase("comum")) {
            debito = TARIFABASE;

        }

        if (saldo >= debito) {
            saldo -= debito;

            return("Catraca Liberada");

        }

        return("Saldo Insuficiente");

    }




}