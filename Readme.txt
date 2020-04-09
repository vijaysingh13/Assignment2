EXECUTION OF THE PROGRAM:
Our program accpets the input(ie fake coin) the user needs to input the weight of fake coin and its position

DESCRIPTION
1) The main program accepts Number of coins,weight of coin,position and then it is passed to Function COIN
2)  Now in function COIN it is checked if position is greater than number of coins if it is true then the given position is invalid
3) The next function is COMPARE COINS here the bag of coins is divided into 3 parts namely Left,middle,Right if the weight of left bag is equal to right bag then it is sure 
   that the counterfeit coin is present in the right bag and then the counterfiet coin is found using divide and conquer method
   if weight of left bag is not equal to middle bag then either one of the bag will contain the counterfiet coin .Now the left and middle bag weight is compared with
    the right bag weight. one with the same weight will not contain the counterfiet coin and the counterfiet coin is found in the other bag 

