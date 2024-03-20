package com.sparta.shh.readwrite;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ToDoManager
{
    private List<ToDo> toDoList = new ArrayList<>();

    public List<ToDo> readToDosFromFile(String fileName)
    {
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(fileName))) {
            while ((line = reader.readLine()) != null) {
                //create a ToDo object and add it to the list

                toDoList.add(createToDo(line));
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return toDoList;
    }

    public ToDo createToDo(String line)
    {
        var splitString = line.split((","));
        ToDo toDo = new ToDo(splitString[0].trim(),splitString[1].trim(), splitString[2].trim(),
                splitString[3].trim(),splitString[4].trim());
        return toDo;
    }
}
