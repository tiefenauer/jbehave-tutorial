package info.tiefenauer.tutorials.jbehave;

/**
 * Created by danieltiefenauer on 29.10.2015.
 */
public class RadioStation {

    private String _name;
    private double _frequency;

    public RadioStation(String name, String frequency) {
        setName(name);
        setFrequency(Double.valueOf(frequency));
    }

    public double get_frequency() {
        return _frequency;
    }

    public void setFrequency(double frequency) {
        _frequency = frequency;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }
}
