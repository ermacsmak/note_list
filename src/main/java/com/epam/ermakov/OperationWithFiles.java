package com.epam.ermakov;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OperationWithFiles {
    public  void export (String[] args)  {

    }
    private static void copyFile(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    public void export() throws IOException {
        File source = new File("C:\\Users\\ermac\\IdeaProjects\\gameoffiles\\src\\main\\resources\\xml_file1.xml");
        File dest = new File("C:\\Users\\Public\\Documents\\xml_file1.xml");
        System.out.println("Провека на наличие файла экспорта");
        if (!dest.exists()){
            copyFile (source, dest);
            System.out.println("Экспорт завершен, имя файла xml_file1.xml, папка назначения C:\\Users\\Public\\Documents");
        }
        else {
            Path pathSource = Paths.get("C:\\Users\\Public\\Documents\\xml_file1.xml");
            try {
                Files.delete(pathSource);
                System.out.println("File deleted successfully");
                copyFile(source, dest);
                System.out.println("Экспорт завершен, имя файла xml_file1.xml, папка назначения C:\\Users\\Public\\Documents");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void imp() throws IOException {
        File source = new File("C:\\xml_file1.xml");
        File dest = new File("C:\\Users\\ermac\\IdeaProjects\\gameoffiles\\src\\main\\resources\\xml_file1.xml");
        System.out.println("Провека на наличие файла импорта");
        if (!dest.exists()){
            copyFile (source, dest);
            System.out.println("Импорт завершен, имя файла xml_file1.xml, папка назначения C:\\Users\\ermac\\IdeaProjects\\gameoffiles\\src\\main\\resources");
        }
        else {
            Path pathSource = Paths.get("C:\\Users\\Public\\Documents\\xml_file1.xml");
            try {
                Files.delete(pathSource);
                System.out.println("File deleted successfully");
                copyFile(source, dest);
                System.out.println("Импорт завершен, имя файла xml_file1.xml, папка назначения C:\\Users\\ermac\\IdeaProjects\\gameoffiles\\src\\main\\resources");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

