package bankapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    public static List<String[]> readFromFile(String file){
        List<String[]> list = new LinkedList<>();
        String line;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            while((line = br.readLine())!=null){
                String[] dataArray = line.split(",");
                list.add(dataArray);
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found!");
            e.printStackTrace();

        } catch (IOException e){
            System.out.println("Can't read file!");
            e.printStackTrace();
        }

        return list;
    }
}
