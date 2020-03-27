package com.laoma.mystudy.cla;

public class SimpleMapperDemon {
    static class Student{
        String name;
        int age;
        double socre;

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", socre=" + socre +
                    '}';
        }

        public Student() {
        }

        public Student(String name, int age, double socre) {
            this.name = name;
            this.age = age;
            this.socre = socre;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSocre() {
            return socre;
        }

        public void setSocre(double socre) {
            this.socre = socre;
        }
    }


    public static void main(String[] args) {
        Student zs = new Student("张三",18,89d);
         //SimpleMapper
    }


}
