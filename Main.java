public class Main {
    public static void main(String args[]) {
        Settings settings = new Settings();
        Hotel hotel = new Hotel();

        while (true) {
            System.out.println("+--------------------------------+");
            System.out.println("|     BEM-VINDO AO LOWHOTEL      |");
            System.out.println("+--------------------------------+");
            System.out.println("| 1. Gerenciar Hospedes          |");
            System.out.println("| 2. Gerenciar Quartos           |");
            System.out.println("| 3. Gerenciar Reservas          |");
            System.out.println("| 4. Gerenciar CheckIns          |");
            System.out.println("| 5. Gerenciar CheckOuts         |");
            System.out.println("| 6. Sair                        |");
            System.out.println("+--------------------------------+");
            System.out.print("Selecione uma opção: ");
            int opcao_menu = settings.sc.nextInt();
            settings.sc.nextLine();
            Settings.limparConsole();

            if (opcao_menu == 1) {
                while (true) {
                    System.out.println("+---------------------------------+");
                    System.out.println("|    GERENCIAMENTO DE HOSPEDES    |");
                    System.out.println("+---------------------------------+");
                    System.out.println("| 1. Novo Hospede                 |");
                    System.out.println("| 2. Mostrar Hospedes             |");
                    System.out.println("| 3. Atualizar Hospede            |");
                    System.out.println("| 4. Remover Hospede              |");
                    System.out.println("| 5. Sair                         |");
                    System.out.println("+---------------------------------+");
                    System.out.print("Selecione uma opção: ");
                    int opcao_quarto = settings.sc.nextInt();
                    settings.sc.nextLine();
                    Settings.limparConsole();

                    if (opcao_quarto == 1) {
                        Hospede.cadastrarHospede(hotel);
                    } else if (opcao_quarto == 2) {
                        Hospede.mostrarHospedes(hotel);
                    } else if (opcao_quarto == 3) {
                        Hospede.atualizarHospede(hotel);
                    } else if (opcao_quarto == 4) {
                        Hospede.removerHospede(hotel);
                    } else if (opcao_quarto == 5) {
                        Settings.limparConsole();
                        break;
                    } else {
                        System.out.println("Opção Inválida! Tente novamente!\n");
                    }
                }
            } else if (opcao_menu == 2) {
                while (true) {
                    System.out.println("+----------------------------------+");
                    System.out.println("|     GERENCIAMENTO DE QUARTOS     |");
                    System.out.println("+----------------------------------+");
                    System.out.println("| 1. Novo Quarto                   |");
                    System.out.println("| 2. Mostrar Quartos               |");
                    System.out.println("| 3. Atualizar Quarto              |");
                    System.out.println("| 4. Remover Quarto                |");
                    System.out.println("| 5. Sair                          |");
                    System.out.println("+----------------------------------+");
                    System.out.print("Selecione uma opção: ");
                    int opcao_quarto = settings.sc.nextInt();
                    settings.sc.nextLine();
                    Settings.limparConsole();

                    if (opcao_quarto == 1) {
                        Quarto.cadastrarQuarto(hotel);
                    } else if (opcao_quarto == 2) {
                        Quarto.mostrarQuartos(hotel);
                    } else if (opcao_quarto == 3) {
                        Quarto.atualizarQuarto(hotel);
                    } else if (opcao_quarto == 4) {
                        Quarto.removerQuarto(hotel);
                    } else if (opcao_quarto == 5) {
                        Settings.limparConsole();
                        break;
                    } else {
                        System.out.println("Opção Inválida! Tente novamente!\n");
                    }
                }
            } else if (opcao_menu == 3) {
                while (true) {
                    System.out.println("+-----------------------------------+");
                    System.out.println("|     GERENCIAMENTO DE RESERVAS     |");
                    System.out.println("+-----------------------------------+");
                    System.out.println("| 1. Nova Reserva                   |");
                    System.out.println("| 2. Mostrar Reservas               |");
                    System.out.println("| 3. Atualizar Reserva              |");
                    System.out.println("| 4. Remover Reserva                |");
                    System.out.println("| 5. Sair                           |");
                    System.out.println("+-----------------------------------+");
                    System.out.print("Selecione uma opção: ");
                    int opcao_reserva = settings.sc.nextInt();
                    settings.sc.nextLine();
                    Settings.limparConsole();

                    if (opcao_reserva == 1) {
                        Reserva.cadastrarReserva(hotel);
                    } else if (opcao_reserva == 2) {
                        Reserva.mostrarReservas(hotel);
                    } else if (opcao_reserva == 3) {
                        Reserva.atualizarReserva(hotel);
                    } else if (opcao_reserva == 4) {
                        Reserva.removerReserva(hotel);
                    } else if (opcao_reserva == 5) {
                        Settings.limparConsole();
                        break;
                    } else {
                        System.out.println("Opção Inválida! Tente novamente!\n");
                    }
                }
            } else if (opcao_menu == 4) {
                while (true) {
                    System.out.println("+-----------------------------------+");
                    System.out.println("|     GERENCIAMENTO DE CHECKINS     |");
                    System.out.println("+-----------------------------------+");
                    System.out.println("| 1. Novo CheckIn                   |");
                    System.out.println("| 2. Mostrar CheckIns               |");
                    System.out.println("| 3. Atualizar CheckIn              |");
                    System.out.println("| 4. Remover CheckIn                |");
                    System.out.println("| 5. Sair                           |");
                    System.out.println("+-----------------------------------+");
                    System.out.print("Selecione uma opção: ");
                    int opcao_checkin = settings.sc.nextInt();
                    settings.sc.nextLine();
                    Settings.limparConsole();

                    if (opcao_checkin == 1) {
                        CheckIn.cadastrarCheckIn(hotel);
                    } else if (opcao_checkin == 2) {
                        CheckIn.mostrarCheckIns(hotel);
                    } else if (opcao_checkin == 3) {
                        CheckIn.atualizarCheckIn(hotel);
                    } else if (opcao_checkin == 4) {
                        CheckIn.removerCheckIn(hotel);
                    } else if (opcao_checkin == 5) {
                        Settings.limparConsole();
                        break;
                    } else {
                        System.out.println("Opção Inválida! Tente novamente!\n");
                    }
                }
            } else if (opcao_menu == 5) {
                while (true) {
                    System.out.println("+------------------------------------+");
                    System.out.println("|     GERENCIAMENTO DE CHECKOUTS     |");
                    System.out.println("+------------------------------------+");
                    System.out.println("| 1. Novo CheckOut                   |");
                    System.out.println("| 2. Mostrar CheckOuts               |");
                    System.out.println("| 3. Atualizar CheckOut              |");
                    System.out.println("| 4. Remover CheckOut                |");
                    System.out.println("| 5. Sair                            |");
                    System.out.println("+------------------------------------+");
                    System.out.print("Selecione uma opção: ");
                    int opcao_checkout = settings.sc.nextInt();
                    settings.sc.nextLine();
                    Settings.limparConsole();

                    if (opcao_checkout == 1) {
                        CheckOut.cadastrarCheckOut(hotel);
                    } else if (opcao_checkout == 2) {
                        CheckOut.mostrarCheckOuts(hotel);
                    } else if (opcao_checkout == 3) {
                        CheckOut.atualizarCheckOut(hotel);
                    } else if (opcao_checkout == 4) {
                        CheckOut.removerCheckOut(hotel);
                    } else if (opcao_checkout == 5) {
                        Settings.limparConsole();
                        break;
                    } else {
                        System.out.println("Opção Inválida! Tente novamente!\n");
                    }
                }
            } else if (opcao_menu == 6) {
                Settings.limparConsole();
                break;
            } else {
                System.out.println("Opção Inválida! Tente novamente!\n");
            }
        }
    }
}