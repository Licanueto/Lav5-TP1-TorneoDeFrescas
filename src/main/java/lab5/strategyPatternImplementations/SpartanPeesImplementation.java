package lab5.strategyPatternImplementations;

import lab5.interfaces.IPeeable;
import java.util.Random;

public class SpartanPeesImplementation implements IPeeable {

    @Override
    public void pee() {
        System.out.println(" A Spartan is peeing, Il spartano è fuori dalla coppa");
    }

    @Override
    public float likelihoodOfPeeing(int amountIngested) {
        Random rand = new Random();
        float randy = 1+ rand.nextInt(55); // randomInt es un numero entre 1 y 55 (Espartanos aguantan más)
        float likelihood = (randy/100)*((float)amountIngested/1000); // transformo el random en probabilidad (entre 0 y 1) y lo multiplico por la cantidad ingerida sobre 1000 para que esta afecte a la probabilidad de orinar
        /*System.out.println("\n amountIngested = " + amountIngested + "mL" +
                "\n random (1-40) = " + randy +
                "\n Likelyhood = "+likelihood);*/
        if(likelihood>=1) pee();
        return likelihood;
    }

}
