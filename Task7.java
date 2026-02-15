// Напишите метод, которому в качестве параметра передается целое число. Метод должен вернуть true, 
// если число отрицательное, и вернуть false если положительное. Замечание: ноль считаем положительным числом.

public class NumberChecker {
    public static boolean isNegative(int number) {
        return number < 0;
    }
    public static void main(String args) {
        System.out.println(isNegative(-25));  // true
        System.out.println(isNegative(0));   // false
        System.out.println(isNegative(16));  // false
    }
}
