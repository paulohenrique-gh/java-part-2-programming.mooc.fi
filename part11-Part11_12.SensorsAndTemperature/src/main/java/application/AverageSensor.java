package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{

    private List<Sensor> sensors;
    private List<Integer> readings;
   
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : sensors) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        this.sensors.stream()
            .forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        this.sensors.stream()
            .forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (this.sensors.isEmpty()) {
            throw new IllegalStateException("Sensors are off");
        }
        int reading = this.sensors.stream()
            .mapToInt(sensor -> {
                if (sensor.isOn()) return sensor.read();
                return 0;
            })
            .sum() / this.sensors.size();
        this.readings.add(reading);
        return reading;
    }

    public List<Integer> readings() {
          return this.readings; 
    }
    
}
