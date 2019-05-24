package com.epam.ermakov;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    boolean check=false, flag = false;
    int count1=1,count=1;
    public String surname, name, year, phone,manager, department;

    public void check(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("выбирите менеджер или отдел: 1-сотрудник, 2-менеджер:");
        String flagMD = in.nextLine();
        count = Integer.parseInt(flagMD);
        checkName (in, count1);
        count1++;
        checkName (in, count1);
        count1--;
        checkNum(in);
        checkPhone(in);
        count1=1;
        checkManDep(in,count);
        if (count==1) System.out.printf("Фамилия %s, имя %s, год рождения %s, телефон %s менеджер %s\n", surname,name,year,phone,manager);
        else System.out.printf("Фамилия %s, имя %s, год рождения %s, телефон %s отдел %s\n", surname,name,year,phone,department);

        in.close();


    }
    private void checkManDep(Scanner in,int count) {
        switch (count){

            case 1:{
                System.out.print("Введите фамилию и имя менеджера ");
                checkName(in, count1);
                count1++;
                checkName(in,count1);
                manager=surname+" "+name;
                break;
            }
            case 2:{
                do {
                    Pattern pattern = Pattern.compile("[a-zA-Z]+");
                    if (flag==true)System.out.println("Ввод только латиницей ");
                    System.out.print("Введите название отдела: ");
                    department = in.nextLine();
                    Matcher matcher = pattern.matcher(department);
                    if (matcher.matches()) check=true;
                    else flag= true;
                } while (!check);
                flag = false;
                break;
            }
        }
    }

    private void checkName(Scanner in,int count1) {
        switch (count1){
            case 1:{
                do {
                    Pattern pattern = Pattern.compile("[а-яА-Я]+");
                    if (flag==true)System.out.println("Ввод только Кириллицей ");
                    System.out.print("Введите фамилию: ");
                    surname = in.nextLine();
                    Matcher matcher = pattern.matcher(surname);
                    if (matcher.matches()) check=true;
                    else flag= true;
                } while (!check);
                flag = false;
                break;
            }
            case 2:{
                do {
                    Pattern pattern = Pattern.compile("[а-яА-Я]+");
                    if (flag==true)System.out.println("Ввод только Кириллицей ");
                    System.out.print("Введите Имя: ");
                    name = in.nextLine();
                    Matcher matcher = pattern.matcher(name);
                    if (matcher.matches()) check=true;
                    else flag= true;
                } while (!check);
                flag = false;
                break;
            }
        }
    }
    public void checkNum (Scanner in) {
        do {
            Pattern pattern = Pattern.compile("\\d{4}");
            if (flag == true) System.out.println("Введите цифрами год рождения после 1919");

            System.out.print("Введите год: ");
            year = in.nextLine();
            int i = Integer.parseInt(year);
            Matcher matcher = pattern.matcher(year);
            if (matcher.matches() || (1919 < i && i < 2001)) check = true;
            else flag = true;
        } while (!check);
        flag =false;
    }
    public void checkPhone (Scanner in) {
        do {
            Pattern pattern = Pattern.compile("^((\\+?7)(d{10}))$");
            if (flag == true) System.out.println("неверный ввод, формат ввода+7**********  ");
            System.out.print("Введите  моб. телефон: ");
            phone = in.nextLine();
            Matcher matcher = pattern.matcher(phone);
            if (matcher.matches()) check = true;
            else flag = true;
        } while (!check);
        flag =false;
    }
}