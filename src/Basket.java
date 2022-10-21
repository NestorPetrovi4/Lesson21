public class Basket {
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
    public void printCart(StringBuilder listFood){
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
}
