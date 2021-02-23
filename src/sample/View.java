/**
 * View Class
 *
 * Used to display images for the program
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * All required Javafx imports + sample package
 */
package sample;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;

/**
 * View Class.
 */
public class View {

    /**
     * All variables for the window.
     */
    private final String WINDOW_TITLE = "ATM Simulator";
    private final int HEIGHT = 300;
    private final int WIDTH = 300;

    /**
     * Controller and Model holder.
     */
    private Controller controller;
    private Model model;

    /**
     * All GridPanes.
     */
    private GridPane gridPaneLogin = new GridPane();
    private GridPane gridPaneConsumerAccount = new GridPane();
    private GridPane gridPaneAdminAccount = new GridPane();
    private GridPane gridPaneTransaction = new GridPane();

    /**
     * All Scenes.
     */
    private Scene windowLogin;
    private Scene windowConsumerAccount = new Scene(gridPaneConsumerAccount,HEIGHT,WIDTH);
    private Scene windowAdminAccount = new Scene(gridPaneAdminAccount,HEIGHT,WIDTH);
    private Scene windowTransaction = new Scene(gridPaneTransaction,HEIGHT,WIDTH);

    /**
     * The Main Stage used to display Scenes.
     */
    private Stage currentStage;

    /**
     * All Login Labels.
     */
    private Label labelLoginGreeting = new Label("Please enter your login details.");
    private Label labelLoginId = new Label(" ID");
    private Label labelLoginPasscode = new Label(" Passcode");

    /**
     * All Consumer Account Labels.
     */
    private Label labelConsumerName = new Label("test");
    private Label labelCheckingBal = new Label("test");
    private Label labelSavingsBal = new Label("test");
    private Label labelTransfereeID = new Label(" Transferee ID");

    /**
     * All Admin Account Labels.
     */
    private Label labelAdminName = new Label("test");
    private Label labelHundredATM = new Label(" Hundred Bills: ");
    private Label labelHundredATMvalue = new Label("Test");
    private Label labelFiftyATM = new Label(" Fifty Bills: ");
    private Label labelFiftyATMvalue = new Label("Test");
    private Label labelTwentyATM = new Label(" Twenty Bills: ");
    private Label labelTwentyATMvalue = new Label("Test");
    private Label labelFiveATM = new Label(" Five Bills: ");
    private Label labelFiveATMvalue = new Label("Test");

    /**
     * All Transaction Labels.
     */
    private Label labelTransaction = new Label("test");
    private Label labelHundred = new Label("0");
    private Label labelFifty = new Label("0");
    private Label labelTwenty = new Label("0");
    private Label labelFive = new Label("0");

    /**
     * All TextFields.
     */
    private TextField textFieldLoginID = new TextField();
    private TextField textFieldLoginPasscode = new TextField();
    private TextField textFieldTransfereeID = new TextField();

    /**
     * Login Button.
     */
    private Button buttonLogin = new Button("Login");

    /**
     * All Consumer Account Buttons.
     */
    private Button buttonDepositChecking = new Button("Deposit: Checking");
    private Button buttonDepositSavings = new Button("Deposit: Savings");
    private Button buttonWithdrawChecking = new Button("Withdraw: Checking");
    private Button buttonWithdrawSavings = new Button("Withdraw: Savings");
    private Button buttonTransferChecking = new Button("Transfer: Checking");
    private Button buttonTransferSavings = new Button("Transfer: Savings");
    private Button buttonConsumerLogout = new Button("Logout");

    /**
     * All Admin Account Buttons.
     */
    private Button buttonDepositATM = new Button("Fill ATM");
    private Button buttonWithdrawATM = new Button("Withdraw from ATM");
    private Button buttonAdminLogout = new Button("Logout");

    /**
     * All Transaction Buttons.
     */
    private Button buttonHundred = new Button("$100");
    private Button buttonFifty = new Button("$50");
    private Button buttonTwenty = new Button("$20");
    private Button buttonFive = new Button("$5");
    private Button buttonReset = new Button("Reset");
    private Button buttonSubmit = new Button("Submit");
    private Button buttonCancel = new Button("Cancel");

    /**
     * View Constructor
     *
     * Constructor for the View Class.
     *
     * @param primaryStage     the main stage for the program
     * @param model            the main model for the program
     * @param con              the main controller for the program
     */
    public View(Stage primaryStage, Controller con, Model mod) {
        this.controller = con;
        this.model = mod;
        setGridPaneLogin();
        setGridPaneConsumerAccount();
        setGridPaneAdminAccount();
        setGridPaneTransaction();
        setButtonFonts();
        setLabelFonts();
        setButtonUse();
        setChildren();
        setWindowLogin(primaryStage);
    }

    /**
     * Login Window Setter
     *
     * Sets up all needed properties for the login window when booting up program.
     *
     * @param primaryStage     the main stage for the program
     */
    public void setWindowLogin(Stage primaryStage) {
        currentStage = primaryStage;
        windowLogin = new Scene(gridPaneLogin,WIDTH,HEIGHT);
        currentStage.setTitle(WINDOW_TITLE);
        currentStage.setScene(windowLogin);
    }

    /**
     * Login Window Setter
     *
     * Brings the user back to the login page when logging out.
     */
    public void setWindowLogin() {
        currentStage.setScene(windowLogin);
    }

    /**
     * Consumer Window Setter
     *
     * Sets up all needed properties for the Consumer window. Used for both login
     * and after a transaction.
     */
    public void setWindowConsumerAccount() {
        String balance = String.valueOf(model.getMainATM().getCurrentConsumer().getBalChecking());
        labelCheckingBal.setText("Checking: " + balance);
        balance = String.valueOf(model.getMainATM().getCurrentConsumer().getBalSavings());
        labelSavingsBal.setText("Savings: " + balance);
        currentStage.setScene(windowConsumerAccount);
    }

    /**
     * Admin Window Setter
     *
     * Sets up all needed properties for the Admin window. Used for both login
     * and after a transaction.
     */
    public void setWindowAdminAccount() {
        String balance = String.valueOf(model.getMainATM().getBillHundred());
        labelHundredATMvalue.setText(balance);
        balance = String.valueOf(model.getMainATM().getBillFifty());
        labelFiftyATMvalue.setText(balance);
        balance = String.valueOf(model.getMainATM().getBillTwenty());
        labelTwentyATMvalue.setText(balance);
        balance = String.valueOf(model.getMainATM().getBillFive());
        labelFiveATMvalue.setText(balance);
        currentStage.setScene(windowAdminAccount);
    }

    /**
     * Transaction Window Setter
     *
     * Sets up all needed properties for the Transaction window. Used for all
     * account types and all transaction types. Available to both Consumers and
     * the Admin.
     *
     * @param transactionType     determines deposit or withdraw
     * @param account             determines checking, savings, or ATM transaction
     */
    public void setWindowTransaction(String transactionType, String account) {
        labelTransaction.setText(transactionType + " to/from " + account);
        currentStage.setScene(windowTransaction);
    }

    /**
     * Login GridPane Setter
     *
     * Setter for the Login GridPane
     */
    private void setGridPaneLogin() {
        GridPane.setConstraints(labelLoginGreeting,0,0);
        GridPane.setConstraints(textFieldLoginID,0,1);
        GridPane.setConstraints(labelLoginId,1,1);
        GridPane.setConstraints(textFieldLoginPasscode,0,2);
        GridPane.setConstraints(labelLoginPasscode,1,2);
        GridPane.setConstraints(buttonLogin,0,3);
        gridPaneLogin.setVgap(0.5);
        gridPaneLogin.setHgap(0.5);
    }

    /**
     * Consumer Account GridPane Setter
     *
     * Setter for the Consumer Account GridPane
     */
    private void setGridPaneConsumerAccount() {
        GridPane.setConstraints(labelConsumerName,0,0);
        GridPane.setConstraints(labelCheckingBal,0,1);
        GridPane.setConstraints(labelSavingsBal,0,2);
        GridPane.setConstraints(buttonDepositChecking,0,3);
        GridPane.setConstraints(buttonDepositSavings,0,4);
        GridPane.setConstraints(buttonWithdrawChecking,0,5);
        GridPane.setConstraints(buttonWithdrawSavings,0,6);
        GridPane.setConstraints(textFieldTransfereeID,0,7);
        GridPane.setConstraints(labelTransfereeID,1,7);
        GridPane.setConstraints(buttonTransferChecking,0,8);
        GridPane.setConstraints(buttonTransferSavings,0,9);
        GridPane.setConstraints(buttonConsumerLogout,0,10);
        gridPaneLogin.setVgap(2);
        gridPaneLogin.setHgap(2);
    }

    /**
     * Admin Account GridPane Setter
     *
     * Setter for the Admin Account GridPane
     */
    private void setGridPaneAdminAccount() {
        GridPane.setConstraints(labelAdminName,0,0);
        GridPane.setConstraints(labelHundredATM,0,1);
        GridPane.setConstraints(labelHundredATMvalue,1,1);
        GridPane.setConstraints(labelFiftyATM,0,2);
        GridPane.setConstraints(labelFiftyATMvalue,1,2);
        GridPane.setConstraints(labelTwentyATM,0,3);
        GridPane.setConstraints(labelTwentyATMvalue,1,3);
        GridPane.setConstraints(labelFiveATM,0,4);
        GridPane.setConstraints(labelFiveATMvalue,1,4);
        GridPane.setConstraints(buttonDepositATM,0,5);
        GridPane.setConstraints(buttonWithdrawATM,0,6);
        GridPane.setConstraints(buttonAdminLogout,0,7);
    }

    /**
     * Transaction GridPane Setter
     *
     * Setter for the Transaction GridPane
     */
    private void setGridPaneTransaction() {
        GridPane.setConstraints(labelTransaction,0,0);
        GridPane.setConstraints(buttonHundred,0,1);
        GridPane.setConstraints(labelHundred,1,1);
        GridPane.setConstraints(buttonFifty,0,2);
        GridPane.setConstraints(labelFifty,1,2);
        GridPane.setConstraints(buttonTwenty,0,3);
        GridPane.setConstraints(labelTwenty,1,3);
        GridPane.setConstraints(buttonFive,0,4);
        GridPane.setConstraints(labelFive,1,4);
        GridPane.setConstraints(buttonReset,0,5);
        GridPane.setConstraints(buttonSubmit,0,6);
        GridPane.setConstraints(buttonCancel,0,7);
    }

    /**
     * Children Setter
     *
     * Setter for all Children in all GridPanes
     */
    private void setChildren() {
        // Login Children
        gridPaneLogin.getChildren().addAll(labelLoginGreeting,textFieldLoginID,labelLoginId,textFieldLoginPasscode,
                labelLoginPasscode,buttonLogin);

        // Consumer Account Children
        gridPaneConsumerAccount.getChildren().addAll(labelConsumerName,labelCheckingBal,labelSavingsBal,
                buttonDepositChecking,buttonDepositSavings,buttonWithdrawChecking,buttonWithdrawSavings,
                buttonTransferChecking,buttonTransferSavings,buttonConsumerLogout,textFieldTransfereeID,labelTransfereeID);

        // Admin Account Children
        gridPaneAdminAccount.getChildren().addAll(labelAdminName,labelHundredATM,labelHundredATMvalue,labelFiftyATM,
                labelFiftyATMvalue,labelTwentyATM,labelTwentyATMvalue,labelFiveATM,labelFiveATMvalue,buttonDepositATM,
                buttonWithdrawATM,buttonAdminLogout);

        // Transaction Children
        gridPaneTransaction.getChildren().addAll(labelTransaction,buttonHundred,labelHundred,buttonFifty,labelFifty,
                buttonTwenty,labelTwenty,buttonFive,labelFive,buttonReset,buttonSubmit,buttonCancel);
    }

    /**
     * Button Use Setter
     *
     * Setter for all Buttons used in all Scenes
     */
    private void setButtonUse() {
        // All Login/Logout buttons
        buttonLogin.setOnAction(event -> controller.checkLogin());
        buttonConsumerLogout.setOnAction(event -> controller.logOut());
        buttonAdminLogout.setOnAction(event -> controller.logOut());

        // All Consumer Account buttons
        buttonDepositChecking.setOnAction(event -> controller.setDepositChecking());
        buttonDepositSavings.setOnAction(event -> controller.setDepositSavings());
        buttonWithdrawChecking.setOnAction(event -> controller.setWithdrawChecking());
        buttonWithdrawSavings.setOnAction(event -> controller.setWithdrawSavings());
        buttonTransferChecking.setOnAction(event -> controller.setTransferChecking(textFieldTransfereeID.getText()));
        buttonTransferSavings.setOnAction(event -> controller.setTransferSavings(textFieldTransfereeID.getText()));

        // All Admin Account buttons
        buttonDepositATM.setOnAction(event -> controller.setDepositATM());
        buttonWithdrawATM.setOnAction(event -> controller.setWithdrawATM());

        // All Transaction buttons
        buttonCancel.setOnAction(event -> controller.setWindowFromCancel());
        buttonHundred.setOnAction(event -> controller.setHundredBill());
        buttonFifty.setOnAction(event -> controller.setFiftyBill());
        buttonTwenty.setOnAction(event -> controller.setTwentyBill());
        buttonFive.setOnAction(event -> controller.setFiveBill());
        buttonReset.setOnAction(event -> controller.resetBills());
        buttonSubmit.setOnAction(event -> controller.makeTransaction());
    }

    /**
     * Button Font Setter
     *
     * Setter for all fonts and sizes for Buttons
     */
    private void setButtonFonts() {
        final String FONT = "Cambria";
        final int SIZE_DEFAULT = 14;
        buttonLogin.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonConsumerLogout.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonAdminLogout.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonDepositChecking.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonDepositSavings.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonWithdrawChecking.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonWithdrawSavings.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonTransferChecking.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonTransferSavings.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonDepositATM.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonWithdrawATM.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonCancel.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonHundred.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonFifty.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonTwenty.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonFive.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonReset.setFont(new Font(FONT,SIZE_DEFAULT));
        buttonSubmit.setFont(new Font(FONT,SIZE_DEFAULT));
    }

    /**
     * label Font Setter
     *
     * Setter for all fonts and sizes for Labels
     */
    private void setLabelFonts() {
        final String FONT = "Cambria";
        final int SIZE_DEFAULT = 16;
        labelLoginGreeting.setFont(new Font(FONT,SIZE_DEFAULT));
        labelLoginId.setFont(new Font(FONT,SIZE_DEFAULT));
        labelLoginPasscode.setFont(new Font(FONT,SIZE_DEFAULT));
        labelConsumerName.setFont(new Font(FONT,SIZE_DEFAULT));
        labelCheckingBal.setFont(new Font(FONT,SIZE_DEFAULT));
        labelSavingsBal.setFont(new Font(FONT,SIZE_DEFAULT));
        labelTransfereeID.setFont(new Font(FONT,SIZE_DEFAULT));
        labelAdminName.setFont(new Font(FONT,SIZE_DEFAULT));
        labelHundredATM.setFont(new Font(FONT,SIZE_DEFAULT));
        labelHundredATMvalue.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFiftyATM.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFiftyATMvalue.setFont(new Font(FONT,SIZE_DEFAULT));
        labelTwentyATM.setFont(new Font(FONT,SIZE_DEFAULT));
        labelTwentyATMvalue.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFiveATM.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFiveATMvalue.setFont(new Font(FONT,SIZE_DEFAULT));
        labelTransaction.setFont(new Font(FONT,SIZE_DEFAULT));
        labelHundred.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFifty.setFont(new Font(FONT,SIZE_DEFAULT));
        labelTwenty.setFont(new Font(FONT,SIZE_DEFAULT));
        labelFive.setFont(new Font(FONT,SIZE_DEFAULT));
    }

    /**
     * Consumer Login Confirmation
     *
     * Confirms the login for a Consumer
     *
     * @return the login confirmation
     */
    public boolean convertLoginConsumer() {
        boolean output;
        output = model.getMainATM().loginVerifyConsumer(textFieldLoginID.getText(),
                textFieldLoginPasscode.getText());
        return output;
    }

    /**
     * Admin Login Confirmation
     *
     * Confirms the login for Admin
     *
     * @return the login confirmation
     */
    public boolean convertLoginAdmin() {
        boolean output;
        output = model.getMainATM().loginVerifyAdmin(textFieldLoginID.getText(),
                textFieldLoginPasscode.getText());
        return output;
    }

    /**
     * Consumer Name Setter
     *
     * Sets the name for the Consumer
     *
     * @param input     used as the name
     */
    public void setLabelConsumerName(String input) {
        labelConsumerName.setText(input);
    }

    /**
     * Admin Name Setter
     *
     * Sets the name for the Admin
     *
     * @param input     used as the name
     */
    public void setLabelAdminName(String input) {
        labelAdminName.setText(input);
    }

    /**
     * Hundred Setter
     *
     * Sets the current count for Hundred in the Transaction Window
     */
    public void setLabelHundred() {
        labelHundred.setText(String.valueOf(model.getCurrHundred()));
    }

    /**
     * Fifty Setter
     *
     * Sets the current count for Fifty in the Transaction Window
     */
    public void setLabelFifty() {
        labelFifty.setText(String.valueOf(model.getCurrFifty()));
    }

    /**
     * Twenty Setter
     *
     * Sets the current count for Twenty in the Transaction Window
     */
    public void setLabelTwenty() {
        labelTwenty.setText(String.valueOf(model.getCurrTwenty()));
    }

    /**
     * Five Setter
     *
     * Sets the current count for Five in the Transaction Window
     */
    public void setLabelFive() {
        labelFive.setText(String.valueOf(model.getCurrFive()));
    }
}