import java.util.Scanner;

//import org.graalvm.nativebridge.jni.JNI.Throw;

/**
 *  Class to let user play animal guessing game
 *
 *  @authors Zoe and Deepa
 *  @version Spring 2022
 *
 */
public class AnimalGuess{

  /**
  * Allows user to play game by calling myGame() method 
  *
  *  @param String[] args, the name of txt file to make a decision tree 
  */
  public static void main(String[] args){
      myGame(DecisionTree.readTreeLine(args[0]));
  }

  /**
  * Boolean testing if input is equivalent to yes or no
  * @param String response, a string representing either yes or no
  * @return boolean, true if input is equivalent to 'yes' and false if 'no'. Otherwise throws an error. 
  */
  public static boolean isYes(String response){
    if(response.equals("Y") || response.equals("Yes") || response.equals("y") || response.equals("yes")){
      return true;
    }
    else if(response.equals("N") || response.equals("No") || response.equals("n") || response.equals("no")){
      return false;
    }
    else{
      throw new IllegalArgumentException("not a valid input");
    }
  }

  /** 
  *  Asks user to answer questions in decision tree and attemps to guess what the animal is. If the guess is wrong it promps the user to give new decision tree to get to correct answer. 
  *  @param myTree Decision tree the path should follow to reach guess 
  *   
  */

  public static void myGame(DecisionTree myTree){
    System.out.println("Think of an animal. I bet I can guess what your animal is!");
    DecisionTree myNode = myTree;
    Scanner sc = new Scanner(System.in);
    while(!myNode.isLeaf()){
      System.out.println(myNode.getData());
      String response = sc.nextLine();
      if(isYes(response)){
        myNode = myNode.getLeft();
      }
      else{
        myNode = myNode.getRight();
      }
    }
    System.out.println("Your animal is a " + myNode.getData());
    System.out.println("Did I guess your animal correctly?");
    String correct = sc.nextLine();
    if(!isYes(correct)){
      System.out.println("Oh no I got it wrong :(. Please help me to learn. What was your animal?");
      String correctAnimal = sc.nextLine();
      System.out.println("Type a yes or no question that would distinguish between my guess and your animal");
      String question = sc.nextLine();
      System.out.println("Would you answer yes to this question for your animal?");
      String answer = sc.nextLine();
      String guessAnimal = myNode.getData();
      myNode.setData(question);
      //DecisionTree newTree = new DecisionTree(question);
      if(isYes(answer)){
        myNode.setLeft(new DecisionTree(correctAnimal));
        myNode.setRight(new DecisionTree(guessAnimal));
      }
      else{
        myNode.setRight(new DecisionTree(correctAnimal));
        myNode.setLeft(new DecisionTree(guessAnimal));
      }
      //myNode = newTree;
      myTree.toFile2("");
      
    }
    System.out.println("Do you want to play again?");
    String playAgain = sc.nextLine();
    if(isYes(playAgain)){
      myGame(myTree);
    }
    else{
      System.out.println("Thanks for playing!");
      sc.close();
    }
  }
}