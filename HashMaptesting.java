/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informationretrival;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Krunal Nisar
 */
public class HashMaptesting {

    public static void main(String args[]) throws IOException, FileNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner sc;
        BufferedReader bf;
        String word;
        HashMap<String,Integer> tempHashMap;
        ArrayList<HashMap<String, Integer>> map = null;
        HashMap<String, ArrayList<HashMap<String, Integer>>> mapping = new HashMap<String, ArrayList<HashMap<String, Integer>>>();

        System.out.println("Enter No of files need to be stored");
        int no = s.nextInt();

        for (int i = 1; i <= no; i++) 
        {

            sc = new Scanner(new FileInputStream("F://" + i + ".txt"));
            while (sc.hasNext()) {
                word = sc.next();
                if (mapping.containsKey(word))
                {
                    ArrayList<HashMap<String, Integer>> temp = mapping.get(word);

                    for (HashMap<String, Integer> tempDocList : temp) 
                    {
                        if (tempDocList.containsKey(i + ".txt")) 
                        {
                            int count = tempDocList.get(i + ".txt");
                            count++;
                            tempDocList.put(i + ".txt", count);
                        }

                        else
                        {
                            tempHashMap = new HashMap<String, Integer>();
                            tempHashMap.put(i+".txt", 1);
                            temp.add(tempHashMap);

                        }

                    } 
                    
                }
                
                else 
                {
                    map = new ArrayList<HashMap<String, Integer>>();
                    tempHashMap = new HashMap<String, Integer>();
                    tempHashMap.put(i + ".txt", 1);
                    map.add(tempHashMap);
                    mapping.put(word, map);
                }

            }

        }

        System.out.println(mapping);
        //System.out.println("Enter the elemnents to be searched");
        //String search = s.next();

//        Iterator keys = mapping.keySet().iterator();
//             while(keys.hasNext())
//        {
//            String abc =  (String) keys.next();
//            Map m = mapping.get(abc);
//            if(m.containsKey(search))
//            {
//               System.out.println("The word "+search+" is present in doc"+abc+" and has word count "+m.get(search));
//           }
//        }
    }
}
