// Создать массив из 5 товаров.

public class Task2.java {
    public static void main(String args) {
        Product[] productsArray = new Product[5];

        productsArray[1] = new Product("Кофe Egoist", "молотый");
        productsArray[2] = new Product("Kофе Jardin", "молотый");
        productsArray[3] = new Product("Кофе Lebo", "молотый");
        productsArray[4] = new Product("Kофе Нескафе", "молотый");
        productsArray[5] = new Product("Кофе Lavazza", "зерновой");

        for (Product product : products) {
            product.showInfo();
            System.out.println();
        }
    }
}
