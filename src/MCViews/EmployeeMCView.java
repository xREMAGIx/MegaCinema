/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

/**
 *
 * @author JuliaHaVy
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;

import  MCModels.Employee;
import MCControllers.EmployeeController;
import javax.swing.JPasswordField;
import jdk.nashorn.internal.parser.TokenType;

// permission
// 3 - admin
// 2 - manager 
// 1 - employee

class EmployeeTableMouseListener extends MouseAdapter {

	private JTable table;
	private static Employee emp;

	public Employee getEmployee() {
		return emp;
	}

	@SuppressWarnings("static-access")
	public EmployeeTableMouseListener(JTable table, Object[] number, Employee emp) {
		this.emp = emp;
		this.table = table;
	}

	public void mouseClicked(MouseEvent event) {
		int row = table.getSelectedRow();
		emp.setAccess(Integer.parseInt(table.getValueAt(row, 0).toString()));
		emp.setId(Integer.parseInt(table.getValueAt(row, 1).toString()));
		emp.setNo(Integer.parseInt(table.getValueAt(row, 2).toString()));
		emp.setName(table.getValueAt(row, 3).toString());
		emp.setAddr(table.getValueAt(row, 4).toString());
		emp.setTel(table.getValueAt(row, 5).toString());
		emp.setEmail(table.getValueAt(row, 6).toString());
	}
}

class EmployeeTable {

	private JTable table = null;
	private Employee emp;

	public EmployeeTable(Employee emp) {
		this.emp = emp;
	}

	public void createTable(JScrollPane scrollPane, Object[] columnNames, List<Employee> empList) {
		try {
			Object data[][] = new Object[empList.size()][columnNames.length];
			Iterator<Employee> itr = empList.iterator();
			int i = 0;
			while (itr.hasNext()) {
				Employee item = itr.next();
				data[i][0] = Integer.toString(item.getAccess());
				data[i][1] = Integer.toString(item.getId());
				data[i][2] = Integer.toString(item.getNo());
				data[i][3] = item.getName();
				data[i][4] = item.getAddr();
				data[i][5] = item.getTel();
				data[i][6] = item.getEmail();
				i++;
			}
			table = new JTable(data, columnNames);
			table.setRowHeight(22);
			table.getTableHeader().setFont(new Font("NewellsHand", Font.PLAIN, 20)); // "NewellsHand"
			table.setFont(new Font("NewellsHand", Font.PLAIN, 14));
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, r);
			table.setBounds(0, 0, 600, 400);
			EmployeeTableMouseListener tml = new EmployeeTableMouseListener(table, columnNames, emp);
			table.addMouseListener(tml);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                        //table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
			scrollPane.add(table);
			scrollPane.setViewportView(table);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class EmployeeMCView extends JPanel {

	private static final long serialVersionUID = 1L;
	int empId;
	private Employee emp = new Employee();
	private JScrollPane scorllPane;
	private JPanel btnList;
	private JButton btnAdd, btnQuery, btnEdit, btnDel;
	List<Employee> rst = new ArrayList<>();

	public EmployeeMCView(int empId) {
		super(new BorderLayout());
		this.empId = empId;
		initContent();
	}

	protected void initContent() {
		btnList = new JPanel();

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            // Phan quyen cho admin va manager
				if (new EmployeeController().Fetch("id=" + empId).get(0).getAccess() != 1) {     //access != 1
					EmployeeDialog playDialog = new EmployeeDialog(1);
					playDialog.toFront();
					playDialog.setModal(true);
					playDialog.setVisible(true);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Not Available !");
				}
			}
		});
		btnList.add(btnAdd);

		btnQuery = new JButton("Query");
		btnQuery.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnQuery.addActionListener(new ActionListener() 
                             {
                    
                                    @Override
		public void actionPerformed(ActionEvent e) 
                             {
                                    if (new EmployeeController().Fetch("id=" + empId).get(0).getAccess() != 1) 
                                    {
			EmployeeDialog playDialog = new EmployeeDialog(2);
			playDialog.toFront();
			playDialog.setModal(true);
			playDialog.setVisible(true);
			showTable();
                                    }
                                    else 
                                    {
                                            JOptionPane.showMessageDialog(null, "Not Available !");
                                    }
                            }
		});
		btnList.add(btnQuery);
                   
                // ------------ btn edit ----------------------------------------------------------------
		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            // Phan quyen edit nhan vien cho admin va manager
				if (new EmployeeController().Fetch("id=" + empId).get(0).getAccess() != 1) {        //access != 1
					EmployeeDialog playDialog = new EmployeeDialog(3);
					playDialog.toFront();
					playDialog.setModal(true);
					playDialog.setVisible(true);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Not Available!");
				}
			}
		});
		btnList.add(btnEdit);

                // ----------- btn delete -----------------------------------------------------------------
		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                            // Phan quyen xoa nhan vien cho admin va manager
				if (new EmployeeController().Fetch("id=" + empId).get(0).getAccess() != 1) {    //access != 1 : nhan vien khong thuc hien dc thao tac nay
					EmployeeDialog playDialog = new EmployeeDialog(4);
					playDialog.toFront();
					playDialog.setModal(true);
					playDialog.setVisible(true);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Not Available!");
				}
			}
		});
		btnList.add(btnDel);

		this.add(btnList, BorderLayout.SOUTH);
		scorllPane = new JScrollPane();
		scorllPane.setPreferredSize(new Dimension(8000, 6000));
		this.add(scorllPane, BorderLayout.NORTH);
		showTable();
	}

	public void showTable() {
		EmployeeTable empTable = new EmployeeTable(emp);
		Object[] in = { "Permission", "ID", "Job number", "Name", "Address", "Tel", "E-mail" };
		List<Employee> empList = new EmployeeController().FetchAll();
		if (rst.size() > 0) {
			empList = rst;
		}
		empTable.createTable(scorllPane, in, empList);
		scorllPane.repaint();
		this.repaint();
	}

	public static void showPanel() {
		JFrame frame = new JFrame("Employee Management");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(new EmployeeMCView(1));
		frame.pack();
		frame.setVisible(true);
	}

	class EmployeeDialog extends JDialog {

		private static final long serialVersionUID = 1L;
		final int flag;
		private int width = 700;
		private int height = 400;
		String accessList[] = { "1 - Employee", "2 - Manage", "3 - Admin" }; // Nhân viên - Quản lí - Quản trị viên // 1-2-3
		private JPanel pan = new JPanel();
		private JComboBox<String> cbxAccess;
		private JLabel lblAccess, lblName, lblNo, lblPassWord, lblAddr, lblTel, lblEmail;
		private JTextField txtName, txtNo, txtAddr, txtTel, txtEmail; //txtPassWord,
                private JPasswordField txtPassWord;
		private JButton btnYes, btnNot;

		EmployeeDialog(final int flag) 
                             {
			this.flag = flag;
			this.setTitle("Employee Management"); // 
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setLayout(null);
			this.addWindowListener(new WindowAdapter() 
                                            {
				public void windowClosing(WindowEvent e) 
                                                            {
					dispose();
				}
			});
                                            
                        // ------- lbl access ---------------------------------
			lblAccess = new JLabel("Access : ");
			lblAccess.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblAccess.setBounds(80, 30, 100, 30);
			pan.add(lblAccess);
			cbxAccess = new JComboBox<String>(accessList);
			cbxAccess.setBounds(200, 30, 250, 30);
			pan.add(cbxAccess);
                        
                        // ----------- lbl job number ---------------------------
			lblNo = new JLabel("Job number : ");
			lblNo.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblNo.setBounds(80, 65, 100, 30);
			pan.add(lblNo);
			txtNo = new JTextField();
			txtNo.setBounds(200, 65, 250, 30);
			pan.add(txtNo);

                         // ---------------- lbl name ------------------------------
                                            lblName = new JLabel("Name : ");
			lblName.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblName.setBounds(80, 100, 100, 30);
			pan.add(lblName);
			txtName = new JTextField();
			txtName.setBounds(200, 100, 250, 30);
			pan.add(txtName);

                        // --------------------- lbl password --------------------------
			lblPassWord = new JLabel("Password : ");
			lblPassWord.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblPassWord.setBounds(80, 135, 100, 30);
			pan.add(lblPassWord);
			txtPassWord = new JPasswordField();
			txtPassWord.setBounds(200, 135, 250, 30);
			pan.add(txtPassWord);

                        // ------------------------- lbl address ---------------------
			lblAddr = new JLabel("Address· : ");
			lblAddr.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblAddr.setBounds(80, 170, 100, 30);
			pan.add(lblAddr);
			txtAddr = new JTextField();
			txtAddr.setBounds(200, 170, 250, 30);
			pan.add(txtAddr);

                        // ----------------------- lbl tell ----------------------------
			lblTel = new JLabel("Tell : ");
			lblTel.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblTel.setBounds(80, 205, 100, 30);
			pan.add(lblTel);
			txtTel = new JTextField();
			txtTel.setBounds(200, 205, 250, 30);
			pan.add(txtTel);

                        // ------------------------- lbl email -------------------------
			lblEmail = new JLabel("Email : ");
			lblEmail.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblEmail.setBounds(80, 240, 100, 30);
			pan.add(lblEmail);
			txtEmail = new JTextField();
			txtEmail.setBounds(200, 240, 250, 30);
			pan.add(txtEmail);

                        // ----------------------------- flag 
			if (flag == 3 || flag == 4) {
				txtName.setText(emp.getName());
				txtNo.setText(Integer.toString(emp.getNo()));
				txtPassWord.setText("");
				txtAddr.setText(emp.getAddr());
				txtTel.setText(emp.getTel());
				txtEmail.setText(emp.getEmail());
			}

                        // ------------------------- btn comfirm -------------------------
			btnYes = new JButton("Confirm");
			btnYes.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			btnYes.setBounds(40, height - 80, 120, 30);
			btnYes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (flag == 1) 
                                                                         {
						btnAddClicked();
					} else if (flag == 2) 
                                                                         {
						btnQueryClicked();
					} else if (flag == 3) 
                                                                         {
						btnModClicked();
					} else if (flag == 4) 
                                                                         {
						btnDelClicked();
					}
					dispose();
				}

			});
			pan.add(btnYes);

                        // -------------- btn Cancel ----------------------------------
			btnNot = new JButton("Cancel");
			btnNot.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			btnNot.setBounds(width - 200, height - 80, 120, 30);
			btnNot.addActionListener(new ActionListener() 
                                            {
				@Override
				public void actionPerformed(ActionEvent e) 
                                                           {
                                                                    dispose();
				}
                                            });
			pan.add(btnNot);

			pan.setBounds(0, 0, width, this.height);
			pan.setLayout(null);
			this.add(pan);
		}

		// ------------------ btn add : click ------------------------
                                private void btnAddClicked() {
                                        if (txtName.getText().isEmpty() || txtName.getText() == null) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid Name !" ); 
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else if (txtNo.getText().isEmpty() || txtNo.getText() == null) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid No !" );
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else if (txtAddr.getText().isEmpty() || txtAddr.getText() == null) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid Address !" );
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else if (txtEmail.getText().isEmpty() || txtEmail.getText() == null) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid Email !" );
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else if (txtPassWord.getText().isEmpty() || txtPassWord.getText() == null) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid Password !" );
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else if (txtTel.getText().isEmpty() || txtTel.getText() == null ) 
                                        {
                                            JOptionPane.showMessageDialog(null, "Invalid Tel !" );
                                            JOptionPane.showMessageDialog(null, "Incomplete Data !");
                                        }
                                        else
                                        {
                                            Employee emp = new Employee();
			emp.setAccess(cbxAccess.getSelectedIndex() + 1);
			emp.setName(txtName.getText());
			emp.setNo(Integer.parseInt(txtNo.getText()));
			emp.setPassword(txtPassWord.getText());
			emp.setAddr(txtAddr.getText());
			emp.setTel(txtTel.getText());
			emp.setEmail(txtEmail.getText());
			new EmployeeController().add(emp);
                                        }
//			if (txtName.getText().length() > 0 && txtNo.getText().length() > 0 && txtPassWord.getText().length() > 0
//					&& txtAddr.getText().length() > 0 && txtTel.getText().length() > 0
//					&& txtEmail.getText().length() > 0) {
//				Employee emp = new Employee();
//				emp.setAccess(cbxAccess.getSelectedIndex() + 1);
//				emp.setName(txtName.getText());
//				emp.setNo(Integer.parseInt(txtNo.getText()));
//				emp.setPassword(txtPassWord.getText());
//				emp.setAddr(txtAddr.getText());
//				emp.setTel(txtTel.getText());
//				emp.setEmail(txtEmail.getText());
//				new EmployeeController().add(emp);
//			} else {
//				JOptionPane.showMessageDialog(null, "Incomplete Data !");
//			}
		}
                                
                            // ------------- btn Query : click ----------------------
		private void btnQueryClicked() {
			Employee emp = new Employee();
			String sql = "";
			if (cbxAccess.getSelectedItem() != null) {
				emp.setAccess(cbxAccess.getSelectedIndex() + 1);
				sql += " access=" + (cbxAccess.getSelectedIndex() + 1);
			}
			if (txtNo.getText().length() > 0) {
				emp.setNo(Integer.parseInt(txtNo.getText()));
				sql += " and no=" + txtNo.getText();
			}
			if (txtName.getText().length() > 0) {
				emp.setName(txtName.getText());
				sql += " and name='" + txtName.getText() + "'";
			}
			if (txtAddr.getText().length() > 0) {
				emp.setAddr(txtAddr.getText());
				sql += " and addr='" + txtAddr.getText() + "'";
			}
			if (txtTel.getText().length() > 0) {
				emp.setTel(txtTel.getText());
				sql += " and tel='" + txtTel.getText() + "'";
			}
			if (txtEmail.getText().length() > 0) {
				emp.setEmail(txtEmail.getText());
				sql += " and email='" + txtEmail.getText() + "'";
			}
			rst = new EmployeeController().Fetch(sql);
		}

                // ------------------ btn modify click -----------------------------
		private void btnModClicked() {
			emp.setAccess(cbxAccess.getSelectedIndex() + 1);
			emp.setName(txtName.getText());
			emp.setNo(Integer.parseInt(txtNo.getText()));
			emp.setPassword(txtPassWord.getText());
			emp.setAddr(txtAddr.getText());
			emp.setTel(txtTel.getText());
			emp.setEmail(txtEmail.getText());
			new EmployeeController().modify(emp);
		}
                                
                        // -------------------------- btn Delete : click --------------------------------------
		private void btnDelClicked() {
			int confirm = JOptionPane.showConfirmDialog(null, " Delete Selected Confirmation ", "Delete", JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				EmployeeController stuSrv = new EmployeeController();
				stuSrv.delete(emp.getId());
				showTable();
			}
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
