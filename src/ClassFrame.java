import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClassFrame extends JFrame {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13;
    JTextField t1, t2;
    JButton b1, b2, b3;
    int numberOfStudent = 1;
    public ArrayList<Integer> goalsArList = new ArrayList<>();
    MyListener myListener = new MyListener();

    String sbc = "Середній бал класу:  _______________________________";
    String nzb = "Кількість учнів з незадовільним балом(оцінка від 1 до 3): _";
    String nb = "Кількість учнів з низьким балом(оцінка від 4 до 6): _______";
    String sb = "Кількість учнів з середнім балом(оцінка від 7  до 9): _____";
    String vb = "       Кількість учнів з високим балом(оцінка від 10 до 12): _____";

    ClassFrame(String s) {
        super(s);
        setLayout(new FlowLayout());

        l1 = new JLabel("Введіть назву класу");
        l2 = new JLabel("Введіть оцінку учня під номером ");
        l3 = new JLabel(nzb);
        l4 = new JLabel(nb);
        l5 = new JLabel(sb);
        l6 = new JLabel(vb);
        l7 = new JLabel(sbc);
        l8 = new JLabel("");
        l9 = new JLabel("");
        l10 = new JLabel("");
        l11 = new JLabel("");
        l12 = new JLabel("");
        l13 = new JLabel("1");


        t1 = new JTextField(2);
        t2 = new JTextField(2);

        b1 = new JButton("Зарахувати");
        b2 = new JButton("Статистика успішності");
        b3 = new JButton("       Очистити       ");

        add(l1);
        add(t1);
        add(l2);
        add(l13);
        add(t2);
        add(b1);
        add(b2);
        add(l7);
        add(l12);
        add(l3);
        add(l8);
        add(l4);
        add(l9);
        add(l5);
        add(l10);
        add(l6);
        add(l11);


        add(b3);
        b1.addActionListener(myListener);
        b2.addActionListener(myListener);
        b3.addActionListener(myListener);

    }

    public class MyListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == b1) {
                try {
                    if (Integer.parseInt(t2.getText()) > 0 && Integer.parseInt(t2.getText()) < 13) {
                        goalsArList.add(Integer.parseInt(t2.getText()));
                        t2.setText(null);
                        l13.setText(String.valueOf(++numberOfStudent));
                    } else {
                        JOptionPane.showMessageDialog(null, "Введіть правильно оцінку!!!");
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(null, "Введіть число!!!");
                }


            }
            if (e.getSource() == b2) {
                if (t1.getText() != null && !goalsArList.isEmpty()) {
                    l7.setText("Середній бал " + t1.getText() + " класу:____________________________");
                } else {
                    JOptionPane.showMessageDialog(null, "Заповніть усі дані!!!");
                }
                l12.setText(sbc(goalsArList));
                l11.setText(vb(goalsArList));
                l10.setText(sb(goalsArList));
                l9.setText(nb(goalsArList));
                l8.setText(nzb(goalsArList));
            }
            if (e.getSource() == b3) {
                goalsArList.clear();
                l7.setText(sbc);
                l12.setText("");
                l11.setText("");
                l10.setText("");
                l9.setText("");
                l8.setText("");
                t2.setText(null);
                numberOfStudent = 1;
                l13.setText(String.valueOf(numberOfStudent));
                t1.setText("");
            }
        }

    }

    public static String nzb(ArrayList<Integer> arrayList) {
        int count = 0;
        for (Integer i : arrayList) {
            if (i > 0 && i < 4)
                count++;
        }
        return String.valueOf(count);
    }

    public static String nb(ArrayList<Integer> arrayList) {
        int count = 0;
        for (Integer i : arrayList) {
            if (i > 3 && i < 7)
                count++;
        }
        return String.valueOf(count);
    }

    public static String sb(ArrayList<Integer> arrayList) {
        int count = 0;
        for (Integer i : arrayList) {
            if (i > 6 && i < 10)
                count++;
        }
        return String.valueOf(count);
    }

    public static String vb(ArrayList<Integer> arrayList) {
        int count = 0;
        for (Integer i : arrayList) {
            if (i > 9)
                count++;
        }
        return String.valueOf(count);
    }

    public static String sbc(ArrayList<Integer> arrayList) {
        arrayList.trimToSize();
        double result = 0.0;

        for (Integer i : arrayList) {
            result += i;
        }
        return String.format("%.2f", result / arrayList.size());
    }

}
