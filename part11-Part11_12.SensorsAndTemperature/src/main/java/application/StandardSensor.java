package application;

public class StandardSensor implements Sensor{

    private int n;
    
    public StandardSensor(int n) {
        this.n = n;
    } 

    @Override
    public boolean isOn() {
        return true;
    }

    @Override
    public void setOn() {

    }

    @Override
    public void setOff() {

    }

    @Override
    public int read() {
        return this.n;
    }
}
