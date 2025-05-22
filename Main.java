import java.util.Scanner;

public class Main {

    public static void printDelim() {
        System.out.println();
        System.out.println("Выберите операцию и введите её номер:");
        System.out.println("1. Добавить новый доход");
        System.out.println("2. Добавить новый расход");
        System.out.println("3. Выбрать систему налогообложения");
    }

    public static void compareAndReturnMinTax(int earnings, int spendings) {
        int tax1 = taxJustEarnings(earnings, spendings);
        int tax2 = taxEarningsMinusSpendings(earnings, spendings);

        if (tax1 < tax2) { // Исправлено условие сравнения
            System.out.println("Мы советуем УСН доходы");
            System.out.println("Ваш налог составит: " + tax1);
            System.out.println("Ваш налог на другой системе: " + tax2);
            System.out.println("Ваша экономия: " + (tax2 - tax1));
        } else {
            System.out.println("Мы советуем УСН доходы минус расходы");
            System.out.println("Ваш налог составит: " + tax2);
            System.out.println("Ваш налог на другой системе: " + tax1);
            System.out.println("Ваша экономия: " + (tax1 - tax2));
        }
    }


    public static int taxJustEarnings(int earnings, int spendings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если дохоты оказались нулевыми
            return 0;
        }
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            printDelim();
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    int money = Integer.parseInt(scanner.nextLine());
                    earnings += money;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    int spending = Integer.parseInt(scanner.nextLine());
                    spendings += spending;
                    break;

                case 3:
                    compareAndReturnMinTax(earnings, spendings);
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}
