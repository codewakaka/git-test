package com.laoma.mystudy.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author code
 */
public class Student {
    String name;
    double score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }
    public Student(String name) {
        this.name = name;
    }
    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public static <E> List<E> filter(List<E> list, Predicate<E> pred) {
        List<E> retList = new ArrayList<>();
        for (E e : list) {
            if (pred.test(e)) {
                retList.add(e);
            }
        }
        return retList;
    }

    public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        List<R> reList = new ArrayList<>(list.size());
        for (T e : list) {
            reList.add(mapper.apply(e));
        }
        return reList;
    }

    public static <E> void foreach(List<E> list, Consumer<E> consumer) {
        for (E e : list) {
            consumer.accept(e);
        }
    }


    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student("dd", 90), new Student("BB", 78), new Student("cc", 100), new Student("cd", 90));
        // students = filter(students,t -> t.getScore() >= 90);
        //System.out.println(students.toString());
        //   List<String> names = map(students,t -> t.getName());
        //  students = map(students,t -> new Student(t.getName().toUpperCase(),t.getScore()));
        // foreach(students,t->t.setName(t.getName().toUpperCase()));
        //过滤分数大于90
        List<Student> names = students.stream().filter(t -> t.getScore() > 90).collect(Collectors.toList());
        //转换
        List<String> collect = students.stream().map(Student::getName).collect(Collectors.toList());
        //过滤加转换
        List<String> collect1 = students.stream().filter(t -> t.getScore() > 80).map(Student::getName).collect(Collectors.toList());
        //去重
        List<String> list = Arrays.asList("abc", "def", "hello", "Abc");

        List<String> collect2 = list.stream().filter(t -> t.length() <= 3).map(String::toUpperCase).distinct().collect(Collectors.toList());
        //
        List<Student> collect3 = students.stream().filter(t -> t.getScore() > 60).sorted(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getName)).collect(Collectors.toList());

        List<Student> collect4 = students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).skip(2).limit(2).collect(Collectors.toList());

        List<String> collect5 = students.stream().filter(t -> t.getScore() > 89).peek(System.out::print).map(Student::getName).collect(Collectors.toList());

        double sum = students.stream().mapToDouble(Student::getScore).sum();
        // System.out.println(sum);

        List<String> strings = Arrays.asList("hello abd abc", "lao bian chen");

        List<String> collect6 = strings.stream().flatMap(t -> Arrays.stream(t.split("\\s+"))).collect(Collectors.toList());

        List<String> collect7 = strings.stream().flatMap(t -> Arrays.stream(t.split("\\s+"))).sorted().collect(Collectors.toList());
        System.out.println();
        System.out.println("======================");
        List<Student> collect8 = students.stream().sorted(Comparator.comparing(Student::getScore).reversed()).collect(Collectors.toList());
        Student student = students.stream().min(Comparator.comparing(Student::getScore)).get();
        //  System.out.println(student);
        long count = students.stream().filter(t -> t.getScore() > 89).count();
        // System.out.println(count);
        //  System.out.println(collect8.toString());
        boolean b = students.stream().allMatch(t -> t.getScore() > 60);
        //  System.out.println(b);
        Optional<Student> any = students.stream().filter(t -> t.getScore() < 80).findAny();

        if (any.isPresent()) {
            //  System.out.println("未及格");
        }

        students.stream().filter(t -> t.getScore() > 80).forEach(t -> {
            System.out.println(t.getName());
        });

        Student[] as = students.stream().filter(t -> t.getScore() > 80).toArray(Student[]::new);

        Optional<Student> reduce = students.stream().reduce((ret, t) -> {
            if (ret.getScore() > t.getScore()) {
                return ret;
            } else {
                return t;
            }
        });
        Student student1 = reduce.get();
        //System.out.println(student1);
        Double reduce1 = students.stream().reduce(0d, (allsum, t) -> allsum += t.getScore(), (sum1, sum2) -> sum1 += sum2);
        System.out.println(reduce1);

    }
}
