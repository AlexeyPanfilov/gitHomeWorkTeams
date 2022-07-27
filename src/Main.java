import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {
                "Молоко",
                "Яблоки",
                "Сыр",
                "Морковь", // здесь должен быть конфликт! Если нет, я не знаю ещё как его вызвать! Мне весь код что ли переписать специально?
                "Хлеб",
        };

        int[] prises = {
                80,
                50,
                200,
                25,
                45
        };

        int[] numb = new int[products.length];

        System.out.println("Список возможных товаров для покупки: ");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i] + " " + prises[i] + " руб/шт");
        }

        int ollSum = 0;
        int numProduct = 0;
        int amount = 0;

        while (true) {

            System.out.println("Выберите товар и количество или введите end для перехода к товарам по акции.");
            String input = scanner.nextLine();//1 2

            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");

            try {
                numProduct = Integer.parseInt(parts[0]) - 1;
                amount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Нужно вводить только числа или end!");
                continue;

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Некорректный ввод! Нужно ввести два числа или end!");
                continue;
            } if (parts.length != 2) {
                System.out.println("Некорректный ввод! Нужно ввести два числа или end!");
                continue;
            }

            if (numProduct < 0 || numProduct > 4) {
                System.out.println("Некорректный ввод позиции! Нужно выбрать номер позиции из списка!");
                continue;
            }

            numb[numProduct] += amount;//сумма штук введенного

            int sum = amount * prises[numProduct];
            ollSum += sum;// подсчет общей суммы списка
        }

        System.out.println("Ваша корзина: ");

        for (int i = 0; i < numb.length; i++) {
            if (numb[i] != 0) {
                System.out.println(products[i] + " " + numb[i] + " шт " +
                        prises[i] + " руб/шт " + (numb[i] * prises[i]) + " в сумме");
            }
        }

        System.out.println("Итого: " + ollSum);

        String[] saleProducts = { // Товары по акции
                "Кефир",
                "Гречка",
                "Шоколад",
        };

        int[] salePrises = {
                100,
                90,
                130,
        };

        int[] saleNumb = new int[3];

        System.out.println(System.lineSeparator() + "Список товаров по акции 2 = 3: ");
        for (int j = 0; j < saleProducts.length; j++) {
            System.out.println((j + 1) + ". " + saleProducts[j] + " " + salePrises[j] + " руб/шт");
        }

        int saleOllSum = 0;
        int saleNumProduct = 0;
        int saleAmount = 0;

        while (true) {
            System.out.println(System.lineSeparator() + "Выберите товар и количество или введите end");
            String input = scanner.nextLine();//1 2
            if (input.equals("end")) {
                break;
            }
            String[] parts = input.split(" ");

            if (parts.length != 2) {
                System.out.println("Некорректный ввод! Нужно ввести два числа!");
                continue;
            }

            try {
                saleNumProduct = Integer.parseInt(parts[0]) - 1;
                saleAmount = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода! Нужно вводить только числа, а не текст!");
                continue;
            }

            if (saleNumProduct < 0 || saleNumProduct > 2) {
                System.out.println("Некорректный ввод позиции! Нужно выбрать номер позиции из списка!");
                continue;
            }

            if (saleAmount == 3) {
                saleNumb[saleNumProduct] += saleAmount;//сумма штук введенного
                int sum = (saleAmount * salePrises[saleNumProduct]) - salePrises[saleNumProduct];
                saleOllSum += sum;// подсчет общей суммы списка по акции
            } else {
                saleNumb[saleNumProduct] += saleAmount;//сумма штук введенного
                int sum = saleAmount * salePrises[saleNumProduct];
                saleOllSum += sum;// подсчет общей суммы списка без акции
            }
        }
        System.out.println("Ваша корзина: ");

        for (int j = 0; j < saleNumb.length; j++) {
            if (saleNumb[j] != 0) {
                System.out.println(saleProducts[j] + " " + saleNumb[j] + " шт " +
                        salePrises[j] + " руб/шт " + (saleNumb[j] * salePrises[j]) + " в сумме без скидки");
            }
        }
        System.out.println("Итого (со скидкой): " + saleOllSum);
    }
}