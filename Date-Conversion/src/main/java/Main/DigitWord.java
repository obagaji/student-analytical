package Main;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class DigitWord {

    private final HashMap<Integer, String> timeMap = new HashMap<>();
    private  int minutes;
    int h;

    public DigitWord() {
        setData();
        getMinutes();
        getHour();
    }
    private void setData() {
        timeMap.put(0, "O'Clock");
        timeMap.put(1, "one");
        timeMap.put(2, "two");
        timeMap.put(3, "three");
        timeMap.put(4, "four");
        timeMap.put(5, "five");
        timeMap.put(6, "six");
        timeMap.put(7, "seven");
        timeMap.put(8, "eight");
        timeMap.put(9, "nine");
        timeMap.put(10, "ten");
        timeMap.put(11, "eleven");
        timeMap.put(12, "twelve");
        timeMap.put(13, "thirteen");
        timeMap.put(14, "fourteen");
        timeMap.put(15, "quarter pass");
        timeMap.put(16, "sixteen");
        timeMap.put(17, "seventeen");
        timeMap.put(18, "eighteen");
        timeMap.put(19, "nineteen");
        timeMap.put(20, "twenty");
        timeMap.put(21, "twenty-one");
        timeMap.put(22, "twenty-two");
        timeMap.put(23, "twenty-three");
        timeMap.put(24, "twenty-four");
        timeMap.put(25, "twenty-five");
        timeMap.put(26, "twenty-six");
        timeMap.put(27, "twenty-seven");
        timeMap.put(28, "twenty-eight");
        timeMap.put(29, "twenty-nine");
        timeMap.put(30, "half pass");
        timeMap.put(45, "quarter to");
    }
    public int getHour() {
        JOptionPane.showMessageDialog(null, "Enter Digit Between 1 to 12");
        Scanner inputsHour = new Scanner(System.in);
        this.h = inputsHour.nextInt();
        if (h <= 0 && h > 12) {
            JOptionPane.showMessageDialog(null, "Please Enter Digit Between 1 to 12");
            Scanner inputHour = new Scanner(System.in);
            h = inputHour.nextInt();
        }
        return h;
    }
    public int getMinutes() {
        JOptionPane.showMessageDialog(null, "Enter minute: Digit Between 0 to 59");
        Scanner input = new Scanner(System.in);
        this.minutes = input.nextInt();
        if (minutes > 0 && minutes > 59) {
            JOptionPane.showMessageDialog(null, "Enter minute: Digit Between 0 to 59");
            Scanner inputs = new Scanner(System.in);
            minutes = inputs.nextInt();
        }
        return minutes;
    }
    public String displayTime(int hrs, int mins) {

        StringBuilder stringBuilder = new StringBuilder();
        if (mins == 0) {
            stringBuilder.append(timeMap.get(hrs));
            stringBuilder.append(" ");
            stringBuilder.append(timeMap.get(mins));
            System.out.printf("%s %s ", timeMap.get(hrs), timeMap.get(mins));
        } else if (mins > 30 && mins != 45) {
            int reminder = 60 - mins;
            stringBuilder.append(timeMap.get(reminder));
            stringBuilder.append(" ");
            stringBuilder.append("minute to");
            hrs = hrs + 1;
            stringBuilder.append(" ");
            stringBuilder.append(timeMap.get(hrs));

        } else if (mins < 30) {
            stringBuilder.append(timeMap.get(mins));
            stringBuilder.append(" ");
            stringBuilder.append("minute pass");
            stringBuilder.append(" ");
            stringBuilder.append(timeMap.get(hrs));

        } else if (mins == 45) {
            stringBuilder.append(timeMap.get(mins));
            hrs = hrs + 1;
            stringBuilder.append(" ");
            stringBuilder.append(timeMap.get(hrs));
        } else if (mins == 30) {
            stringBuilder.append(timeMap.get(mins));
            stringBuilder.append(" ");
            stringBuilder.append(timeMap.get(hrs));
        }
        return stringBuilder.toString();
    }


}
