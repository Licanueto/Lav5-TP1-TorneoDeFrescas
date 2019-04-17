package lab5;

import lab5.model.Human;
import lab5.model.Spartan;
import lab5.model.Viking;
import lab5.strategyPatternImplementations.SpartanDrinksImplementation;
import lab5.strategyPatternImplementations.SpartanPeesImplementation;
import lab5.strategyPatternImplementations.VikingDrinksImplementation;
import lab5.strategyPatternImplementations.VikingPeesImplementation;

import java.util.*;
import java.util.stream.Collectors;

public class App 
{
    public static void main(String[] args) {

        System.out.println("Lab 5 - Torneo de Frescas - DNI impar\n");

        Random rand = new Random();

        List<Human> vikingList = Arrays.asList((Human)
                new Viking("Ǫlviðr",20,94,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Alfhild",32,103,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Asger",41,130,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Bjorn",32,110,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Endre",28,77,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Minea",28,110,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Giđeš",24,84,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10),
                new Viking("Øfden",34,60,new VikingPeesImplementation(),new VikingDrinksImplementation(),rand.nextInt(10)+10));

        List<Human> spartanList = Arrays.asList((Human)
                new Spartan("Anaxandrides",28,90,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Cleomenes",14,110,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Leonidas",23,94,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Pleistrachus",20,77,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Eurykratidas",44,160,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Cleombrotos",34,96,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Nøørjen",26,75,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10),
                new Spartan("Kongeriket",31,110,new SpartanPeesImplementation(),new SpartanDrinksImplementation(),rand.nextInt(10)+10));

        // Orden y presentación
        System.out.println(" Sorted Vikings:");
        vikingList = vikingList.stream().sorted().peek(System.out::println).collect(Collectors.toList());
        System.out.println("\n Sorted Spartans");
        spartanList = spartanList.stream().sorted().peek(System.out::println).collect(Collectors.toList());

        // En caso de ser necesario: Presentación con println (comentada por redundancia)
//        vikingList.stream().forEach(System.out::println);
//        spartanList.stream().forEach(System.out::println);

        // Se saca al primero, se los vuelve a presentar y se los pone en una nueva lista para no perder info
        System.out.println("\n\n All vikings (again) but the first one:");
        List<Human> sortedVikingListMinusOne = vikingList.stream().skip(1).peek(System.out::println).collect(Collectors.toList());
        System.out.println("\n All spartans (again) but the first one:");
        List<Human> sortedSpartanListMinusOne = spartanList.stream().skip(1).peek(System.out::println).collect(Collectors.toList());

        // En caso de ser necesario: Nueva presentación con println (comentada por redundancia)
//        sortedVikingListMinusOne.stream().forEach(System.out::println);
//        sortedVikingListMinusOne.stream().forEach(System.out::println);

        // Enfrentamiento
        Tournament.match(sortedVikingListMinusOne,sortedSpartanListMinusOne);
    }
}