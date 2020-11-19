import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener,Runnable {
    private Display display;
    private  Model model;
    private EuclideanDistance euclideanDistance=new EuclideanDistance();
    private TSPAlgorithm tspAlgorithm=new TSPAlgorithm();
    private int noOfCities=29;
    private TSPInput tspInput=new TSPInput(noOfCities);
    private Thread t;
    int[] scaled_coordinates_x=new int[noOfCities];
    int[] scaled_coordinates_y=new int[noOfCities];


    Controller(){
        display=new Display();
        model=new Model();
        t=new Thread(this);
        display.getBtn().addActionListener(this);
        display.getBtn1().addActionListener(this);
    }

    public void drawPoints(int x[],int y[],int minX,int maxX, int minY, int maxY) {
        Graphics g = display.image.getGraphics();
        g.setColor(Color.red);
        for (int i = 0; i < x.length; i++) {
            float d1= x[i]-minX;
            float d2= maxX - minX;
            float d3= (d1/d2)*1450;
            float d4= y[i]-minY;
            float d5= (d4/d2)*700;
            scaled_coordinates_x[i]=(int)d3;
            scaled_coordinates_y[i]=(int)d5;
            g.drawRect((int) d3,(int) d5, 1, 1);
        }
        g.dispose();
        display.getCanvas().repaint();
    }

    public void run(){
        try {
            int no_of_cities=Integer.parseInt(model.getCities());
            model.setAdjacencyMatrix(euclideanDistance.distanceCalculation(tspInput.getxCoordinates(),tspInput.getyCoordinates()));
            tspAlgorithm.tsp(model.getAdjacencyMatrix(),no_of_cities);
            model.setNodesList(tspAlgorithm.getNodeList());
            String a=Integer.toString(tspAlgorithm.getDistance());
            display.setDist(new JLabel(String.valueOf(0)));
            display.getCanvas().add(display.getDist());
            display.getCanvas().add(display.getNoOfIterations());
            display.getCanvas().add(display.getIterationCount());
            Graphics g = display.image.getGraphics();
            g.setColor(Color.red);
            for (int i = 0; i < model.getNodesList().length - 1; i++) {
                g.drawLine(scaled_coordinates_x[model.getNodesList()[i]],scaled_coordinates_y[model.getNodesList()[i]],scaled_coordinates_x[model.getNodesList()[i+1]],scaled_coordinates_y[model.getNodesList()[i+1]]);
                display.getIterationCount().setText(Integer.toString(i));
                display.getDist().setText(Integer.toString(tspAlgorithm.distance1[i]));
                t.sleep(1000);
            }
        }catch (Exception e){}
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==display.getBtn()){
            display.selectFile();
            tspInput.readFile(display.getStr());
            model.setxCoordinates(tspInput.getxCoordinates());
            model.setyCoordiates(tspInput.getyCoordinates());
            int maxX= maxNumber(model.getxCoordinates());
            int minX= minNumber(model.getxCoordinates());
            int maxY=maxNumber(model.getyCoordiates());
            int minY=minNumber(model.getyCoordiates());
            drawPoints(tspInput.getxCoordinates(),tspInput.getyCoordinates(),minX,maxX,minY,maxY);
        }
        else{
            if(ae.getActionCommand().equals("Run")){
                if(t.isAlive()){
                    t.resume();
                    display.getBtn1().setText("Stop");
                }
                else{
                    model.setCities(display.getText().getText());
                    t.start();
                    display.getBtn1().setText("Stop");
                }
            }
            else{
                t.suspend();
                display.getBtn1().setText("Run");
            }
        }
    }
    public int maxNumber(int[] array ){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        return max;
    }
    public int minNumber(int[] array ){
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]<min){
                min=array[i];
            }
        }
        return min;
    }
}
