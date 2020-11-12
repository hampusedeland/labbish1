import java.awt.*;

/**
 * Representerar en Volvo, som är en Car(bil) och implementerar interfacet
 */
//impliments här och inte i saab?
public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;


    /**
     * Default Konstruktor, som anropar Car, Och "bygger en default Volvo
     * @param
     */
    public Volvo240(Integer nrDoors, Color color, double enginePower){
        super(nrDoors, color, enginePower);
        modelName = "Volvo240";
    }
    /**
     * Beskriver hur farten påverkan av "trimfactor"
     */
    @Override
    public double speedFactor(){
        return enginePower * 0.01 * trimFactor;
    }




}
