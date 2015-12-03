import java.util.*;
import java.io.*;
import java.lang.*;

/*
 * Poker is a family of gambling card games involving betting and individual play, 
 * whereby the winner is determined by the ranks and combinations of players' cards.
 * 
 * Poker is played with 2 - 10 players with a deck of 52 cards.
 * The game begins with a deal of a hand to each player.
 * A hand has 5 random cards from the deck.
 * The player(or players, as ties are possible) with the best hand rank wins the game.
 * 
 * A deck of 52 cards has 13 cards from 2 to 10, Jack, Queen, King and Ace.
 * 2 has the least rank and Ace has the highest rank.
 * There are 4 suits, 2 red and 2 black.
 * Red suits are Diamonds and Hearts.
 * Black suits are Clubs and Spades.
 * All colors have equal rank in poker.
 *
 * Card Code: 2 from the diamond suit will be given a code 2D. Similarly, Ace from Space will be AS.
 * 
 * The following are the poker hand ranks highest to least:
 * 1Royal Flush - A straight from a ten to an ace with all five cards of the same suit.
 * Ex: AH, KH, QH, JH, TH
 
 * 2Straignt Flush - Any straight with all five cards of the same suit.
 * Ex: 9C, 8C, 7C, 6C, 5C
​
 * 3Four of a Kind - Any four cards of the same rank.
 * Ex: AH, AS, AD, AC, KH
 *  - If two players share the same Four of a Kind (on the board), the bigger fifth card (the "kicker") decides who wins the pot.
​
 * 4Full House - Any three cards of the same rank together with any two cards of the same rank.
 * Ex: AH, AS, AD, KH, KS
 *  - Our example shows "Aces full of Kings" and it is a bigger full house than "Kings full of Aces."
​
 * 5Flush - Any five cards of the same suit (not consecutive).
 * Ex: AS, TS, 7S, 6S, 2S
 *  - The highest card of the five determines the rank of the flush. Our example shows an Ace-high flush, which is the highest possible.
​
 * 6Straight - Any five consecutive cards of different suits.
 * Ex: 5C, 4D, 3S, 2H, Ah
 *  - Aces can count as either a high or a low card. Our example shows a five-high straight, which is the lowest possible straight.
​
 * 7Three of a Kind - Any three cards of the same rank.
 * Ex: AH, AS, AD, KS, QC
 *  - Our example shows three-of-a-kind Aces, with a King and a Queen as side cards - the best possible three of a kind.
​
 * 8Two Pair - Any two cards of the same rank together with another two cards of the same rank.
 * Ex: AH, AS, KC, KD, QS
 *  - Our example shows the best possible two-pair, Aces and Kings. The highest pair of the two determines the rank of the two-pair.
​
 * One Pair - Any two cards of the same rank.
 * Ex: AH, AS, KH, QS, JD
 *  - Our example shows the best possible one-pair hand.
​
 * High Card - Any hand not in the above-mentioned hands.
 * Ex: AH, KS, QD, JC, 9S
 *  - Our example shows the best possible high-card hand.
 *
 * FAQs are available in this web page: http://www.pokerlistings.com/poker-hand-ranking
 * 
 * Your task is to write a "Object Oriented Program" using Java which takes hands between 2 to 10 and print the best hand or hands.
 * 
 * The following test cases will be used to evaluate your program. Each test case is separated by a new line.
 *
 * INPUT:
 * TS JC QD KH AH
 * AC 2H 3S 4D 5S
 * AD 2D 3D 4D 5D
 * TS JS QS KS AS
 * OUTPUT:
 * TS JS QS KS AS
 *
 * INPUT:
 * AH KH QH TH 2H
 * 5H 5S 3H 6S 9D
 * 9H 9S 9D KS QC
 * OUTPUT:
 * AH KH QH TH 2H
 * 
 * INPUT:
 * 9D 9S 9H 6C 6S
 * 3D 3S 2C 2S AH
 * OUTPUT:
 * 9D 9S 9H 6C 6S
 */
public class poker2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str;
		StringTokenizer st;
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		ArrayList<String> sublist;
		int count = 0;
		while(sc.hasNext()) {
			str = sc.nextLine();
			if(str.equalsIgnoreCase("END")) {
				break;
			}
			count++;
			sublist = new ArrayList<String>();
			st = new StringTokenizer(str," ");
			while(st.hasMoreTokens()) {
				sublist.add(st.nextToken());
			}
			list.add(sublist);
		}
		cards cd = new cards(list);
		cd.getRanks();
		cd.print();
	}
}
@SuppressWarnings("deprecation")
class cards {
	ArrayList<ArrayList<String>> cards;

	ArrayList<Integer> winners = new ArrayList<>();
	cards(ArrayList<ArrayList<String>> cards){
		this.cards = cards;
	}
	String str[] = {"A","K","Q","J","T","9","8","7","6","5","4","3","2"};
	String str1[] = {"H","D","C","S"};
	ArrayList<String> suits = new ArrayList<>(Arrays.asList(str1));
	//int rank[] = {}
	
	ArrayList<String> ranks = new ArrayList<>(Arrays.asList(str));
	public void print() {
		int count = 0;
		int min = (int)Collections.min(winners);
		//System.out.println(min);
		for(int i = 0; i < winners.size(); i++) {
			if(winners.get(i) == min)  {
				//System.out.println("final");
				//System.out.println("i"+i);
				String str = cards.get(i)+"";
				str = str.substring(1,str.length()-1);
				StringTokenizer st1 = new StringTokenizer(str,",");
				while(st1.hasMoreTokens()) {
					System.out.print(st1.nextToken());
				}
				System.out.println();
				//System.out.println(cards.get(0).toString());
			}
		}
		System.out.println(winners);
		// System.out.println(ranks);
		// System.out.println(suits);
		// System.out.println(cards);
	}
	public void getRanks() {
		//System.out.println("came");
		for(int i = 0; i < cards.size(); i++) {
			findRank(cards.get(i));
		}
	}
	public void findRank(ArrayList<String> subCards) {
		//System.out.println(subCards);
		String s = subCards.get(0).charAt(1)+"";
		String r = subCards.get(0).charAt(0)+"";
		ArrayList<String> com = new ArrayList<String>();
		ArrayList<String> com1 = new ArrayList<String>();
		//System.out.println(s);
		int suitcount = 0;
		int rankCount = 0;
		for(int i = 0; i < 5; i++) {
			//System.out.println(r);
			if(r.equals(subCards.get(i).charAt(0)+"")) {
				//System.out.println("s"+subCards.get(i));
				rankCount++;
			}
			//r = subCards.get(i).charAt(0)+"";
			if(s.equals(subCards.get(i).charAt(1)+"")) {
				//System.out.println("s"+subCards.get(i));
				suitcount++;
			}
		}
		System.out.println("rank: "+rankCount+" "+r);
		System.out.println("suit: "+ suitcount+" "+s);
		int straightCount =1;
		int temp = ranks.indexOf(subCards.get(0).charAt(0)+"");
		for(int i = 1; i < 5 ; i++) {
			//System.out.println("stra");
			int temp2 = ranks.indexOf(subCards.get(i).charAt(0)+"");
				if(temp==0) {
					straightCount++;
				}
				if(temp ==temp2-1 || temp == temp2+1) {
					straightCount++;
				}
				//System.out.println("temp: "+temp+" temp2: "+temp2);
				if(temp2 == 0) {
					straightCount++;
				}
				//System.out.println("temp: "+temp+" temp2: "+temp2);
				temp = temp2;

			}
			//System.out.println(straightCount);
		if(straightCount == 5 && suitcount!=5) {
			winners.add(6);
			//continue;
		}
		else if(suitcount == 5) {
				//System.out.println("royal");
			temp = ranks.indexOf(subCards.get(0).charAt(0)+"");
			//System.out.println(temp);
			int flag = 1;
			for(int i = 1; i < 5 ; i++) {
				int temp2 = ranks.indexOf(subCards.get(i).charAt(0)+"");
				if(temp ==temp2-1 || temp == temp2+1) {
					flag++;
				}
				//System.out.println("temp: "+temp+" temp2: "+temp2);
				temp = temp2;

			}
			//if(flag == 5 && subCards.get(0).charAt(0)+"")
			if(flag==5) {
				String s1 = subCards.get(0).charAt(0)+"";
				String s2 = subCards.get(4).charAt(0)+"";
				if(s1.equals("A") && s2.equals("T")) {
					winners.add(1);
				}
				else {
					winners.add(2);
				}
			}
			else {
				winners.add(5);
			}
		}
		else if(rankCount == 4) {
			winners.add(3);
		}
		else if(rankCount == 3) {
			int innerRank = 0;
			for(int i = 0; i < 5; i++) {
				if(!r.equals(subCards.get(i).charAt(0)+"")) {
					if(!com.contains(subCards.get(i).charAt(0)+"")) {
						com.add(subCards.get(i).charAt(0)+"");
						innerRank++;
					}
				}
			}
			if(innerRank == 2) {
				winners.add(7);
			}
			if(innerRank < 2) {
				winners.add(4);
			}
		}
		else if(rankCount == 2) {
			int innerRank = 0;
			com = new ArrayList<>();
			for(int i = 0; i < 5; i++) {
				if(!r.equals(subCards.get(i).charAt(0)+"")) {
					if(!com.contains(subCards.get(i).charAt(0)+"")) {
						com.add(subCards.get(i).charAt(0)+"");
						innerRank++;
					}
				}
			}
			if(innerRank == 2) {
				winners.add(8);
			}
			if(innerRank == 3) {
				winners.add(9);
			}
			int innerRank1 = 0;
		}
		else {
			winners.add(10);
		}
	}
}