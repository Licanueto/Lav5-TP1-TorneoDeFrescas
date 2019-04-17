package lab5;

import lab5.dao.ConnectionDAO;
import lab5.interfaces.IDrinkable;
import lab5.interfaces.IPeeable;
import lab5.model.Human;
import lab5.model.Spartan;
import lab5.model.Viking;
import lab5.strategyPatternImplementations.SpartanPeesImplementation;
import lab5.strategyPatternImplementations.VikingDrinksImplementation;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tournament {

    private static List<Human> everyone = null;
    private static long totalVikings = 0;
    private static long totalSpartans = 0;
    private static long totalHumans = 0;
    private static Human boss = null;
    private static int iterations = 0;

    public static void match(List<Human> vikings, List<Human> spartans){

        //Estas implementaciones son especificas del dueño de la taberna/boss/bartender pero no es lo que se pide
        /*IPeeable bossPee = new IPeeable() {
            @Override
            public void pee() {
                System.out.println("The Bartender is peeing like a Baws! ..that doesn't help much though, Il capo è fuori dalla coppa");
            }
            @Override
            public float likelihoodOfPeeing(int amountIngested) {
                Random rand = new Random();
                float randy = 1+ rand.nextInt(50); // randomInt es un numero entre 1 y 50 (El boss es el que mas aguante tiene)
                float likelihood = (randy/100)*((float)amountIngested/1000); // transformo el random en probabilidad (entre 0 y 1) y lo multiplico por la cantidad ingerida sobre 1000 para que esta afecte a la probabilidad de orinar
                    System.out.println("\n amountIngested = " + amountIngested + "mL" +
                    "\n random (1-40) = " + randy +
                    "\n Likelyhood = "+likelihood);
                if(likelihood>=1) pee();
                return likelihood;
            }
        };
        IDrinkable bossDrink = new IDrinkable() {
            @Override
            public int drink() {
                Random rand = new Random();
                int sip = 50 + rand.nextInt(295); // sorbos de 50mL a 295mL (el boss es el que más tranqui toma)
                return sip;
            }
        };*/



        everyone = Stream
                        .concat(vikings.stream(),spartans.stream()) // Junta ambos equipos
                        .collect(Collectors.toList()); // Los pone en la lista
        totalVikings = vikings.stream().count();
        totalSpartans = spartans.stream().count();
        totalHumans = totalVikings+totalSpartans+1;
        boss = new Human("Bartender",100,525,new SpartanPeesImplementation(),new VikingDrinksImplementation());
        iterations = 0;

        System.out.println("\n\n\n -------------------------------------------\n ||||||      Tournament commences     ||||||\n -------------------------------------------");

        matchIteration(false);

        if((int)totalHumans>1)System.out.println(  "\n --------------------------\n      Weys q'pasan to the final:\n --------------------------");
        if((int)totalHumans==1)System.out.println( "\n --------------------------\n      Wey q'pasa to the final: \n --------------------------");
        if((int)totalHumans==0) System.out.println("\n --------------------------------\n        DRAW !!! - NO FINAL   \n --------------------------------\n\n Nobody wins but hey, everyone's drunk and the bartender is making more than ends meet.\n");
        else {
            everyone.stream().forEach(h -> System.out.println(h.basicPresentation() + " without urinating so I've sort of won for now"));

            // Final Round / Boss Fight
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n -------------------------------------------\n ||||||          FINAL ROUND         ||||||\n -------------------------------------------");
            System.out.println(" NOTE: Just to be fair/cocky the Bartender has drunk as much as the drunker of the semifinal contestants");
            boss.setAmountIngested(everyone.stream().max(Comparator.comparing(Human::getAmountIngested)).get().getAmountIngested());
            everyone.add(boss); // agrega al boss a la lista
            totalHumans++; //pa que se actualize teniendo en cuenta al boss
            matchIteration(true);
            if ((int) totalHumans == 0)
                System.out.println("\n --------------------------\n           DRAW !!!\n --------------------------\n\n Nobody wins yet everyone's drunk.\n \"Something something Nash Equilibrium something something.\"");
            else {
                System.out.print("\n --------------------------------\n       WINNER: "); everyone.stream().forEach(inHuman -> System.out.print(inHuman.getName()+" !!!   \n --------------------------------\n"));
                everyone.stream().forEach(inHuman -> System.out.println(inHuman.basicPresentation()+" also I've WON"));
                ConnectionDAO dao = new ConnectionDAO();
                dao.persist(everyone.stream().findFirst().orElse(null));
            }
        }
        System.out.println( "\nThe tournament has finished.");
    }



    private static void matchIteration(boolean isFinal){

        while ((!isFinal  &&  totalVikings > 0  &&  totalSpartans > 0)   ||   (isFinal  &&  totalHumans > 1)){
            iterations++;
            System.out.println("\n ------------------------------------\n        Everyone takes a sip...\n              Round N°"+iterations+"\n ------------------------------------");
            everyone.stream()
                    .forEach(h -> h.setAmountIngested( h.getAmountIngested() + h.getDrinkingStyleImp().drink() )); // todos toman y se les suma lo que tomaron a amountIngested
                    /* En principio la idea era otra pero no la pude hacer andar. Al drink() pretendía multiplicarlo por round((Viking)v.getProDrinker()/10) de forma que
                    *  el campo de proDrinker afectara cuanto toma cada vikingo pero por alguna razón no funciona.. lo mismo aplica para los espartanos con extraTolerance
                    * Como no funciona voy a tratar ambos streams al mismo tiempo ya que no hace la diferencia. Creo que se soluciona con Map pero logro cazar cómo usarlo  */
            everyone = everyone.stream()
                    .filter(h -> h.getPeeingStyleImp().likelihoodOfPeeing(h.getAmountIngested()) < 1) // deja solo a los que no orinan (P<!)
                    .peek(h -> System.out.println(h.basicPresentation()))  // los muestra/presenta
                    .collect(Collectors.toList());  // los devuleve a la lista

            totalVikings = everyone.stream().filter(v -> v instanceof Viking).count();
            totalSpartans = everyone.stream().filter(s -> s instanceof Spartan).count();
            totalHumans = everyone.stream().count();
            System.out.println("----------------------------\n  Total Vikings left = "+totalVikings);
            System.out.println("  Total Spartans left = "+totalSpartans);
            System.out.println("  Total Humans left = "+totalHumans);
        }
    }
}
