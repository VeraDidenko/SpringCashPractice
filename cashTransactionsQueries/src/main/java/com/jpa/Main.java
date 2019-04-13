package com.jpa;

import com.jpa.model.Student;
import com.jpa.worker.StudentWorker;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationSpring.class);

        System.out.println("\n-----------------------------------------------");
        System.out.println("Cash demonstration:");
        System.out.println("-----------------------------------------------\n");

        StudentWorker studentWorker = context.getBean(StudentWorker.class, "studentWorker");
        Student student = studentWorker.getStudent(2);
        System.out.println(student);

        student = studentWorker.getStudent(2);
        System.out.println(student);


        System.out.println("\n-----------------------------------------------");
        System.out.println("Dynamic query:");
        System.out.println("-----------------------------------------------\n");

        for (Student student1 : studentWorker.findAllDynamicQuery()) {
            System.out.println(student1);
        }

        System.out.println("\n-----------------------------------------------");
        System.out.println("Criteria Api Query:");
        System.out.println("-----------------------------------------------\n");

        for (Student student1 : studentWorker.findAllCriteriaApi()) {
            System.out.println(student1);
        }

        System.out.println("\n-----------------------------------------------");
        System.out.println("Named query:");
        System.out.println("-----------------------------------------------\n");

        for (Student student1 : studentWorker.findAllNamedQuery()) {
            System.out.println(student1);
        }

        System.out.println("\n-----------------------------------------------");
        System.out.println("Native query:");
        System.out.println("-----------------------------------------------\n");

        for (Student student1 : studentWorker.findAllNativeQuery()) {
            System.out.println(student1);
        }


        context.close();

    }

}
