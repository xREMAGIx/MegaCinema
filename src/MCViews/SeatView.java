/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

/**
 *
 * @author DELL
 */
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

import MCModels.Movie;
import MCModels.Sale;
import MCModels.SaleItem;
import MCModels.Schedule;
import MCModels.Seat;
import MCModels.Theater;
import MCModels.Ticket;

import MCControllers.EmployeeController;
import MCControllers.MovieController;
import MCControllers.SaleItemController;
import MCControllers.SaleController;
import MCControllers.ScheduleController;
import MCControllers.SeatController;
import MCControllers.SellReportController;
import MCControllers.SellTicketController;
import MCControllers.TheaterController;
import MCControllers.TicketController;
import MCModels.SellReport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

class PlayTreeCellRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = 1L;

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
            int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        setText(value.toString());
        if (sel) {
            setForeground(getTextSelectionColor());
        } else {
            setForeground(getTextNonSelectionColor());
        }
        this.setIcon(new ImageIcon("resource/image/dict.gif"));
        return this;
    }
}

public class SeatView extends JPanel {

    private static final long serialVersionUID = 1L;
    float prices = 0;
    int empId;
    Schedule sched = null;
    Seat seat = null;
    Sale sale = null;
    Ticket ticket = null;
    SellTicketController sellTicket = new SellTicketController();
    JButton btnSeats[][] = null;
    Map<Integer, Integer> mapTab = new HashMap<Integer, Integer>();
    Map<Integer, JButton[][]> mapScs = new HashMap<Integer, JButton[][]>();
    int tabCount = 0;
    int seatCount = 0;
    int rst = 0;
    List<Integer> rstList = new ArrayList<>();
    ImageIcon iconSold = new ImageIcon("image/seat_sold.png");
    ImageIcon iconSelected = new ImageIcon("image/seat_selected.png");
    ImageIcon iconSale = new ImageIcon("image/seat_sale.png");
    ImageIcon iconBroken = new ImageIcon("image/seat_broken.png");
    ImageIcon iconNull = new ImageIcon("");

    JSplitPane splitPane = new JSplitPane();
    private JTabbedPane tabbedPane;
    private JScrollPane scrollPane;
    private JPanel seatPanel;

    public SeatView(int empId) {
        super(new BorderLayout());
        this.empId = empId;
        sellTicket.makeNewSale();
        initContent();
    }

    protected void initContent() {
        this.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                sellTicket.removeAllTicket();
                sellTicket.clearSale();
            }
        });

        iconSold.setImage(iconSold.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        iconSelected.setImage(iconSelected.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        iconSale.setImage(iconSale.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        iconBroken.setImage(iconBroken.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        iconNull.setImage(iconNull.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));

        splitPane = new JSplitPane();
        JPanel right = new JPanel();
        JPanel left = new JPanel();
        right.setLayout(new BorderLayout());
        right.setBounds(200, 0, 600, 600);
        left.setLayout(null);
        left.setBounds(0, 0, 200, 600);
        final JTree tree = createTree();
        tree.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        DataDictTreeCellRenderer render = new DataDictTreeCellRenderer();
//        tree.setCellRenderer(render);
        left.setLayout(new BorderLayout());
        left.add(tree);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (node == null) {
                    return;
                }
                Object object = node.getUserObject();
                if (node.isRoot()) {
                } else if (node.isLeaf()) {
                    sched = (Schedule) object;
                    int key = 0;
                    for (Map.Entry<Integer, Integer> entryTab : mapTab.entrySet()) {
                        if (entryTab.getValue() == sched.getTheaterId()) {
                            key = entryTab.getKey();
                            for (Map.Entry<Integer, JButton[][]> entryScs : mapScs.entrySet()) {
                                if (entryScs.getKey() == entryTab.getKey()) {
                                    btnSeats = entryScs.getValue();
                                }
                            }
                        }
                    }
                    showSeatsTable();
                    tabbedPane.setSelectedIndex(key - 1);
                    tabbedPane.repaint();
                } else {
                }
            }
        });
        right.add(createtabbedPane());

        splitPane.setBounds(0, 0, 8000, 6000);
        splitPane.setOneTouchExpandable(true);
        splitPane.setContinuousLayout(true);
        splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(left);
        splitPane.setRightComponent(right);
        splitPane.setDividerSize(1);
        splitPane.setDividerLocation(250);
        this.add(splitPane);
    }

    private JTabbedPane createtabbedPane() {
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 16));
        TheaterController theaterC = new TheaterController();
        List<Theater> theaterList = theaterC.selectAll();
        tabCount = 0;
        for (Theater theaterItem : theaterList) {
            int row = theaterItem.getRowCount();
            int col = theaterItem.getColCount();
            SeatController seatC = new SeatController();
            List<Seat> seatList = seatC.select("theaterId=" + theaterItem.getId());
            seatPanel = new JPanel();

            seatPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
            seatPanel.setLayout(new GridLayout(row, col, 0, 0));
            btnSeats = new JButton[row][col];
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    seat = new Seat();
                    seat.setStatus(-1);
                    for (Seat seatItem : seatList) {
                        if (seatItem.getRow() == i && seatItem.getColumn() == j) {
                            seat = seatItem;
                            break;
                        }
                    }
                    final JButton btnSeat = new JButton();
                    btnSeat.setBackground(Color.WHITE);
                    btnSeat.setPreferredSize(new Dimension(30, 30));
                    btnSeat.setOpaque(false);
                    ImageIcon icon = null;
                    btnSeat.setVisible(true);
                    if (seat.getStatus() == 0) {
                        icon = new ImageIcon("");
                        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    } else if (seat.getStatus() == -1) {
                        icon = new ImageIcon("image/seat_broken.png");
                        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    } else if (seat.getStatus() == 1) {
                        icon = new ImageIcon("image/seat_sale.png");
                        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
                    }
                    btnSeat.setIcon(icon);
                    btnSeat.setBorderPainted(false);
                    btnSeat.setName("" + seat.getId());
                    btnSeat.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            SeatDialog seatDialog = new SeatDialog(
                                    Integer.parseInt(((JButton) e.getSource()).getName()));
                            seatDialog.toFront();
                            seatDialog.setModal(true);
                            seatDialog.setVisible(true);
                            if (rst != -1) {
                                if (rst < 0) {
                                    rst = -rst;
                                    if (new SeatController().select("seatId=" + rst).get(0).getStatus() == -1) {
                                        ((JButton) e.getSource()).setIcon(iconBroken);
                                    } else if (new SeatController().select("seatId=" + rst).get(0).getStatus() == 0) {
                                        ((JButton) e.getSource()).setIcon(iconNull);
                                    } else if (new SeatController().select("seatId=" + rst).get(0).getStatus() == 1) {
                                        ((JButton) e.getSource()).setIcon(iconSale);
                                    }
                                } else if (rst > 0) {
                                    if (new TicketController().Select("seatId=" + rst + " and " + "schedId=" + sched.getId())
                                            .get(0).getStatus() == 0) {
                                        ((JButton) e.getSource()).setIcon(iconSale);
                                    } else if (new TicketController()
                                            .Select("seatId=" + rst + " and " + "schedId=" + sched.getId()).get(0)
                                            .getStatus() == 1) {
                                        ((JButton) e.getSource()).setIcon(iconSelected);
                                    } else if (new TicketController()
                                            .Select("seatId=" + rst + " and " + "schedId=" + sched.getId()).get(0)
                                            .getStatus() == 9) {
                                        ((JButton) e.getSource()).setIcon(iconSold);
                                    }
                                }
                                showSeatsTable();
                                rst = 0;
                            }
                        }

                    });
                    btnSeats[i - 1][j - 1] = btnSeat;
                    seatPanel.add(btnSeats[i - 1][j - 1]);
                }
            }

            tabCount++;
            mapTab.put(tabCount, theaterItem.getId());
            mapScs.put(tabCount, btnSeats);

            //seatPanel.setPreferredSize(new Dimension(300, 300));
            scrollPane = new JScrollPane(seatPanel);
            scrollPane.setPreferredSize(new Dimension(8000, 6000));
            tabbedPane.addTab(theaterItem.getName(), scrollPane);

            //theaterItem.createSeats(theaterItem);
        }
        tabbedPane.setPreferredSize(new Dimension(700, 700));

        return tabbedPane;
    }

    private JTree createTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("All Movie");
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        JTree tree = new JTree(treeModel);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        addTreeNode(root);
        tree.expandRow(0);
        tree.setSelectionRow(0);
        return tree;
    }

    private void addTreeNode(DefaultMutableTreeNode root) {
        MovieController movieC = new MovieController();
        List<Movie> movieList = movieC.SelectAll();
        DefaultMutableTreeNode parentNode = null;

        for (Movie movieItem : movieList) {
            parentNode = new DefaultMutableTreeNode(movieItem.getName());
            root.add(parentNode);
            ScheduleController schedC = new ScheduleController();
            List<Schedule> schedList = schedC.SelectAll();
            DefaultMutableTreeNode childNode = null;
            for (Schedule schedItem : schedList) {
                if (schedItem.getMovieId() == movieItem.getId()) {
                    childNode = new DefaultMutableTreeNode(schedItem);
                    childNode.toString();
                    parentNode.add(childNode);
                }
            }
        }
    }

    public void showSeatsTable() {
        if (sched != null) {
            System.out.println(sched.getId());
            TicketController ticketC = new TicketController();

            int row = new TheaterController().select("theaterId=" + sched.getTheaterId()).get(0).getRowCount();
            int col = new TheaterController().select("theaterId=" + sched.getTheaterId()).get(0).getColCount();
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    btnSeats[i - 1][j - 1].setIcon(iconSale);
                }
            }

            if (ticketC.Select("schedId = " + sched.getId()).size() != 0) {

                for (Ticket item : ticketC.Select("schedId = " + sched.getId())) {
                    int i = new SeatController().select("seatId=" + item.getSeatId()).get(0).getRow();
                    int j = new SeatController().select("seatId=" + item.getSeatId()).get(0).getColumn();
                    if (item.getSeatId() == Integer.parseInt(btnSeats[i - 1][j - 1].getName())) {
                        if (item.getStatus() == 9) {
                            btnSeats[i - 1][j - 1].setIcon(iconSold);
                        } else if (item.getStatus() == 1) {
                            btnSeats[i - 1][j - 1].setIcon(iconSelected);
                        } else if (item.getStatus() == 0) {
                            btnSeats[i - 1][j - 1].setIcon(iconSale);
                        }
                    }
                }
            }
        }
        tabbedPane.repaint();
    }

    public static void showPanel() {
        JFrame frame = new JFrame("Seat management");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new SeatView(1));
        frame.pack();
        frame.setVisible(true);
    }

    class SeatDialog extends JDialog {

        private static final long serialVersionUID = 1L;
        Seat seat;
        private int width = 600;
        private int height = 400;
        private JPanel pan = new JPanel();
        private JLabel lblEdit, lblTxt1, lblTxt2, lblPayment, lblPayment1, lblPayment2;
        private JTextField txtPayment;
        private JComboBox<String> cbxFlag;
        private JButton btnChoose, btnEdit, btnBuy, btnBye;
        String flagList[] = {"Damage", "Empty", "Available"};

        SeatDialog(int seatId) {
            seat = new SeatController().select("seatId=" + seatId).get(0);
            this.setTitle("Seat operation");
            this.setSize(width, height);
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setLayout(null);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    rst = -1;
                    sellTicket.removeAllTicket();
                    sellTicket.clearSale();
                    dispose();
                }
            });

            lblTxt1 = new JLabel("Current: ");
            lblTxt1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblTxt1.setBounds(100, 50, 80, 50);
            pan.add(lblTxt1);

            lblTxt2 = new JLabel("" + flagList[seat.getStatus() + 1]);
            lblTxt2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblTxt2.setBounds(160, 50, 140, 50);
            pan.add(lblTxt2);

            lblEdit = new JLabel("Modify: ");
            lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblEdit.setBounds(100, 85, 80, 50);
            pan.add(lblEdit);

            cbxFlag = new JComboBox<String>(flagList);
            cbxFlag.setBounds(190, 95, 130, 30);
            pan.add(cbxFlag);

            lblPayment1 = new JLabel("Total: ");
            lblPayment1.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblPayment1.setBounds(100, 120, 80, 50);
            pan.add(lblPayment1);
            lblPayment2 = new JLabel(prices + "  dollar");
            lblPayment2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblPayment2.setBounds(160, 120, 100, 50);
            pan.add(lblPayment2);

            lblPayment = new JLabel("Paid: ");
            lblPayment.setFont(new Font("Tahoma", Font.PLAIN, 16));
            lblPayment.setBounds(100, 155, 80, 50);
            pan.add(lblPayment);
            txtPayment = new JTextField();
            txtPayment.setBounds(170, 165, 80, 30);
            pan.add(txtPayment);

            btnChoose = new JButton("Select");
            btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnChoose.setBounds(60, height - 100, 100, 30);
            btnChoose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnChooseClicked(seat);
                    dispose();
                }

            });

            pan.add(btnChoose);
            btnBuy = new JButton("Purchase");
            btnBuy.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnBuy.setBounds(180, height - 100, 100, 30);
            btnBuy.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    btnBuyClicked();
                    dispose();
                }

            });
            pan.add(btnBuy);

//            btnBye = new JButton("Refund");
//            btnBye.setFont(new Font("Tahoma", Font.PLAIN, 16));
//            btnBye.setBounds(300, height - 100, 100, 30);
//            btnBye.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    btnByeClicked(seat);
//                    dispose();
//                }
//
//            });
//            pan.add(btnBye);
            btnEdit = new JButton("Edit");
            btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
            btnEdit.setBounds(420, height - 100, 100, 30);
            btnEdit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (new EmployeeController().Fetch("id=" + empId).get(0).getAccess() != 1) {
                        btnEditClicked(seat, cbxFlag.getSelectedIndex() - 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Permission denied!");
                    }
                    dispose();
                }

            });
            pan.add(btnEdit);

            pan.setBounds(0, 0, width, this.height);
            pan.setLayout(null);
            this.add(pan);
        }

        private void btnChooseClicked(Seat bseat) {
            if (sched != null) {
                if (bseat.getStatus() == 1) {
                    if (new TicketController().Select("seatId=" + bseat.getId()).size() == 0
                            || new TicketController().Select("seatId=" + bseat.getId()).get(0).getStatus() == 0) {
                        //select a seat and create a ticket 
                        ticket = sellTicket.makeNewTicket(sched, bseat);
                        sellTicket.addTicket(ticket);
                        prices += ticket.getPrice();
                        rst = bseat.getId();
                        rstList.add(bseat.getId());
                    } else if (new TicketController().Select("seatId=" + bseat.getId()).size() != 0
                            && new TicketController().Select("seatId=" + bseat.getId()).get(0).getStatus() == 1) {
                        ticket = new TicketController().Select("seatId=" + bseat.getId()).get(0);
                        //ticket.setStatus(0);

                        prices -= ticket.getPrice();
                        // new TicketController().modify(ticket);
                        sellTicket.removeTicket(ticket);

                        rst = bseat.getId();
                        for (int i = 0; i < rstList.size(); i++) {
                            if (rstList.get(i) == rst) {
                                rstList.remove(rstList.get(i));
                            }
                        }
                    } else if (new TicketController().Select("seatId=" + bseat.getId()).size() != 0
                            && new TicketController().Select("seatId=" + bseat.getId()).get(0).getStatus() == 9) {
                        JOptionPane.showMessageDialog(null, "This seat is sold!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "The seat is bad!");
                    rst = -1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please select the time first!");
                rst = -1;
            }
            showSeatsTable();

        }

        private void btnEditClicked(Seat bseat, int status) {
            if (status == -1 || status == 0 || status == 1) {
                bseat.setStatus(status);
                new SeatController().modify(bseat);
                rst = -bseat.getId();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid state!");
                rst = -1;
            }
        }

        private void btnBuyClicked() {
            if (sched != null && txtPayment.getText().length() > 0) {
                if (prices <= Integer.parseInt(txtPayment.getText())) {
                    sale = new Sale();
                    sale.setEmpId(empId);
                    sale.setPayment(Float.parseFloat(txtPayment.getText()));
                    System.out.println(sellTicket.getInfo());
                    JOptionPane.showMessageDialog(null, sellTicket.getInfo());

                    int totalPrice = sellTicket.doSale(sale);
                    rst = 0;

                    SellReportController rc = new SellReportController();

                    SellReport report = new SellReport();
                    report.setId(rc.getNextID());
                    //report.setCinemaId(cbCinema.getSelectedIndex() + 1);
                    report.setTicketTotal(totalPrice);

                    SimpleDateFormat pFormatter2 = new SimpleDateFormat("yyyy-MM-dd");

                    //String datetime = "";
                    //datetime += dtTime.datePicker.getDateStringOrEmptyString() + " ";
                    String todayDate = pFormatter2.format(new Date());

                    try {
                        report.setReportDay(pFormatter2.parse(todayDate));
                    } catch (ParseException ex) {
                        Logger.getLogger(SellProductMCView.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    if (rc.getCurDayID(report.getReportDay()) != -1) {
                        rc.updateSellReport(rc.getCurDayID(report.getReportDay()), 0, report.getTicketTotal());
                    } else {
                        rc.insertSellReport(report.getId(), report.getCinemaId(), report.getReportDay(), 0, report.getTicketTotal());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Not pay enough!!");
                    rst = -1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please enter your payment first");
                rst = -1;
            }
        }

        private void btnByeClicked(Seat bseat) {
//            if (sched != null) {
//                if (bseat.getStatus() == 1) {
//                    ticket = new TicketController().Select("seatId=" + bseat.getId() + " and " + "schedId=" + sched.getId())
//                            .get(0);
//
//                    sale = new SaleController().select(
//                            "id=" + new SaleItemController().select("ticketId=" + ticket.getId()).get(0).getSaleId())
//                            .get(0);
//
//                    sale.setTime(new Timestamp(new Date().getTime()));
//                    sale.setStatus(-1);
//                    new SaleController().modify(sale);
//                    for (SaleItem item : new SaleItemController().select("id=" + sale.getId())) {
//                        Ticket tick = new TicketController().Select("id=" + item.getTicketId()).get(0);
//                        tick.setStatus(0);
//                        new TicketController().modify(tick);
//                    }
//                    rst = bseat.getId();
//                } else {
//                    JOptionPane.showMessageDialog(null, "The seat is broken / selected / sold!");
//                    rst = -1;
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Please select a movie and the number of seat first");
//                rst = -1;
//            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                showPanel();
            }
        });
    }
}
