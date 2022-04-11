
/**
 *  Class to test DecisionTree class
 *
 *  @Zoe and Deepa
 *  @version Spring 2022
 *
 */
class Main {
  /*
  * Method to test DecisionTree class methods
  */
  
  public static void main(String[] args) {
    System.out.println("Hello world!");
    DecisionTree myTree = new DecisionTree("Is it a mammal?");
    myTree.setLeft(new DecisionTree("Does is have feet?"));
    myTree.setRight(new DecisionTree("Does it have scales"));
    myTree.getLeft().setLeft(new DecisionTree("Dog"));
    myTree.getLeft().setRight(new DecisionTree("footless cat"));
    myTree.getRight().setLeft(new DecisionTree("Aligator"));
    myTree.getRight().setRight(new DecisionTree("slug"));
    System.out.println(myTree.followPath("Y")); 
    //AnimalGuess.myGame(myTree);
    //System.out.println(DecisionTree.readTreeLine()); 
    //myTree.toFile2("");  
  }
}

 