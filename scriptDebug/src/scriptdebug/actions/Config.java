package scriptdebug.actions;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.internal.browser.DefaultWebBrowser;
import org.eclipse.ui.internal.browser.WebBrowserEditorInput;

import console.message.ConsoleFactory;

import scriptdebug.lifecyclemanage.ClientProcess;
import scriptdebug.model.DebugInfoModel;
import scriptdebug.model.JSDebugModel;
import scriptdebug.utils.BrowserUtils;
import scriptdebug.utils.IpUtils;

//VS4E -- DO NOT REMOVE THIS LINE!
@SuppressWarnings("restriction")
public class Config extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JButton jButton1;
	private JButton jButton0;
	private JScrollPane ipSet;
	private JPanel browserSet;
	private JTabbedPane jTabbedPane0;
	private JTable browserTable;
	private JTable ipTable;
	private JScrollPane jScrollPane1;
	private JButton jButton2;
	private JButton jButton3;
	private JPanel jPanel;
	// static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	static ConsoleFactory consoleFactory = new ConsoleFactory();
	private IWorkbenchWindow window;

	/*
	 * public static void main(String[] args) { try { Config dialog = new
	 * Config(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	public Config(IWorkbenchWindow window) {
		this.window = window;
		initComponents();
	}

	private void initComponents() {
		setTitle("JavaScript调试");
		setAlwaysOnTop(true);
		setForeground(Color.black);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(115, 154, 10, 10),
				new Leading(12, 12, 12)));
		add(getJButton1(this), new Constraints(new Leading(220, 94, 10, 10),
				new Leading(322, 12, 12)));
		add(getJButton0(this), new Constraints(new Leading(77, 94, 10, 10),
				new Leading(322, 10, 10)));
		add(getJTabbedPane0(), new Constraints(new Leading(20, 344, 12, 12),
				new Leading(42, 193, 10, 10)));
		add(getJPanel(), new Constraints(new Leading(20, 346, 10, 10),
				new Leading(253, 41, 10, 10)));
		setSize(382, 380);
		setLocation(400, 200);
	}

	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return jTextField3;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("时间");
		}
		return jLabel3;
	}

	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return jTextField2;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("状态数");
		}
		return jLabel2;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED,
					null, null, null, null));
		}
		return jTextField1;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("深度");
		}
		return jLabel1;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
			jPanel.setLayout(new GroupLayout());

			jPanel.add(getJLabel2(), new Constraints(new Leading(122, 12, 12),
					new Leading(9, 12, 12)));
			jPanel.add(getJLabel1(), new Constraints(new Leading(5, 10, 10),
					new Leading(9, 12, 12)));
			jPanel.add(getJTextField1(), new Constraints(new Leading(52, 49,
					12, 12), new Leading(7, 12, 12)));
			jPanel.add(getJTextField2(), new Constraints(new Leading(169, 49,
					12, 12), new Leading(7, 12, 12)));
			jPanel.add(getJLabel3(), new Constraints(new Leading(236, 12, 12),
					new Leading(9, 12, 12)));
			jPanel.add(getJTextField3(), new Constraints(new Leading(283, 49,
					12, 12), new Leading(7, 12, 12)));

		}
		return jPanel;
	}

	private JButton getJButton3() {
		if (jButton3 == null) {
			jButton3 = new JButton();
			jButton3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int selectRow = browserTable.getSelectedRow();
					if (selectRow != -1) {
						DefaultTableModel defaultTableModel = (DefaultTableModel) browserTable
								.getModel();
						defaultTableModel.removeRow(selectRow);
					}

				}
			});
			jButton3.setText("-");
		}
		return jButton3;
	}

	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel defaultTableModel = (DefaultTableModel) browserTable
							.getModel();
					String[] aStrings = { "", "" };
					defaultTableModel.addRow(aStrings);

				}
			});
			jButton2.setSize(40, 20);
			jButton2.setText("+");
		}
		return jButton2;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJTable1());
		}
		return jScrollPane1;
	}

	private JTable getJTable1() {
		if (browserTable == null) {
			browserTable = new JTable();
			browserTable.setModel(new DefaultTableModel(new Object[][] { { "",
					"", "", "", }, }, new String[] { "浏览器名称", "浏览器路径",
					"操作系统名称", "操作系统位数" }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class,
						Object.class, Object.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
			/*
			 * jTable1.getColumnModel().getColumn(1).setCellRenderer(new
			 * TableCellRenderer() {
			 * 
			 * @Override public Component getTableCellRendererComponent(JTable
			 * table, Object value, boolean isSelected, boolean hasFocus, int
			 * row, int column) {
			 * 
			 * return null; } });
			 */
		}
		return browserTable;
	}

	private JTabbedPane getJTabbedPane0() {
		if (jTabbedPane0 == null) {
			jTabbedPane0 = new JTabbedPane();
			jTabbedPane0.addTab("IP设置", getJScrollPane0());
			jTabbedPane0.addTab("运行环境设置", getJPanel0());
		}
		return jTabbedPane0;
	}

	private JPanel getJPanel0() {
		if (browserSet == null) {
			browserSet = new JPanel();
			browserSet.setLayout(new GroupLayout());
			browserSet.add(getJButton2(), new Constraints(new Leading(199, 50,
					10, 10), new Leading(132, 23, 10, 10)));
			browserSet.add(getJButton3(), new Constraints(new Leading(259, 50,
					10, 10), new Leading(132, 23, 12, 12)));
			browserSet.add(getJScrollPane1(), new Constraints(new Leading(6,
					328, 10, 10), new Leading(5, 119, 10, 10)));
		}
		return browserSet;
	}

	private JScrollPane getJScrollPane0() {
		if (ipSet == null) {
			ipSet = new JScrollPane();
			ipSet.setViewportView(getJTable0());
		}
		return ipSet;
	}

	private JTable getJTable0() {
		if (ipTable == null) {
			ipTable = new JTable();
			ipTable.setModel(new DefaultTableModel(new Object[][] {
					{ "Web服务器", "", }, { "数据服务器", "", }, { "代理服务器", "", },
					{ "本地IP", "", }, }, new String[] { "名称", "IP地址", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };

				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}

				@Override
				public boolean isCellEditable(int row, int column) {
					if (column == 1) {
						return true;
					} else {
						return false;
					}
				}
			});
		}
		return ipTable;
	}

	private JButton getJButton0(final Config config) {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("确定");
			jButton0.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (ClientProcess.getRecorderClientProcess() != null
							|| ClientProcess.getReplayClienyProcess() != null) {
						printToConsole("脚本调试插件运行中，请先停止脚本调试插件", true, true);
						config.setVisible(false);
						return;
					}
					final JSDebugModel jsDebugModel = new JSDebugModel(IpUtils
							.createIpModel(ipTable), BrowserUtils
							.createBrowserModel(browserTable));
					jsDebugModel.setDeep(Integer.parseInt(jTextField1.getText()));
					jsDebugModel.setStatus(Integer.parseInt(jTextField2
							.getText()));
					jsDebugModel.setTime(Integer.parseInt(jTextField3.getText()));
					DebugInfoModel result = jsDebugModel.executeStartCommand();
					if (result.isSuccess()) {
						printToConsole(
								"启动脚本调试插件成功，可通过浏览器访问调试主页" + "\n" + "http://"
										+ jsDebugModel.getIpModel().getWebIp()
										+ "/app", true, true);
						config.setVisible(false);
						/*
						 * DefaultWebBrowser browser = new
						 * DefaultWebBrowser(null, "OpenInBrowser"); try {
						 * browser.openURL(new URL("http://" +
						 * jsDebugModel.getIpModel().getWebIp() + "/app")); }
						 * catch (Exception ue) {
						 * printToConsole(ue.getMessage(), true, false);
						 * printToConsole("浏览器自动开启失败，可尝试手动打开浏览器，并访问调试主页", true,
						 * false);
						 * 
						 * }
						 */

						Display.getDefault().syncExec(new Runnable() {
							public void run() {
								try {
									WebBrowserEditorInput editorInput = new WebBrowserEditorInput(
											new URL("http://"
													+ jsDebugModel.getIpModel()
															.getWebIp()
													+ "/app"));
									String editorId = "org.eclipse.ui.browser.editor"; // 用户自己扩展的编辑器对应的ID
									IWorkbenchPage workbenchaPage = window
											.getActivePage();
									;
									IEditorPart editor = workbenchaPage
											.findEditor(editorInput);
									if (editor != null)
										workbenchaPage.bringToTop(editor);
									else {
										editor = workbenchaPage.openEditor(
												editorInput, editorId);
									}
								} catch (Exception e1) {
									e1.printStackTrace();
									printToConsole(
											"内部浏览器自动开启失败，可尝试手动打开浏览器，并访问调试主页",
											true, false);
								}
							}
						});

					} else {
						printToConsole("启动脚本调试插件失败！", true, true);
						for (String error : result.getFailMessage()) {
							printToConsole(error, true, false);
						}
						config.setVisible(false);
					}
				}
			});
		}
		return jButton0;
	}

	private JButton getJButton1(final Config config) {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					config.dispose();
				}
			});
			jButton1.setText("取消");
		}
		return jButton1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("JavaScript调试参数设置");
		}
		return jLabel0;
	}

	public static void printToConsole(String message, boolean activate,
			boolean clear) {

		consoleFactory.showConsole();
		MessageConsole messageConsole = consoleFactory.getConsole();
		if (clear)
			messageConsole.clearConsole();
		MessageConsoleStream printer = messageConsole.newMessageStream();
		printer.setActivateOnWrite(activate);
		/*
		 * Date date = new Date(); String time = format.format(date);
		 */
		printer.println("提示：" + message);
	}

}
