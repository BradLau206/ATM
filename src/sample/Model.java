/**
 * Model Class
 *
 * Used to run logic within the program.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * sample package
 */
package sample;

/**
 * Model Class
 */
public class Model {

    /**
     * Controller, Model, and ATM
     */
    private Controller controller;
    private View view;
    private ATM mainATM;

    /**
     * All counters for Transaction
     */
    private int currHundred = 0;
    private int currFifty = 0;
    private int currTwenty = 0;
    private int currFive = 0;

    /**
     * Account Type ATM
     */
    private final String ATM = "ATM";

    /**
     * Model Constructor
     *
     * Constructor for the Model Class.
     *
     * @param con       Controller Class
     */
    public Model(Controller con) {
        this.controller = con;
        // View is also set
        this.mainATM = new ATM(this.controller);
    }

    /**
     * ATM Getter
     *
     * Getter for the ATM
     *
     * @return the ATM
     */
    public ATM getMainATM() {
        return this.mainATM;
    }

    /**
     * Login Verifier
     *
     * Verifies the login of a user and put the information in the needed account window.
     *
     * @param consumerLogin     boolean for consumer
     * @param adminLogin        boolean for admin
     *
     * @Return The message required for the login state.
     */
    public String verifyLogin(boolean consumerLogin, boolean adminLogin) {
        String output;
        String name;
        if(consumerLogin) {
            name = mainATM.getCurrentConsumer().getName();
            output = (name + " is logged in.");
            setLoginScreenConsumer(name);
        }
        else if (adminLogin) {
            name = mainATM.getMainAdmin().getName();
            output = (name + " is logged in.");
            setLoginScreenAdmin(name);
        }
        else
            output = ("Invalid Login");
        return output;
    }

    /**
     * Logout Setter
     *
     * Brings the user back to the Login screen
     */
    public void setLogout() {
        view.setWindowLogin();
    }

    /**
     * Consumer Account Setter
     *
     * Sets the window for the consumer
     *
     * @param input     The name of the user
     */
    private void setLoginScreenConsumer(String input) {
        String name = input;
        view.setWindowConsumerAccount();
        view.setLabelConsumerName("Welcome back " + name);
    }

    /**
     * Admin Account Setter
     *
     * Sets the window for the admin
     *
     * @param input     The name of the user
     */
    private void setLoginScreenAdmin(String input) {
        String name = input;
        view.setLabelAdminName(name);
        view.setWindowAdminAccount();
    }

    /**
     * Deposit Setter
     *
     * Sets the deposit transaction
     *
     * @param account     Type of account to deposit in
     */
    public void setDeposit(String account) {
        mainATM.setBillsDeposit(currHundred,currFifty,currTwenty,currFive);
        if(!account.equals(ATM)) {
            int total = calculateBillValues();
            mainATM.getCurrentConsumer().deposit(total, account);
        }
    }

    /**
     * Withdraw Setter
     *
     * Sets the withdraw transaction
     *
     * @param account     Type of account to withdraw out of
     */
    public void setWithdraw(String account) {
        if(!account.equals(ATM)) {
            int total = calculateBillValues();
            mainATM.getCurrentConsumer().withdraw(total, account); // Withdraw from consumer account
            if (mainATM.getCurrentConsumer().isWithdraw())
                setBillsWithdraw();
        }
        else {
            setBillsWithdraw(); // Withdraw from ATM exclusively
        }
    }

    /**
     * Bill Withdraw
     *
     * Helper method used to withdraw bills from ATM
     */
    private void setBillsWithdraw() {
        if (mainATM.getBillHundred() - currHundred >= 0 && mainATM.getBillFifty() - currFifty >= 0
                && mainATM.getBillTwenty() - currTwenty >= 0 && mainATM.getBillFifty() - currFive >= 0) {

            mainATM.setBillsWithdraw(currHundred, currFifty, currTwenty, currFive);
        }
    }

    /**
     * Total Transaction Counter
     *
     * Calculator for all bills entered in a transaction.
     *
     * @return calculation of all inputs
     */
    private int calculateBillValues() {
        int hundred = mainATM.getVALUE_HUNDRED(currHundred);
        int fifty = mainATM.getVALUE_FIFTY(currFifty);
        int twenty = mainATM.getVALUE_TWENTY(currTwenty);
        int five = mainATM.getVALUE_FIVE(currHundred);
        int total = hundred + fifty + twenty + five;
        return total;
    }

    /**
     * Transfer Setter
     *
     * Sets up a transfer transaction between two accounts.
     *
     * @param account       type of account to transfer between
     * @param transferee    the consumer to transfer money to
     */
    public void setTransfer(String account, Consumer transferee) {
        int hundred = mainATM.getVALUE_HUNDRED(currHundred);
        int fifty = mainATM.getVALUE_FIFTY(currFifty);
        int twenty = mainATM.getVALUE_TWENTY(currTwenty);
        int five = mainATM.getVALUE_FIVE(currFive);
        int total = hundred + fifty + twenty + five;
        mainATM.getCurrentConsumer().transfer(total,account,transferee);
    }

    /**
     * View Setter
     *
     * Sets the view class into the model class.
     *
     * @param view       main view
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * Current Hundred Setter
     *
     * Adds a point to Hundred for every time it is
     * clicked in the Transaction Window
     */
    public void setCurrHundred() {
        this.currHundred += 1;
    }

    /**
     * Current Fifty Setter
     *
     * Adds a point to Fifty for every time it is
     * clicked in the Transaction Window
     */
    public void setCurrFifty() {
        this.currFifty += 1;
    }

    /**
     * Current Twenty Setter
     *
     * Adds a point to Twenty for every time it is
     * clicked in the Transaction Window
     */
    public void setCurrTwenty() {
        this.currTwenty += 1;
    }

    /**
     * Current Five Setter
     *
     * Adds a point to Five for every time it is
     * clicked in the Transaction Window
     */
    public void setCurrFive() {
        this.currFive += 1;
    }

    /**
     * Current Hundred Getter
     *
     * Gets the current number of Hundred
     *
     * @return all inputs of Hundred
     */
    public int getCurrHundred() {
        return currHundred;
    }

    /**
     * Current Fifty Getter
     *
     * Gets the current number of Fifty
     *
     * @return all inputs of Fifty
     */
    public int getCurrFifty() {
        return currFifty;
    }

    /**
     * Current Twenty Getter
     *
     * Gets the current number of Twenty
     *
     * @return all inputs of Twenty
     */
    public int getCurrTwenty() {
        return currTwenty;
    }

    /**
     * Current Five Getter
     *
     * Gets the current number of Five
     *
     * @return all inputs of Five
     */
    public int getCurrFive() {
        return currFive;
    }

    /**
     * Current Bill Reset
     *
     * Resets all current bill scores
     */
    public void resetCurrBills() {
        this.currHundred = 0;
        this.currFifty = 0;
        this.currTwenty = 0;
        this.currFive = 0;
    }
}