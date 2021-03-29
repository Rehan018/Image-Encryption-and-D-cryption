import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageEncyrption {
    public static void letsOprate(int key)
    {
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        //file  inputstreem
        try {
            FileInputStream fis=new FileInputStream(file);
            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for (byte b:data)
            {
                System.out.println(b);
               data [i]=(byte)(b^key);
               i++;
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null,"Done");



        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setTitle("Image Opration");
        f.setSize(300,250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font=new Font("Roboto",Font.ITALIC,10);
        //creating button
        JButton button=new JButton();
        button.setText("Select Image");


        button.setFont(font);

        //creating Text field
        JTextField textField=new JTextField(10);
        textField.setFont(font);
        button.addActionListener(e->{
            System.out.println("buttion click");
            String text=textField.getText();
            int temp;
            temp = Integer.parseInt(text);
            letsOprate(temp);
        });//e->{} this is lamda function gives by replacing ananomus class
        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);





        f.setVisible(true);

    }

    }

