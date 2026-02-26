// Напишите метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль, 
// положительное ли число передали или отрицательное. Замечание: ноль считаем положительным числом.

public class Task6.java {
    public static void checkNumber(int number) {
        if (number > 0) {
            System.out.println("Передано положительное число или ноль: " + number);
        } else {
            System.out.println("Передано отрицательное число: " + number);
        }
    }
    public static void main(String args) {
        checkNumber(8);    // Положительное число
        checkNumber(-10);   // Отрицательное число
        checkNumber(0);    // Ноль положительное число
    }
}
