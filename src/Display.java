import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Display{
    private JFrame frame;
    final BufferedImage image = new BufferedImage(1500, 900,BufferedImage.TYPE_INT_RGB);
    private JPanel canvas;
    private JButton btn=new JButton("File");
    private JButton btn1=new JButton("Run");
    private JTextField text=new JTextField(8);
    private JLabel starting=new JLabel("Starting Point");
    private JLabel optimalDistance = new JLabel("Optimal Distance:");
    private JLabel dist;
    private JLabel noOfIterations=new JLabel("Iterations:");
    private JLabel iterationCount=new JLabel();
    private String str;
    Display() {
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
               g.drawImage(image,0 , 100, this);
            }
        };
        btn.setBounds(100,100,5,5);
        frame = new JFrame();
        frame.setLayout(new BorderLayout());// <== make panel fill frame
        canvas.add(btn);
        canvas.add(btn1);
        canvas.add(starting);
        canvas.add(text);
        canvas.add(optimalDistance);
        frame.add(canvas, BorderLayout.CENTER);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setCanvas(JPanel canvas) {
        this.canvas = canvas;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }

    public void setBtn1(JButton btn1) {
        this.btn1 = btn1;
    }

    public void setText(JTextField text) {
        this.text = text;
    }

    public void setStarting(JLabel starting) {
        this.starting = starting;
    }

    public void setOptimalDistance(JLabel optimalDistance) {
        this.optimalDistance = optimalDistance;
    }

    public void setDist(JLabel dist) {
        this.dist = dist;
    }

    public void setNoOfIterations(JLabel noOfIterations) {
        this.noOfIterations = noOfIterations;
    }

    public void setIterationCount(JLabel iterationCount) {
        this.iterationCount = iterationCount;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public JFrame getFrame() {
        return frame;
    }

    public BufferedImage getImage() {
        return image;
    }

    public JPanel getCanvas() {
        return canvas;
    }

    public JButton getBtn() {
        return btn;
    }

    public JButton getBtn1() {
        return btn1;
    }

    public JTextField getText() {
        return text;
    }

    public JLabel getStarting() {
        return starting;
    }

    public JLabel getOptimalDistance() {
        return optimalDistance;
    }

    public JLabel getDist() {
        return dist;
    }

    public JLabel getNoOfIterations() {
        return noOfIterations;
    }

    public JLabel getIterationCount() {
        return iterationCount;
    }

    public String getStr() {
        return str;
    }

    public void selectFile() {
        JFileChooser chooser = new JFileChooser();
        // optionally set chooser options ...
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            str=f.getAbsolutePath();
            // read  and/or display the file somehow. ....
        } else {
            // user changed their mind
        }
    }
}