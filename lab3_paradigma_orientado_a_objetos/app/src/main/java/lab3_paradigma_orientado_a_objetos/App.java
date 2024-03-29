/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package lab3_paradigma_orientado_a_objetos;

import lab3_paradigma_orientado_a_objetos.UserMenu.UserMenu;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
       UserMenu um = new UserMenu();
       um.run();
       
       /* Pruebas realizadas si se desean utilizar agregar el import correspondiente
       �//Prueba de Element
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
        
        eS.add(e1);
        eS.add(e2);
        e3.element = "3";
        eS.add(e3);
        
        System.out.println(eS.numElements());
        System.out.println(eS.nthElement(3).toString());
        System.out.println(eS.toString());
        eS.insertXElements(5);
        System.out.println(eS.toString());
        eS.remove(e2);
        System.out.println(eS.toString());
        eS.remove(1);
        System.out.println(eS.toString());
        eS.clear();
        System.out.println(eS.toString());
        eS.insertXElements(4);
        System.out.println(eS.toString());
        System.out.println(eS.contains(e3));
        
        Element e = new Element("10");
        
        ArrayList<IElement> r = eS.getElements();
        r.add(e3);
        r.add(e);
        System.out.println(r);
        System.out.println(eS.toString());
        eS.add(e3);
        System.out.println(eS.toString());
        eS.setElements(r);
        System.out.println(eS.toString());
        ArrayList<IElement> p = eS.getElements();
        p.add(e);
        eS.setElements(p);
        System.out.println(eS.toString());

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
        c3.add(e1);
        Element e4 = new Element(4);
        Element e5 = new Element(5);
        c3.add(e4);
        c3.add(e5);
        System.out.println(c1.oneCommonElement(c3));

        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c2));
        c2.clear();
        c2.insertXElements(3);
        System.out.println(c1.equals(c2));
        
        
        //Para CardsSet
        System.out.println("\nCardsSet:");
        CardsSet cS = new CardsSet();
        cS.add(c1);
        cS.add(c3);
        System.out.println(cS.numCards());
        System.out.println(cS.nthCard(1));
        System.out.println(cS.toString());
        CardsSet cS2 = new CardsSet();
        cS2.add(c1);
        cS.subtract(cS2);
        System.out.println(cS.toString());
        
        //Para Dobble
        System.out.println("\nDobble:");
        ElementsSet eSD = new ElementsSet();
        eSD.insertXElements(7);
        Dobble d = new Dobble(eSD, 3, 7);
        System.out.println(d.toString());
        Dobble d2 = new Dobble(eSD, 3, 4);
        System.out.println(d2.toString());
        System.out.println(d2.missingCards().toString());
        System.out.println(d2.toString());
        System.out.println(d2.toString());
       
       Dobble dp = new Dobble(3);
       dp.setElements(eS);
       dp.addElement("5");
       dp.addElement("6");
       dp.addCard(c1);
       dp.addCard(c3);
       dp.addCard(c1);
       System.out.println(dp.toString());
       dp.removeCard(c1);
       dp.removeCard(1);
       System.out.println(dp.toString());
       ICardsSet cSDobble = d2.getDobbleCards();
       IElementsSet cSElements = d2.getElements();
       System.out.println(cSDobble.toString());
       dp.setElements(cSElements);
       dp.setDobbleCards(cSDobble);
       System.out.println(dp.toString());
       Element n8 = new Element(8);
       dp.addElement("8");
       Element n2 = new Element(2);
       Element n7 = new Element(7);
       Card nCard = new Card();
       nCard.add(n2);
       nCard.add("5");
       nCard.add(n7);
       dp.addCard(nCard);
       System.out.println(dp.toString());
       System.out.println("No mixed:\n" + cSDobble.toString());
       cSDobble.mix();
       System.out.println("Mixed:\n" + cSDobble.toString());
       */
    }
}
