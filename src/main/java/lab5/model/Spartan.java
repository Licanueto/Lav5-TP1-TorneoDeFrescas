package lab5.model;

import lab5.interfaces.IDrinkable;
import lab5.interfaces.IPeeable;

public class Spartan extends Human{

    private Integer extraTolerance;

    public Spartan(String name, Integer age, Integer weight, IPeeable interface_pee, IDrinkable interface_drink, Integer extraTolerance) {
        super(name, age, weight, interface_pee, interface_drink);
        this.extraTolerance = extraTolerance;
    }

    @Override
    public String toString() {
        return " I'm a Spartan and thus I've got an extra tolerance of "+extraTolerance+ ", " + super.toString();
    }

    @Override
    public String basicPresentation(){
        return " I'm a Spartan that's still going strong! "+super.basicPresentation();
    }
}
