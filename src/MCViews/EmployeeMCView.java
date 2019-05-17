/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

/**
 *
 * @author Huynh Ha Vy
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
//import me.lancer.cms.service.EmployeeSrv;

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
			table.setRowHeight(24);
			table.getTableHeader().setFont(new Font("NewellsHand", Font.PLAIN, 16)); // "NewellsHand"
			table.setFont(new Font("NewellsHand", Font.PLAIN, 14));
			DefaultTableCellRenderer r = new DefaultTableCellRenderer();
			r.setHorizontalAlignment(JLabel.CENTER);
			table.setDefaultRenderer(Object.class, r);
			table.setBounds(0, 0, 800, 600);
			EmployeeTableMouseListener tml = new EmployeeTableMouseListener(table, columnNames, emp);
			table.addMouseListener(tml);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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
				if (new EmployeeController().Fetch("emp_id=" + empId).get(0).getAccess() != 1) {
					EmployeeDialog playDialog = new EmployeeDialog(1);
					playDialog.toFront();
					playDialog.setModal(true);
					playDialog.setVisible(true);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Not Available!");
				}
			}
		});
		btnList.add(btnAdd);

		btnQuery = new JButton("Query");
		btnQuery.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnQuery.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EmployeeDialog playDialog = new EmployeeDialog(2);
				playDialog.toFront();
				playDialog.setModal(true);
				playDialog.setVisible(true);
				showTable();
			}
		});
		btnList.add(btnQuery);

		btnEdit = new JButton("Edit");
		btnEdit.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new EmployeeController().Fetch("emp_id=" + empId).get(0).getAccess() != 1) {
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

		btnDel = new JButton("Delete");
		btnDel.setFont(new Font("NewellsHand", Font.PLAIN, 16));
		btnDel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (new EmployeeController().Fetch("emp_id=" + empId).get(0).getAccess() != 1) {
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new EmployeeMCView(1));
		frame.pack();
		frame.setVisible(true);
	}

	class EmployeeDialog extends JDialog {

		private static final long serialVersionUID = 1L;
		final int flag;
		private int width = 400;
		private int height = 400;
		String accessList[] = { "Employee", "Manage", "Admin" }; // Nhân viên - Quản lí - Quản trị viên
		private JPanel pan = new JPanel();
		private JComboBox<String> cbxAccess;
		private JLabel lblAccess, lblName, lblNo, lblPassWord, lblAddr, lblTel, lblEmail;
		private JTextField txtName, txtNo, txtPassWord, txtAddr, txtTel, txtEmail;
		private JButton btnYes, btnNot;

		EmployeeDialog(final int flag) {
			this.flag = flag;
			this.setTitle("Employee Operation"); // Hoạt động của nhân viên
			this.setSize(width, height);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			this.setLayout(null);
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					dispose();
				}
			});

			lblAccess = new JLabel("Permission : ");
			lblAccess.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblAccess.setBounds(80, 30, 60, 30);
			pan.add(lblAccess);
			cbxAccess = new JComboBox<String>(accessList);
			cbxAccess.setBounds(140, 30, 120, 30);
			pan.add(cbxAccess);

			lblNo = new JLabel("Job number : ");
			lblNo.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblNo.setBounds(80, 65, 60, 30);
			pan.add(lblNo);
			txtNo = new JTextField();
			txtNo.setBounds(140, 65, 120, 30);
			pan.add(txtNo);

			lblName = new JLabel("Name : ");
			lblName.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblName.setBounds(80, 100, 60, 30);
			pan.add(lblName);
			txtName = new JTextField();
			txtName.setBounds(140, 100, 120, 30);
			pan.add(txtName);

			lblPassWord = new JLabel("Password : ");
			lblPassWord.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblPassWord.setBounds(80, 135, 60, 30);
			pan.add(lblPassWord);
			txtPassWord = new JTextField();
			txtPassWord.setBounds(140, 135, 120, 30);
			pan.add(txtPassWord);

			lblAddr = new JLabel("Address· : ");
			lblAddr.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblAddr.setBounds(80, 170, 60, 30);
			pan.add(lblAddr);
			txtAddr = new JTextField();
			txtAddr.setBounds(140, 170, 120, 30);
			pan.add(txtAddr);

			lblTel = new JLabel("Tell : ");
			lblTel.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblTel.setBounds(80, 205, 60, 30);
			pan.add(lblTel);
			txtTel = new JTextField();
			txtTel.setBounds(140, 205, 120, 30);
			pan.add(txtTel);

			lblEmail = new JLabel("Email : ");
			lblEmail.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			lblEmail.setBounds(80, 240, 60, 30);
			pan.add(lblEmail);
			txtEmail = new JTextField();
			txtEmail.setBounds(140, 240, 120, 30);
			pan.add(txtEmail);

			if (flag == 3 || flag == 4) {
				txtName.setText(emp.getName());
				txtNo.setText(Integer.toString(emp.getNo()));
				txtPassWord.setText("");
				txtAddr.setText(emp.getAddr());
				txtTel.setText(emp.getTel());
				txtEmail.setText(emp.getEmail());
			}

			btnYes = new JButton("Confirm");
			btnYes.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			btnYes.setBounds(40, height - 80, 66, 30);
			btnYes.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (flag == 1) {
						btnAddClicked();
					} else if (flag == 2) {
						btnQueryClicked();
					} else if (flag == 3) {
						btnModClicked();
					} else if (flag == 4) {
						btnDelClicked();
					}
					dispose();
				}

			});
			pan.add(btnYes);

			btnNot = new JButton("Cancel");
			btnNot.setFont(new Font("NewellsHand", Font.PLAIN, 16));
			btnNot.setBounds(width - 106, height - 80, 66, 30);
			btnNot.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}

			});
			pan.add(btnNot);

			pan.setBounds(0, 0, width, this.height);
			pan.setLayout(null);
			this.add(pan);
		}

		private void btnAddClicked() {
			if (txtName.getText().length() > 0 && txtNo.getText().length() > 0 && txtPassWord.getText().length() > 0
					&& txtAddr.getText().length() > 0 && txtTel.getText().length() > 0
					&& txtEmail.getText().length() > 0) {
				Employee emp = new Employee();
				emp.setAccess(cbxAccess.getSelectedIndex() + 1);
				emp.setName(txtName.getText());
				emp.setNo(Integer.parseInt(txtNo.getText()));
				emp.setPassword(txtPassWord.getText());
				emp.setAddr(txtAddr.getText());
				emp.setTel(txtTel.getText());
				emp.setEmail(txtEmail.getText());
				new EmployeeController().add(emp);
			} else {
				JOptionPane.showMessageDialog(null, "Incomplete Data");
			}
		}

		private void btnQueryClicked() {
			Employee emp = new Employee();
			String sql = "";
			if (cbxAccess.getSelectedItem() != null) {
				emp.setAccess(cbxAccess.getSelectedIndex() + 1);
				sql += " emp_access=" + (cbxAccess.getSelectedIndex() + 1);
			}
			if (txtNo.getText().length() > 0) {
				emp.setNo(Integer.parseInt(txtNo.getText()));
				sql += " and emp_no=" + txtNo.getText();
			}
			if (txtName.getText().length() > 0) {
				emp.setName(txtName.getText());
				sql += " and emp_name='" + txtName.getText() + "'";
			}
			if (txtAddr.getText().length() > 0) {
				emp.setAddr(txtAddr.getText());
				sql += " and emp_addr='" + txtAddr.getText() + "'";
			}
			if (txtTel.getText().length() > 0) {
				emp.setTel(txtTel.getText());
				sql += " and emp_tel='" + txtTel.getText() + "'";
			}
			if (txtEmail.getText().length() > 0) {
				emp.setEmail(txtEmail.getText());
				sql += " and emp_email='" + txtEmail.getText() + "'";
			}
			rst = new EmployeeController().Fetch(sql);
		}

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