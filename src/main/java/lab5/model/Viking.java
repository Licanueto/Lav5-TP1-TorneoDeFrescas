package lab5.model;

import lab5.interfaces.IDrinkable;
import lab5.interfaces.IPeeable;

public class Viking extends Human{

    private Integer proDrinker;

    public Viking(String name, Integer age, Integer weight, IPeeable interface_pee, IDrinkable interface_drink, Integer proDrinker) {
        super(name, age, weight, interface_pee, interface_drink);
        this.proDrinker = proDrinker;
    }

    @Override
    public String toString() {
        return " I'm a Viking so I'm a pro...drinker of level "+proDrinker+ ", " + super.toString();
    }
    @Override
    public String basicPresentation(){
        return " I'm a Viking that's standing still! "+super.basicPresentation();
    }

    public Integer getProDrinker() {
        return proDrinker;
    }


}
