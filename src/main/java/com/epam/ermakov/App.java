package com.epam.ermakov;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class App {

    public static  void main(String[] args) {
        String filePath = new File("").getAbsolutePath();
        filePath.concat("path to the property file");
        //System.out.println(filePath);
        Menu menu = new Menu();
        menu.addEntry(new MenuEntry("View") {
            @Override
            public void run() throws ParserConfigurationException, SAXException, IOException {
                System.out.println("Список записей");
                DOM dom = new DOM();
                dom.dOMView();
            }

        });
        menu.addEntry(new MenuEntry("Add a note") {
            @Override
            public void run() throws ParserConfigurationException, SAXException, IOException {
                System.out.println("Список записей");
                DOM dom = new DOM();
                dom.dOMAddNote();
                System.out.println("введите тип  сотрудника");
                System.out.println("Ввод фамилии");
                System.out.println("ввод имени");
                System.out.println("ввод год рождения");
                System.out.println("телефон");
                System.out.println("Введите тип отдела/менеджера");
            }
        });//не работает
        menu.addEntry(new MenuEntry("Searching by surname ") {
            @Override
            public void run() {
                System.out.println("Введите фамилию для поиска");
            }
        });//не работает
        menu.addEntry(new MenuEntry("Searching by name") {
            @Override
            public void run() {
                System.out.println("Введите имя для поиска");
            }
        });//не работает
        menu.addEntry(new MenuEntry("Searching by phone number") {
            @Override
            public void run() {
                System.out.println("Введите телефон для поиска");
            }
        });//не работает
        menu.addEntry(new MenuEntry("save file") {
            @Override
            public void run() {
                System.out.println("сохранить изменения");
            }
        });//не работает
        menu.addEntry(new MenuEntry("import") {
            @Override
            public void run() {
                OperationWithFiles operationWithFiles =new OperationWithFiles();
                try {
                    operationWithFiles.imp();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        menu.addEntry(new MenuEntry("export") {
            @Override
            public void run() {
                OperationWithFiles operationWithFiles =new OperationWithFiles();
                try {
                    operationWithFiles.export();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        menu.run();
    }
}
