//Question 1 counterfeit coin question
import java.util.Scanner;
public class coin {
// method to read coin length
	private Coin[] initializeCoins(int numCoins,int weight,int position){     
		if(position>numCoins)                                             
		{
			System.out.println("Invalid Position");
			System.exit(1);
		}
		Coin[] coins = new Coin[numCoins];
		for(int j = 0; j < coins.length; j++)
			coins[j] = new Coin(1, j);
		coins[position].setWeight(weight);  // this is the fake coin
		System.out.println("The fake coin is a position " + position);
		return coins;
	}
	//method to compare weight of coins
	private int compareCoins(Coin[] left, Coin[] right){
		if(left.length != right.length)
			System.out.println("unequal piles");
		int leftWeight = 0;
        for (Coin aLeft : left)
            leftWeight += aLeft.getWeight();
		int rightWeight = 0;
        for (Coin aRight : right)
            rightWeight += aRight.getWeight();
        if(leftWeight==rightWeight)
        	return 0;
        else
        	return leftWeight;
	}
	
	private void searchMessage(Coin[] coins){
		if (coins.length >= 1){
			System.out.println("searching from " + coins[0].getPosition()+ " to " 
					+ coins[coins.length - 1].getPosition());
		} else
			System.out.println("searching empty array");
	}
//method to search the position of counterfeit coin
	private int findFakeCoin(Coin[] coins){
		int j=0,k=0;
		//checking for different weights of coin(ie lighter,heavier)
		if(coins.length == 0)
			return -1;
		else if(coins.length == 1) 
			return coins[0].getPosition();
		else if(coins.length == 2)
			return coins[0].getWeight()!=1?coins[0].getPosition():coins[1].getPosition();
		else {
			// bag containing coins is divided into 3 parts
			int third = coins.length / 3;
			Coin[] leftCoins=new Coin[third];
			Coin[] middleCoins=new Coin[third];
			Coin[] rightCoins=new Coin[coins.length-(2*third)];
			for(int i=0;i<third;i++)
				leftCoins[i]=coins[i];
			for(int i=third;i<2*third;i++)
				middleCoins[j++]=coins[i];
			for(int i=2*third;i<coins.length;i++)
				rightCoins[k++]=coins[i];
			//comparing left and middle bag
			int result = compareCoins(leftCoins, middleCoins); 
			if(result == 0) { 
				searchMessage(rightCoins);
				return findFakeCoin(rightCoins);
			}
			else if(result==third)
			{
				searchMessage(middleCoins);
				return findFakeCoin(middleCoins);
			}
			else
			{
				searchMessage(leftCoins);
				return findFakeCoin(leftCoins);
			}
		}
	}
//reading and initializing no of coins,weight,position
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int weight,position,num;
		System.out.println("Enter the Number of coins and defective coin weight and position");
		num=scanner.nextInt();
		weight=scanner.nextInt();
		position=scanner.nextInt();
		coin fc = new coin();
		Coin[] coins = fc.initializeCoins(num,weight,position);
		int fakeCoinPosition = fc.findFakeCoin(coins);
        System.out.println("fake coin is found at position " + fakeCoinPosition);
	}
	
	private class Coin {  // inner class
		int weight;
		int position;
		
		Coin(int weight, int position){
			this.weight = weight;
			this.position = position;
		}
		//method to get weight
		int getWeight() {
			return weight;
		}
		
		void setWeight(int weight){
			this.weight = weight;
		}
		//get position method
		int getPosition(){
			return position;
		}
	}

}

