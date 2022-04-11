//import java.util.ArrayList;
//import java.util.*;
//import java.util.Arrays;
//import java.util.stream.Collectors;
//import java.io.File;  // Import the File class
//import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;


/**
 *  Implements a binary decision tree
 *
 *  @Zoe and Deepa
 *  @version Spring 2022
 *
 */
public class DecisionTree extends BinaryTree<String> {
  /** leaf constructor */
  public DecisionTree(String s) {
    super(s);
  }

  /** @override */
  public void setLeft(BinaryTree<String> left) {
    if ((left==null)||(left instanceof DecisionTree)) {
      super.setLeft(left);
    } else {
      throw new UnsupportedOperationException();
    }
  }

  /** @override */
  public DecisionTree getLeft() {
    return (DecisionTree)super.getLeft();
  }

  /** @override */
  public DecisionTree getRight() {
    return (DecisionTree)super.getRight();
  }

  /** 
  *  Implements a binary decision tree
  * 
  *  @Zoe and Deepa
  *  @version Spring 2022
  *
  */
  public DecisionTree followPath(String myPath){
    DecisionTree currentNode = this;
    if(myPath == "") {
      return currentNode; 
    }
    for(char c : myPath.toCharArray()){
      if(c == 'Y'){
        currentNode = currentNode.getLeft();
      }
      else if (c == 'N'){
        currentNode = currentNode.getRight();
      }
    }
    return currentNode;
  }


  
  //input function - deepa 
  /** 
  *  writes input function to read decisionTree from txt file 
  *  @param filename String name of file 
  *  @return tree user's decision tree 
  *
  */
  public static DecisionTree readTreeLine(String filename) {
    DecisionTree tree = null; 
    try{
      File myObj = new File(filename);
      Scanner myReader = new Scanner(myObj); 
      String line = ""; 
      while(myReader.hasNextLine()) {
        line = myReader.nextLine(); 
        int index = line.indexOf(" "); 
        String path = line.substring(0, index); //gives path ex:YNY
        String info = line.substring(index + 1); //gives text ex: is it a mammal
        if(path == "") {
          tree = new DecisionTree(info); 
        }
        else {
          String parent = path.substring(0, path.length()-1); //YN if path was YNY
          String child = path.substring(path.length()-1); 
          DecisionTree newTree = tree.followPath(parent); 
          if(child.equals("Y")) {
            newTree.setLeft(new DecisionTree(info)); 
        
          }
          else if(child.equals("N")) {
            newTree.setRight(new DecisionTree(info)); 
          }
        }
        //System.out.println(line);  
      }
      myReader.close(); 
    }
    
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
    }
    
    return tree;
  }
  
  
  /** 
  *  Creates a new PrintWriter and calls dtoFile method 
  *  @param String currPath, a path through the decision tree (ie "YNY") 
  *
  */
  public void toFile2(String currPath){
    try{
      PrintWriter out = new PrintWriter(new FileWriter("Animal Tree.txt"));
      dtoFile(currPath, out);
      out.close();
    }
    catch(IOException e){
      System.out.println("Can not follow path");
    }
  }

  /** 
  *  Prints out decision tree line by line in preorder transversal
  *  @param String currPath, a path through the decision tree (ie "YNY") 
  *  @param PrintWriter out, a Printwriter the lines will be printed to
  */
  
  public void dtoFile(String currPath, PrintWriter out){
    DecisionTree myNode = this;   
    if(myNode.isLeaf()) {
      out.println(currPath + " " + myNode.getData()); 
    } else {
        out.println(currPath + " " + myNode.getData()); 
      if(myNode.getLeft() != null) {
        currPath += "Y";
        myNode.getLeft().dtoFile(currPath, out);  
      }
      if(myNode.getRight() != null) {
        currPath = currPath.substring(0, currPath.length()-1);
        currPath += "N"; 
        myNode.getRight().dtoFile(currPath, out); 
      }
    }
  }
}


    