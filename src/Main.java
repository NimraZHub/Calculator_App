import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;

public class Main {
    //declare variables
    static JFrame frame;
    static JTextField textField;//screen
    static JButton [] numberButtons = new JButton[10];//dynamic button array
    static JButton [] functionButtons = new JButton[28];
    static JButton addBtn,subBtn,mulBtn,divBtn,eqBtn,decBtn,clrBtn,delBtn,cosBtn,
            sinBtn,tanBtn,acosBtn,asinBtn,atanBtn,lnBtn,logBtn,expBtn,powBtn,sqrtBtn,
            meanBtn, medianBtn, modeBtn, stddevBtn,addNumberBtn,factBtn, percBtn,onBtn,offBtn;
    static JPanel panel;
    static double num1=0,num2=0,result=0;
    static char operator;
    static DecimalFormat df = new DecimalFormat("0.##########");
    static double []numbers = new double[100];
    static int count = 0;
    static boolean calculatorOn = true;
    public static void main(String[] args) {
        //create frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500,100,500,650);
        frame.setLayout(null);
        //Image Insert
        ImageIcon image = new ImageIcon("C:\\Users\\HP\\Documents\\Idea Projects\\Calculator_App\\src\\calculator.png");
        frame.setIconImage(image.getImage());

        Font myfont = new Font("Arial",Font.BOLD,16);
        Font trigFont = new Font("Arial", Font.BOLD, 14);
        textField = new JTextField();
        textField.setBounds(27,33,430,50);
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
        meanBtn = new JButton("x̄");
        medianBtn = new JButton("M");
        modeBtn = new JButton("Mo");
        stddevBtn = new JButton("Sx");
        addNumberBtn = new JButton("Add");
        factBtn = new JButton("!");
        percBtn = new JButton("%");
        onBtn = new JButton("On");
        offBtn = new JButton("Off");


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
        functionButtons[19] = meanBtn;
        functionButtons[20] = medianBtn;
        functionButtons[21] = modeBtn;
        functionButtons[22] = stddevBtn;
        functionButtons[23] = factBtn;
        functionButtons[24] = percBtn;
        functionButtons[25] = addNumberBtn;
        functionButtons[26] = onBtn;
        functionButtons[27] = offBtn;

        for (int i = 0; i < 28; i++) {
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
        delBtn.setBounds(27,540,150,50);
        clrBtn.setBounds(308,540,150,50);

        panel = new JPanel();
        panel.setBounds(27,100,430,430);
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

        panel.add(powBtn);
        panel.add(sqrtBtn);
        panel.add(factBtn);
        panel.add(percBtn);
        panel.add(lnBtn);
        panel.add(logBtn);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(expBtn);
        panel.add(meanBtn);

        panel.add(onBtn);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(medianBtn);
        panel.add(modeBtn);
        panel.add(stddevBtn);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(addBtn);
        panel.add(subBtn);
        panel.add(mulBtn);
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(divBtn);

        panel.add(addNumberBtn);
        panel.add(eqBtn);
        panel.add(offBtn);
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
        addNumberBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(); // Call method to add number to array
            }
        });
        meanBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double mean;
                if (count == 0) {
                    textField.setText("No Data");
                    return;
                } else {
                    double sum = 0;
                    for (int i = 0; i < count; i++) {
                        sum += numbers[i];
                    }
                    mean = sum / count;
                }
                    textField.setText("Mean: " + df.format(mean));
                count = 0;
            }
        });
        medianBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add the number from textField to the array
                addNumber();
                if (count == 0) {
                    textField.setText("No Data");
                    return;
                }
                // Sort the array up to the current count
                Arrays.sort(numbers, 0, count);
                double median;
                if (count % 2 == 0) {
                    median = (numbers[count / 2 - 1] + numbers[count / 2]) / 2;
                } else {
                    median = numbers[count / 2];
                }
                textField.setText("Median: " + df.format(median));
                count = 0;
            }
        });
        modeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call addNumber to add the new number from the text field to the array
                addNumber();
                if (count == 0) {
                    textField.setText("No Data");
                    return;
                }
                int maxCount = 0;
                double mode = numbers[0];
                for (int i = 0; i < count; i++) {
                    int currentCount = 0;
                    for (int j = 0; j < count; j++) {
                        if (numbers[j] == numbers[i]) {
                            currentCount++;
                        }
                    }
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        mode = numbers[i];
                    }
                }
                textField.setText("Mode: " + df.format(mode));
                count = 0;
            }
        });
        stddevBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call addNumber to add the new number from the text field to the array
                addNumber();
                if (count == 0) {
                    textField.setText("No Data");
                    return;
                }
                double sum = 0;
                for (int i = 0; i < count; i++) {
                    sum += numbers[i];
                }
                double mean = sum / count;
                double varianceSum = 0;
                for (int i = 0; i < count; i++) {
                    varianceSum += Math.pow(numbers[i] - mean, 2);
                }
                double variance = varianceSum / count;
                double standardDeviation = Math.sqrt(variance);
                textField.setText("Std Dev: " + df.format(standardDeviation));
                count = 0;
            }
        });
        factBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber();
                int n = (int) numbers[count - 1];
                if (n < 0) {
                    textField.setText("Error: Negative input");
                    return;
                }
                long fact = 1;
                for (int i = 1; i <= n; i++) {
                    fact *= i;
                }
                textField.setText("Factorial: " + fact);
            }
        });
        percBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNumber(); // Add the number to the array
                if (count > 0) {
                    double percentage = numbers[count - 1] / 100;
                    textField.setText("Percentage: " + df.format(percentage));
                } else {
                    textField.setText("No Number");
                }
            }
        });
        onBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorOn = true;
                updateButtonStates();
                textField.setText("");
            }
        });
        offBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatorOn = false;
                updateButtonStates();
                textField.setText("Calculator is Off");
            }
        });
        updateButtonStates();
        frame.setVisible(true);
    }
    private static void updateButtonStates() {
        // Update the state of each button based on the calculator's power state
        for (int i = 0; i < 10; i++) {
            numberButtons[i].setEnabled(calculatorOn);
        }
        for (int i = 0; i < 26; i++) {
            functionButtons[i].setEnabled(calculatorOn);
        }
    }

    // Add number to array
    public static void addNumber() {
        String input = textField.getText();
        if (input != null && !input.isEmpty() && input.matches("-?\\d+(\\.\\d+)?")) {
            // Ensure there's room in the array
            if (count < numbers.length) {
                numbers[count++] = Double.parseDouble(input);
                textField.setText("");
            } else {
                textField.setText("Array Full");
            }
        } else {
            textField.setText("Invalid Input");
        }
    }
}





