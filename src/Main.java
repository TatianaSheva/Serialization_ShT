import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        String[] listOfProducts = {"Молоко", "Соль", "Помидоры", "Оливки"};
        int[] prices = {70, 25, 100, 90};

        int[] sum = {0, 0, 0, 0};
        int[] count = {0, 0, 0, 0};

        int productNumber = 0;
        int productCount = 0;
        int sumProducts = 0;


        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < listOfProducts.length; i++) {
            System.out.println((i + 1) + ". " + listOfProducts[i] + " " + prices[i] + " руб./шт.");
        }

        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }


            String[] split = input.split(" ");
            if (split.length != 2) {
                System.out.println("Ошибка ввода: Вы вввели 1 число или более 2 чисел =(");
                continue;
            }

            // Исключение для ввода слов NumberFormatException
            try {
                String a = split[0];//до пробела, чтобы получить номер продукта
                productNumber = Integer.parseInt(a) - 1;
                // throw new NumberFormatException("Ошибка ввода: Вы ввели не число. Для корректной работы программы введите число!");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода: Вы ввели не число. Для корректной работы программы введите число!");
                continue;
            }
            if (productNumber + 1 > listOfProducts.length || productNumber < 0) {
                System.out.println("Ошибка ввода: Вы ввели слишком большое или неположительное число!");
                continue;
            }


            String b = split[1]; //после пробела, чтобы получить количество
            try {
                productCount = Integer.parseInt(b);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода: Вы ввели не число. Для корректной работы программы введите число!");
                continue;
            }

            if (productCount < 0) {
                System.out.println("Ошибка ввода: Вы ввели слишком большое или неположительное число!");
                continue;
            }

            sum[productNumber] += prices[productNumber] * productCount;
            count[productNumber] += productCount;
        }

        System.out.println(" ");
        System.out.println("Ваша корзина:");

        for (int i = 0; i < listOfProducts.length; i++) {
            if (count[i] != 0) {
                System.out.println(listOfProducts[i] + " " + count[i] + " шт., " + prices[i] + " руб., " + sum[i] + " рублей в сумме.");
            }
            sumProducts += sum[i];
        }
        System.out.println("Итого: " + sumProducts + " рублей.");
    }
}
