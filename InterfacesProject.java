/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interfacesproject;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author TMacRae2026
 */
public class InterfacesProject {

    public static void main(String[] args) {
        //Create an arraylist of tasks
        ArrayList<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Study for Biology test", 4, 10));
        tasks.add(new Task("Complete Catholic Innovations homework", 1, 4));
        tasks.add(new Task("Walk the dog", 3, 1));
        tasks.add(new Task("Buy the AP Lang book", 3, 4));
        
        //sort the tasks by priority from highest to lowest (and complexity if the priority is the same)
        Collections.sort(tasks);
        //the list is backwards, so make it forwards
        Collections.reverse(tasks);
        
        //print the sorted tasks
        System.out.println("Sorted tasks list: ");
        for(Task t : tasks) {
            System.out.println(" - " + t.name + "\n - Priority: " + t.getPriority() + "\n - Complexity: " + t.getComplexity() + "\n"); // print out all the tasks and their priorities
        }
    }
}

class Task implements Priority, Complexity, Comparable<Task> {
    String name;
    private int priorityLevel;
    private int complexity;
    
    
    public Task(String name, int priorityLevel, int complexity) {
        this.name = name;
        this.priorityLevel = priorityLevel;
        this.complexity = complexity;
    }
    
    //impliment the methods from priority
    @Override
    public void setPriority(int level) {
        this.priorityLevel = level;
    }
    
    @Override
    public int getPriority() {
        return priorityLevel;
    }
    
    
    //impliment the methods from complexity
    @Override
    public int getComplexity() {
        return complexity;
    }
    
    @Override
    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }
    
    //impliment the compare method from Comparable
    @Override
    public int compareTo(Task other) {
        if(this.priorityLevel != other.priorityLevel){
            return Integer.compare(this.priorityLevel, other.priorityLevel);
        } else {
            // if the tasks have the same priority, compare by complexity
            return Integer.compare(this.complexity, other.complexity);
        }
    }
    
}

//create interface priority
interface Priority {
    void setPriority(int priority);
    int getPriority();
}

//create interface complexity
interface Complexity {
    void setComplexity(int complexity);
    int getComplexity();
}
