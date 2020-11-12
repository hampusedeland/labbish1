import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class test1 {
    private Car saab;
    Saab95 saab123 = new Saab95(4, Color.black,124);
    Volvo240 volvon = new Volvo240(4,Color.BLUE,130);
    @Before

    public void init(){
        saab = new Car(2, Color.red, 125);


    }
    @Test
    public void volvospeedfactor() {
        assertTrue(volvon.speedFactor()==volvon.getEnginePower()*0.01*1.25);
    }
    @Test
    public void turboOnsaab(){
        saab123.setTurboOn();
        assertEquals(saab123.turboOn,true);

    }
    @Test
    public void turboOfSaab(){
        saab123.setTurboOff();
        assertEquals(saab123.turboOn,false);
    }

   /* @Test
    public void speedfactorsaab(){
        assertTrue(saab123.speedFactor()==saab123.getEnginePower()*0.13);
    }

    */
    //ideer för tester
    @Test
    public void testcolor(){
        saab.setColor(Color.BLACK);
        assertEquals(saab.getColor(),Color.black);
    }

    @Test
    public void testadörrar (){
        assertTrue(saab123.getNrDoors()==4);
    }
    @Test public void turnRightOk(){
        saab.setCurrentdirection("north");
        saab.turnRight();
        assertEquals(saab.getCurrentdirection(),"east");
    }
    @Test
    public void turboOn(){
        saab123.setTurboOn();
        assertEquals(saab123.turboOn,true);
    }
    @Test
    public void testTurnLeft(){
        saab.setCurrentdirection("west");
        saab.turnLeft();
        assertTrue(saab.getCurrentdirection()=="south");
    }

    @Test
    public void testTurnRight(){
        //start con, starts north
        saab.setCurrentdirection("north");
        //three right turns should result in the direction being west
        saab.turnRight();
        saab.turnRight();
        saab.turnRight();
        assertTrue(saab.getCurrentdirection()=="west");

    }

    @Test
    public void testMove() {
        saab.currentSpeed = 1;
        saab.setCurrentdirection("north");
        saab.setX(0);
        saab.setY(0);
        for (int i = 0; i <= 10; i++) {
            saab.move();
            saab.move();
            saab.move();
        }
        //this should result in the car moving 10 steps
        //The car being directed north, and starting in (0,0)
        // should result in the car ending up in (0,10)
        assertTrue(saab.getY() >= 9);

    }
    @Test
    public void testPosition() {
        saab.setX(0);
        saab.setY(0);

        assertTrue(saab.getX()==0 && saab.getY()==0);
    }

    @Test
    public void testSetCurrentdirectionOK(){
        saab.setCurrentdirection("west");
        saab.move();
        saab.turnLeft();
        saab.turnRight();

    }

    @Test
    public void testGasOK(){

        for(int i= 0 ; i<=200 ; i++) {
            saab.gas(0.9);
        }
        assertTrue(saab.currentSpeed<=saab.enginePower);

    }

    @Test
    public void testBreakOK(){
        saab.currentSpeed=100;
        for(int i= 0 ; i<=200 ; i++) {
            saab.brake(0.9);
        }
        //för man kan breaka med 1 som max
        assertTrue(saab.currentSpeed<=1);

    }

    @Test
    public void testIncrementSpeedOK(){
        saab.currentSpeed=1;
        saab.incrementSpeed(20);
        //vi får inte öka hastigheten med mer än 1, så därav ska hastigheten
        //vara oförändrad
        assertTrue(saab.getCurrentSpeed()>=0.9);

    }

    @Test
    public void testDecremetSpeedOK(){
        saab.currentSpeed=1;
        saab.decrementSpeed(20);
        //vi får inte öka hastigheten med mer än 1, så därav ska hastigheten
        //vara oförändrad
        assertTrue(saab.getCurrentSpeed()==1);
    }

    @Test
    public void testStopEngineOK(){
        saab.currentSpeed=20;
        saab.stopEngine();
        assertTrue(saab.getCurrentSpeed()==0);
    }

    @Test
    public void testStartEngineOK(){
        saab.currentSpeed=0;
        saab.startEngine();
        assertTrue(saab.getCurrentSpeed()==0.1);

    }

    /*@Test
    public void testSpeedFactorSaabOK(){
        double noTurbo = saab.speedFactor();
        saab.setTurboOn();
        double withTurbo = saab.speedFactor();
        int vad = Double.compare(noTurbo, withTurbo);
        assertTrue(vad<0);
    }
    @Test
    public void testSpeedFactor(){
    }
    /*@Test
    public void testTurbOonOnOK(){
        saab.turboOn;
        assertTrue(saab.setTurboOn());
    }
    @Test
    public void testTurbOonOffOK(){}*/



}