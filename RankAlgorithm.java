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
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Krunal Nisar
 */
public class RankAlgorithm {

    public static void main(String args[]) throws IOException, FileNotFoundException {
        Scanner s = new Scanner(System.in);
        Scanner sc;
        BufferedReader bf;
        String word;
        float averageDocumentCount;
        float DocumentCount = 0;
        HashMap<String, Integer> map = null;
        HashMap<String, HashMap<String, Integer>> mapping = new HashMap<String, HashMap<String, Integer>>();
        BM25 bm25 = new BM25();
        HashMap<String,Integer> documentMap = new HashMap<String,Integer>();
        ArrayList<Document> documentList = new ArrayList<>();
        System.out.println("Enter No of files need to be stored");
        int no = s.nextInt();

        for (int i = 1; i <= no; i++) 
        {
            int noOfCounts = 0;
            sc = new Scanner(new FileInputStream("F:\\NorthEastern University\\Spring 2015\\Program Structures and ALogorithms\\final project\\IR\\dataset\\"+i+".txt"));
            Document d = new Document();
            d.setName(i+".txt");
            while (sc.hasNext()) 
            {
                noOfCounts++;
                word = sc.next();
                if (mapping.containsKey(word)) 
                {
                    HashMap<String, Integer> temp = mapping.get(word);
                    
                    if(temp.containsKey(i+".txt"))
                    {
                        int count =  temp.get(i+".txt");
                        count++;
                        temp.put(i+".txt"   , count);
                    }
                    
                    else
                    {
                       // map = new HashMap<String, Integer>();
                        temp.put(i+".txt"   , 1);
                        //map.put(i+".txt", 1);
                        //mapping.put(word,map);
                        
                    }
                    
                   
                } 
                else 
                {
                    map = new HashMap<String, Integer>();
                    map.put(i+".txt", 1);
                    mapping.put(word,map);
                }

            }
            d.setNoOfWords(noOfCounts++);
            documentMap.put(i+".txt", d.getNoOfWords());
            documentList.add(d);
            
        }

        System.out.println(mapping);
        for(Document d : documentList)
        {
            System.out.println(d.getName()+" "+d.getNoOfWords());
            DocumentCount = DocumentCount + d.getNoOfWords();
            
        }
        
        averageDocumentCount = DocumentCount/documentList.size();
        System.out.println(averageDocumentCount);
        
    
        
      
        
        System.out.println("Enter the string to be searched");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        String words = br.readLine();
        
            //sc = new Scanner(new FileInputStream("F:\\NorthEastern University\\Spring 2015\\Program Structures and ALogorithms\\final project\\IR\\dataset\\check.txt"));
            
            for(String search  : words.split(" "))
            {
                    //String search = s.next();
                    System.out.println("*************************");
                    System.out.println(search);
                     System.out.println("*************************");
                    if(mapping.containsKey(search))
                        {
                    HashMap<String,Integer> temp = mapping.get(search);
                    int size = temp.size();
                    
                    Iterator keys = temp.keySet().iterator();
                    while(keys.hasNext())
                    {
                        String document = (String) keys.next();
                        int termfrequency  = temp.get(document);
                        float firstTerm =  bm25.calculateIDF(documentList.size(), size);
                        int documentLength = documentMap.get(document);
                        
                        float secondTerm = bm25.calculateSecondTem(termfrequency, documentLength, averageDocumentCount);
                        float score = bm25.finalScore(firstTerm, secondTerm, document);
                        System.out.println("FInal SCORE: "+score+" for  Document    "+document);
                        
                    }
                   
                    
                    
                    
                        
                     //System.out.println(score);
                }
        }
        
        System.out.println(BM25.getScoreMap());
//                    Iterator keys = temp.keySet().iterator();
//                    while(keys.hasNext())
//                    {
//                       String abc =  (String) keys.next();
//
//                        int frequency = temp.get(abc);
//
//                               System.out.println("Documents :"+abc+" "+"Frequency :"+frequency);

               
               
            
        
         //  Iterator keys = mapping.keySet().iterator();
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
