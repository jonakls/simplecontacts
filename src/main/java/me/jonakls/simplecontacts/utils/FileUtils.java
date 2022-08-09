package me.jonakls.simplecontacts.utils;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileUtils {

    public static File createFile(String file) {
        String fileName = file.endsWith(".txt") ? file : file + ".txt";
        File userFile = new File(fileName);

        try {
            if (!userFile.exists()) {
                userFile.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al crear el archivo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return userFile;
    }

    public static File createFile(String file, String customPath) {
        File folder = new File(customPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        String fileName = file.endsWith(".txt") ? file : file + ".txt";
        File file1 = new File(customPath + fileName);
        try {
            if (!file1.exists()) {
                file1.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error al crear el archivo",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return file1;
    }


}
