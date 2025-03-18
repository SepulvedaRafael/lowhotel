public class CheckOut {
    private Reserva reserva;
    private String dataCheckOut;
    private double valorTotal;

    public static Settings settings = new Settings();

    public CheckOut(Reserva reserva, String dataCheckOut, double valorTotal) {
        this.reserva = reserva;
        this.dataCheckOut = dataCheckOut;
        this.valorTotal = valorTotal;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public final static void cadastroCheckOut() {
        System.out.println("+-----------------------------------+");
        System.out.println("|     CADASTRAMENTO DE CHECKOUT     |");
        System.out.println("+-----------------------------------+");
    }

    public static void cadastrarCheckOut(Hotel hotel) {
        cadastroCheckOut();
        int numero_reserva = 1;
        for (Reserva reserva : hotel.getReservas()) {
            System.out.println(numero_reserva + ". " + "[" + reserva.getCodigoReserva() + "] "
                    + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
            numero_reserva++;
        }
        System.out.print("Selecione uma das opções: ");
        int opcao_reserva = settings.sc.nextInt();
        Reserva reserva_selecionada = hotel.getReservas().get(opcao_reserva - 1);
        settings.sc.nextLine();
        Settings.limparConsole();

        cadastroCheckOut();
        System.out.println("Modelo: XX/XX/XXXX");
        System.out.print("Data do CheckOut: ");
        String data_checkout = settings.sc.nextLine();
        Settings.limparConsole();

        cadastroCheckOut();
        System.out.print("Valor Total: R$");
        double valor_total = settings.sc.nextDouble();
        settings.sc.nextLine();
        Settings.limparConsole();

        CheckOut checkout = new CheckOut(reserva_selecionada, data_checkout, valor_total);
        hotel.cadastrarCheckOut(checkout);
        Settings.limparConsole();
    }

    public static void mostrarCheckOuts(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|      Relatório de CheckOuts      |");
            System.out.println("+----------------------------------+");
            for (CheckOut checkout : hotel.getCheckOuts()) {
                System.out.println("Código da Reserva: " + checkout.getReserva().getCodigoReserva());
                System.out.println("Nome do Hospede: " + checkout.getReserva().getHospede().getNome());
                System.out.println("Número do Quarto: " + checkout.getReserva().getQuarto().getNumero());
                System.out.println("Data do CheckOut: " + checkout.getDataCheckOut());
                System.out.println("Valor Total: R$" + checkout.getValorTotal());
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

    public static void atualizarCheckOut(Hotel hotel) {
        while (true) {
            System.out.println("+----------------------------------+");
            System.out.println("|      Atualização de CheckOut      |");
            System.out.println("+----------------------------------+");
            int numero = 1;
            for (CheckOut checkout : hotel.getCheckOuts()) {
                System.out.println(numero + ". " + "[" + checkout.getReserva().getCodigoReserva() + "] " + checkout.getReserva().getHospede().getNome() + " - " + checkout.getDataCheckOut() + " [" + checkout.getValorTotal() + "]");
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                int numero_checkin = 1;
                for (CheckOut checkout : hotel.getCheckOuts()) {
                    if (opcao == numero_checkin) {
                        while (true) {
                            System.out.println("+-----------------------------------+");
                            System.out.println("|      Atributos dos CheckOuts      |");
                            System.out.println("+-----------------------------------+");
                            System.out.println("| 1. Reserva                        |");
                            System.out.println("| 2. Data de CheckOut               |");
                            System.out.println("| 3. Valor Total                    |");
                            System.out.println("| 4. Sair                           |");
                            System.out.println("+-----------------------------------+");
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
                                    System.out.println(numero_reserva + ". " + "[" + reserva.getCodigoReserva() + "] "
                                            + reserva.getHospede().getNome() + " - " + reserva.getQuarto().getNumero());
                                    numero_reserva++;
                                }
                                System.out.print("Selecione uma das opções: ");
                                int opcao_reserva = settings.sc.nextInt();
                                checkout.setReserva(hotel.getReservas().get(opcao_reserva - 1));
                                settings.sc.nextLine();
                                Settings.limparConsole();
                            } else if (opcao_atributos == 2) {
                                System.out.println("+-----------------------------------------+");
                                System.out.println("|   Atribuição de Nova Data de CheckOut   |");
                                System.out.println("+-----------------------------------------+");
                                System.out.print("Nova Data de CheckOut: ");
                                String nova_dataCheckOut = settings.sc.nextLine();
                                checkout.setDataCheckOut(nova_dataCheckOut);
                                Settings.limparConsole();
                            } else if (opcao_atributos == 3) {
                                System.out.println("+------------------------------------+");
                                System.out.println("|   Atribuição de Novo Valor Total   |");
                                System.out.println("+------------------------------------+");
                                System.out.print("Novo Valor Total: R$");
                                double novo_valorTotal = settings.sc.nextDouble();
                                settings.sc.nextLine();
                                checkout.setValorTotal(novo_valorTotal);
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

    public static void removerCheckOut(Hotel hotel) {
        while (true) {
            System.out.println("+-----------------------------------+");
            System.out.println("|        Remoção de CheckOut        |");
            System.out.println("+-----------------------------------+");
            int numero = 1;
            for (CheckOut checkout : hotel.getCheckOuts()) {
                System.out.println(numero + ". " + "[" + checkout.getReserva().getCodigoReserva() + "] " + checkout.getReserva().getHospede().getNome() + " - " + checkout.getDataCheckOut() + " [" + checkout.getValorTotal() + "]");
                numero++;
            }
            System.out.println(numero + ". Sair");
            System.out.print("Selecione uma das opções: ");
            int opcao = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao < numero) {
                hotel.getCheckOuts().remove(opcao - 1);
            } else {
                Settings.limparConsole();
                break;
            }
        }
    }
}