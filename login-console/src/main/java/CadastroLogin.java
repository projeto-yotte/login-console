import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroLogin {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Scanner leitorTexto = new Scanner(System.in);

        Validacoes validacoes = new Validacoes();

        System.out.println("""
                        :::   :::  ::::::::  ::::::::::: ::::::::::: ::::::::::
                        :+:   :+: :+:    :+:     :+:         :+:     :+:
                         +:+ +:+  +:+    +:+     +:+         +:+     +:+
                          +#++:   +#+    +:+     +#+         +#+     +#++:++#
                           +#+    +#+    +#+     +#+         +#+     +#+
                           #+#    #+#    #+#     #+#         #+#     #+#
                           ###     ########      ###         ###     ##########
                                
                Ja tem cadastro?
                - 0 (Caso não)
                - 1 (Caso sim)
                - 2 (Para sair da aplicação)
                """);
        Integer cadastrar = leitor.nextInt();

        String nome ="";
        String email = "";
        String senha = "";
        String usuarioMaquina;
        String ip = "";
        String modelo;
        String so;
        String matricula;
        Boolean todasValidacoes = false;

        String validarEmail;
        String validarSenha;

        ArrayList listaUsers = new ArrayList();
        ArrayList user = new ArrayList();

        do {
            if (cadastrar.equals(0)){
                System.out.println("Fazer cadastro...");

                System.out.println("Digite seu nome:");
                nome = leitorTexto.nextLine();

                System.out.println("Digite seu email:");
                email = leitorTexto.nextLine();

                System.out.println("Digite seu senha:");
                senha = leitorTexto.nextLine();

                System.out.println("Digite sua usuarioMAquina:");
                usuarioMaquina = leitorTexto.nextLine();

                System.out.println("Digite seu IP: ");
                ip = leitorTexto.nextLine();

                System.out.println("Digite o modelo do notebook: ");
                modelo = leitorTexto.nextLine();

                System.out.println("Digite qual SO voce utiliza: ");
                so = leitorTexto.nextLine();

                System.out.println("Digite sua matricula: ");
                matricula = leitorTexto.nextLine();

                Boolean isSenhaValida = validacoes.isSenhaValida(senha);
                Boolean isSenhaComplexa = validacoes.isSenhaComplexa(senha);
                Boolean emailNaoTemEspacos = validacoes.naoTemEspacos(email);
                Boolean isEmailValido = validacoes.isEmailValido(email);

                if(isSenhaValida && emailNaoTemEspacos && isEmailValido && isSenhaComplexa) {
                    todasValidacoes = true;
                } else {
                    System.out.println("Dados inválidos, faça o cadastro novamente!!");
                }

            }
        } while (todasValidacoes.equals(false));

        List userList = validacoes.obterNovaLista();
        userList.add(nome);
        userList.add(email);
        userList.add(senha);

        listaUsers.add(userList);
        System.out.println(listaUsers);
        System.out.println("Cadastro finalizado! você será redirecionado para a tela de login!");

        Boolean todasValidacoesLogin = false;

        do {

            System.out.println("Digite seu email:");
            validarEmail = leitorTexto.nextLine();
            System.out.println("Digite sua senha:");
            validarSenha = leitorTexto.nextLine();
            if (validarEmail.equals(email) && validarSenha.equals(senha)){
                todasValidacoesLogin = true;
            }else {
                System.out.println("Email ou senha incorretas. Tente novamente!");
            }
        }while (todasValidacoesLogin.equals(false));

        System.out.println("Login realizado com sucesso! \uD83D\uDE04");

    }
}
