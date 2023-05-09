package com.example.pokus1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DataSaving {

    //Zde budeme ukládat data z 'data' folderu

    public static int[] sumUpNumbers(String directoryFilePath) {
        File directory = new File(directoryFilePath);
        File[] files = directory.listFiles(File::isFile);
        int[] returnArray = new int[4];
        String[] arr;
        int counter = 0;
        if (files != null) {
            for (File file : files) {
                counter++;
                try {
                    BufferedReader br = new BufferedReader(new FileReader(file));
                    String st;
                    while ((st = br.readLine()) != null) {
                        arr = st.split(";");

                        //Uložení do listu
                        //Sečtení všech dat (ze všech vytvořených souborů)
                        returnArray[0] += Integer.parseInt(arr[0]);
                        returnArray[1] += Integer.parseInt(arr[1]);
                        returnArray[2] += Integer.parseInt(arr[2]);
                    }

                } catch (IOException ignored) {
                }
            }
        }
        returnArray[3] = counter;
        return returnArray;
    }
 }










