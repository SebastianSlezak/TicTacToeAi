package pl.sebastianslezak;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class TicTacToe extends JFrame implements ActionListener {

    static ArrayList<Integer> player = new ArrayList<>();
    static ArrayList<Integer> cpu = new ArrayList<>();

    final static String GAME_IS_NOT_STARTED = Status.GAME_IS_NOT_STARTED.getStatus();
    final static String GAME_IN_PROGRESS = Status.GAME_IN_PROGRESS.getStatus();
    final static String X_WINS = Status.X_WINS.getStatus();
    final static String O_WINS = Status.O_WINS.getStatus();
    final static String DRAW = Status.DRAW.getStatus();
    final static String HUMAN = PlayerStatus.HUMAN.getStatus();
    final static String ROBOT = PlayerStatus.ROBOT.getStatus();

    JButton a3 = new JButton();
    JButton b3 = new JButton();
    JButton c3 = new JButton();
    JButton a2 = new JButton();
    JButton b2 = new JButton();
    JButton c2 = new JButton();
    JButton a1 = new JButton();
    JButton b1 = new JButton();
    JButton c1 = new JButton();
    JButton buttonPlayer1 = new JButton(HUMAN);
    JButton buttonPlayer2 = new JButton(HUMAN);
    JButton buttonResetStart = new JButton("Start");
    JPanel tictactoePanel;
    static JLabel labelStatus = new JLabel(GAME_IS_NOT_STARTED);
    static String turn = "player";
    List<JButton> ticTacToePanelList = Arrays.asList(a3, b3, c3, a2, b2, c2, a1, b1, c1);
//    private final JButton[] ticTacToePanelList = {a3, b3, c3, a2, b2, c2, a1, b1, c1};

    public TicTacToe() {
        super("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setLayout(new BorderLayout());
        setVisible(true);

        ticTacToePanel();

        JPanel statusPanel = statusPanel();

        JPanel initialPanel = initialPanel();

        add(initialPanel, BorderLayout.PAGE_START);
        add(tictactoePanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.PAGE_END);
    }

    private JPanel initialPanel() {
        JPanel initialPanel = new JPanel();
        initialPanel.setLayout(new GridLayout());
        buttonPlayer1.setFocusPainted(false);
        buttonPlayer2.setFocusPainted(false);
        buttonResetStart.setFocusPainted(false);
        buttonPlayer1.setName("ButtonPlayer1");
        buttonPlayer2.setName("ButtonPlayer2");
        buttonResetStart.setName("ButtonStartReset");
        buttonPlayer1.addActionListener(this);
        buttonPlayer2.addActionListener(this);
        buttonResetStart.addActionListener(this);
        initialPanel.add(buttonPlayer1);
        initialPanel.add(buttonResetStart);
        initialPanel.add(buttonPlayer2);
        return initialPanel;
    }

    private JPanel statusPanel() {
        JPanel statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(450, 30));
        statusPanel.setLayout(new BorderLayout());
        labelStatus.setName("LabelStatus");
        labelStatus.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        statusPanel.add(labelStatus, BorderLayout.LINE_START);
        return statusPanel;
    }

    private void ticTacToePanel() {
        Font font = new Font("Arial", Font.BOLD, 50);

        a3.setName("ButtonA3");
        b3.setName("ButtonB3");
        c3.setName("ButtonC3");
        a2.setName("ButtonA2");
        b2.setName("ButtonB2");
        c2.setName("ButtonC2");
        a1.setName("ButtonA1");
        b1.setName("ButtonB1");
        c1.setName("ButtonC1");

        tictactoePanel = new JPanel();
        tictactoePanel.setLayout(new GridLayout(3, 3));
        tictactoePanel.setSize(450, 450);
        tictactoePanel.setOpaque(true);

        for (JButton t : ticTacToePanelList) {
            tictactoePanel.add(t);
        }

        Component[] components = tictactoePanel.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton tictactoePanel = (JButton) component;
                tictactoePanel.setFont(font);
                tictactoePanel.setFocusPainted(false);
                tictactoePanel.setEnabled(false);
                tictactoePanel.setBackground(Color.WHITE);
                tictactoePanel.setText(" ");
                tictactoePanel.addActionListener(this);
            }
        }
    }

    public static void main(String[] args) {
<<<<<<< HEAD
=======

>>>>>>> 6134dfa (in progress)
        new TicTacToe();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean progress = labelStatus.getText().equals(GAME_IS_NOT_STARTED) || labelStatus.getText().equals(GAME_IN_PROGRESS);
        boolean turnPlayer = turn.equals("player");
        boolean turnCpu = turn.equals("cpu");

        String symbol;

        if (e.getSource() == buttonResetStart) {
            if (buttonResetStart.getText().equals("Start")) {
                buttonResetStart.setText("Reset");
                for (JButton t : ticTacToePanelList) {
                    t.setEnabled(true);
                }
            } else if (buttonResetStart.getText().equals("Reset")) {
                buttonResetStart.setText("Start");
                for (JButton t : ticTacToePanelList) {
                    t.setEnabled(false);
                }
                reset();
            }
        } else if (e.getSource() == buttonPlayer1) {
            if (buttonPlayer1.getText().equals(HUMAN)) {
                buttonPlayer1.setText(ROBOT);
            } else if (buttonPlayer1.getText().equals(ROBOT)) {
                buttonPlayer1.setText(HUMAN);
            }
        } else if (e.getSource() == buttonPlayer2) {
            if (buttonPlayer2.getText().equals(HUMAN)) {
                buttonPlayer2.setText(ROBOT);
            } else if (buttonPlayer2.getText().equals(ROBOT)) {
                buttonPlayer2.setText(HUMAN);
            }
        }
<<<<<<< HEAD
        //TODO SKRÓCIĆ
=======
>>>>>>> 6134dfa (in progress)
        //HUMAN VS HUMAN ✔
        else if (buttonPlayer1.getText().equals(HUMAN) && buttonPlayer2.getText().equals(HUMAN)) {
            if (progress) {
                if (turnPlayer) {
                    symbol = "X";
                    insertSymbol(e, symbol);
                    turn = "cpu";
                } else if (turnCpu) {
                    symbol = "O";
                    insertSymbol(e, symbol);
                    turn = "player";
                }
            }
        }
<<<<<<< HEAD
        //HUMAN VS ROBOT
        else if (buttonPlayer1.getText().equals(HUMAN) && buttonPlayer2.getText().equals(ROBOT)) {
            if (progress) {
//                if (turnPlayer) {
                symbol = "X";
                insertSymbol(e, symbol);
                turn = "cpu";
//                } else if (turnCpu) {
=======
        //HUMAN VS ROBOT ✔
        else if (buttonPlayer1.getText().equals(HUMAN) && buttonPlayer2.getText().equals(ROBOT)) {
            if (progress) {
                symbol = "X";
                insertSymbol(e, symbol);
                turn = "cpu";
>>>>>>> 6134dfa (in progress)
                if (!labelStatus.getText().equals(X_WINS)) {
                    symbol = "O";
                    insertSymbol(symbol);
                    turn = "player";
                }
<<<<<<< HEAD
//                }
            }
            System.out.println(player);
            System.out.println(cpu);
        }
        //ROBOT VS HUMAN
        else if (buttonPlayer1.getText().equals(ROBOT) && buttonPlayer2.getText().equals(HUMAN)) {
            if (progress) {
//                if (turnPlayer) {
//                    symbol = "X";
//                    insertSymbol(e, symbol);
//                    turn = "cpu";
//                } else if (turnCpu) {
//                    symbol = "O";
//                    insertSymbol(e, symbol);
//                    turn = "player";
//                }
            }
        }
        //ROBOT VS ROBOT
        else if (buttonPlayer1.getText().equals(ROBOT) && buttonPlayer2.getText().equals(ROBOT)) {
//            if (progress) {
//                if (turnPlayer) {
//                    symbol = "X";
//                    insertSymbol(e, symbol);
//                    turn = "cpu";
//                } else if (turnCpu) {
//                    symbol = "O";
//                    insertSymbol(e, symbol);
//                    turn = "player";
//                }
//            }
        }
=======
            }
        }
        //ROBOT VS HUMAN
        //TODO W insertSymbol nie ma wstawiania do tablicy dodawania do przyciskow
        //TODO komputer moze grac z komputerem dopiero kiedy nacisnie sie jaksi przycisk
        else if (buttonPlayer1.getText().equals(ROBOT) && buttonPlayer2.getText().equals(HUMAN)) {
            if (progress) {
                symbol = "X";
                insertSymbol(symbol);
                turn = "cpu";
                if (!labelStatus.getText().equals(X_WINS)) {
                    symbol = "O";
                    insertSymbol(e, symbol);
                    turn = "player";
                }
            }
        }
//        //ROBOT VS ROBOT
//        else if (buttonPlayer1.getText().equals(ROBOT) && buttonPlayer2.getText().equals(ROBOT)) {
//            if (progress) {
//                    symbol = "X";
//                    insertSymbol(symbol);
//                    turn = "cpu";
//                    symbol = "O";
//                    insertSymbol(symbol);
//                    turn = "cpu";
//            }
//        }
>>>>>>> 6134dfa (in progress)
    }

    private void insertSymbol(String symbol) {

        labelStatus.setText(GAME_IN_PROGRESS);
        Random random = new Random();

        boolean turnCpu = turn.equals("cpu");

        int cpuRandom = random.nextInt(ticTacToePanelList.size());

        if (cpu.size() + player.size() == 9) {
            labelStatus.setText(DRAW);
        } else {
            while (cpu.contains(cpuRandom) || player.contains(cpuRandom)) {
                cpuRandom = random.nextInt(ticTacToePanelList.size());
<<<<<<< HEAD
                System.out.println(".");
            }
        }


=======
            }
        }

>>>>>>> 6134dfa (in progress)
        //TODO ZASTĄPIĆ SWITCHEM
        //TODO NAPRAWIC
        if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
            if (turnCpu) {
                cpu.add(cpuRandom);
                ticTacToePanelList.get(cpuRandom).setText(symbol);
            }
        }
<<<<<<< HEAD
//        else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(1);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(2);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(3);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(4);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(5);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(6);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(7);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        } else if (ticTacToePanelList.get(cpuRandom).getText().equals(" ")) {
//            if (turnCpu) {
//                cpu.add(8);
//                ticTacToePanelList.get(cpuRandom).setText(symbol);
//            }
//        }
=======
>>>>>>> 6134dfa (in progress)
        checkWinner();
    }

    private void insertSymbol(ActionEvent e, String symbol) {

        boolean turnPlayer = turn.equals("player");
        boolean turnCpu = turn.equals("cpu");

        labelStatus.setText(GAME_IN_PROGRESS);

        if (e.getSource() == a3) {
            if (a3.getText().equals(" ")) {
                if (turnPlayer) {
                    a3.setText(symbol);
                    player.add(0);
                } else if (turnCpu) {
                    a3.setText(symbol);
                    cpu.add(0);
                }
            }
        } else if (e.getSource() == b3) {
            if (b3.getText().equals(" ")) {
                if (turnPlayer) {
                    b3.setText(symbol);
                    player.add(1);
                } else if (turnCpu) {
                    b3.setText(symbol);
                    cpu.add(1);
                }
            }
        } else if (e.getSource() == c3) {
            if (c3.getText().equals(" ")) {
                if (turnPlayer) {
                    c3.setText(symbol);
                    player.add(2);
                } else if (turnCpu) {
                    c3.setText(symbol);
                    cpu.add(2);
                }
            }
        } else if (e.getSource() == a2) {
            if (a2.getText().equals(" ")) {
                if (turnPlayer) {
                    a2.setText(symbol);
                    player.add(3);
                } else if (turnCpu) {
                    a2.setText(symbol);
                    cpu.add(3);
                }
            }
        } else if (e.getSource() == b2) {
            if (b2.getText().equals(" ")) {
                if (turnPlayer) {
                    b2.setText(symbol);
                    player.add(4);
                } else if (turnCpu) {
                    b2.setText(symbol);
                    cpu.add(4);
                }
            }
        } else if (e.getSource() == c2) {
            if (c2.getText().equals(" ")) {
                if (turnPlayer) {
                    c2.setText(symbol);
                    player.add(5);
                } else if (turnCpu) {
                    c2.setText(symbol);
                    cpu.add(5);
                }
            }
        } else if (e.getSource() == a1) {
            if (a1.getText().equals(" ")) {
                if (turnPlayer) {
                    a1.setText(symbol);
                    player.add(6);
                } else if (turnCpu) {
                    a1.setText(symbol);
                    cpu.add(6);
                }
            }
        } else if (e.getSource() == b1) {
            if (b1.getText().equals(" ")) {
                if (turnPlayer) {
                    b1.setText(symbol);
                    player.add(7);
                } else if (turnCpu) {
                    b1.setText(symbol);
                    cpu.add(7);
                }
            }
        } else if (e.getSource() == c1) {
            if (c1.getText().equals(" ")) {
                if (turnPlayer) {
                    c1.setText(symbol);
                    player.add(8);
                } else if (turnCpu) {
                    c1.setText(symbol);
                    cpu.add(8);
                }
            }
        }
        checkWinner();
    }

    private void reset() {
        Component[] buttonReset = tictactoePanel.getComponents();

        for (Component component : buttonReset) {
            if (component instanceof JButton) {
                JButton resetButton = (JButton) component;
                resetButton.setText(" ");
            }
        }
        player.clear();
        cpu.clear();
        labelStatus.setText(GAME_IS_NOT_STARTED);
        turn = "player";
    }

    private static void checkWinner() {
        List<Integer> rowTop = Arrays.asList(0, 1, 2);
        List<Integer> rowMid = Arrays.asList(3, 4, 5);
        List<Integer> rowBot = Arrays.asList(6, 7, 8);
        List<Integer> colLeft = Arrays.asList(0, 3, 6);
        List<Integer> colMid = Arrays.asList(1, 4, 7);
        List<Integer> colRight = Arrays.asList(2, 5, 8);
        List<Integer> cross1 = Arrays.asList(0, 4, 8);
        List<Integer> cross2 = Arrays.asList(2, 4, 6);

// TODO RAW USE OF PARAMETERIZED CLASS 'LIST'

        List<List> winning = Arrays.asList(rowTop, rowMid, rowBot, colLeft, colMid, colRight, cross1, cross2);

        for (List list : winning) {
            if (player.containsAll(list)) {
                labelStatus.setText(X_WINS);
                turn = "player";
            } else if (cpu.containsAll(list)) {
                labelStatus.setText(O_WINS);
                turn = "player";
            } else if (cpu.size() + player.size() == 9 && !labelStatus.getText().equals(X_WINS) && !labelStatus.getText().equals(O_WINS)) {
                labelStatus.setText(DRAW);
                turn = "player";
            }
        }
    }
}