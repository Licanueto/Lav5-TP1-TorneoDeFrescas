package lab5.interfaces;

public interface IPeeable {

    public void pee();

    /**
     * Probabilidad de orinar.
     * @param amountIngested Cantidad ingerida en mL
     * @return Devuelve un valor entre 0 y 1
     */
    public float likelihoodOfPeeing(int amountIngested);

}
