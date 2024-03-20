package com.sparta.shh.readwrite;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteApp
{
    public static void main(String[] args) {
        String myPathString = "src/main/resources/Todo.txt";
        String myOutputPathString = "src/main/resources/output.txt";
        String myOutputPathString2 = "src/main/resources/listOutput2.txt";
        System.out.println("Read all lines using nio");

        var result = readNioAllLines(myPathString);
        System.out.println(result);

        for (String line : result)
        {
            System.out.println(line);
        }
        readLineByLineNio(myPathString);
        System.out.println("write using nio - all text");
        String whatToWrite = "Pretend this is a very long string that I want to write to a file";
        writeNio(myOutputPathString,whatToWrite);
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        writeStringListNio(myOutputPathString2,result);

    }

    private static void writeStringListNio(String pathString, List<String> result)
    {
        Path thePath = Paths.get(pathString);
        try{
            Files.write(thePath,result.stream().toList());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static void writeNio(String pathString, String whatToWrite)
    {
        Path thePath = Paths.get(pathString);
        try {
            Files.write(thePath,whatToWrite.getBytes());
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private static List<String> readNioAllLines(String myPathString)
    {
        List<String> readLines = null;
        Path path = Paths.get(myPathString);
        try {
            readLines = Files.readAllLines(path);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return readLines;
    }

    private static void readLineByLineNio(String myPathString) {
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(myPathString))) {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
    }
//    private static void readLineByLineNio(String myPathString)
//    {
//        String line;
//        BufferedReader reader = null;
//        try {
//            reader = Files.newBufferedReader(Paths.get(myPathString));
//            while ((line = reader.readLine()) != null)
//            {
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();;
//
//        }
//        finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }





