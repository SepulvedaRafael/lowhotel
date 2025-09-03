public class Hospede {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public static Settings settings = new Settings();

    public Hospede(String nome, String cpf, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public final static void cadastroHospede() {
        System.out.println("+--------------------------------+");
        System.out.println("|    CADASTRAMENTO DE HOSPEDE    |");
        System.out.println("+--------------------------------+");
    }

    public static void cadastrarHospede(Hotel hotel) {
        cadastroHospede();
        System.out.print("Nome do Hospede: ");
        String nome_hospede = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroHospede();
        System.out.println("Modelo: 123.456.789-10");
        System.out.print("CPF do Hospede: ");
        String cpf_hospede = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroHospede();
        System.out.println("Modelo: (DDD) XXXXX-XXXX");
        System.out.print("Telefone do Hospede: ");
        String telefone_hospede = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroHospede();
        System.out.println("Modelo: emailexample@example.com");
        System.out.print("E-mail do Hospede: ");
        String email_hospede = settings.sc.nextLine();

        Hospede hospede = new Hospede(nome_hospede, cpf_hospede, telefone_hospede, email_hospede);
        hotel.cadastrarHospede(hospede);
        Settings.limparConsole();
    }

    public static void mostrarHospedes(Hotel hotel) {
        while (true) {
            System.out.println("+---------------------------------+");
            System.out.println("|      Relatório de Hospedes      |");
            System.out.println("+---------------------------------+");
            int numero = 1;
            for (Hospede hospede : hotel.getHospedes()) {
                System.out.println("N°: " + numero);
                System.out.println("Nome: " + hospede.getNome());
                System.out.println("CPF: " + hospede.getCpf());
                System.out.println("Telefone: " + hospede.getTelefone());
                System.out.println("Email: " + hospede.getEmail());
                System.out.println("+---------------------------------+");
                numero++;
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

    public static void atualizarHospede(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|      Atualização de Hospede      |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (Hospede hospede : hotel.getHospedes()) {
                System.out.println(numero + ". " + hospede.getNome() + " - " + hospede.getCpf());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                int numero_hospede = 1;
                for (Hospede hospede : hotel.getHospedes()) {
                    if (opcao == numero_hospede) {
                        while (true) {
                            System.out.println("+----------------------------------+");
                            System.out.println("|      Atributos dos Hospedes      |");
                            System.out.println("+----------------------------------+");
                            System.out.println("| 1. Nome                          |");
                            System.out.println("| 2. CPF                           |");
                            System.out.println("| 3. Telefone                      |");
                            System.out.println("| 4. Email                         |");
                            System.out.println("| 5. Sair                          |");
                            System.out.println("+----------------------------------+");
                            System.out.print("Selecione uma das opções: ");
                            int opcao_atributos = settings.sc.nextInt();
                            settings.sc.nextLine();
                            Settings.limparConsole();

                            if (opcao_atributos == 1) {
                                System.out.println("+---------------------------------+");
                                System.out.println("|     Atribuição de Novo Nome     |");
                                System.out.println("+---------------------------------+");
                                System.out.print("Novo Nome: ");
                                String novo_nome = settings.sc.nextLine();
                                hospede.setNome(novo_nome);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 2) {
                                System.out.println("+--------------------------------+");
                                System.out.println("|     Atribuição de Novo CPF     |");
                                System.out.println("+--------------------------------+");
                                System.out.print("Novo CPF: ");
                                String novo_cpf = settings.sc.nextLine();
                                hospede.setCpf(novo_cpf);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 3) {
                                System.out.println("+-------------------------------------+");
                                System.out.println("|     Atribuição de Novo Telefone     |");
                                System.out.println("+-------------------------------------+");
                                System.out.print("Novo Telefone: ");
                                String novo_telefone = settings.sc.nextLine();
                                hospede.setTelefone(novo_telefone);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 4) {
                                System.out.println("+----------------------------------+");
                                System.out.println("|     Atribuição de Novo Email     |");
                                System.out.println("+----------------------------------+");
                                System.out.print("Novo Email: ");
                                String novo_email = settings.sc.nextLine();
                                hospede.setEmail(novo_email);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 5) {
                                Settings.limparConsole();
                                break;
                            } else {
                                System.out.println("Opção Inválida! Tente novamente!\n");
                            }
                        }
                    }
                    numero_hospede++;
                }
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }

    public static void removerHospede(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|        Remoção de Hospede        |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (Hospede hospede : hotel.getHospedes()) {
                System.out.println(numero + ". " + hospede.getNome() + " - " + hospede.getCpf());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                hotel.getHospedes().remove(opcao - 1);
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }
}