// Напишите метод, которому в качестве аргументов передается строка и число, 
// метод должен отпечатать в консоль указанную строку, указанное количество раз.

public class RepeatString {
    public static void repeatString(String text, int count) {
        if (text == null || count < 0) {
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }
    public static void main(String args) {
        repeatString("Привет, Юля!", 5);
    }
}
