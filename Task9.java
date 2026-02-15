// Напишите метод, который определяет, является ли год високосным, и возвращает boolean
// (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого 100-го, 
// при этом каждый 400-й – високосный.

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void main(String args) {
        System.out.println(isLeapYear(2400));  // true (делится на 400)
        System.out.println(isLeapYear(1500));  // false (делится на 100, но не на 400)
        System.out.println(isLeapYear(2000));  // true (делится на 4, не делится на 100)
    }
}
