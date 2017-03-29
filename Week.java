import java.util.*;

/**
 * Created by bedaa on 08/03/2017.
 */

public class Week {
    public void weekly() {
        Random rand = new Random();
        Scanner sk = new Scanner(System.in);
        System.out.println("Please type in your lotto numbers that you wanna play with. ");
        System.out.println("This program has the same rules as the lottery in Baden-Württenberg, Germany.");
        System.out.println("You have to choose six number between 1 - 49");
        System.out.println("Additionally a random 'super number' between 1 -9 will be added to your ticket.");
        System.out.println("Separate the numbers with ';'  on one ticket and separate the different tickets with '-'");
        String numbers = sk.nextLine();
        String[] tickets = numbers.split("-");
        //the program turns our lottery tickets into sets of strings and put them into a list
        List<Set<String>> lottery = new ArrayList<>();
        for (String tick : tickets ) {
            Set<String> lottset = new TreeSet<String>(Arrays.asList(tick.split(";")));
            if (lottset.size() == 6) {
        lottery.add(lottset); }
           else {
                throw new NullPointerException("you have to give six numbers for each field");
            }

        }
        int  n = rand.nextInt(10);
        Lottery ourlotteryticket = new Lottery(lottery , n);

        System.out.println("You have " + lottery.size() + " tickets");
        System.out.println("Please type in for how many round you would like to buy the tickets.");
        int w = sk.nextInt();
        System.out.println("You have bought it for " + w + " rounds. Its gonna be "
                + (lottery.size() * w ) + ",20 euro");
        int twosup = 0;
        int three = 0;
        int threesup = 0;
        int four = 0;
        int foursoup = 0;
        int five = 0;
        int fivesoup = 0;
        int six = 0;
        int sixsoup = 0;
        for (int v = 1; v <= w ; v++) {
            Generator gen = new Generator();
            Set<String> thenumbers = gen.thewinners();
            int sup = rand.nextInt(10);
            System.out.println("----------");
            System.out.println(v + ". week:");



            for (Set<String> set : ourlotteryticket.lotterytickets) {
                System.out.println("----------");
                System.out.println("Our numbers:");
                System.out.println(set);
                System.out.println("The numbers");
                System.out.println(thenumbers);
                Set<String> common = new TreeSet<>(set);
                common.retainAll(thenumbers);
                int retain = common.size();
                System.out.print("the following numbers are the same:");
                System.out.println(common);
                System.out.println("which makes " + retain + " numbers ");
                System.out.println("Our supernumber is:" + ourlotteryticket.Supernumber);
                System.out.println("The supernumber of the round:" + sup);
                System.out.println("----------");
                if (retain == 2 && sup == ourlotteryticket.Supernumber) {
                        twosup++;
                }
                else if (retain == 3 && sup != ourlotteryticket.Supernumber) {
                    three++;
                }
                else if (retain == 3 && sup == ourlotteryticket.Supernumber) {
                    threesup++;
                }
                else if (retain == 4 && sup != ourlotteryticket.Supernumber) {
                    four++;
                }
                else if (retain == 4 && sup == ourlotteryticket.Supernumber) {
                    foursoup++;
                }
                else if (retain == 5 && sup != ourlotteryticket.Supernumber) {
                    five++;
                }
                else if (retain == 5 && sup == ourlotteryticket.Supernumber) {
                    fivesoup++;
                }
                else if (retain == 6 && sup != ourlotteryticket.Supernumber) {
                    six++;
                }
                else if (retain == 6 && sup == ourlotteryticket.Supernumber) {
                    sixsup++;
                }

                System.out.println("----------");
            }
        }

        //the results after the last week
        System.out.println("Two + sup: " + twosup);
        System.out.println("Three: " + three);
        System.out.println("Three + sup: " + threesup);
        System.out.println("Four: " + four);
        System.out.println("Four + sup: " + foursoup);
        System.out.println("Five: " + five);
        System.out.println("Five + sup: " + fivesoup);
        System.out.println("Six: " + six);
        System.out.println("Six + sup: " + sixsoup);

    }
}
