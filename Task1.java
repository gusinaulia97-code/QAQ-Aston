public class Task1.java {
    private String название;
    private LocalDate датаПроизводства;
    private String производитель;
    private String странаПроисхождения;
    private double цена;
    private boolean забронирован;

    public Task1.java (String название, String датаПроизводства, 
                String странаПроисхождения, double цена, 
                boolean забронирован, LocalDate производитель) {
        this.название = название;
        this.производитель = датаПроизводства;
        this.странаПроисхождения = странаПроисхождения;
        this.цена = цена;
        this.забронирован = забронирован;
        this.датаПроизводства = производитель;
    }

    public void вывестиИнформацию() {
        System.out.println("Информация о товаре:");
        System.out.printf("Название: %s%n", название);
        System.out.printf("Производитель: %s%n", производитель);
        System.out.printf("Страна происхождения: %s%n", странаПроисхождения);
        System.out.printf("Цена: %.2f%n", цена);
        
        if (забронирован) {
            System.out.println("Товар забронирован покупателем");
        } else {
            System.out.println("Товар свободен");
        }
        
        System.out.printf("Дата производства: %s%n", 
                         LocalDate.from(датаПроизводства));
    }
}
