import java.util.List;
import java.util.Set;

/**
 * Created by bedaa on 09/03/2017.
 */
public class Lottery {
    List<Set<String >> lotterytickets;
    Integer Supernumber;

    public Lottery( List<Set<String>> lotterytickets , Integer Supernumber){
        this.lotterytickets = lotterytickets;  //the (six) numbers
        this.Supernumber = Supernumber;  //the supernumber
    }
}
