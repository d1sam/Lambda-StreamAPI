package ua.od.atomspace;

import java.util.Scanner;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        //Predicate<T>
        Predicate<Integer> isPositive = x -> x > 0;

        System.out.println(isPositive.test(5)); // true
        System.out.println(isPositive.test(-7)); // false

        //BinaryOperator<T>
        BinaryOperator<Integer> multiply = (x, y) -> x*y;

        System.out.println(multiply.apply(3, 5)); // 15
        System.out.println(multiply.apply(10, -2)); // -20

        //UnaryOperator<T>
        UnaryOperator<Integer> square = x -> x*x;

        System.out.println(square.apply(5)); // 25
        System.out.println(square.apply(6)); // 36

        //Function<T,R>
        Function<Integer, String> convert = x-> String.valueOf(x) + " долларов";

        System.out.println(convert.apply(5)); // 5 долларов
        System.out.println(convert.apply(10)); // 10 долларов

        //Consumer<T>
        Consumer<Integer> printer = x-> System.out.printf("%d долларов \n", x);

        printer.accept(600); // 600 долларов
        printer.accept(1000); // 1000 долларов

        //Supplier<T>
        Supplier<User> userFactory = ()->{
            Scanner in = new Scanner(System.in);
            System.out.println("Введите имя: ");
            String name = in.nextLine();
            return new User(name);
        };

        User user1 = userFactory.get();
        User user2 = userFactory.get();

        System.out.println("Имя user1: " + user1.getName());
        System.out.println("Имя user2: " + user2.getName());
    }
}
class User{

    private String name;
    String getName(){
        return name;
    }

    User(String n){
        this.name=n;
    }
}