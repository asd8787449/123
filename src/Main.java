import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class Main  extends JFrame {
    public Main() {
        init();
    }

    private JLayeredPane layeredPane = new JLayeredPane();
    private boolean teat=false; //觸發首次完成後

    /*--- Page1 ---*/
    //Object
    private JPanel Page1 = new JPanel();
    private JLabel BGLable1 = new JLabel(new ImageIcon("BackgrundImage/backgrund2.jpg"));
    private JLabel TitlePage1 = new JLabel();              //主題 標籤 (猜數字)
    private JButton jbnList[] = new JButton[3];                         //清單 按鈕[3]
    //Variable
    private int Option_key =0;


    /*--- Recorde ---*/
    //Object
    private JPanel RandPanel = new JPanel();
    private JPanel Recorde_Panel = new JPanel(new GridLayout(6, 4, 3, 3));
    private JLabel Recorde_Lable[][] = new JLabel[6][4];
    private JLabel RandingBack = new JLabel(new ImageIcon("Back.png"));
    private JLabel BGL_Rand = new JLabel(new ImageIcon("BackgrundImage/Mood.jpg"));

    /*--- Page2 ---*/
    //Object
    private JPanel Page2 = new JPanel();
    private JLabel BGLName = new JLabel(new ImageIcon("name.png"));
    private JLabel DBLable = new JLabel(new ImageIcon("DB_YourName.png")); //無輸入警告標籤
    private Random random = new Random();           //亂數
    private JTextField NameIn = new JTextField();                      //輸入名字框
    private JButton Ok = new JButton(), No = new JButton();              //確認與返回按鈕
    //Variable
    private int b = 0;          //迴圈判斷
    private int random1[] = new int[4];               //儲存亂數
    private int ChackUserInLengh = 0;                 //Chack長度變數
    private String Name;                                                //暫定儲存Name
    private boolean a = false;  //產生亂數迴圈判斷


    /*--- Page3 ---*/
    //Object
    private JPanel Page3 = new JPanel();
    private JPanel UseInputPanel = new JPanel(new GridLayout(2, 4));  //輸入及箭頭版面
    private JPanel PromptPanel[]=new JPanel[100];
    private JPanel NotePanel = new JPanel();
    private JPanel jPanel[]=new JPanel[4];  //輸入內Panel
    private JLabel UserLb[] = new JLabel[8];  //輸入及箭頭 ( 標籤 [] )
    private JLabel BGLBook = new JLabel(new ImageIcon("book.png"));
    private JLabel BGL_P3 = new JLabel(new ImageIcon("BackgrundImage/Mood.jpg"));
    private JLabel TimeLable = new JLabel("0");          //時間 標籤
    private JLabel NotBookPage = new JLabel("P.1");
    private JLabel jLabel[]=new JLabel[4];  //輸入背景
    private Object options[] = {"OK"};
    private Timer P2Time;      //計數器

    //Variable
    private int keyLocation = 4;   //判斷UserLb[] 陣列裡位置  ( 整數 )
    private int i1 = 1;         //若紀錄已滿則從1開始覆蓋
    private int Time = 1;
    private int I=0;
    private int IVisible=0;
    private int AnswerA = 0;        //A變數
    private int AnswerB = 0;        //B變數
    private int GetKey;  //取得Key輸入後判斷值 ( 整數 )整數
    private int ArrayLable = 0;
    private String own, two, three, four, ALL;  //抓取輸入值 ( 字串 )
    private boolean Input;                    //判斷user boolean

    private void init() {
//      This and cp
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayeredPane(layeredPane);
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(600, 170, 600, 300);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Page1.requestFocus(true);
            }
        });
        layeredPane.add(Page1, JLayeredPane.MODAL_LAYER);
        layeredPane.add(Page2, JLayeredPane.MODAL_LAYER);
        layeredPane.add(Page3, JLayeredPane.MODAL_LAYER);
        layeredPane.add(RandPanel, JLayeredPane.MODAL_LAYER);
        RandPanel.add(Recorde_Panel, JLayeredPane.MODAL_LAYER);
        RandPanel.add(RandingBack, JLayeredPane.MODAL_LAYER);
        RandPanel.add(BGL_Rand, JLayeredPane.DEFAULT_LAYER);
        BGL_Rand.setBounds(0,0,600,300);
        Recorde_Panel.setOpaque(false);
        Page1.setBounds(0, 0, 600, 300);
        Page2.setBounds(0, 0, 600, 300);
        Page3.setBounds(0, 0, 600, 300);
        RandPanel.setBounds(0,0,600,300);
        RandPanel.setLayout(null);
        Recorde_Panel.setBounds(100, 25, 390, 200);
        RandingBack.setBounds(0, 80, 90, 90);
        BGLable1.setSize(this.getWidth(), this.getHeight());
        BGLName.setBounds(150, 0, 300, 270);
        DBLable.setSize(160, 100);
        Page1.requestFocus(true);
        Page1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 10:
                        switch (Option_key){
                            case 0:
                                Page1.setVisible(false);
                                Page2.setVisible(true);
                                Page2.requestFocus(true);
                                break;
                            case 1:
                                Page1.setVisible(false);
                                RandPanel.setVisible(true);
                                RandPanel.requestFocus(true);
                                break;
                            case 2:
                                System.exit(3);
                                break;
                        }
                        break;
                    case 38:
                        if (Option_key > 0) {
                            Option_key--;
                            P1Button_Icon(); }
                        break;
                    case 40:
                        if (Option_key < 2) {
                            Option_key++;
                            P1Button_Icon(); }
                        break;
                }
            }
        });
//      Page1--------------------------------------------------------------------
        Page1.setVisible(true);
        Page1.setLayout(null);
        /*---set Title Type---*/
        Page1.add(TitlePage1);
        TitlePage1.setBounds(340, 0, 250, 70); //邊界
        TitlePage1.setIcon(new ImageIcon("Title.png"));
        /*---set ListButton Type---*/
        for (int i = 0; i < 3; i++) {
            jbnList[i] = new JButton();
        }
        /*---set RandingPanel Type---*/
        RandingBack.setOpaque(false);
        RandPanel.setVisible(false);
        RandPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case 27:
                        Page1.setVisible(true);
                        RandPanel.setVisible(false);
                        Page1.requestFocus(true);
                        break;
                }
            }
        });
        /*---set Start Type---*/
        P1Button_Icon();
        Page1.add(jbnList[0], JLayeredPane.MODAL_LAYER);
        jbnList[0].setBounds(380, 80, 190, 50);
        jbnList[1].setIcon(new ImageIcon("RECORDY.png"));
        jbnList[0].setOpaque(false);
        jbnList[0].setBorderPainted(false);
        jbnList[0].setContentAreaFilled(false);
        /*---set Randing Type---*/
        Page1.add(jbnList[1], JLayeredPane.MODAL_LAYER);
        jbnList[1].setBounds(350, 140, 240, 50);
        jbnList[1].setIcon(new ImageIcon("RECORDW.png"));
        jbnList[1].setOpaque(false);
        jbnList[1].setBorderPainted(false);
        jbnList[1].setContentAreaFilled(false);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 4; j++) {
                Recorde_Lable[i][j] = new JLabel();
                Recorde_Lable[i][j].setHorizontalAlignment(JLabel.CENTER);
                Recorde_Lable[i][j].setFont(new Font(null, Font.BOLD, 17));
                if (i >= 1 && j == 0) {
                    Recorde_Lable[i][0].setText(Integer.toString(i));
                }
                Recorde_Panel.add(Recorde_Lable[i][j]);
            }
        }
        Recorde_Lable[0][1].setText("Name");
        Recorde_Lable[0][2].setText("Time");
        /*---set Exit Type---*/
        Page1.add(jbnList[2], JLayeredPane.MODAL_LAYER);
        jbnList[2].setBounds(405, 200, 135, 50);
        jbnList[2].setIcon(new ImageIcon("EXITW.png"));
        jbnList[2].setOpaque(false);
        jbnList[2].setBorderPainted(false);
        jbnList[2].setContentAreaFilled(false);
        Page1.add(BGLable1, JLayeredPane.DEFAULT_LAYER);

//      Page2--------------------------------------------------------------------
        Page2.setVisible(false);
        Page2.setLayout(null);
        /*---set NameIn Type---*/
        Page2.add(NameIn);
        NameIn.setBounds(235, 149, 120, 35);
        NameIn.setFont(new Font(null, Font.BOLD, 20));
        Page2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                if(NameIn.getText().length()<8){
                    if( keyEvent.getKeyCode()>=48&&keyEvent.getKeyCode()<=57     //判斷是否為數字或英文
                            || keyEvent.getKeyCode()>=65&&keyEvent.getKeyCode()<=90
                            || keyEvent.getKeyCode()>=65&&keyEvent.getKeyCode()<=90 )
                    { NameIn.setText(NameIn.getText()+ keyEvent.getKeyChar()); }  //取值在輸入內
                    else if(keyEvent.getKeyCode()==10){
                        if (NameIn.getText().length() != 0) {
                            if(teat==true){
                                ArrayLable=0;
                                NotePanel = new JPanel();
                                NotePanel.setLayout(null);
                                NotePanel.setBounds(15, 10, 196, 250);
                                Page3.add(NotePanel,JLayeredPane.MODAL_LAYER);
                                NotePanel.add(NotBookPage,JLayeredPane.MODAL_LAYER);
                                NotBookPage.setBounds(97,220,30,30);
                                NotBookPage.setFont(new Font(null,Font.BOLD,15));
                                NotePanel.add(BGLBook, JLayeredPane.DEFAULT_LAYER);
                                BGLBook.setSize(220, 250);
//                                TESTPanel.add(PromptPanel[0]);
//                                jLabel[0].setText("676767");
//                                PromptPanel[0].add(jLabel[0]);
                                NotePanel.setOpaque(false);
                                Page3.add(BGL_P3,JLayeredPane.DEFAULT_LAYER);
                                NotePanel.revalidate();
                            }
                            Name = NameIn.getText();  //抓取Name
                            Page2.setVisible(false);
                            Page3.setVisible(true);
                            DBLable.setVisible(false);
                            Page3.requestFocus(true);   //Page3 取得Focus權限
                            while (a == false) {
                                /*---亂數產生---*/
                                for (int RunRandom = 0; RunRandom < 4; RunRandom++) {
                                    random1[RunRandom] = random.nextInt(9);  //產生亂數
                                    /*---檢查亂數有無重複---*/
                                    if (RunRandom == 3) {
                                        for (int run1 = 0; run1 < 4; run1++) {
                                            for (int run2 = 0; run2 < 4; run2++) {
                                                if (random1[run1] == random1[run2]) {
                                                    b++; } } }
                                        if (b > 4) {
                                            a = false;
                                            b = 0;
                                        } else {
                                            a = true; } } } }
                            a = false;
                            for (int i = 0; i < 4; i++) {
                                System.out.print(random1[i] + "\t");
                            }
                            System.out.println("\n");
                        } else {
                            DBLable.setVisible(true); }
                    }
                    else if(keyEvent.getKeyCode()==27){
                        Page2.setVisible(false);
                        Page1.setVisible(true);
                        DBLable.setVisible(false);
                        Page1.requestFocus(true);
                    }
                }
                if(keyEvent.getKeyCode()==8 && NameIn.getText().length()!=0){ //使用者案Backspace時
                    int lengh=NameIn.getText().length()-1;
                    NameIn.setText(NameIn.getText().substring(0,lengh));
                }
            }
        });
        /*---set DB Type---*/
        Page2.add(DBLable);
        DBLable.setVisible(false);
        DBLable.setLocation(350, 2);
        /*---set OK or No Type---*/
        Page2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

            }
        });
        Page2.add(Ok);
        Ok.setBounds(503, 80, 90, 90);
        Ok.setIcon(new ImageIcon("Into.png"));
        Ok.setBorderPainted(false);
        Ok.setContentAreaFilled(false);
        /*---- No -----*/
        Page2.add(No);
        No.setBounds(0, 80, 90, 90);
        No.setIcon(new ImageIcon("Back.png"));
        No.setBorderPainted(false);
        No.setContentAreaFilled(false);
        Page2.add(BGLName, JLayeredPane.MODAL_LAYER);
//      Page3--------------------------------------------------------------------
        Page3.setVisible(false);
        Page3.setLayout(null);
        Page3.setSize(600, 300);
        Page3.add(UseInputPanel,JLayeredPane.MODAL_LAYER);
        UseInputPanel.setBounds(240, 3, 350, 160);
        UseInputPanel.setOpaque(false);
        /*---set UserLb Type---*/
        for (int i = 0; i < 8; i++) {
            UserLb[i] = new JLabel();
            UserLb[i].setOpaque(false);
            UserLb[i].setHorizontalAlignment(JLabel.CENTER);
            if(i<4){
                jPanel[i]=new JPanel();
                jPanel[i].setLayout(null);
                jPanel[i].setSize(200,155);
                jPanel[i].setOpaque(false);
                UseInputPanel.add(jPanel[i]);
                jLabel[i]=new JLabel();
                jLabel[i].setBounds(0,0,120,90);
                UserLb[i].setBounds(10,17,60,70);
                jPanel[i].add(UserLb[i],JLayeredPane.MODAL_LAYER);    //數字
                jPanel[i].add(jLabel[i],JLayeredPane.DEFAULT_LAYER);  //背景
            }
            else  {
                UseInputPanel.add(UserLb[i]);
                UserLb[i].setSize(190, 140);
                UserLb[i].setIcon(new ImageIcon("Arrow.png"));
                UserLb[i].setVisible(false);
                if (i == 4) {
                    UserLb[i].setVisible(true);
                }
            }
        }
        jLabel[0].setIcon(new ImageIcon("StickyNotesW.png"));
        jLabel[1].setIcon(new ImageIcon("StickyNotesY.png"));
        jLabel[2].setIcon(new ImageIcon("StickyNotesP.png"));
        jLabel[3].setIcon(new ImageIcon("StickyNotesB.png"));
        /*---set Time Type---*/
        Page3.add(TimeLable,JLayeredPane.MODAL_LAYER);
        TimeLable.setBounds(334, 115, 160, 140);
        TimeLable.setFont(new Font(null, Font.BOLD, 90));
        TimeLable.setForeground(new Color(197, 197, 197));
        TimeLable.setHorizontalAlignment(JLabel.CENTER);
        P2Time = new Timer(1000, new ActionListener() {       //計時 ActionListener
            @Override
            public void actionPerformed(ActionEvent e) {
                TimeLable.setText(Integer.toString(Time++));
            }
        });
        /*---set TESTPanel Type---*/
        Page3.add(NotePanel,JLayeredPane.MODAL_LAYER);
        NotePanel.setBounds(15, 10, 196, 250);
        NotePanel.setLayout(null);
        NotePanel.setOpaque(false);
        BGLBook.setSize(220, 250);
        /*---set BGL_P3 Type---*/
        Page3.add(BGL_P3,JLayeredPane.DEFAULT_LAYER);
        BGL_P3.setSize(600,300);
        /*---set NotBookPage Type---*/
        NotBookPage.setBounds(97,220,30,30);
        NotBookPage.setFont(new Font(null,Font.BOLD,15));
        NotePanel.add(NotBookPage,JLayeredPane.MODAL_LAYER);
        /*----set CHECK and ActionListener---*/
        Page3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                GetKey = e.getKeyCode() - 48;
                switch (e.getKeyCode()) {
                    case 10:  //ENTER
                        Check();
                        break;
                    case 39:  //RIGHT
                        if (keyLocation < 7) {
                            keyLocation++;
                            ArrowSet();
                        }
                        break;
                    case 37:  //LEFT
                        if (keyLocation > 4) {
                            keyLocation--;
                            ArrowSet();
                        }
                        break;
                    case 38: //UP
                        if(IVisible>0){
                            IVisible--;
                            NotBookPage.setText("P."+Integer.toString(IVisible+1));
                            A();
                        }
                        break;
                    case 40:  //DOWN
                        if(IVisible<I){
                            IVisible++;
                            NotBookPage.setText("P."+Integer.toString(IVisible+1));
                            A();
                        }
                        break;
                    case 48:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/0.png"));
                        NumberLocation();
                        break;
                    case 49:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/1.png"));
                        NumberLocation();
                        break;
                    case 50:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/2.png"));
                        NumberLocation();
                        break;
                    case 51:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/3.png"));
                        NumberLocation();
                        break;
                    case 52:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/4.png"));
                        NumberLocation();
                        break;
                    case 53:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/5.png"));
                        NumberLocation();
                        break;
                    case 54:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/6.png"));
                        NumberLocation();
                        break;
                    case 55:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/7.png"));
                        NumberLocation();
                        break;
                    case 56:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/8.png"));
                        NumberLocation();
                        break;
                    case 57:
                        UserLb[keyLocation - 4].setIcon(new ImageIcon("NumberImage/9.png"));
                        NumberLocation();
                        break;
                }
            }
        });
        NotePanel.add(BGLBook, JLayeredPane.DEFAULT_LAYER);
    }
    public void Check() {
        /*----判斷Error變數---*/
        if(ArrayLable==0 ){  //初始標籤一時 新增第一Panel
            PromptPanel[I]=new JPanel();
            PromptPanel[I].setBounds(33, 20, 150, 300);
            PromptPanel[I].setOpaque(false);
            NotePanel.add(PromptPanel[I], JLayeredPane.MODAL_LAYER);
        }
        if(IVisible!=I){  //發現與目前記錄不同頁面時 自動跳往目前頁面
            PromptPanel[IVisible].setVisible(false);
            PromptPanel[I].setVisible(true);
            IVisible=I;
        }
        if (ArrayLable!=0 && ArrayLable%7==0){  //滿7次後 自動新增下頁面
            I++;
            IVisible=I;
            PromptPanel[I-1].setVisible(false);  //前一頁顯示不見
            PromptPanel[I]=new JPanel();
            PromptPanel[I].setBounds(33, 20, 150, 300);
            PromptPanel[I].setOpaque(false);
            NotBookPage.setText("P."+Integer.toString(I+1));
            NotePanel.add(PromptPanel[I], JLayeredPane.MODAL_LAYER);
        }
        NotePanel.add(BGLBook, JLayeredPane.DEFAULT_LAYER);  //新增筆記背景，避免蓋掉紀錄
        ALL = own + two + three + four;
        if (ALL.length()!=4) {
            ChackUserInLengh++;//有空格 則ChackUserInLengh++
        }
        /*----判斷Error變數成立---*/
        if (ChackUserInLengh > 0) {
            JOptionPane.showMessageDialog(Page3, "請在空格處輸入");  //呼叫對話框
            Input = false;
        }else if (ChackUserInLengh == 0) {
            Input = true;
            P2Time.start();
        }
        ChackUserInLengh = 0;
        /*----判斷boolean變數---*/
        if (Input == true) {
            if (Integer.parseInt(own) == random1[0]) {
                AnswerA++;
            } else {
                TestB(Integer.parseInt(own));
            }
            if (Integer.parseInt(two) == random1[1]) {
                AnswerA++;
            } else {
                TestB(Integer.parseInt(two));
            }
            if (Integer.parseInt(three) == random1[2]) {
                AnswerA++;
            } else {
                TestB(Integer.parseInt(three));
            }
            if (Integer.parseInt(four) == random1[3]) {
                AnswerA++;
            } else {
                TestB(Integer.parseInt(four));
            }
            /*----新增標籤---*/
            JLabel jlbPrompt[] = new JLabel[ArrayLable + 1];
            jlbPrompt[ArrayLable] = new JLabel();
            /*----標籤抓取資訊---*/
            jlbPrompt[ArrayLable].setText(jlbPrompt[ArrayLable].getText() + " " + ALL + " ： ");
            jlbPrompt[ArrayLable].setFont(new Font(null, Font.BOLD, 18));
            PromptPanel[I].add(jlbPrompt[ArrayLable]);
            /*----判斷A和B並輸出文字---*/
            if (AnswerA == 4) {     // 全對時
                P2Time.stop();
                jlbPrompt[ArrayLable].setText(ALL+ " " + " ： "+"O");
                /*----全對時對話框設定---*/
                int Response = JOptionPane.showOptionDialog(Page3, "答案為:" +
                                ALL + "\n" + "你用了 " + TimeLable.getText() + " 秒完成",
                        "猜中了!!", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE,null,
                        options,options[0]);
                if (i1 == 6) {
                    i1 = 1;
                }  //記錄滿時 i1=1 為覆蓋紀錄
                if (Recorde_Lable[i1][2].getText().length() == 0) {
                    Recorde_Lable[i1][1].setText(Name);
                    Recorde_Lable[i1][2].setText(TimeLable.getText());
                    Recorde_Lable[i1][3].setText(" [ "+ own +" "+ two + " "+ three +" "+four +" ] ");
                    i1++;
                } else if (Recorde_Lable[i1][2].getText().length() != 0) {
                    Recorde_Lable[i1][1].setText(Name);
                    Recorde_Lable[i1][2].setText(TimeLable.getText());
                    Recorde_Lable[i1][3].setText(" [ "+ own +" "+ two + " "+ three +" "+four +" ] ");
                    i1++;
                }
                NotePanel.removeAll();
                teat=true;
                TimeLable.setText("0");
                NameIn.setText("");
                Time = 1;
                IVisible=0;
                ALL="";
                own="";
                two="";
                three="";
                four="";
                I=0;
                if (Response == 0) {   //回應確認
                    Page3.setVisible(false);
                    Page1.setVisible(true);
                    NotBookPage.setText("P.1");
                    for(int i=0;i<4;i++){
                        UserLb[i].setIcon(null);
                    }
                    Page1.requestFocus(true);
                }
                /*-----------------------*/
            } else if (AnswerA != 0 && AnswerB == 0) {
                jlbPrompt[ArrayLable].setText(jlbPrompt[ArrayLable].getText()+AnswerA+"A");
            } else if (AnswerA == 0 && AnswerB != 0) {
                jlbPrompt[ArrayLable].setText(jlbPrompt[ArrayLable].getText()+AnswerB+"B");
            } else if (AnswerA != 0 && AnswerB != 0) {
                jlbPrompt[ArrayLable].setText(jlbPrompt[ArrayLable].getText()+AnswerA+"A"+AnswerB+"B");
            } else{
                jlbPrompt[ArrayLable].setText(jlbPrompt[ArrayLable].getText()+"X" + "\t");
            }
            ArrayLable++;
            AnswerA = 0;
            AnswerB = 0;
            Input = false;
        }
    }
    /*----箭頭顯示設定----*/
    public void ArrowSet() {
        for (int i = 4; i < 8; i++) {
            UserLb[i].setVisible(false);
        }
        UserLb[keyLocation].setVisible(true); }
    /*----首頁清單顯示設定----*/
    public void P1Button_Icon() {
        for (int i = 0; i < 3; i++) {
            switch (i){
                case 0:
                    jbnList[i].setIcon(new ImageIcon("STARTW.png"));
                    break;
                case 1:
                    jbnList[i].setIcon(new ImageIcon("RECORDW.png"));
                    break;
                case 2:
                    jbnList[i].setIcon(new ImageIcon("EXITW.png"));
                    break;
            }
        }
        switch (Option_key){
            case 0:
                jbnList[0].setIcon(new ImageIcon("STARTY.png"));
                break;
            case 1:
                jbnList[1].setIcon(new ImageIcon("RECORDY.png"));
                break;
            case 2:
                jbnList[2].setIcon(new ImageIcon("EXITY.png"));
                break;
        }
    }
    /*----判斷位置存取資料(String)----*/
    public void NumberLocation() {
        int Test = keyLocation - 4;
        if (Test == 0) { own = Integer.toString(GetKey);   }
        if (Test == 1) { two = Integer.toString(GetKey);   }
        if (Test == 2) { three = Integer.toString(GetKey); }
        if (Test == 3) { four = Integer.toString(GetKey);  }
    }
    /*----判斷A----*/
    public void A() {
        for(int i=0;i<=I;i++){
            PromptPanel[i].setVisible(false);
        }
        PromptPanel[IVisible].setVisible(true);
    }
    /*----判斷B----*/
    public int TestB(int SaveLocation) {
        for (int i = 0; i < 4; i++) {
            if (SaveLocation == random1[i]) {
                AnswerB++; }
        }
        return AnswerB; }
    public static void main(String[] args) {
        new Main(); }
}