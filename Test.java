/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package informationretrival;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Krunal Nisar
 */
public class Test {
    
    public static void main(String args[]) throws FileNotFoundException, IOException
    {
    int line = 0;
    BufferedReader sc;
    sc = new BufferedReader(new FileReader("F:\\NorthEastern University\\Spring 2015\\Program Structures and ALogorithms\\final project\\IR\\dataset\\check.txt"));
    while(sc.readLine() != null)    
    {
            
            System.out.println("lines no "+sc.);
        
    }
    }
}
