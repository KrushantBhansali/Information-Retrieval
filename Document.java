/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package informationretrival;

/**
 *
 * @author Krunal Nisar
 */
public class Document {
    
    String name;
    int noOfWords;

    public int getNoOfWords() {
        return noOfWords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public void setNoOfWords(int noOfWords) {
        this.noOfWords = noOfWords;
    }
    
    
}
