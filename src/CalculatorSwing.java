
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Calculator implements ActionListener {
    String first="",op="",last="";
    JTextField out;
    Calculator(){
        JFrame frame = new JFrame("Calculator");

        out = new JTextField(20);
        out.setBorder(new EmptyBorder(15,0,15,0));
        out.setEditable(false);
        out.setText("");

        JButton n0 = new JButton("0");
        JButton n1 = new JButton("1");
        JButton n2 = new JButton("2");
        JButton n3 = new JButton("3");
        JButton n4 = new JButton("4");
        JButton n5 = new JButton("5");
        JButton n6 = new JButton("6");
        JButton n7 = new JButton("7");
        JButton n8 = new JButton("8");
        JButton n9 = new JButton("9");
        JButton bs = new JButton("-");
        JButton ba = new JButton("+");
        JButton bm = new JButton("*");
        JButton bd = new JButton("/");
        JButton be = new JButton("=");
        JButton bc = new JButton("Clr");

        n0.addActionListener(this);
        n1.addActionListener(this);
        n2.addActionListener(this);
        n3.addActionListener(this);
        n4.addActionListener(this);
        n5.addActionListener(this);
        n6.addActionListener(this);
        n7.addActionListener(this);
        n8.addActionListener(this);
        n9.addActionListener(this);
        bs.addActionListener(this);
        ba.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        be.addActionListener(this);
        bc.addActionListener(this);

        JPanel p = new JPanel();
        p.add(out);
        p.add(n7);
        p.add(n8);
        p.add(n9);
        p.add(bd);

        p.add(n4);
        p.add(n5);
        p.add(n6);
        p.add(bm);

        p.add(n1);
        p.add(n2);
        p.add(n3);
        p.add(bs);

        p.add(bc);
        p.add(n0);
        p.add(ba);
        p.add(be);

        be.addActionListener(this);

        frame.add(p);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(228,300);
        frame.setVisible(true);
        frame.setResizable(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String s = e.getActionCommand();
        if(s.charAt(0)>='0' && s.charAt(0)<='9'){
            if(op.equals("")){
                first+=s;
            }
            else{
                last+=s;
            }
            out.setText(first+op+last);
        }

        if(s.charAt(0)=='+' || s.charAt(0)=='-' || s.charAt(0)=='*' ||s.charAt(0)=='/'){
            op+=s;
            out.setText(first+op+last);
        }

        if(s.charAt(0)=='='){
            float num1= Float.parseFloat(first);
            float num2= Float.parseFloat(last);

            float answer=-1;
            switch (op){
                case "+" :
                    answer=num1+num2;
                    out.setText(Float.toString(answer));
                    break;
                case "-":
                    answer=num1-num2;
                    out.setText(Float.toString(answer));
                    break;
                case "*":
                    answer=num1*num2;
                    out.setText(Float.toString(answer));
                    break;
                case "/":
                    if(num2==0){
                        out.setText("Division by 0");
                        break;
                    }
                    answer=num1/num2;
                    System.out.println(answer);
                    out.setText(Float.toString(answer));
                    break;
                default:
                    out.setText("Invalid operation");
                    break;
            }
        }
        if(s.equals("Clr")){
            System.out.println("asd");
            first=op=last="";
            out.setText(first+op+last);
        }
    }
}
class CalculatorSwing{
    public static void main(String[] args) {
        new Calculator();
    }
}
