package lab5.strategyPatternImplementations;

import lab5.interfaces.IDrinkable;
import java.util.Random;

public class SpartanDrinksImplementation implements IDrinkable {

    @Override
    public int drink() {
        Random rand = new Random();
        int sip = 55 + rand.nextInt(300); // sorbo promedio de espartano, de 55mL a 350mL (toman más lento)
        return sip;
    }
}
