import java.util.*;

public class Hotel {
    public Settings settings = new Settings();
    private ArrayList<Hospede> hospedes = new ArrayList<Hospede>();
    private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    private ArrayList<CheckIn> checkins = new ArrayList<CheckIn>();
    private ArrayList<CheckOut> checkouts = new ArrayList<CheckOut>();

    public ArrayList<Hospede> getHospedes() {
        return hospedes;
    }

    public ArrayList<Quarto> getQuartos() {
        return quartos;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public ArrayList<CheckIn> getCheckIns() {
        return checkins;
    }

    public ArrayList<CheckOut> getCheckOuts() {
        return checkouts;
    }

    public void cadastrarHospede(Hospede hospede) {
        hospedes.add(hospede);
    }

    public void cadastrarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void cadastrarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void cadastrarCheckIn(CheckIn checkin) {
        checkins.add(checkin);
    }

    public void cadastrarCheckOut(CheckOut checkout) {
        checkouts.add(checkout);
    }

    public void mostrarRelatorio() {
        System.out.println("+---------------------------------+");
        System.out.println("|      Relatório do LowHotel      |");
        System.out.println("+---------------------------------+");
        System.out.println("| 1. Visão Geral                  |");
        System.out.println("| 2. Todos os Hospedes            |");
        System.out.println("| 3. Todos os Quartos             |");
        System.out.println("| 4. Todas as Reservas            |");
        System.out.println("| 5. Todos os CheckIns            |");
        System.out.println("| 6. Todos os CheckOut            |");
        System.out.println("| 7. Sair                         |");
        System.out.println("+---------------------------------+");
        System.out.print("Selecione uma opção: ");
        int opcao_menu = settings.sc.nextInt();
        Settings.limparConsole();

        // Hospedes
        if (opcao_menu == 2) {
            while (true) {
                System.out.println("+---------------------------------+");
                System.out.println("|      Relatório de Hospedes      |");
                System.out.println("+---------------------------------+");
                int numero = 1;
                for (Hospede hospede : hospedes) {
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
    }
}
