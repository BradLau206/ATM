/**
 * Controller Class
 *
 * Used to read in calls to action.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * sample package
 */
package sample;

/**
 * Controller Class
 */
public class Controller {

    /**
     * View, Model, and MessageBox
     */
    private View view;
    private Model model;
    private MessageBox messageBox;

    /**
     * All Account types
     */
    private final String CHECKING = "Checking";
    private final String SAVINGS = "Savings";
    private final String ATM = "ATM";

    /**
     * All Transaction types
     */
    private final String DEPOSIT = "Deposit";
    private final String WITHDRAW = "Withdraw";
    private final String TRANSFER = "Transfer";

    /**
     * All Strings used to carry current info on
     * current Consumer/Admin
     */
    private String currAccount = "";
    private String currTransaction = "";
    private String currID = "";

    /**
     * Controller Constructor
     *
     * Constructor for the Controller Class.
     */
    public Controller() {
        messageBox = new MessageBox();
    }

    /**
     * View Setter
     *
     * Sets the View into the Controller Class.
     */
    public void setView(View _view) {
        this.view = _view;
    }

    /**
     * Model Setter
     *
     * Sets the Model into the Controller Class.
     */
    public void setModel(Model _model) {
        this.model = _model;
    }

    /**
     * Login Checker
     *
     * Checks to make sure the login is valid.
     */
    public void checkLogin() {
        boolean consumerLogin = view.convertLoginConsumer();
        boolean adminLogin = view.convertLoginAdmin();
        messageBox.setOutput(model.verifyLogin(consumerLogin,adminLogin));
        messageBox.setWindow();
    }

    /**
     * Logout
     *
     * Logs out the user and resets all instance variables
     */
    public void logOut() {
        model.setLogout();
        resetBills();
    }

    /**
     * Deposit in Checking Setter
     *
     * Sets up Transaction Window for Checking (Deposit)
     */
    public void setDepositChecking() {
        currAccount = CHECKING;
        currTransaction = DEPOSIT;
        view.setWindowTransaction(currTransaction,currAccount);
    }

    /**
     * Deposit in Savings Setter
     *
     * Sets up Transaction Window for Savings (Deposit)
     */
    public void setDepositSavings() {
        currAccount = SAVINGS;
        currTransaction = DEPOSIT;
        view.setWindowTransaction(currTransaction,currAccount);
    }

    /**
     * Withdraw in Checking Setter
     *
     * Sets up Transaction Window for Checking (Withdraw)
     */
    public void setWithdrawChecking() {
        currAccount = CHECKING;
        currTransaction = WITHDRAW;
        view.setWindowTransaction(currTransaction,currAccount);
    }

    /**
     * Withdraw in Savings Setter
     *
     * Sets up Transaction Window for Savings (Withdraw)
     */
    public void setWithdrawSavings() {
        currAccount = SAVINGS;
        currTransaction = WITHDRAW;
        view.setWindowTransaction(currTransaction,currAccount);
    }

    /**
     * Transfer in Checking Setter
     *
     * Sets up Transaction Window for Checking (Transfer)
     */
    public void setTransferChecking(String transfereeID) {
        if(model.getMainATM().transfereeConfirm(transfereeID)) {
            currAccount = CHECKING;
            currTransaction = TRANSFER;
            view.setWindowTransaction(currTransaction,currAccount);
        }
        else {
            messageBox.setOutput("ID not valid");
            messageBox.setWindow();
        }
    }

    /**
     * Transfer in Savings Setter
     *
     * Sets up Transaction Window for Savings (Transfer)
     */
    public void setTransferSavings(String transfereeID) {
        if(model.getMainATM().transfereeConfirm(transfereeID)) {
            currAccount = SAVINGS;
            currTransaction = TRANSFER;
            view.setWindowTransaction(currTransaction,currAccount);
        }
        else {
            messageBox.setOutput("ID not valid");
            messageBox.setWindow();
        }
    }

    /**
     * Deposit in ATM Setter
     *
     * Sets up Transaction Window for ATM (Deposit)
     */
    public void setDepositATM() {
        currAccount = ATM;
        currTransaction = DEPOSIT;
        view.setWindowTransaction(currAccount,currTransaction);
    }

    /**
     * Withdraw in ATM Setter
     *
     * Sets up Transaction Window for ATM (Withdraw)
     */
    public void setWithdrawATM() {
        currAccount = ATM;
        currTransaction = WITHDRAW;
        view.setWindowTransaction(currAccount,currTransaction);
    }

    /**
     * Transaction Setter
     *
     * Sets up Transaction
     */
    public void makeTransaction() {
        if(currTransaction.equals(DEPOSIT))
            makeDeposit();
        else if (currTransaction.equals(WITHDRAW))
            makeWithdraw();
        else if (currTransaction.equals(TRANSFER))
            makeTransfer(model.getMainATM().getCurrentTransferee());
    }

    /**
     * Deposit Setter
     *
     * Sets up Deposit (Helper)
     */
    private void makeDeposit() {
        model.setDeposit(currAccount);
        messageBox.setOutput("Deposit Complete\nATM:\n\tHundred: " + model.getMainATM().getBillHundred() +
                "\n\tFifty: " + model.getMainATM().getBillFifty() + "\n\tTwenty: " +
                model.getMainATM().getBillTwenty() + "\n\tFive: " + model.getMainATM().getBillFive());
        messageBox.setWindow();
        if(!currAccount.equals(ATM))
            view.setWindowConsumerAccount();
        else
            view.setWindowAdminAccount();
    }

    /**
     * Withdraw Setter
     *
     * Sets up Withdraw (Helper)
     */
    private void makeWithdraw() {
        model.setWithdraw(currAccount);
        messageBox.setOutput("Withdraw Complete\nATM:\n\tHundred: " + model.getMainATM().getBillHundred() +
                "\n\tFifty: " + model.getMainATM().getBillFifty() + "\n\tTwenty: " +
                model.getMainATM().getBillTwenty() + "\n\tFive: " + model.getMainATM().getBillFive());
        messageBox.setWindow();
        if(!currAccount.equals(ATM))
            view.setWindowConsumerAccount();
        else
            view.setWindowAdminAccount();
    }

    /**
     * Transfer Setter
     *
     * Sets up Transfer (Helper)
     */
    private void makeTransfer(Consumer transferee) {
        model.setTransfer(currAccount,transferee);
        messageBox.setOutput("Transfer Complete\nATM:\n\tHundred: " + model.getMainATM().getBillHundred() +
                "\n\tFifty: " + model.getMainATM().getBillFifty() + "\n\tTwenty: " +
                model.getMainATM().getBillTwenty() + "\n\tFive: " + model.getMainATM().getBillFive());
        messageBox.setWindow();
        view.setWindowConsumerAccount();
    }

    /**
     * Window to Cancel
     *
     * Goes back to the Account Page
     */
    public void setWindowFromCancel() {
        if(currID.equals(model.getMainATM().getMainAdmin().getId()))
            view.setWindowAdminAccount();
        else
            view.setWindowConsumerAccount();
    }

    /**
     * Current Hundred Setter
     *
     * Sets up current Hundred score
     */
    public void setHundredBill() {
        model.setCurrHundred();
        view.setLabelHundred();
    }

    /**
     * Current Fifty Setter
     *
     * Sets up current Fifty score
     */
    public void setFiftyBill() {
        model.setCurrFifty();
        view.setLabelFifty();
    }

    /**
     * Current Twenty Setter
     *
     * Sets up current Twenty score
     */
    public void setTwentyBill() {
        model.setCurrTwenty();
        view.setLabelTwenty();
    }

    /**
     * Current Five Setter
     *
     * Sets up current Five score
     */
    public void setFiveBill() {
        model.setCurrFive();
        view.setLabelFive();
    }

    /**
     * Bill Score Reset
     *
     * Reset all bill scores
     */
    public void resetBills() {
        model.resetCurrBills();
        view.setLabelHundred();
        view.setLabelFifty();
        view.setLabelTwenty();
        view.setLabelFive();
    }

    /**
     * Current ID Setter
     *
     * Sets up Current ID from the current Customer
     */
    public void setCurrID(String currID) {
        this.currID = currID;
    }
}