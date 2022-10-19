import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] food = {"Хлеб", "Масло", "Чай", "Вода", "Колбаса"};
        int[] basket = new int[5];
        int[] price = {59, 150, 243, 30, 580};
        int sumFood = 0;
        System.out.println("Список товаров доступных для добавления в корзину:");
        StringBuilder listFood = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            listFood.append((i + 1) + ". " + food[i] + " " + price[i] + " руб/шт \n");
        }
        System.out.println(listFood.toString());
        while (true) {
            System.out.println("Выберите товар путем ввода его номера и количества. Для завершения покупок введите end");
            String inputStr = scanner.nextLine();
            if (inputStr.equals("end")) break;
            else if (inputStr == "") continue;
            String[] parts = inputStr.split(" ");
            if (parts.length < 2) {
                System.out.println("Вы некорректно ввели номер товара и его количество!!");
                continue;
            }
            int numFood = Integer.parseInt(parts[0]) - 1;
            int countFood = Integer.parseInt(parts[1]);
            if (numFood < 0 || numFood > (food.length - 1)) {
                System.out.println("Такого номера товара нет в предложенном перечне");
                continue;
            }
            basket[numFood] += countFood;
            sumFood += countFood * price[numFood];
        }
        if (sumFood == 0) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("Ваш заказ: \n");
            listFood.setLength(0);
            for (int i = 0; i < basket.length; i++) {
                if (!(basket[i] == 0)) {
                    listFood.append(food[i] + " " + basket[i] + " шт. * " + price[i] + " руб = " + (basket[i] * price[i]) + " руб. \n");
                }
            }
            listFood.append("Итоговая сумма покупки = " + sumFood + " руб");
            System.out.println(listFood.toString());
        }
    }
}
