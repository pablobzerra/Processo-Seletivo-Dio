package candidaturas;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] selecionados = {
            "FELIPE",
            "JOANA",
            "MARIA",
            "JULIO",
            "DENISE"
        };
        //System.out.println("teste");
        //analisarCandidatos(2000.0);
        //analisarCandidatos(1900.0);
        //analisarCandidatos(2200.0);

        selecaoCadidatos();
        mostrarSelecionados();

        for (String candidato: selecionados) {
            ligarCandidato(candidato);
        }
    }

    static void ligarCandidato(String candidato) {
        int tentativas = 1; //tentativas de ligacoes
        boolean continuarTentando = true;  //Continuar ligando para o candidato caso nao atenda
        boolean atendeu = false; //verificar se o candidatl atendeu

        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativas++;
            } else {
                System.err.println("O candidato " + candidato + " Atendeu a ligacao!");
            }


        } while (continuarTentando && tentativas < 3);
        
        if (atendeu) {
            System.out.println("Conseguimos realizar contato com o candidato " + candidato + " Tentativas realizadas " + tentativas);
        } else {
            System.out.println("Nao conssguimos entrar em contato com o " + candidato + " Tentativas realizadas " + tentativas);
        }
    }

    static boolean atender() {
        Random random = new Random();
        int check = random.nextInt(3);
        return check == 1;
        //no curso so colocava return new Random.nextInt(3) == 1; mas por algum motivo deu erro
    }


    static void mostrarSelecionados () {
        String[] selecionados = {
            "FELIPE",
            "JOANA",
            "MARIA",
            "JULIO",
            "DENISE"
        };


        for (int indice = 0; indice < selecionados.length; indice++) {
            String candidato = selecionados[indice];
            int posSelecionado = indice + 1;

            System.out.println("O candidato de n°" + posSelecionado + " é o " + candidato);
        }

        System.out.println("\nForEarch Abreviado:\n");

        for (String candidato: selecionados) {
            System.out.println("O candidato selecionado foi " + candidato);
        }
    }

    //void nao retorna a nada
    static void analisarCandidatos(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("FAZER UMA CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO OS DEMAIS CANDIDATOS");
        }
    }


    //void: Nao retorna a nada
    static void selecaoCadidatos() {
        String [] candidatos = {
            "JOAO",
            "MARIA",
            "ENZO",
            "JULIO",
            "CLEIDE",
            "JOSE",
            "NEYMAR",
            "DENISE",
            "ANDERSON",
            "LUCIA",
            "RAFAEL",
            "GABRIEL"
        };

        int numSelecionados = 0;
        int posCadidatos = 0; // posicao do array

        double salarioBase = 2000.0;

        while (numSelecionados < 5 && posCadidatos < candidatos.length) {
            String candidato = candidatos[posCadidatos];
            double salarioPretendido = valorPretendido();
            

            System.out.println("O candidato " + candidato + " solicitou este valor de salario => " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga\n");
                numSelecionados++;
            } else {
                System.out.println("O candidato " + candidato + " nao foi selecionado para a vaga\n");
            }

            posCadidatos++;

        }
    }


    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);
    }
}
