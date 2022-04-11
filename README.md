# Decision-Trees
Explores an application of binary decision trees. Implements a DecisionTree class as a subclass of BinaryTree<String>, and uses it to write a program that will play a simple "20 Questions" style guessing game. The user playing the game will help to create the tree. Each time the program guesses wrong, the tree will be extended by one node, as shown in the sample session below.

$ java AnimalGuess
Think of an animal.
I'll try to guess it.
Is your animal a Mouse?
no
I got it wrong.
Please help me to learn.
What was your animal?
Crocodile
Type a yes or no question that would distinguish between a Crocodile and a Mouse
Is it a mammal?
Would you answer yes to this question for the Crocodile?
no
Play again?
yes
Think of an animal.
I''ll try to guess it.
Is it a mammal?
no
Is your animal a Crocodile?
yes
I guessed it!
Play again?
no
$
  

