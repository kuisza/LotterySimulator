import java.util.Set;
import java.util.TreeSet;

/**
 * Created by bedaa on 09/03/2017.
 */
public class Generator {
    public Set<String> thewinners() {

        Set<String> thewinners = new TreeSet<>();
        String randomNum;

        while (thewinners.size() < 6) {
            randomNum = Integer.toString((int) (Math.random() * 49) + 1); // Random number created here between 1-49.
            if (!thewinners.contains(randomNum)) { // Here, code checks if same random number generated before.
                thewinners.add(randomNum);
            }

        }

        return thewinners;

    }

}
