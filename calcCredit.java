import java.util.Scanner;

public class Main {

    public static int calcCredit(int price, int weigth) {
        int result = price / 100 + weigth * 100;
        return result;

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите цену товара (в руб.): ");
        int price = scanner.nextInt();
        System.out.print("Введите вес товара (в кг.): ");
        int weigth = scanner.nextInt();
        System.out.print("Размер пошлины (в руб.) составит: " + calcCredit(price, weigth));

    }
}
