/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package informationretrival;

import java.util.HashMap;

/**
 *
 * @author Krunal Nisar
 */
public class BM25 {
    
    final static float k = (float) 2.0;
    final static float b= (float) 0.75;
    private static HashMap<String,Float> scoreMap = new HashMap<String,Float>();
    
   public  float calculateIDF(int totalDocument, int noOfDocumentContainingTerm)
   {
            System.out.println("Total Document"+totalDocument);
            System.out.println("noOfDocumentContainingTerm"+noOfDocumentContainingTerm);
//            double numerator = totalDocument - noOfDocumentContainingTerm + 0.5;
//            double denominator = noOfDocumentContainingTerm + 0.5;
//            double fraction = numerator/denominator;
//            System.out.print(fraction);
//            System.out.println("Calculate IDF"+(float) Math.log10(fraction));
//            return (float) Math.log10(fraction);
               double numerator = totalDocument;
               double denominator = noOfDocumentContainingTerm;
                double fraction = numerator/denominator;
                System.out.print(1 + (float) Math.log10(fraction));
                return (1 + (float) Math.log10(fraction));
        
   }
   
   public  float calculateMultipleScore(int term, int noOfTerms, float averageCount)
   {
      
            double numerator = term * 2.2;
            double endTerm =  (0.75*noOfTerms)/averageCount;
            
            double denominator = term + (1.2 * (1-0.75+endTerm));
            double fraction = numerator/denominator;
            
            return (float) Math.log(fraction);
        
   }
   
   
   public  float calculateSecondTem(int termFrequency, int documentLength, float averageDocumentLength)
   {
       double numerator = termFrequency * (k+1);
       double denominator = termFrequency + k * (1 - b + b*(documentLength/averageDocumentLength));
       double fraction = numerator/denominator;
       System.out.println("Calculating Second Term "+fraction);
        return (float) fraction;
   }
   
   
   public  float finalScore(float firstterm,float secondTerm, String document)
   {
       float score = firstterm * secondTerm;
       
       if(scoreMap.containsKey(document))
       {
           float originalScore = scoreMap.get(document);
           originalScore = originalScore +  score;
           scoreMap.put(document, originalScore);
       }
       else
       {
            scoreMap.put(document, score);
       }
            return score;
   }

    public static HashMap<String, Float> getScoreMap() {
        return scoreMap;
    }

    public static void setScoreMap(HashMap<String, Float> scoreMap) {
        BM25.scoreMap = scoreMap;
    }
   
   
}
