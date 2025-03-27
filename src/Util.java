import java.text.DecimalFormat;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.*;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Util {

    private BilheteUnico[] bilhete = new BilheteUnico[3];
    private int index = 0;

    public void menuPrincipal() {

        int opcao = 0;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";

        do {

            opcao = parseInt(showInputDialog(menu));

            switch (opcao) {
                case 1:
                    menuAdmin();
                    break;
                case 2:
                    menuUsuario();
                    break;

            }

        } while(opcao != 3);

    }

    private void menuAdmin() {

        int opcao;
        String menu = "MENU PRINCIPAL ADMINISTRADOR\n";

        menu += "1. Emitir bilhete\n";
        menu += "2. Listar bilhete\n";
        menu += "3. Excluir bilhete\n";
        menu += "4. Sair\n";

        do {

            opcao = parseInt(showInputDialog(menu));

            switch(opcao) {
                case 1:
                    emitirBilhete();
                    break;
                case 2:
                    listarBilhete();
                    break;
                case 3:
                    excluirBilhete();
                    break;

            }

        } while(opcao != 4);

    }

    private void emitirBilhete() {

        String nome, perfil;
        long cpf;

        if (index < bilhete.length) {
            nome = showInputDialog("Nome do usuário: ");
            cpf = parseLong(showInputDialog("CPF do usuário: "));
            perfil = showInputDialog("Estudante ou Professor ou Comum: ");

            bilhete[index] = new BilheteUnico(nome, cpf, perfil);

            index++;

        } else {
            showMessageDialog(null, "Procure um posto de atendimento");

        }

    }

    private void listarBilhete() {

        DecimalFormat df = new DecimalFormat("0.00");

        String aux = "";

        for (int i = 0; i < index; i++) {

            aux += "Número do bilhete: " + bilhete[i].numeroBilhete + "\n";
            aux += "Saldo do bilhete: R$" + df.format(bilhete[i].saldo) + "\n";
            aux += "Nome do usuário do bilhete: " + bilhete[i].usuario.nome + "\n";
            aux += "Perfil do usuário do bilhete: " + bilhete[i].usuario.perfil + "\n";
            aux += "CPF do usuário do bilhete: " + bilhete[i].usuario.cpf + "\n\n";

        }

        showMessageDialog(null, aux);

    }

    private void menuUsuario() {

        int opcao;
        String menu = "MENU PRINCIPAL USUÁRIO\n";

        menu += "1. Carregar bilhete\n";
        menu += "2. Consultar saldo\n";
        menu += "3. Passar na catraca\n";
        menu += "4. Sair\n";

        do {

            opcao = parseInt(showInputDialog(menu));

            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida! Tente novamente.");

            } else {

                switch(opcao) {
                    case 1:
                        carregarBilhete();
                        break;
                    case 2:
                        consultarSaldo();
                        break;
                    case 3:
                        passarNaCatraca();
                        break;

                }

            }

        } while(opcao != 4);

    }

    private void carregarBilhete() {

        int indice = pesquisar();
        double valor;

        if (indice != -1) {
            valor = parseDouble(showInputDialog("Valor da recarga: "));

            bilhete[indice].carregarBilhete(valor);

        }

    }

    private void consultarSaldo() {

        int indice = pesquisar();

        if (indice != -1) {
            showMessageDialog(null, "Saldo = R$ " + bilhete[indice].consultarSaldo());

        }

    }

    private void passarNaCatraca() {

        int indice = pesquisar();

        if (indice != -1) {
            showMessageDialog(null, bilhete[indice].passarCatraca());

        }

    }

    private int pesquisar() {

        long cpf = parseLong(showInputDialog("Informe o CPF: "));

        for (int i = 0; i < index; i++) {

            if (bilhete[i].usuario.cpf == cpf) {
                return (i);

            }

        }

        showMessageDialog(null, "O CPF: " + cpf + " Não foi encontrado!");

        return (-1);

    }

    private void excluirBilhete() {

        int indice = pesquisar();
        int resposta;

        if (indice != -1) {
            resposta = showConfirmDialog(null, "Tem certeza de que deseja excluir o bilhete?");

            if (resposta == YES_OPTION) {
                bilhete[indice] = bilhete[index - 1];
                index--;

            }

        }

    }

}// class