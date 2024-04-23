package demostudentcollection04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StudentManager {

    private ArrayList<Student> listStudents = new ArrayList<>();

    public StudentManager() {
    }

    public ArrayList<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(ArrayList<Student> listStudents) {
        this.listStudents = listStudents;
    }

    public void create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input id: ");
        String _id = sc.nextLine();
        for (Student st : listStudents){
            if (st.getId().equals(_id)){
                System.out.println("Duplicate student id");
                return;
            }
        }
        System.out.println("Input name: ");
        String _name = sc.nextLine();
        System.out.println("Input age: ");
        int _age = Integer.parseInt(sc.nextLine());
        System.out.println("Input score: ");
        double _score = Double.parseDouble(sc.nextLine());
        Student st = new Student(_id, _name, _age, _score);
        listStudents.add(st);
    }

    public void read() {
        if (listStudents.isEmpty()) {
            System.out.println("Empty list.");
            return;
        }
        
        for (Student x : listStudents) {
            System.out.println(x);
        }
    }

    public void details(String id) {
        if (listStudents.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        
        for (Student st : listStudents) {
            if (st.getId().equals(id)) {
                System.out.println(st);
                return;
            }
        }
        System.out.println("Sinh viên không tồn tại!");
    }
    
    public void update(String s) {
        boolean isExisted = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId().equals(s)) {
                Scanner sc = new Scanner(System.in);
                isExisted = true;
                System.out.println("Input name: ");
                String _name = sc.nextLine();
                System.out.println("Input age: ");
                int _age = Integer.parseInt(sc.nextLine());
                System.out.println("Input score: ");
                double _score = Double.parseDouble(sc.nextLine());
                listStudents.get(i).setName(_name);
                listStudents.get(i).setAge(_age);
                listStudents.get(i).setScore(_score);
            }
        }
        System.out.println("Sinh viên không tồn tại");
    } ;
    
    public void delete(String s) {
        if (listStudents.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Student student = null;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId().equals(s)) {
                student = listStudents.get(i);
                break;
            }
        }
        if (student != null) {
            listStudents.remove(student);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Sinh viên không tồn tại");
        }
    }

    ;
    
    public void sortId() {
        Collections.sort(listStudents, Student.sortId);
    }

    public void sortName() {
        Collections.sort(listStudents, Student.sortName);
    }

    public void sortAge() {
        Collections.sort(listStudents, Student.sortAge);
    };
    
    public void sortScore() {
        Collections.sort(listStudents, Student.sortScore);
    };
    
    public void readDataFromFile(String filename) {
        try {
            File f = new File(filename);
            if (!f.exists()) {
            return;
            }

            FileReader fr = new FileReader(f);
            BufferedReader bfr = new BufferedReader(fr);

            String line;

            while ((line =bfr.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(line, ",");
                String _id = stk.nextToken();
                String _name = stk.nextToken();
                int _age = Integer.parseInt(stk.nextToken());
                double _score = Double.parseDouble(stk.nextToken());

                Student st = new Student(_id, _name, _age, _score);
                listStudents.add(st);
            }

            bfr.close();
            fr.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void writeDataToFile(String filename) {
        
        if (listStudents.isEmpty()) {
            System.out.println("Không cần ghi file");
            return;
        }
        
        try 
        {
            File f = new File(filename);

            FileWriter fw = new FileWriter(f);

            PrintWriter pw = new PrintWriter(fw);

            for (Student st : listStudents) {
                pw.println(st.getId() + "," + st.getName() + ","
                        + st.getAge() + ","
                        + st.getScore());
            }

            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
