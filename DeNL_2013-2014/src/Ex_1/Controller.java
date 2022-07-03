package Ex_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class Controller extends JPanel implements MouseListener {
    JPanel panelStatus; // Thiết lập thanh trạng thái
    private Model modelShape; // Lưu thông tin hình đang vẽ
    private ArrayList<Model> listShape;// danh sách thông tin của các hình
    private boolean flag = false; // kiểm tra điều kiện kích hoạt để vẽ hình
    JLabel statusLabel; // Cập nhật thông tin trạng thái

    /*
    Trả về hình vẽ đang sử dụng hiện tại (dùng để thao tác sự kiện với view)
     */
    public Model getModelShape() {
        return modelShape;
    }
    /*
    Constructor
     */
    public Controller(View view) {
        this.modelShape = new Model(0, 0, 0, 0, "");// cho hình vẽ ban đầu
        this.listShape = new ArrayList<Model>();
        /*
        tạo mới thanh trạng thái
         */
        panelStatus = new JPanel();
        statusLabel = new JLabel();
        panelStatus.add(statusLabel);
        this.add(panelStatus);
        /*
        Add event
         */
        this.addMouseMotionListener(mouseMotionListener);
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        /*
        draw shape in the list
         */
        for (Model modelShape : this.listShape) {
            switch (modelShape.getShape()) {
                case "Đường thẳng":
                    g.drawLine(modelShape.getX1(), modelShape.getY1(), modelShape.getX2(), modelShape.getY2());
                    break;
                case "Elip":
                    g.drawOval(modelShape.actualX(), modelShape.actualY(), modelShape.width(), modelShape.height());
                    break;
                case "Chữ nhật":
                    g.drawRect(modelShape.getX1(), modelShape.getY1(), modelShape.width(), modelShape.height());
            }
        }
        /*
        Vẽ hình đã chọn ở button
         */
        switch (modelShape.getShape()) {
            case "Đường thẳng":
                g.drawLine(modelShape.getX1(), modelShape.getY1(), modelShape.getX2(), modelShape.getY2());
                break;
            case "Elip":
                g.drawOval(modelShape.actualX(), modelShape.actualY(), modelShape.width(), modelShape.height());
                break;
            case "Chữ nhật":
                g.drawRect(modelShape.getX1(), modelShape.getY1(), modelShape.width(), modelShape.height());
                break;
        }
    }

    MouseMotionListener mouseMotionListener = new MouseMotionListener() {
        @Override
        public void mouseDragged(MouseEvent e) {

        }
        // phương thức để vẽ hình, khi gọi repaint thì hình sẽ đc vẽ
        @Override
        public void mouseMoved(MouseEvent e) {
            if (flag) {
                modelShape.setX2(e.getX());
                modelShape.setY2(e.getY());
                repaint();
            }

        }
    };

    @Override
    public void mouseClicked(MouseEvent e) {
        /**
         * check = false đã đc khởi tạo ban đầu
         * Khi lần đầu click chuột check == true ==> Khi click chuột vị trí chuột vừa click được đặt là A(x1,y1)
         *                                           => Kích hoạt vẽ
         * Khi click chuột lần 2 check == false ==> Dừng việc vẽ và vị trí đã click là B(x2,y2)
         * Hình đã đc vẽ qua 2 điểm A và B
         * Thêm hình vào danh sách
         */
        if (flag) {
            modelShape.setX2(e.getX());
            modelShape.setY2(e.getY());
            listShape.add(new Model(modelShape));
            statusLabel.setText(statusLabel.getText() + e.getX() + ", " + e.getY() + ")");
            repaint();
        } else {
            modelShape.setX1(e.getX());
            modelShape.setY1(e.getY());
            if (modelShape.getShape().equals("Chữ nhật"))
                statusLabel.setText("Status: Hình chữ nhật "
                     + "(" + e.getX() + ", " + e.getY() + ") - (");
            if (modelShape.getShape().equals("Đường thẳng"))
                statusLabel.setText("Status: Đường thẳng "
                        + "(" + e.getX() + ", " + e.getY() + ") - (");
            if (modelShape.getShape().equals("Elip"))
                statusLabel.setText("Status: Hình Elip "
                        + "(" + e.getX() + ", " + e.getY() + ") - (");
        }
        flag = !flag; // Tắt điều kiện để kích hoạt vẽ hình
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
