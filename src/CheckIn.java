public class CheckIn {
    private Reserva reserva;
    private String dataCheckIn;
    private String observacoes;

    public static Settings settings = new Settings();

    public CheckIn(Reserva reserva, String dataCheckIn, String observacoes) {
        this.reserva = reserva;
        this.dataCheckIn = dataCheckIn;
        this.observacoes = observacoes;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public final static void cadastroCheckIn() {
        System.out.println("+----------------------------------+");
        System.out.println("|     CADASTRAMENTO DE CHECKIN     |");
        System.out.println("+----------------------------------+");
    }

    public static void cadastrarCheckIn(Hotel hotel) {
        cadastroCheckIn();
        int numero_reserva = 1;
        for (Reserva reserva : hotel.getReservas()) {
            System.out.println(numero_reserva + ". " + "[" + reserva.getCodigoReserva() + "] " + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
            numero_reserva++;
        }
        System.out.print("Selecione uma das opções: ");
        int opcao_reserva = settings.sc.nextInt();
        Reserva reserva_selecionada = hotel.getReservas().get(opcao_reserva - 1);
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroCheckIn();
        System.out.println("Modelo: XX/XX/XXXX");
        System.out.print("Data do CheckIn: ");
        String data_checkin = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroCheckIn();
        System.out.print("Observações: ");
        String observacoes_checkin = settings.sc.nextLine();
        Settings.limparConsole();

        CheckIn checkin = new CheckIn(reserva_selecionada, data_checkin, observacoes_checkin);
        hotel.cadastrarCheckIn(checkin);
        Settings.limparConsole();
    }

    public static void mostrarCheckIns(Hotel hotel) {
        while (true) {
            System.out.println("+---------------------------------+");
            System.out.println("|      Relatório de CheckIns      |");
            System.out.println("+---------------------------------+");
            for (CheckIn checkin : hotel.getCheckIns()) {
                System.out.println("Código da Reserva: " + checkin.getReserva().getCodigoReserva());
                System.out.println("Nome do Hospede: " + checkin.getReserva().getHospede().getNome());
                System.out.println("Número do Quarto: " + checkin.getReserva().getQuarto().getNumero());
                System.out.println("Data do CheckIn: " + checkin.getDataCheckIn());
                System.out.println("Observações: " + checkin.getObservacoes());
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

    public static void atualizarCheckIn(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|      Atualização de CheckIn      |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (CheckIn checkin : hotel.getCheckIns()) {
                System.out.println(numero + ". " + "[" + checkin.getReserva().getCodigoReserva() + "] " + checkin.getReserva().getHospede().getNome() + " - " + checkin.getDataCheckIn());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                int numero_checkin = 1;
                for (CheckIn checkin : hotel.getCheckIns()) {
                    if (opcao == numero_checkin) {
                        while (true) {
                            System.out.println("+----------------------------------+");
                            System.out.println("|      Atributos dos CheckIns      |");
                            System.out.println("+----------------------------------+");
                            System.out.println("| 1. Reserva                       |");
                            System.out.println("| 2. Data de CheckIn               |");
                            System.out.println("| 3. Observacoes                   |");
                            System.out.println("| 4. Sair                          |");
                            System.out.println("+----------------------------------+");
                            System.out.print("Selecione uma das opções: ");
                            int opcao_atributos = settings.sc.nextInt();
                            settings.sc.nextLine();
                            Settings.limparConsole();

                            if (opcao_atributos == 1) {
                                System.out.println("+----------------------------------+");
                                System.out.println("|    Atribuição de Nova Reserva    |");
                                System.out.println("+----------------------------------+");
                                int numero_reserva = 1;
                                for (Reserva reserva : hotel.getReservas()) {
                                    System.out.println(numero_reserva + ". " + "[" + reserva.getCodigoReserva() + "] " + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
                                    numero_reserva++;
                                }
                                System.out.print("Selecione uma das opções: ");
                                int opcao_reserva = settings.sc.nextInt();
                                checkin.setReserva(hotel.getReservas().get(opcao_reserva - 1));
                                settings.sc.nextLine();
                                Settings.limparConsole();
                            } else if (opcao_atributos == 2) {
                                System.out.println("+----------------------------------------+");
                                System.out.println("|   Atribuição de Nova Data de CheckIn   |");
                                System.out.println("+----------------------------------------+");
                                System.out.print("Nova Data de CheckIn: ");
                                String nova_dataCheckIn = settings.sc.nextLine();
                                checkin.setDataCheckIn(nova_dataCheckIn);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 3) {
                                System.out.println("+-----------------------------------+");
                                System.out.println("|   Atribuição de Nova Observação   |");
                                System.out.println("+-----------------------------------+");
                                System.out.print("Nova Observação: ");
                                String nova_observacao = settings.sc.nextLine();
                                checkin.setObservacoes(nova_observacao);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 4) {
                                Settings.limparConsole();
                                break;
                            } else {
                                System.out.println("Opção Inválida! Tente novamente!\n");
                            }
                        }
                    }
                    numero_checkin++;
                }
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }

    public static void removerCheckIn(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|        Remoção de CheckIn        |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (CheckIn checkin : hotel.getCheckIns()) {
                System.out.println(numero + ". " + "[" + checkin.getReserva().getCodigoReserva() + "] " + checkin.getReserva().getHospede().getNome() + " - " + checkin.getDataCheckIn());
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                hotel.getCheckIns().remove(opcao - 1);
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }
}