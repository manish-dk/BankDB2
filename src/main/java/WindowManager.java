import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowManager {
		Frame outer;
		Frame createFrame;
		Frame depositFrame;
		Frame withdrawFrame;
		Frame balanceFrame;
		static Frame errorFrame;
		TextField name;
		TextField address;
		TextField id;
		TextField amount;
		TextField balance;
		Label n;
		Label a;
		Label b;
		static GridLayout grid = new GridLayout(5,4);
		static FlowLayout flow = new FlowLayout();
		
		public static void generateError(String message) {
			errorFrame = new Frame("Error");
			errorFrame.setSize(300,100);
			Panel upperPanel = new Panel();
			Panel lowerPanel = new Panel();
			upperPanel.setBackground(Color.GRAY);
			lowerPanel.setBackground(Color.GRAY);
			Button okBtn = new Button("OK");
			Label messageLabel = new Label(message);
			upperPanel.setVisible(true);
			upperPanel.setLayout(flow);
			lowerPanel.setVisible(true);
			lowerPanel.setLayout(flow);
			upperPanel.add(messageLabel);
			lowerPanel.add(okBtn);
			errorFrame.add(upperPanel,BorderLayout.NORTH);
			errorFrame.add(lowerPanel,BorderLayout.CENTER);
			errorFrame.setVisible(true);
			okBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					errorFrame.setVisible(false);
				}
			});
		}
		public void home() {
			
			outer = new Frame("Bank");
			outer.setVisible(true);
			outer.setSize(300,400);
			Panel buttonPanel = new Panel();
			buttonPanel.setVisible(true);
			buttonPanel.setLayout(grid);
			outer.add(buttonPanel,BorderLayout.CENTER);

			Button createBtn = new Button("Create Account");
			Button balanceBtn = new Button("Check Balance");
			Button depositBtn = new Button("Deposit");
			Button withdrawBtn = new Button("Withdraw");
			Button exitBtn = new Button("Exit");
			
			buttonPanel.add(createBtn);
			buttonPanel.add(balanceBtn);
			buttonPanel.add(depositBtn);
			buttonPanel.add(withdrawBtn);
			buttonPanel.add(exitBtn);
			
			createBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outer.setVisible(false);
					create();
				}
			});
			
			balanceBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outer.setVisible(false);
					balance();
				}
			});
			
			depositBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outer.setVisible(false);
					deposit();
				}
			});
			
			withdrawBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					outer.setVisible(false);
					withdraw();
				}
			});
			
			exitBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		
		public void create() {
			createFrame = new Frame("Create Account");
			createFrame.setVisible(true);
			createFrame.setSize(300,400);
			Panel buttonPanel = new Panel();
			Panel upperPanel = new Panel();
			Panel lowerPanel = new Panel();
			upperPanel.setVisible(true);
			upperPanel.setLayout(flow);
			lowerPanel.setVisible(true);
			lowerPanel.setLayout(flow);
			buttonPanel.setVisible(true);
			buttonPanel.setLayout(grid);
			createFrame.add(buttonPanel,BorderLayout.SOUTH);
			createFrame.add(upperPanel,BorderLayout.NORTH);
			createFrame.add(lowerPanel,BorderLayout.CENTER);
			Label n = new Label("Name: ");
			Label a = new Label("Address: ");
			name = new TextField();
			address = new TextField();
			Button submitBtn = new Button("Create Account");
			Button cancelBtn = new Button("Cancel");
			
			name.setColumns(20);
			address.setColumns(20);
			upperPanel.add(n);
			upperPanel.add(name);
			lowerPanel.add(a);
			lowerPanel.add(address);
			buttonPanel.add(submitBtn);
			buttonPanel.add(cancelBtn);
			
			cancelBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createFrame.setVisible(false);
					cancel();
				}
			});
			submitBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					createFrame.setVisible(false);
					cancel();
					createAcc(name.getText(),address.getText());
				}
			});
		}
		public void withdraw() {
			withdrawFrame = new Frame("Withdraw Money");
			withdrawFrame.setVisible(true);
			withdrawFrame.setSize(300,400);
			Panel buttonPanel = new Panel();
			Panel upperPanel = new Panel();
			Panel lowerPanel = new Panel();
			upperPanel.setVisible(true);
			upperPanel.setLayout(flow);
			lowerPanel.setVisible(true);
			lowerPanel.setLayout(flow);
			buttonPanel.setVisible(true);
			buttonPanel.setLayout(grid);
			withdrawFrame.add(buttonPanel,BorderLayout.SOUTH);
			withdrawFrame.add(upperPanel,BorderLayout.NORTH);
			withdrawFrame.add(lowerPanel,BorderLayout.CENTER);
			Label n = new Label("ID: ");
			Label a = new Label("Amount: ");
			id = new TextField();
			amount = new TextField();
			Button submitBtn = new Button("Withdraw");
			Button cancelBtn = new Button("Cancel");
			
			id.setColumns(20);
			amount.setColumns(20);
			upperPanel.add(n);
			upperPanel.add(id);
			lowerPanel.add(a);
			lowerPanel.add(amount);
			buttonPanel.add(submitBtn);
			buttonPanel.add(cancelBtn);
			
			cancelBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					withdrawFrame.setVisible(false);
					cancel();
				}
			});
			submitBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					withdrawFrame.setVisible(false);
					cancel();
					withdraw(id.getText(),amount.getText());
				}
			});
			
		}
		public void deposit() {
			depositFrame = new Frame("Deposit Money");
			depositFrame.setVisible(true);
			depositFrame.setSize(300,400);
			Panel buttonPanel = new Panel();
			Panel upperPanel = new Panel();
			Panel lowerPanel = new Panel();
			upperPanel.setVisible(true);
			upperPanel.setLayout(flow);
			lowerPanel.setVisible(true);
			lowerPanel.setLayout(flow);
			buttonPanel.setVisible(true);
			buttonPanel.setLayout(grid);
			depositFrame.add(buttonPanel,BorderLayout.SOUTH);
			depositFrame.add(upperPanel,BorderLayout.NORTH);
			depositFrame.add(lowerPanel,BorderLayout.CENTER);
			Label n = new Label("ID: ");
			Label a = new Label("Amount: ");
			id = new TextField();
			amount = new TextField();
			Button submitBtn = new Button("Deposit");
			Button cancelBtn = new Button("Cancel");
			
			id.setColumns(20);
			amount.setColumns(20);
			upperPanel.add(n);
			upperPanel.add(id);
			lowerPanel.add(a);
			lowerPanel.add(amount);
			buttonPanel.add(submitBtn);
			buttonPanel.add(cancelBtn);
			
			cancelBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					depositFrame.setVisible(false);
					cancel();
				}
			});
			
			submitBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					depositFrame.setVisible(false);
					cancel();
					deposit(id.getText(),amount.getText());
				}
			});
		}
		
		public void balance() {
			balanceFrame = new Frame("Check Balance");
			balanceFrame.setVisible(true);
			balanceFrame.setSize(300,500);
			Panel buttonPanel = new Panel();
			Panel upperPanel = new Panel();
			Panel lowerPanel = new Panel();
			upperPanel.setVisible(true);
			upperPanel.setLayout(flow);
			lowerPanel.setVisible(true);
			lowerPanel.setLayout(grid);
			buttonPanel.setVisible(true);
			buttonPanel.setLayout(grid);
			balanceFrame.add(buttonPanel,BorderLayout.SOUTH);
			balanceFrame.add(upperPanel,BorderLayout.NORTH);
			balanceFrame.add(lowerPanel,BorderLayout.CENTER);
			Label i = new Label("Enter Account num: ");
			id = new TextField();
			id.setColumns(10);
			n = new Label("Name: ");
			a = new Label("Address: ");
			b = new Label("Balance: ");
			Label name = new Label();
			Label address = new Label();
			Label balance = new Label();
			Button submitBtn = new Button("Check Balance");
			Button cancelBtn = new Button("Cancel");
			
			
			upperPanel.add(i);
			upperPanel.add(id);
			lowerPanel.add(n);
			lowerPanel.add(name);
			lowerPanel.add(a);
			lowerPanel.add(address);
			lowerPanel.add(b);
			lowerPanel.add(balance);
			buttonPanel.add(submitBtn);
			buttonPanel.add(cancelBtn);
			
			cancelBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					balanceFrame.setVisible(false);
					cancel();
				}
			});
			
			submitBtn.addActionListener(
					new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DBConnect.balance(id.getText(),n,a,b);
				}
			});
		}
		
		public void deposit(String id, String amount) {
			DBConnect.deposit(id, amount);
		}
		
		public void withdraw(String id, String amount) {
			DBConnect.withdraw(id, amount);
		}
		
		public void cancel() {
			outer.setVisible(true);
		}
		
		public void createAcc(String name,String address) {
			DBConnect.create(name, address);
		}
		
}
