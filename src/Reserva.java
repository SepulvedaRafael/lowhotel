public class Reserva {
    private Hospede hospede;
    private Quarto quarto;
    private String dataInicio;
    private String dataFim;
    private int codigoReserva;

    public static Settings settings = new Settings();

    public Reserva(Hospede hospede, Quarto quarto, String dataInicio, String dataFim, int codigoReserva) {
        this.hospede = hospede;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.codigoReserva = codigoReserva;
    }

    public Hospede getHospede() {
        return hospede;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public int getCodigoReserva() {
        return codigoReserva;
    }

    public void setHospede(Hospede hospede) {
        this.hospede = hospede;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public void setCodigoReserva(int codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public final static void cadastroReserva() {
        System.out.println("+--------------------------------+");
        System.out.println("|    CADASTRAMENTO DE RESERVA    |");
        System.out.println("+--------------------------------+");
    }

    public static void cadastrarReserva(Hotel hotel) {
        cadastroReserva();
        int numero_hospede = 1;
        for (Hospede hospede : hotel.getHospedes()) {
            System.out.println(numero_hospede + ". " + hospede.getNome() + " - " + hospede.getCpf());
            numero_hospede++;
        }
        System.out.print("Selecione uma das opções: ");
        int opcao_hospede = settings.sc.nextInt();
        Hospede hospede_selecionado = hotel.getHospedes().get(opcao_hospede - 1);
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroReserva();
        int numero_quarto = 1;
        for (Quarto quarto : hotel.getQuartos()) {
            System.out.println(numero_quarto + ". Quarto Nº" + quarto.getNumero() + " - " + quarto.getTipo());
            numero_quarto++;
        }
        System.out.print("Selecione uma das opções: ");
        int opcao_quarto = settings.sc.nextInt();
        Quarto quarto_selecionado = hotel.getQuartos().get(opcao_quarto - 1);
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroReserva();
        System.out.println("Modelo: XX/XX/XXXX");
        System.out.print("Data de Início da Reserva: ");
        String dataInicio_reserva = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroReserva();
        System.out.println("Modelo: XX/XX/XXXX");
        System.out.print("Data de Fim da Reserva: ");
        String dataFim_reserva = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroReserva();
        System.out.print("Código da Reserva: ");
        int codigo_reserva = settings.sc.nextInt();
        settings.sc.nextLine();
        Settings.limparConsole();

        Reserva reserva = new Reserva(hospede_selecionado, quarto_selecionado, dataInicio_reserva, dataFim_reserva, codigo_reserva);
        hotel.cadastrarReserva(reserva);
        Settings.limparConsole();
    }

    public static void mostrarReservas(Hotel hotel) {
        while (true) {
            System.out.println("+---------------------------------+");
            System.out.println("|      Relatório de Reservas      |");
            System.out.println("+---------------------------------+");
            for (Reserva reserva : hotel.getReservas()) {
                System.out.println("Código da Reserva: " + reserva.getCodigoReserva());
                System.out.println("Nome do Hospede: " + reserva.getHospede().getNome());
                System.out.println("Número do Quarto: " + reserva.getQuarto().getNumero());
                System.out.println("Data de Início: " + reserva.getDataInicio());
                System.out.println("Data de Fim: " + reserva.getDataFim());
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

    public static void atualizarReserva(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|      Atualização de Reserva      |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (Reserva reserva : hotel.getReservas()) {
                System.out.println(numero + ". " + "[" + reserva.getCodigoReserva() + "] " + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                int numero_reserva = 1;
                for (Reserva reserva : hotel.getReservas()) {
                    if (opcao == numero_reserva) {
                        while (true) {
                            System.out.println("+----------------------------------+");
                            System.out.println("|      Atributos das Reservas      |");
                            System.out.println("+----------------------------------+");
                            System.out.println("| 1. Hospede                       |");
                            System.out.println("| 2. Quarto                        |");
                            System.out.println("| 3. Data de Início                |");
                            System.out.println("| 4. Data de Fim                   |");
                            System.out.println("| 5. Código da Reserva             |");
                            System.out.println("| 6. Sair                          |");
                            System.out.println("+----------------------------------+");
                            System.out.print("Selecione uma das opções: ");
                            int opcao_atributos = settings.sc.nextInt();
                            settings.sc.nextLine();
                            Settings.limparConsole();

                            if (opcao_atributos == 1) {
                                System.out.println("+--------------------------------+");
                                System.out.println("|   Atribuição de Novo Hospede   |");
                                System.out.println("+--------------------------------+");
                                int numero_hospede = 1;
                                for (Hospede hospede : hotel.getHospedes()) {
                                    System.out.println(numero_hospede + ". " + hospede.getNome() + " - " + hospede.getCpf());
                                    numero_hospede++;
                                }
                                System.out.print("Selecione uma das opções: ");
                                int opcao_hospede = settings.sc.nextInt();
                                reserva.setHospede(hotel.getHospedes().get(opcao_hospede - 1));
                                settings.sc.nextLine();
                                Settings.limparConsole();
                            } else if (opcao_atributos == 2) {
                                System.out.println("+-------------------------------+");
                                System.out.println("|   Atribuição de Novo Quarto   |");
                                System.out.println("+-------------------------------+");
                                int numero_quarto = 1;
                                for (Quarto quarto : hotel.getQuartos()) {
                                    System.out.println(numero_quarto + ". Quarto Nº" + quarto.getNumero() + " - " + quarto.getTipo());
                                    numero_quarto++;
                                }
                                System.out.print("Selecione uma das opções: ");
                                int opcao_quarto = settings.sc.nextInt();
                                reserva.setQuarto(hotel.getQuartos().get(opcao_quarto - 1));
                                settings.sc.nextLine();
                                Settings.limparConsole();
                            } else if (opcao_atributos == 3) {
                                System.out.println("+---------------------------------------+");
                                System.out.println("|   Atribuição de Nova Data de Início   |");
                                System.out.println("+---------------------------------------+");
                                System.out.print("Nova Data de Início: ");
                                String nova_dataInicio = settings.sc.nextLine();
                                reserva.setDataInicio(nova_dataInicio);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 4) {
                                System.out.println("+------------------------------------+");
                                System.out.println("|   Atribuição de Novo Data de Fim   |");
                                System.out.println("+------------------------------------+");
                                System.out.print("Nova Data de Fim: ");
                                String nova_dataFim = settings.sc.nextLine();
                                reserva.setDataFim(nova_dataFim);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 5) {
                                System.out.println("+---------------------------------+");
                                System.out.println("|    Atribuição de Novo Código    |");
                                System.out.println("+---------------------------------+");
                                System.out.print("Novo Código: ");
                                int novo_codigo = settings.sc.nextInt();
                                settings.sc.nextLine();
                                reserva.setCodigoReserva(novo_codigo);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 6) {
                                Settings.limparConsole();
                                break;
                            } else {
                                System.out.println("Opção Inválida! Tente novamente!\n");
                            }
                            numero_reserva++;
                        }
                    }
                }
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }

    public static void removerReserva(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|        Remoção de Reserva        |");
            System.out.println("+----------------------------------+");
            int numero_reserva = 1;
            for (Reserva reserva : hotel.getReservas()) {
                System.out.println(numero_reserva + ". " + "[" + reserva.getCodigoReserva() + "] " + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
                numero_reserva++;
            }
            System.out.println(numero_reserva + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero_reserva) {
                hotel.getReservas().remove(opcao - 1);
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }
}