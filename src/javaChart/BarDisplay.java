/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaChart;
 
import java.io.Serializable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeSupport;
import java.util.LinkedHashMap;
import java.util.Map;
 
import javax.swing.JPanel;
/**
 *
 * @author Konrad
 */
public class BarDisplay extends JPanel implements Serializable {
   
    Dimension size;
    private int value;
    private int value2;
    private int value3;
    private int value4;
    private int value5;
    private int maxValue = 100;
   
    private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();
   
    //////////////////////////////////
    //dodawanie słupków
    public void addBar(Color color, int value)
    {
            bars.put(color, value);
            repaint();
    }
 
    public void addBar2 (Color color, int value2)
    {
            bars.put(color, value2);
            repaint();
    }
    
    public void addBar3 (Color color, int value3)
    {
            bars.put(color, value3);
            repaint();
    }
    
    public void addBar4 (Color color, int value4)
    {
            bars.put(color, value4);
            repaint();
    }
        
    public void addBar5 (Color color, int value5)
    {
            bars.put(color, value5);
            repaint();
    }
    ///////////////////////////////////    
    
    //rysowanie
    protected void paintComponent(Graphics g)
    {
            // ustal największą wartość
           
            int max = maxValue;
           
            // rysowanie słupków
            int width = (getWidth() / bars.size()) - 2;
            int x = 1;
            for (Color color : bars.keySet())
            {
                    int value = bars.get(color);
                    int height = (int)
                        ((getHeight()) * ((double)value / max));
                    g.setColor(getBackground());
                    g.fillRect(x, getHeight() - height, width, height); //wypełnij słupek kolorem
                    g.setColor(getForeground());
                    g.drawRect(x, getHeight() - height, width, height); //rysuj obramowanie słupka kolorem
                    x += (width + 2);
            }
    }
    
    //getter dla największej wartości słupków
    public int getMaxValue(){
        return this.maxValue;
    }
   
    //setter dla największej wartości słupków
    public void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }
   
    public Dimension getPreferredSize() {
            return new Dimension(bars.size() * 10 + 2, 50);
    }
   
    ///////////////////////////////////////
    //properties dla wartości słupka
    //private PropertyChangeSupport va =
            //new PropertyChangeSupport(this);
   
    public void updateValues(){
        addBar(Color.red, (int) value);
        addBar(Color.blue, (int) value2);
        addBar(Color.black, (int) value3);
        addBar(Color.pink, (int) value4);
        addBar(Color.orange, (int) value5);
        repaint();
    }
   
    private final PropertyChangeSupport chg = new PropertyChangeSupport(this);
    ////////////////////////////////////////
    //settery i gettery dla wartości poszczególnych słupków
    public synchronized int getValue(){
        return this.value;
    }
   
    public synchronized void setValue(int value){
        //int oldValue = value;
        chg.firePropertyChange("11111", this.value, value);
        this.value = value;
        updateValues();
        this.revalidate();
        this.repaint();
        //va.firePropertyChange("Wartość", oldValue, val);
    }
    ////////////////////////////////////
    
    public synchronized int getValue2(){
        return this.value2;
    }
   
    public synchronized void setValue2(int value2){
        //int oldValue = value;
        chg.firePropertyChange("2222", this.value2, value2);
        this.value2 = value2;
        updateValues();
        this.revalidate();
        this.repaint();
        //va.firePropertyChange("Wartość", oldValue, val);
    }
    ////////////////////////////////////
    
    public synchronized int getValue3(){
        return this.value3;
    }
   
    public synchronized void setValue3(int value3){
        //int oldValue = value;
        chg.firePropertyChange("3333", this.value3, value3);
        this.value3 = value3;
        updateValues();
        this.revalidate();
        this.repaint();
        //va.firePropertyChange("Wartość", oldValue, val);
    }
    ////////////////////////////////////
    
    public synchronized int getValue4(){
        return this.value4;
    }
   
    public synchronized void setValue4(int value4){
        //int oldValue = value;
        chg.firePropertyChange("44444", this.value4, value4);
        this.value4 = value4;
        updateValues();
        this.revalidate();
        this.repaint();
        //va.firePropertyChange("Wartość", oldValue, val);
    }
    ////////////////////////////////////
    
    public synchronized int getValue5(){
        return this.value5;
    }
   
    public synchronized void setValue5(int value5){
        //int oldValue = value;
        chg.firePropertyChange("5555", this.value5, value5);
        this.value5 = value5;
        updateValues();
        this.revalidate();
        this.repaint();
        //va.firePropertyChange("Wartość", oldValue, val);
    }
    ////////////////////////////////////
    ////////////////////////////////////////


    public BarDisplay() {
        Dimension size = getPreferredSize();
        size.width  = size.height = Math.max(size.width, size.height);
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.red);
        setSize(400, 200);
        addBar(Color.red, (int) 70);
        addBar(Color.blue, (int) 34); 
        addBar(Color.black, (int) 23); 
        addBar(Color.pink, (int) 65); 
        addBar(Color.orange, (int) 49); 
    }
      
}