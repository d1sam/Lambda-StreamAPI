package ua.od.atomspace;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillList(list1);
        fillArr(arr1);

        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray();
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());

        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArr(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray();
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(list2);
        System.out.println(Arrays.toString(arr2));

        Arrays.stream(arr2).forEach(a -> System.out.println(a));
        list2.stream().forEach(System.out::println);

        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillList(list3);
        fillArr(arr3);

        int res1 = list3.stream().reduce(0, (accumulator, a) -> accumulator + a);// указали изначальное значение аккумулятора = 0,
        // если не указать то оно равно первому элементу, а работа с потоком начинается со второго элемента
        int res2 = Arrays.stream(arr3).reduce((accumulator, a) -> accumulator * a).getAsInt();

        System.out.println("res1 = " + res1);
        System.out.println("res2 = " + res2);

        int[] arr4 = new int[10];
        List<Integer> list4 = new ArrayList<>();

        fillList(list4);
        fillArr(arr4);

        arr4 = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 3).toArray();
        list4 = list4.stream().filter(a -> a % 2 != 0).map(a -> a * 3).collect(Collectors.toList());

        System.out.println(list4);
        System.out.println(Arrays.toString(arr4));

        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(23);
        hashSet.add(8);
        hashSet.add(99);

        hashSet = hashSet.stream().map(a->a*2).collect(Collectors.toSet());
        System.out.println(hashSet);
    }

    private static void fillList(List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }
    }

    private static void fillArr(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
