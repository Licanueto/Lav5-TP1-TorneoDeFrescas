package lab5.model;

import lab5.interfaces.IDrinkable;
import lab5.interfaces.IPeeable;

import java.util.Objects;

public class Human implements Comparable{
    private String name;
    private Integer age;
    private Integer weight;
    private Integer amountIngested;
    private IPeeable peeingStyleImp;
    private IDrinkable drinkingStyleImp;

    public Human(String name, Integer age, Integer weight, IPeeable peeingStyleImp, IDrinkable drinkingStyleImp) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.amountIngested = 0;
        this.peeingStyleImp = peeingStyleImp;
        this.drinkingStyleImp = drinkingStyleImp;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAmountIngested() {
        return amountIngested;
    }

    public void setAmountIngested(Integer amountIngested) {
        this.amountIngested = amountIngested;
    }

    public IPeeable getPeeingStyleImp() {
        return peeingStyleImp;
    }

    public void setPeeingStyleImp(IPeeable peeingStyleImp) {
        this.peeingStyleImp = peeingStyleImp;
    }

    public IDrinkable getDrinkingStyleImp() {
        return drinkingStyleImp;
    }

    public void setDrinkingStyleImp(IDrinkable drinkingStyleImp) {
        this.drinkingStyleImp = drinkingStyleImp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return getName().equals(human.getName()) &&
                getAge().equals(human.getAge()) &&
                getWeight().equals(human.getWeight());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getWeight());
    }

    @Override
    public String toString() {
        return "I'm "+ age + "yo and I weigh " + weight + "kg, also my name is " + name+". By now I've drunk "+amountIngested+"mL of beer.";
    }
    public String basicPresentation(){
        return "They call me "+name+" and I've drunk "+amountIngested+"mL of beer";
    }

    @Override
    public int compareTo(Object o) throws ClassCastException{
        if (o instanceof Human){
            Human h = (Human) o;
            return this.getWeight().compareTo(h.getWeight());
        }else throw new ClassCastException();
    }
}
