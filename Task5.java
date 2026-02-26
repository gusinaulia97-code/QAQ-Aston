// Напишите метод, принимающий на вход два целых числа и проверяющий, 
// что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

public class Task5.java {
    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }
    public static void main(String args) {
        System.out.println(checkSum(6, 7));  // true (6 + 7 = 13)
        System.out.println(checkSum(18, 4)); // false (18 + 4 = 22)
    }
}
