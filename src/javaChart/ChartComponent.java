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
public class ChartComponent extends JPanel implements Serializable {
   
    Dimension size;
    public int value;
    public int value2;
    public int maxValue = 100;
   
    private Map<Color, Integer> bars =
            new LinkedHashMap<Color, Integer>();
   
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
                    g.fillRect(x, getHeight() - height, width, height);
                    g.setColor(getForeground());
                    g.drawRect(x, getHeight() - height, width, height);
                    x += (width + 2);
            }
    }
    
    public int getMaxValue(){
        return this.maxValue;
    }
   
    public void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }
   
    public Dimension getPreferredSize() {
            return new Dimension(bars.size() * 10 + 2, 50);
    }
   
    ///////////////////////////////////////
    //properties dla wartośći słupka
    //private PropertyChangeSupport va =
            //new PropertyChangeSupport(this);
   
    public void updateValues(){
        addBar(Color.red, (int) value);
        addBar(Color.blue, (int) value2);
        repaint();
    }
   
    private final PropertyChangeSupport chg = new PropertyChangeSupport(this);
   
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
   
    public ChartComponent() {
        Dimension size = getPreferredSize();
        size.width  = size.height = Math.max(size.width, size.height);
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.red);
        setSize(400, 200);
        //setPreferredSize();
        addBar(Color.red, (int) 70);
        addBar(Color.blue, (int) 20);    
    }
      
}