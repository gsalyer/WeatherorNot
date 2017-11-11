import acm.graphics.GCanvas;
import acm.program.Program;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends Program {
    private JTextField zip;
    private JLabel weather;
    private JLabel temperature;
    private JLabel cityState;

    public GUI() {
        start();
    }

    public void init() {
        JLabel inputLabel = new JLabel("Enter ZIP:");

        GCanvas canvas = new GCanvas();
        this.add(canvas);

        JLabel weatherLabel;
        JLabel tempLabel;
        JLabel cityStateLabel;


        canvas.add(inputLabel, 20, 20);

        zip = new JTextField();
        zip.setSize(200, 20);
        canvas.add(zip, 100, 20);

        JButton goButton = new JButton("Get data");
        goButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getWeatherInfo(zip.getText()) ;
            }
        });

        canvas.add(goButton, 350, 20);

        JButton clearButton = new JButton("Clear data");
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clearInfo();
            }
        });
        canvas.add(clearButton, 450, 20);


        weatherLabel = new JLabel("Weather: ");
        weatherLabel.setSize(300, 20);
        canvas.add(weatherLabel, 50, 50);

        weather = new JLabel("");
        weather.setSize(300, 20);
        canvas.add(weather, 110, 50);

        tempLabel = new JLabel("Temperature: ");
        tempLabel.setSize(300, 20);
        canvas.add(tempLabel, 50, 80);

        temperature = new JLabel("");
        temperature.setSize(300, 20);
        canvas.add(temperature, 130, 80);

        cityStateLabel = new JLabel("City/State:");
        cityStateLabel.setSize(300, 20);
        canvas.add(cityStateLabel, 50, 110);

        cityState = new JLabel("");
        cityState.setSize(300, 20);
        canvas.add(cityState, 110, 110);

        addActionListeners();
    }

    public static void main(String[] args) {
        GUI g = new GUI();
    }

    public void getWeatherInfo(String zip) {
        Weather w = new Weather("95677");
        weather.setText(w.getWeather());
        temperature.setText(w.getTemperature());
        cityState.setText(w.getCityState());
    }

    public void clearInfo() {
        zip.setText("");
        this.weather.setText("");
        temperature.setText("");
        cityState.setText("");
    }
}
