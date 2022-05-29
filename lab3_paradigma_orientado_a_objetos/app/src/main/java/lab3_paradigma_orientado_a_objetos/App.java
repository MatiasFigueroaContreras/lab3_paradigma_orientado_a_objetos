/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab3_paradigma_orientado_a_objetos;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        //Prueba de Element
        System.out.println("Element:");
        Element e1 = new Element(1);
        Element e2 = new Element("2");
        if(e1.equals(e2)){
            System.out.println("Son iguales");
        }
        else{
            System.out.println("No son iguales");
        }
        
        Element e3 = new Element("1");
        if(e1.equals(e3)){
            System.out.println("Son iguales");
        }
        else{
            System.out.println("No son iguales");
        }
        
        System.out.println(e2.toString());
        
        //Prueba de ElementsSet
        System.out.println("\nElementsSet:");
        ElementsSet eS = new ElementsSet();
        
        eS.insertElement(e1);
        eS.insertElement(e2);
        e3.element = "3";
        eS.insertElement(e3);
        
        System.out.println(eS.numElements());
        System.out.println(eS.nthElement(3).toString());
        System.out.println(eS.toString());
        eS.insertXElements(5);
        System.out.println(eS.toString());
        eS.remove(e2);
        System.out.println(eS.toString());
        eS.remove(1);
        System.out.println(eS.toString());
        eS.clearOut();
        System.out.println(eS.toString());
        eS.insertXElements(4);
        System.out.println(eS.toString());
        System.out.println(eS.contains(e3));

        
        //Prueba de Card
        System.out.println("\nCard:");
        Card c1 = new Card();
        c1.insertXElements(3);
        System.out.println(c1.toString());
        
        Card c2 = new Card();
        c2.insertXElements(5);
        System.out.println(c2.toString());
        
        System.out.println("Elementos en comun: " + c1.commonElements(c2));
        
        System.out.println(c1.oneCommonElement(c2));
        Card c3 = new Card();
        c3.insertElement(e1);
        Element e4 = new Element(4);
        Element e5 = new Element(5);
        c3.insertElement(e4);
        c3.insertElement(e5);
        System.out.println(c1.oneCommonElement(c3));

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c2));
        c2.clearOut();
        c2.insertXElements(3);
        System.out.println(c1.equals(c2));
        
        
        //Para CardsSet
        System.out.println("\nCardsSet:");
        CardsSet cS = new CardsSet();
        cS.insertCard(c1);
        cS.insertCard(c3);
        System.out.println(cS.numCards());
        System.out.println(cS.nthCard(1));
        System.out.println(cS.toString());
        
        //Para Dobble
        System.out.println("\nDobble:");
        ElementsSet eSD = new ElementsSet();
        eSD.insertXElements(7);
        Dobble d = new Dobble(eSD, 3, 7, 3);
        System.out.println(d.toString());
        
        
    }
}
