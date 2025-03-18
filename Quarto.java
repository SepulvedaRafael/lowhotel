public class Quarto {
    private int numero;
    private String tipo;
    private int capacidade;
    private double preco;

    public static Settings settings = new Settings();

    public Quarto(int numero, String tipo, int capacidade, double preco) {
        this.numero = numero;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.preco = preco;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public final static void cadastroQuarto() {
        System.out.println("+---------------------------------+");
        System.out.println("|     CADASTRAMENTO DE QUARTO     |");
        System.out.println("+---------------------------------+");
    }

    public static void cadastrarQuarto(Hotel hotel) {
        cadastroQuarto();
        System.out.print("Número do Quarto: ");
        int numero_quarto = settings.sc.nextInt();
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroQuarto();
        System.out.println("Modelo: Simples | Casal");
        System.out.print("Tipo do Quarto: ");
        String tipo_quarto = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroQuarto();
        System.out.print("Capacidade do Quarto: ");
        int capacidade_quarto = settings.sc.nextInt();
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroQuarto();
        System.out.println("Modelo: XX,XX");
        System.out.print("Preço do Quarto: R$");
        double preco_quarto = settings.sc.nextDouble();

        Quarto quarto = new Quarto(numero_quarto, tipo_quarto, capacidade_quarto, preco_quarto);
        hotel.cadastrarQuarto(quarto);
        Settings.limparConsole();
    }

    public static void mostrarQuartos(Hotel hotel) {
        while (true) {
            System.out.println("+--------------------------------+");
            System.out.println("|      Relatório de Quartos      |");
            System.out.println("+--------------------------------+");
            for (Quarto quarto : hotel.getQuartos()) {
                System.out.println("Número do Quarto: " + quarto.getNumero());
                System.out.println("Tipo do Quarto: " + quarto.getTipo());
                System.out.println("Capacidade do Quarto: " + quarto.getCapacidade());
                System.out.println("Preço do Quarto: R$" + quarto.getPreco());
                System.out.println("+---------------------------------+");
            }
            System.out.print("Digite 0 para sair: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();

            if (opcao == 0) {
                Settings.limparConsole();
                break;
            }
        }
    }

    public static void atualizarQuarto(Hotel hotel) {
        while (true) {
            System.out.println("+---------------------------------+");
            System.out.println("|      Atualização de Quarto      |");
            System.out.println("+---------------------------------+");
            int numero = 1;
            for (Quarto quarto : hotel.getQuartos()) {
                System.out.println(numero + ". Quarto Nº" + quarto.getNumero() + " - " + quarto.getTipo());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                int numero_quarto = 1;
                for (Quarto quarto : hotel.getQuartos()) {
                    if (opcao == numero_quarto) {
                        while (true) {
                            System.out.println("+---------------------------------+");
                            System.out.println("|      Atributos dos Quartos      |");
                            System.out.println("+---------------------------------+");
                            System.out.println("| 1. Numero                       |");
                            System.out.println("| 2. Tipo                         |");
                            System.out.println("| 3. Capacidade                   |");
                            System.out.println("| 4. Preço                        |");
                            System.out.println("| 5. Sair                         |");
                            System.out.println("+---------------------------------+");
                            System.out.print("Selecione uma das opções: ");
                            int opcao_atributos = settings.sc.nextInt();
                            settings.sc.nextLine();
                            Settings.limparConsole();

                            if (opcao_atributos == 1) {
                                System.out.println("+---------------------------------+");
                                System.out.println("|    Atribuição de Novo Numero    |");
                                System.out.println("+---------------------------------+");
                                System.out.print("Novo Numero: ");
                                int novo_numero = settings.sc.nextInt();
                                settings.sc.nextLine();
                                quarto.setNumero(novo_numero);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 2) {
                                System.out.println("+---------------------------------+");
                                System.out.println("|     Atribuição de Novo Tipo     |");
                                System.out.println("+---------------------------------+");
                                System.out.print("Novo Tipo: ");
                                String novo_tipo = settings.sc.nextLine();
                                quarto.setTipo(novo_tipo);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 3) {
                                System.out.println("+-----------------------------------+");
                                System.out.println("|   Atribuição de Nova Capacidade   |");
                                System.out.println("+-----------------------------------+");
                                System.out.print("Nova Capacidade: ");
                                int nova_capacidade = settings.sc.nextInt();
                                settings.sc.nextLine();
                                quarto.setCapacidade(nova_capacidade);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 4) {
                                System.out.println("+----------------------------------+");
                                System.out.println("|     Atribuição de Novo Preço     |");
                                System.out.println("+----------------------------------+");
                                System.out.print("Novo Preço: R$");
                                double novo_preco = settings.sc.nextDouble();
                                quarto.setPreco(novo_preco);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 5) {
                                Settings.limparConsole();
                                break;
                            } else {
                                System.out.println("Opção Inválida! Tente novamente!\n");
                            }
                        }
                    }
                    numero_quarto++;
                }
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }

    public static void removerQuarto(Hotel hotel) {
        while (true) {
            System.out.println("+---------------------------------+");
            System.out.println("|        Remoção de Quarto        |");
            System.out.println("+---------------------------------+");
            int numero = 1;
            for (Quarto quarto : hotel.getQuartos()) {
                System.out.println(numero + ". Quarto Nº" + quarto.getNumero() + " - " + quarto.getTipo());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                hotel.getQuartos().remove(opcao - 1);
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }
}