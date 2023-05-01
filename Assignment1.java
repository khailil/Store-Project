import java.util.*;

public class Assignment1 {
	
	public static void main(String [] args){
		Scanner inScan = new Scanner(System.in);
		
		System.out.println("Is there a customer waiting? (y/n)\n");
		String start = new String(inScan.nextLine());
		
		if(start.equalsIgnoreCase("y")) {
			String cont = new String("y");
			
			while(cont.equalsIgnoreCase("y")){
				System.out.println("Welcome to Weasley's Wizard Wheezes!\n");
				System.out.println("Our prices are as follows:");
				System.out.println("	Pygmy Puffs: 290 Knuts each");
				System.out.println("	Extendable Ears: 60 Knuts each");
				System.out.println("	Extendable Ears: 160 Knuts for a bag of three");
				System.out.println("	Trick Wand (regular): 1479 Knuts Each");
				System.out.println("	Trick Wand (autographed): 2465 Knuts Each\n");
				
				System.out.println("If you would like, you can attempt a challenge question \nfor a chance at a discount. Otherwise you can proceed \nnormally. If you do attempt the challenge question, be \nwarned that answering incorrectly will result in an \nadditional 10% charge on your final bill.\n");
				
				System.out.println("Do you accept the challenge? (y/n)\n");
				String chall = new String(inScan.nextLine());
				
				int discount = 0;
				
				if(chall.equalsIgnoreCase("y")) {
					System.out.println("Who wrote 'Fantastic Beasts and where to Find them'?\n");
					String ans1 = new String(inScan.nextLine());
					if(ans1.equalsIgnoreCase("Newt Scamander")) {
						System.out.println("Good job, that's correct! Discount for you!\n");
						discount = 1;
					}
					else {
						System.out.println("Sorry, the correct answer was 'Newt Scamander'!\nThat's going to be a 10% penalty!\n");
						discount = 2;
					}
					System.out.println("Well, now that that's done, why don't you take a look around?\n");
				}
				else {
					System.out.print("Ah well, maybe next time then. \nWhy don't you go take a look around?\n");
				}
				
				double total = 0.0;
				int shopTrack = 0;
				double floopus = 0.0;
				int pygTot, earTot, wandTot, wandaTot;
				pygTot = earTot = wandTot = wandaTot = 0;
				
				int pygPay, earPay, wandPay, wandaPay;
				pygPay = earPay = wandPay = wandaPay = 0;
				// I should change this to cases instead of a while loop maybe.
				
				
				while(shopTrack != 5) {
					System.out.println("\n(1) Buy Pygmy Puffs\n(2) Buy Extendable Ears\n(3) Buy Trick Wands\n(4) Check Cart\n(5) Checkout\n");
					shopTrack = inScan.nextInt(); inScan.nextLine();
					
					
					if(shopTrack == 1) {
						System.out.println("How many puffs would you like to buy?\n");
						pygTot = inScan.nextInt(); inScan.nextLine();
						if(pygTot > 0) {
							total += pygTot * 290;
							pygPay += pygTot;
						}
					}
					else if(shopTrack == 2) {
						System.out.println("How many ears would you like to buy?\n");
						earTot = inScan.nextInt(); inScan.nextLine();
						if(earTot > 3) {
							int weasel = earTot / 3;
							int doofus = earTot % 3;
							total += doofus * 60 + weasel * 160;
							earPay += doofus * 60 + weasel * 160;
						}
						else if(earTot > 0) {
							total = earTot * 60;
							earPay += earTot;
						}
					}
					else if(shopTrack == 3) {
						System.out.println("What kind of trick wand would you like to buy?\n");
						
						
						int loopa = 0;
						while(loopa == 0) {
							loopa = 1;
							String typeW = new String(inScan.nextLine());
							if(typeW.equalsIgnoreCase("autographed")) {
								System.out.println("How many would you like to buy?\n");
								wandaTot = inScan.nextInt(); inScan.nextLine();
								if(wandaTot > 0) {
									total += wandaTot * 2465;
									wandaPay += wandaTot;
								}
							}
							else if(typeW.equalsIgnoreCase("regular")) {
								if(discount == 1) {
									System.out.println("Are you sure you don't want an autographed one?\nIt's the same price as this with the discount. (y/n)");
							
									String wundT = new String(inScan.nextLine());
										
										if(wundT.equalsIgnoreCase("y")) {
											System.out.println("Lovely! How many would you like to buy?\n");
											wandaTot = inScan.nextInt(); inScan.nextLine();
											if(wandaTot > 0) {
												total += wandaTot * 2465;
												wandaPay += wandaTot;
											}
										}
										else if(wundT.equalsIgnoreCase("n")) {
											System.out.println("Alright then. How many would you like to buy?\n");
											wandTot = inScan.nextInt(); inScan.nextLine();
											if(wandTot > 0) {
												total += wandTot * 2465;
												wandPay += wandTot;
											}
											
										}
										else {
											System.out.println("Sorry, what was that?");
										}
								}
							}
							else {
								System.out.println("Please enter a valid wand type.\n");
								loopa = 0;
							}
						}
					}
					else if(shopTrack == 4) {
						//System.out.println("Currently in your cart are:\n" + pygTot + " Pygmy Puffs\n" + earTot + " Extendable Ears\n" + wandTot + " Trick Wands (regular)\n" + wandaTot + " Trick Wands (autographed)\n");
						System.out.println("Currently in your cart are:");
						
						if(pygTot > 0) {
							System.out.println(pygTot + " Pygmy Puffs for: " + wandPay + " Knuts\n");
						}
						
						if(earTot > 0) {
							System.out.println(earTot + " Extendable Ears for: " + earPay + " Knuts\n");
						}
						
						if(wandTot > 0) {
							System.out.println(wandTot + " Trick Wands (regular) for: " + wandPay + " Knuts\n");
						}
						
						if(wandaTot > 0) {
							System.out.println(wandaTot + " Trick Wands (autographed) for: " + wandaPay + " Knuts\n");
						}
						floopus = total;
						
						if(discount == 1) {
							floopus = total * 0.9;
							
							System.out.println("Discount currently applied.");
						}
						int floopu = (int)floopus;
						System.out.println("Your current total is " + floopu + " Knuts.");
						if(discount == 2) {
							double flonkus = total * 0.1;
							int flonku = (int)flonkus;
							System.out.println("Your penalty for failing the challenge is " + flonku + " Knuts.");
						}
						
						System.out.println("To remove an item from your cart enter it as a negative number in the buy option.");
						
					}
					else if(shopTrack == 5) {
						
						if(discount == 1) {
							total = total * 0.9;
						}
						else if(discount == 2) {
							total = total * 1.1;
						}
						
						int finalTot = (int)total;
						
						System.out.println("Alright, your total is " + finalTot + " Knuts. \nAre you okay with this total? (y/n)\n");
						String temp = new String(inScan.nextLine());
						double payTot = 0.0;
						
						if(temp.equalsIgnoreCase("y")) {
							
							for(double i = 0.0; i < total;) {
								System.out.println("Please enter your payment type (Galleons, Sickles, or Knuts)\n");
								
								String curr = new String(inScan.nextLine());
								
								System.out.println("Now enter how much you would like to pay with this type.");
								
								int currMult = inScan.nextInt(); inScan.nextLine();
								
								if(curr.equalsIgnoreCase("Sickles")) {
									payTot += (currMult * 29);
									i += (currMult * 29);
								}
								else if(curr.equalsIgnoreCase("Sickle")) {
									payTot += (currMult * 29);
									i += (currMult * 29);
								}
								else if(curr.equalsIgnoreCase("Galleons")) {
									payTot += (currMult * 493);
									i += (currMult * 493);
								}
								else if(curr.equalsIgnoreCase("Galleon")) {
									payTot += (currMult * 493);
									i += (currMult * 493);
								}
								else if(curr.equalsIgnoreCase("Knuts")) {
									payTot += currMult;
									i += currMult;
								}
								else if(curr.equalsIgnoreCase("Knut")) {
									payTot += currMult;
									i += currMult;
								}
								else {
									System.out.println("Not a valid currency type. Try again.\n");
								}
							}
							
							System.out.println("Your current payment balance is: " + payTot + " Knuts.\n");
							
							if(payTot > total) {
								double chang = payTot - total;
								int fine = (int)chang;
								
								int galChang = fine / 493;
								int galRem = fine % 493;
								
								int sickChang = galRem / 29;
								int sickRem = galRem % 29;
								
								int knutChang = sickRem / 29;
								
								System.out.print("Your change is ");
								if(galChang != 0) {
									System.out.print(galChang + " Galleons ");
								}
								
								if(sickChang != 0) {
									System.out.print(sickChang + " Sickles ");
								}
								
								if(knutChang != 0) {
									System.out.print(knutChang + " Knuts ");
								}
								
								System.out.print("\n");
							}
							
							
							System.out.println("Thanks for shopping at Weasley's Wizard Wheezes!\n");
						}
						else {
							shopTrack = 0;
						}
					}
					else {
						System.out.println("Please enter a valid number.");
					}
				}
				
				System.out.println("Is there another customer waiting? (y/n)");
				cont = inScan.nextLine();
			}
		}
		else {
			System.out.println("Guess I'll go take a break if there's no one waiting.");
		}
	}
	
}
