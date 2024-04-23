package demostudentcollection04;

import java.util.Comparator;

public class Student implements Comparable {

    private String id, name;
    private int age;
    private double score;

    public Student() 
    {

    }

    public Student(String id, String name, int age, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override //của lớp object.
    public String toString() {
        return " id=" + id + ",  name=" + name + ",  age=" + age + ", score=" + score;
    }

   public static Comparator sortId = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            if (s1.getId().length() > s2.getId().length()) {
                return 1;
            } else if (s1.getId().equals(s2.getId())) {
                return 0;
            } else {
                return -1;
            }
        }

    };

    public static Comparator sortName = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            if (s1.getName().length() > s2.getName().length()) {
                return 1;
            } else if (s1.getName().equals(s2.getName())) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    public static Comparator sortScore = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            if (s1.getScore() > s2.getScore()) {
                return 1;
            } else if (s1.getScore() == s2.getScore()) {
                return 0;
            } else {
                return -1;
            }
        }
    };
    public static Comparator sortAge = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            Student s1 = (Student) o1;
            Student s2 = (Student) o2;

            if (s1.getAge() > s2.getAge()) {
                return 1;
            } else if (s1.getAge() == s2.getAge()) {
                return 0;
            } else {
                return -1;
            }
        }
    };

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
