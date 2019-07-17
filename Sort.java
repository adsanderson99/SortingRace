/*************************************************************************
 *
 *  Pace University
 *  Fall 2018
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team members: Austin Sanderson
 *  Collaborators: n/a
 *  References: Data Structure & Algorithm Analysis in Java, page 289
 *
 *  Assignment: Assignment #5
 *  Problem: To compare sorting methods
 *  Description: The run times will be compared from method that uses selection
 *      sort and two methods that use quick sort with different pivot positions
 *
 *  Input: An array of integers 
 *  Output: The runtime of three sort methods 
 *
 *  Visible data fields:
 *  n/a
 *
 *  Visible methods:
 *  public static void selectionSort(List<Integer> items)
 *  public static void quickSort(List<Integer> items)
 *  public static void randomQuickSort(List<Integer> items)
 *  public static void main(String[] args)    
 *
 *************************************************************************/

import java.util.ArrayList;
import java.util.List;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class Sort 
{
    /**
     * Sorts a list of Integers using Selection Sort
     */
    public static void selectionSort(List<Integer> items){
        for (int i = 0; i < items.size(); i++) {
            int index = i;
            for (int j = i; j < items.size(); j++) {
                if (items.get(j) < items.get(index))
                    index = j;
            }
            int min = items.get(index);
            items.set(index, items.get(i));
            items.set(i, min);
        }
    }
    
    /**
     * Sorts a list of Integers using Quick Sort
     */
    public static void quickSort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> small = new ArrayList();
            List<Integer> same    = new ArrayList();
            List<Integer> large  = new ArrayList();
            Integer chosenItem = items.get(items.size() / 2);
            for(Integer i : items){
                if(i < chosenItem)
                    small.add(i);
                else if(i > chosenItem)
                    large.add(i);
                else
                    same.add(i);
            }

            quickSort(small );
            quickSort(large );

            items.clear( );
            items.addAll(small);
            items.addAll(same);
            items.addAll(large);
        }  
    }
    
    /**
     * Sorts a list of Integers using Quick Sort with a random pivot
     */
    public static void randomQuickSort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> small = new ArrayList();
            List<Integer> same    = new ArrayList();
            List<Integer> large  = new ArrayList();
            Integer chosenItem = items.get((int)(Math.random() * items.size() + 
                    1));
            for(Integer i : items){
                if(i < chosenItem)
                    small.add(i);
                else if(i > chosenItem)
                    large.add(i);
                else
                    same.add(i);
            }

            quickSort(small );
            quickSort(large );

            items.clear( );
            items.addAll(small);
            items.addAll(same);
            items.addAll(large);
        }  
    }
    
    public static void main(String[] args){
        List<Integer> increase1 = new ArrayList();
        List<Integer> decrease1 = new ArrayList();
        List<Integer> random1 = new ArrayList();
        List<Integer> increase2 = new ArrayList();
        List<Integer> decrease2 = new ArrayList();
        List<Integer> random2 = new ArrayList();
        List<Integer> increase3 = new ArrayList();
        List<Integer> decrease3 = new ArrayList();
        List<Integer> random3 = new ArrayList();
        
        for(int a = 1; a <= 1000; a++){
            increase1.add(a);
            increase2.add(a);
            increase3.add(a);
        }

        for(int b = 1000; b > 0; b--){
            decrease1.add(b);
            decrease2.add(b);
            decrease3.add(b);
        }
        
        for(int c = 0; c < 1000; c++){
            random1.add((int)(Math.random() * 1000 + 1));
            random2.add((int)(Math.random() * 1000 + 1));
            random3.add((int)(Math.random() * 1000 + 1));
        }
        
        System.out.println("Selection Sort");

        long sI = System.nanoTime();
        selectionSort(increase1);
        System.out.println("Increasing: The time taken was " + (System.nanoTime() - sI) + " nanoseconds.");
        
        long sD = System.nanoTime();
        selectionSort(decrease1);
        System.out.println("Decreasing: The time taken was " + (System.nanoTime() - sD) + " nanoseconds.");
        
        long sR = System.nanoTime();
        selectionSort(random1);
        System.out.println("Random: The time taken was " + (System.nanoTime() - sR) + " nanoseconds.");
        
        System.out.println("\n-----------\n");
        System.out.println("Quick sort with Mean Pivot");

        long qI = System.nanoTime();
        quickSort(increase2);
        System.out.println("Increasing: The time taken was " + (System.nanoTime() - qI) + " nanoseconds.");
        
        long qD = System.nanoTime();
        quickSort(decrease2);
        System.out.println("Decreasing: The time taken was " + (System.nanoTime() - qD) + " nanoseconds.");
        
        long qR = System.nanoTime();
        quickSort(random2);
        System.out.println("Random: The time taken was " + (System.nanoTime() - qR) + " nanoseconds.");
        
        System.out.println("\n-----------\n");
        System.out.println("Quick Sort With Random Pivot");

        long rI = System.nanoTime();
        randomQuickSort(increase3);
        System.out.println("Increasing: The time taken was " + (System.nanoTime() - rI) + " nanoseconds.");
        
        long rD = System.nanoTime();
        randomQuickSort(decrease3);
        System.out.println("Decreasing: The time taken was " + (System.nanoTime() - rD) + " nanoseconds.");
        
        long rR = System.nanoTime();
        randomQuickSort(random3);
        System.out.println("Random: The time taken was " + (System.nanoTime() - rR) + " nanoseconds.");
    }
  
}
