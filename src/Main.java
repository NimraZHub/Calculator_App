import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main {
    //declare variables
    static JFrame frame;
    static JTextField textField;//screen
    static JButton [] numberButtons = new JButton[10];//dynamic button array
    static JButton [] functionButtons = new JButton[19];
    static JButton addBtn,subBtn,mulBtn,divBtn,eqBtn,decBtn,clrBtn,delBtn,cosBtn,
            sinBtn,tanBtn,acosBtn,asinBtn,atanBtn,lnBtn,logBtn,expBtn,powBtn,sqrtBtn;
    static JPanel panel;
    static double num1=0,num2=0,result=0;
    static char operator;
    static DecimalFormat df = new DecimalFormat("0.##########");
    public static void main(String[] args) {
        //create frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,100,500,600);
        frame.setLayout(null);
        //Image Insert
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Documents\\Idea Projects\\Calculator_App\\src\\calculator.png");
        frame.setIconImage(image.getImage());

        Font myfont = new Font("Arial",Font.BOLD,16);
        Font trigFont = new Font("Arial", Font.BOLD, 14);
        textField = new JTextField();
        textField.setBounds(45,25,400,50);
        textField.setFont(myfont);
        textField.setEditable(false);

        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        clrBtn = new JButton("Clear");
        delBtn = new JButton("Delete");
        decBtn = new JButton(".");
        eqBtn = new JButton("=");
        cosBtn = new JButton("cos");
        sinBtn = new JButton("sin");
        tanBtn = new JButton("tan");
        acosBtn = new JButton("acos");
        asinBtn = new JButton("asin");
        atanBtn = new JButton("atan");
        lnBtn = new JButton("ln");
        logBtn = new JButton("log");
        expBtn = new JButton("exp");
        powBtn = new JButton("^");
        sqrtBtn = new JButton("√");

        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = cosBtn;
        functionButtons[9] = sinBtn;
        functionButtons[10] = tanBtn;
        functionButtons[11] = acosBtn;
        functionButtons[12] = asinBtn;
        functionButtons[13] = atanBtn;
        functionButtons[14] = lnBtn;
        functionButtons[15] = logBtn;
        functionButtons[16] = expBtn;
        functionButtons[17] = powBtn;
        functionButtons[18] = sqrtBtn;

        for (int i = 0; i < 19; i++) {
            functionButtons[i].setFont(trigFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setPreferredSize(new Dimension(70, 40));
        }

        for (int i = 0; i <10 ; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(myfont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setPreferredSize(new Dimension(70, 40));
        }
        delBtn.setBounds(45,500,150,50);
        clrBtn.setBounds(205,500,150,50);

        panel = new JPanel();
        panel.setBounds(45,100,410,380);
        panel.setLayout(new GridLayout(6,4,5,5));
        panel.setBackground(Color.GRAY);
        panel.setVisible(true);
        //add buttons into panel
        panel.add(cosBtn);
        panel.add(sinBtn);
        panel.add(tanBtn);
        panel.add(acosBtn);
        panel.add(asinBtn);
        panel.add(atanBtn);
        panel.add(lnBtn);
        panel.add(logBtn);
        panel.add(expBtn);
        panel.add(powBtn);
        panel.add(sqrtBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(divBtn);
        panel.add(eqBtn);
        //add components into frame
        frame.add(textField);
        frame.add(delBtn);
        frame.add(clrBtn);
        frame.add(panel);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            numberButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(textField.getText()+numberButtons[finalI].getText());
                }
            });
        }
        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText()+".");
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
            }
        });
        subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
            }
        });
        mulBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
            }
        });
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
            }
        });
        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(textField.getText());
                switch (operator){
                    case '+':{
                        result = num1+num2;
                        break;
                    }
                    case '-':{
                        result = num1-num2;
                        break;
                    }
                    case '*':{
                        result = num1*num2;
                        break;
                    }
                    case '/':{
                        result = num1/num2;
                        break;
                    }
                }//end switch
                textField.setText(result+"");
                num1 = result;
            }
        });
        clrBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().isEmpty()==false) {
                    String txt = textField.getText();//123
                    textField.setText("");
                    textField.setText(txt.substring(0, txt.length() - 1));//12
                }
//                String txt = textField.getText(); //123
//                textField.setText("");//""
//                for (int i = 0; i < txt.length()-1; i++) {
//                    textField.setText(textField.getText()+txt.charAt(i));
//                }

            }
        });
        //Trignometric functions
        cosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.cos(Math.toRadians(value));
                textField.setText(df.format(result));
            }
        });
        sinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.sin(Math.toRadians(value));
                textField.setText(df.format(result));
            }
        });
        tanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.tan(Math.toRadians(value));
                textField.setText(df.format(result));
            }
        });
        acosBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.acos(value));
                textField.setText(df.format(result));
            }
        });
        asinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.asin(value));
                textField.setText(df.format(result));
            }
        });
        atanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.toDegrees(Math.atan(value));
                textField.setText(df.format(result));
            }
        });
        // Logarithmic functions
        lnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                if(value <= 0){
                    textField.setText("Error");
                }
                else{
                    result = Math.log(value);
                    textField.setText(df.format(result));
                }
            }
        });
        logBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                if(value <= 0){
                    textField.setText("Error");
                }
                else{
                    result = Math.log10(value);
                    textField.setText(df.format(result));
                }
            }
        });
        expBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                result = Math.exp(value);
                textField.setText(df.format(result));
            }
        });
        //Power and Square Root functions
        powBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num1 = Double.parseDouble(textField.getText());
                operator = '^';
                textField.setText(" ");
            }
        });
        sqrtBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double value = Double.parseDouble(textField.getText());
                if (value <= 0){
                    textField.setText("Error");
                }
                else{
                    result = Math.sqrt(value);
                    textField.setText(df.format(result));
                }
            }
        });
        // Handle Exponentiation
        eqBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(operator == '^'){
                num2 = Double.parseDouble(textField.getText());
                result = Math.pow(num1,num2);
                }
                else{
                    num2 = Double.parseDouble(textField.getText());
                    switch (operator){
                        case '+':{
                            result = num1+num2;
                            break;
                        }
                        case '-':{
                            result = num1-num2;
                            break;
                        }
                        case '*':{
                             result = num1*num2;
                             break;
                        }
                        case '/':{
                              result = num1/num2;
                              break;
                        }
                    }//end switch
                }
                textField.setText(df.format(result));
                num1 = result;
            }
        });
        frame.setVisible(true);




    }
}





