package Ex_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    JPanel panelStatus;
    Controller control_Panel;
    JButton lineBtn,elipBtn,recBtn;
    JToolBar toolBar;

    public View() {
        this.setSize(500,500);
        this.setTitle("Vẽ hình");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        init();
        actionEvent();
        this.setVisible(true);
    }

    private void actionEvent() {
        this.lineBtn.addActionListener(this);
        this.elipBtn.addActionListener(this);
        this.recBtn.addActionListener(this);
    }

    private void init() {
        toolBar = new JToolBar();
        toolBar.addSeparator();
        toolBar.setRollover(true);
        lineBtn = new JButton("Đường thẳng");
        elipBtn = new JButton("Elip");
        recBtn = new JButton("Chữ nhật");
        toolBar.add(lineBtn);
        toolBar.add(elipBtn);
        toolBar.add(recBtn);
        this.add(toolBar,BorderLayout.NORTH);
        /*
        Panel Draw
         */
        control_Panel = new Controller(this);
        control_Panel.setBackground(Color.white);
        this.add(control_Panel,BorderLayout.CENTER);

        panelStatus = control_Panel.panelStatus;
        this.add(panelStatus,BorderLayout.SOUTH);

    }

    public static void main(String[] args) {
        new View();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String src = e.getActionCommand();
        if (src.equals("Đường thẳng")){
            control_Panel.getModelShape().setShape("Đường thẳng");
        }if (src.equals("Elip")){
            control_Panel.getModelShape().setShape("Elip");
        }if (src.equals("Chữ nhật")){
            control_Panel.getModelShape().setShape("Chữ nhật");
        }
    }
}
