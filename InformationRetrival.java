/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package informationretrival;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Krunal Nisar
 */
public class InformationRetrival {

      
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        
        int noOfWords=0;
        Score score = null;
        Scanner s = new Scanner(System.in);
        Scanner sc;
        BufferedReader bf;
        String word;
        ArrayList<Score> scoreList  = null;
        HashMap<String, ArrayList<Score> > mapping = new HashMap<String, ArrayList<Score>>();

        System.out.println("Enter No of files need to be stored");
        int no = s.nextInt();

        for (int i = 1; i <= no; i++) 
        {
             
            sc = new Scanner(new FileInputStream("F://"+i+".txt"));
            while (sc.hasNext()) {
                
                word = sc.next();
                if (mapping.containsKey(word)) 
                {
                    ArrayList<Score> temp = mapping.get(word);
                    for(Score sco : temp)
                    {
                        if(sco.getDocument().getName().equals(i+".txt"))
                        {
                            sco.setCount(sco.getCount()+1);
                        }
                    }
                }
                
                else
                    
                    {
                         scoreList = new ArrayList<Score>();
                         score = new Score();
                         score.setCount(1);
                         score.getDocument().setName(i+".txt");
                         scoreList.add(score);
                         mapping.put(word, scoreList);
                    }
                    
                   noOfWords++;
                }
                score.getDocument().setNoOfWords(noOfWords);
            
        }
                

            
        
        System.out.println(mapping);
        System.out.println(noOfWords);
        for(Score scoo :scoreList )
        {
        System.out.println("name : "+scoo.getDocument().getName()+" "+scoo.getDocument().getNoOfWords());
        }
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
