import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame
{   public String str="",str1="",str2=""; // for store strings
    public int a=0,b=0,res=0; //for performed integer operation
    public float fa=0,fb=0,fres=0; // for performed float operation
    public Button n0,n1,n2,n3,n4,n5,n6,n7,n8,n9,point,add,minus,multiply,divide,clean,delete,equal; // create some basic button of calculator
    public TextField result,help; // create display of calculator
    public Label name; // for developer name
    Calculator(){ }  //Default constructor
    Calculator(String Title)
    {
        super(Title);
    } //constructor take Title as argument
    // set all components of calculator
    void setComponents()
    {
        n0=new Button("0");
        n1=new Button("1");
        n2=new Button("2");
        n3=new Button("3");
        n4=new Button("4");
        n5=new Button("5");
        n6=new Button("6");
        n7=new Button("7");
        n8=new Button("8");
        n9=new Button("9");
        point=new Button(".");
        add=new Button("+");
        minus=new Button("-");
        multiply=new Button("*");
        divide=new Button("/");
        equal=new Button("=");
        delete=new Button("X");
        clean=new Button("C");
        result=new TextField("0");
        help=new TextField("Welcome,Thanks for visit");
        name=new Label("@All Rights Reserved                   Developed by  RK.NANDA");
        setLayout(null);
        //set position of components
        //result layer (display)
        result.setBounds(5,10,280,37);
        help.setBounds(5,45,280,35);
        delete.setBounds(290,10,40,32);
        clean.setBounds(290,47,40,32);
        //first layer
        n1.setBounds(5,90,77,35);
        n2.setBounds(86,90,77,35);
        n3.setBounds(169,90,77,35);
        add.setBounds(251,90,79,35);
        //second layer
        n4.setBounds(5,134,77,35);
        n5.setBounds(86,134,77,35);
        n6.setBounds(169,134,77,35);
        minus.setBounds(251,134,79,35);
        //third layer
        n7.setBounds(5,175,77,35);
        n8.setBounds(86,175,77,35);
        n9.setBounds(169,175,77,35);
        multiply.setBounds(251,175,79,35);
        //fourth layer
        point.setBounds(5,215,77,35);
        n0.setBounds(86,215,77,35);
        equal.setBounds(169,215,77,35);
        divide.setBounds(251,215,79,35);
        // last layer
        name.setBounds(10,240,320,60);
        //adding of components
        add(n0);
        add(n1);
        add(n2);
        add(n3);
        add(n4);
        add(n5);
        add(n6);
        add(n7);
        add(n8);
        add(n9);
        add(point);
        add(equal);
        add(add);
        add(minus);
        add(multiply);
        add(divide);
        add(clean);
        add(delete);
        add(result);
        add(help);
        add(name);
        //Event handel(action)
        n0.addActionListener(new NumberPress());
        n1.addActionListener(new NumberPress());
        n2.addActionListener(new NumberPress());
        n3.addActionListener(new NumberPress());
        n4.addActionListener(new NumberPress());
        n5.addActionListener(new NumberPress());
        n6.addActionListener(new NumberPress());
        n7.addActionListener(new NumberPress());
        n8.addActionListener(new NumberPress());
        n9.addActionListener(new NumberPress());
        add.addActionListener(new Operator());
        minus.addActionListener(new Operator());
        multiply.addActionListener(new Operator());
        divide.addActionListener(new Operator());
        clean.addActionListener(new Clean());
        delete.addActionListener(new Delete());
        point.addActionListener(new MyPoint());
        equal.addActionListener(new MyEqual());
    }
    //all operation handel by this class like add,subtract,divide,multiply
    class  Operator implements ActionListener
    {
        PerformedOperation po=new PerformedOperation();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int op=0,mp=0;
            char ch[]=str.toCharArray();
            for(int i=0;i<str.length();i++)
            {
                if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/')
                {
                    op++;
                    mp=i;
                }
            }
            if(op==0)
            {
                str=str+e.getActionCommand();
                result.setText(str);
            }
            else if(mp==str.length()-1)
            {
                po.Operation();
                result.setText(str);
            }
            else
            {
                po.Operation();
                str=str+e.getActionCommand();
                result.setText(str);
            }
        }
    }
    // all button press handel by this class
    class NumberPress implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            help.setText("");
            str = str + e.getActionCommand();
            result.setText(str);
        }
    }
    // Equal button operation
    class MyEqual implements ActionListener
    {
        PerformedOperation po=new PerformedOperation();
        @Override
        public void actionPerformed(ActionEvent e)
        {
            int op=0;
            char ch[]=str.toCharArray();
            for(int i=0;i<str.length();i++)
            {
                if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/')
                    op++;
            }
            if(op!=0)
            {
                po.Operation();
            }
        }
    }
    // point button operation
    class MyPoint implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            help.setText("");
            int p=0,o=0;
            int n=str.length()-1;
            char ch[]=str.toCharArray();
            for(int i=0;i<str.length();i++)
            {
                if(ch[i]=='.')
                    p++;
                if(ch[i]=='+' || ch[i]=='-'||ch[i]=='*'||ch[i]=='/')
                    o++;
            }
            if(p==0&&o==0)
            {
                if(str.length()==0)
                    str=str+"0.";
                else
                    str=str+".";
            }
            else if((p==1 && o==1)||(o==1&&p==0))
            {
                if(ch[n]=='+'||ch[n]=='-'||ch[n]=='*'||ch[n]=='/')
                    str=str+"0.";
                else if(ch[n]=='.')
                    str=str;
                else
                    str=str+".";
            }
            else
                str=str;
            result.setText(str);
        }
    }
    // Delete button operation
    class Delete implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            help.setText("");
                if (str.length() == 1 && str=="0")
                { }
                if (str.length() == 1 && str!="0") {
                    str = "";
                    result.setText("0");
                } if(str.length()>1) {
                    char ch[] = str.toCharArray();
                    int n = str.length() - 1;
                    ch[n] = '\0';
                    str = "";
                    for (int i = 0; i < n; i++)
                        str = str + ch[i];
                    result.setText(str);
                }
        }
    }
    // Clean display button operation
    class Clean implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            help.setText("");
            str="";
            result.setText("0");
        }
    }
    //performed all operation
    public class PerformedOperation
    {
        public void Operation()
        {   int p=0,op=0,mp=0; //p(No. of point) op(No.of Operation) mp(Position of operation)
            char operator[]={' '};
            char ch[]=str.toCharArray();
            for(int i=0;i<str.length();i++)
            {
                if(ch[i]=='+'||ch[i]=='-'||ch[i]=='*'||ch[i]=='/')
                {
                    op++;
                    operator[0]=ch[i];
                    mp=i;
                }
                if(ch[i]=='.')
                    p++;
            }
            if(mp==(str.length()-1))
            {
                help.setText("Enter Second Number");
            }
            else
            {
                int i;
                for(i=0;i<mp;i++)
                {
                    str1=str1+ch[i];
                }
                i++;
                for( ;i<str.length();i++)
                {
                    str2=str2+ch[i];
                }
                if(p==0)
                {
                    //only int no. in the string
                    a=Integer.parseInt(str1);
                    str1="";
                    b=Integer.parseInt(str2);
                    str2="";
                    if(operator[0]=='+')
                    {
                        res=a+b;
                        str=res+"";
                        result.setText(str);
                    }
                    if(operator[0]=='-')
                    {
                        res=a-b;
                        str=res+"";
                        result.setText(str);
                    }
                    if(operator[0]=='*')
                    {
                        res=a*b;
                        str=res+"";
                        result.setText(str);
                    }
                    if(operator[0]=='/') {
                        if (b == 0)
                        {
                            help.setText("Cannot divide by Zero " + "' " + str + " '");
                            char div[] = str.toCharArray();
                            int n = str.length() ;
                            for(i=0;i<n;i++)
                            {
                                if(ch[i]=='/')
                                {
                                    n=i;
                                    break;
                                }
                            }
                            div[n] = '\0';
                            str = "";
                            for (i = 0; i < n; i++)
                                str = str + div[i];
                        }
                        else if(a%b==0)
                        {
                            res=a/b;
                            str=res+"";
                            result.setText(str);
                        }
                        else if(a%b!=0)
                        {
                            fres=(float)a/b;
                            str=fres+"";
                            result.setText(str);
                        }
                    }
                }
                else
                {
                    //float no. in the string
                    fa=Float.parseFloat(str1);
                    str1="";
                    fb=Float.parseFloat(str2);
                    str2="";
                    if(operator[0]=='+')
                    {
                        fres=fa+fb;
                        str=fres+"";
                        result.setText(str);
                    }
                    if(operator[0]=='-')
                    {
                        fres=fa-fb;
                        str=fres+"";
                        result.setText(str);
                    }
                    if(operator[0]=='*')
                    {
                        fres=fa*fb;
                        str=fres+"";
                        result.setText(str);
                    }
                    if(operator[0]=='/')
                    {
                        if (fb==0)
                        {
                            help.setText("Cannot divide by Zero " + "' " + str + " '");
                            char div[] = str.toCharArray();
                            int n = str.length() ;
                            for(i=0;i<n;i++)
                            {
                               if(ch[i]=='/')
                               {
                                   n=i;
                                   break;
                               }
                            }
                            div[n] = '\0';
                            str = "";
                            for (i = 0; i < n; i++)
                                str = str + div[i];
                        }
                        else
                        {
                            fres=fa/fb;
                            str=fres+"";
                            result.setText(str);
                        }
                    }
                }
            }
        }
    }
    // main class
    public static void main(String[] args)
    {
        Calculator frame=new Calculator("Calculator");//create JFrame reference variable
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\logo.png")); //set icon
        frame.setSize(350,320); //set size of frame
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // code Quit operation
        frame.setVisible(true); //for show frame on display
        frame.setComponents(); //initialize all components
    }
}
