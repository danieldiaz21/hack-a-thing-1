package com.tutorialChallenge;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient("Brad", 28,
                new Eye("Left Eye", "Short-sighted", "Blue", true),
                new Eye("Right Eye", "Niormal", "blue", true),
                new Heart("Heart", "Normal", 65),
                new Stomach("Sotmahc", "PUD", false),
                new Skin("Skin", "burned", "white", 40));
        System.out.println("Name: " + patient.getName());
        System.out.println("Age: " + patient.getAge());

        Scanner scanner = new Scanner(System.in);

        boolean shouldFinish = false;
        while (!shouldFinish) {
            System.out.println("Choose an Organ: " +
                    "\n\t1. LEft Eye" +
                    "\n\t2. right eye" +
                    "\n\t3. heart" +
                    "\n\t4. stomach" +
                    "\n\t5. skin" +
                    "\n\t6. quit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    patient.getLeftEye().getDetails();
                    if (patient.getLeftEye().isOpened()) {
                        System.out.println("\t\t1. close the eyey");
                        if (scanner.nextInt() == 1) {
                            patient.getLeftEye().close();
                        } else {
                            continue;
                        }
                    }else {
                        System.out.println("\t\t1. open the eye");
                        if (scanner.nextInt() == 1) {
                            patient.getLeftEye().open();
                        } else {
                            continue;
                        }
                    }
                    break;
                case 2:
                    patient.getRightEye().getDetails();
                    if (patient.getRightEye().isOpened()) {
                        System.out.println("\t\t1. close the eyey");
                        if (scanner.nextInt() == 1) {
                            patient.getRightEye().close();
                        } else {
                            continue;
                        }
                    }else {
                        System.out.println("\t\t1. open the eye");
                        if (scanner.nextInt() == 1) {
                            patient.getRightEye().open();
                        } else {
                            continue;
                        }
                    }
                    break;
                case 3:
                    patient.getHeart().getDetails();
                    System.out.println("\t\t1. Change hte heart rate");
                    if (scanner.nextInt() == 1) {
                        System.out.println("Enter the new heart rate: ");
                        int newHeartRate = scanner.nextInt();
                        patient.getHeart().setRate(newHeartRate);
                    } else {
                        continue;
                    }
                    break;
                case 4:
                    patient.getStomach().getDetails();
                    System.out.println("\t\t1. Digest");
                    if (scanner.nextInt() ==1 ){
                        patient.getStomach().digest();
                    } else{
                        continue;
                    }
                    break;
                case 5:
                    patient.getSkin().getDetails();
                    break;
                default:
                    shouldFinish = true;
                    break;
            }
        }
    }
}
