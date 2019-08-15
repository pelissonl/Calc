package calculadora;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class Calculadora extends JFrame{
    private JButton [] bOp = new JButton[4];  
    private JButton [] b = new JButton[10];  
    private JButton bponto, bresult, blimpa, bexit;  
    private JTextField tela;                                      
    CalculatorEngine Engine = new CalculatorEngine();
         
    public Calculadora(){  
        inicializar();
        eventos();
    }
 
    private void inicializar(){
        // Definindo a janela da Calculadora
        setTitle("Calculadora");
        setBounds(200,200,300,400);
        setBackground(new Color(150,150,150));
     
        // Adicionando os botoes
        b[0] = new JButton("0");
        b[0].setBounds(50,250,50,25);
        add(b[0]);
     
        int k = 50, j =100;  
        for (int i = 1; i<10; i++){    
            b[i] = new JButton(""+i);  
            b[i].setBounds(k,j,50,25); 
            add(b[i]);                 
         
            if (i%3==0) { 
                k=50;     
                j+=50;    
            }
            else k+=50; 
        }
        bOp[0] = new JButton("+"); bOp[1] = new JButton("-");
        bOp[2] = new JButton("*"); bOp[3] = new JButton("/");
        for (int i = 0; i<4; i++){
            bOp[i].setBounds(200,100+50*i,50,25); add(bOp[i]);
        }
     
        // Adicionando os demais botoes da calculadora.
 
        bponto= new JButton("."); bponto.setBounds(150,250,50,25); add(bponto);
        bresult = new JButton("="); bresult.setBounds(100,250,50,25); add(bresult);
        blimpa = new JButton("Limpar"); blimpa.setBounds(50,300,100,25); add(blimpa);
        bexit = new JButton("Sair"); bexit.setBounds(150,300,100,25); add(bexit);
     
        tela = new JTextField(); tela.setBounds(50,50,200,30); add(tela);
        setLayout(null);
     
    }
 
    private void eventos(){
        for (int i = 0; i<10; i++){
            final int j = i;
            b[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    tela.setText(tela.getText()+j);
                    tela.setHorizontalAlignment(JTextField.RIGHT);
                }
            });
        }
        for (int i = 0; i<4; i++) {
            final int j = i;
            bOp[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    Engine.Operation(j,tela.getText());
                    tela.setText("");
                }
            });
        }
        bponto.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tela.setText(tela.getText()+".");
                tela.setHorizontalAlignment(JTextField.RIGHT);
            }
        });
        bresult.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tela.setText(""+Engine.Display(tela.getText()));
            }
        });
        blimpa.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tela.setText("");
            }
        });
        bexit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
    }
 
    public static void main(String[] args) {
        JFrame frame = new Calculadora();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
 
}