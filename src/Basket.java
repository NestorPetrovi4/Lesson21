import java.io.*;

public class Basket implements Serializable {
    private static final long serialVersionUID = 11L;
    private String[] food;
    private int[] price;
    private int[] baskets;
    private int sumFood;

    public Basket(int[] price, String[] food) {
        this.food = food;
        this.price = price;
        baskets = new int[food.length];
    }

    public void addToCart(int productNum, int amount) {
        baskets[productNum] += amount;
        sumFood += amount * price[productNum];
        File basketBin = new File("Basket.bin");
        saveBin(basketBin);
    }

    public int[] getPrice() {
        return price;
    }

    public String[] getFood() {
        return food;
    }

    public int getSumFood() {
        return sumFood;
    }

    public void printCart(StringBuilder listFood) {
        if (sumFood == 0) {
            System.out.println("Ваша корзина пуста");
        } else {
            System.out.println("Ваш заказ: \n");
            listFood.setLength(0);
            for (int i = 0; i < baskets.length; i++) {
                if (!(baskets[i] == 0)) {
                    listFood.append(food[i] + " " + baskets[i] + " шт. * " + price[i] + " руб = " + (baskets[i] * price[i]) + " руб. \n");
                }
            }
            listFood.append("Итоговая сумма покупки = " + sumFood + " руб");
            System.out.println(listFood.toString());
        }
    }

    public void saveBin(File file) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(this);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Basket loadFromBinFile(File file) {
        Basket basket = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            basket = (Basket) ois.readObject();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return basket;
    }
}
