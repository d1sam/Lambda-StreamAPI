package ua.od.atomspace.alishevRealization;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface Executable {
    int execute();
}

class Runner {
    void run(Executable e) {
        int num = e.execute();
        System.out.println(num);
    }
}

class ExecutableImplementation implements Executable {
    @Override
    public int execute() {
        return 1;
    }
}

public class Test {
    public static void main(String[] args) {
        int z = 5;
        Runner runner = new Runner();

        runner.run(new ExecutableImplementation());// передали класс, который реализует интерфейс Executable и определяет метод execute

        runner.run(new Executable() {// у анонимного класса своя область видимости и с нее нельзя обращаться на верхний уровень
            @Override
            public int execute() {
                // z = 32; - невозможно, ибо анонимный класс имеет свою область видимости и не видит переменную выше
                int z = 3;// возможно, ибо свой скоуп
                return 2;
            }
        });// перередали анонимный класс, который реализует интерфейс Executable и определяет метод execute

        runner.run(() -> {
            return z + 3;// в лямбде можем использовать переменные из области видимости выше, так как лямбда не имеет своей области видимости
        });// перередали лямбду, которыая реализует интерфейс Executable и определяет метод execute

        // z = 3; - это нельзя делать, ибо в этом случае нельзя будет использовать в лямбде переменную
        // в лямбде могут быть использованы только те переменные из высшей области видимости, что являются final или эфективно final (не изменяются после объяаления)

        List<String> list = new ArrayList<>();
        list.add("Hello world!");
        list.add("Bye bye world!");
        list.add("Good luck!");
        list.add("Have fun!");

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        System.out.println(list);

        list.sort(((o1, o2) -> {
            if (o1.length() > o2.length()) {
                return -1;
            } else if (o1.length() < o2.length()) {
                return 1;
            } else {
                return 0;
            }
        }));

        System.out.println(list);
    }
}
