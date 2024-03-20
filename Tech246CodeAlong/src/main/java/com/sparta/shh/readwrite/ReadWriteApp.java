package com.sparta.shh.readwrite;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadWriteApp
{
    public static void main(String[] args) {
        String myPathString = "src/main/resources/Todo.txt";
        System.out.println("Read all lines using nio");

        var result = readNioAllLines(myPathString);
        System.out.println(result);

        for (String line : result)
        {
            System.out.println(line);
    }}

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
}
