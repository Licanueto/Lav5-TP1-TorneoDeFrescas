package lab5.strategyPatternImplementations;

import lab5.interfaces.IDrinkable;
import java.util.Random;

public class VikingDrinksImplementation implements IDrinkable {

    @Override
    public int drink() {
        Random rand = new Random();
        int sip = 60 + rand.nextInt(305); // sorbo promedio de vikingo, de 60mL a 365mL (toman más rápido)
        return sip;
    }
}
