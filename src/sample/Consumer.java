/**
 * Consumer Class
 *
 * The consumer and all his/her banking information.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * sample package
 */
package sample;

/**
 * Consumer Class
 */
public class Consumer {

    /**
     * All variables of personal information
     */
    private String name;
    private String id;
    private String passcode;
    private double balChecking;
    private double balSavings;

    /**
     * Checks if withdraw is used
     */
    private boolean isWithdraw = false;

    /**
     * Message box used after all transactions
     */
    private MessageBox messageBox = new MessageBox();

    /**
     * Consumer Constructor
     *
     * Constructor class used for Consumer
     *
     * @param name              Name of Consumer
     * @param id                Consumer ID
     * @param passcode          Consumer Password
     * @param balChecking       Consumer's total Checking value
     * @param balSavings        Consumer's total Savings value
     */
    public Consumer(String name, String id, String passcode, double balChecking, double balSavings) {
        this.name = name;
        this.id = id;
        this.passcode = passcode;
        this.balChecking = balChecking;
        this.balSavings = balSavings;
    }

    /**
     * Withdraw Transaction
     *
     * Consumer withdraws money from one of his/her accounts
     *
     * @param input             Amount of money being withdrawn
     * @param account           Account to withdraw from
     */
    public void withdraw(double input, String account) {
        if (account.equals("Checking")) {
            if(balChecking - input >= 0) { // Check if withdraw is greater than 0
                balChecking -= input;
                isWithdraw = true;
            }
            else {
                isWithdraw = false;
                setMessageBox(account); // Set error message
            }
        }
        else if (account.equals("Savings"))
            if(balSavings - input >= 0) { // Check if withdraw is greater than 0
                balSavings -= input;
                isWithdraw = true;
            }
            else {
                isWithdraw = false;
                setMessageBox(account); // Set error message
            }
        else
            System.out.println("ERROR: Selected balance account invalid. (WITHDRAW)");
    }

    /**
     * Deposit Transaction
     *
     * Consumer deposits money into one of his/her accounts
     *
             * @param input             Amount of money being deposited
     * @param account           Account to deposit into
     */
    public void deposit(double input, String account) {
        if (account.equals("Checking"))
            balChecking += input;
        else if (account.equals("Savings"))
            balSavings += input;
        else
            System.out.println("ERROR: Selected balance account invalid. (DEPOSIT)");
    }

    /**
     * Transfer Transaction
     *
     * Consumer transfers money from one of his/her accounts
     * into another user's account
     *
     * @param input             Amount of money being withdrawn
     * @param account           Account to withdraw from
     * @param transferee        The Consumer receiving the transfer
     */
    public void transfer(double input,String account, Consumer transferee) {
        transferee.deposit(input,account);
        this.withdraw(input,account);
    }

    /**
     * Name Getter
     *
     * Get the name of Consumer
     *
     * @return name of Consumer
     */
    public String getName() {
        return name;
    }

    /**
     * ID Getter
     *
     * Get the ID of Consumer
     *
     * @return ID of Consumer
     */
    public String getId() {
        return id;
    }

    /**
     * Passcode Getter
     *
     * Get the passcode of Consumer
     *
     * @return passcode of Consumer
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * Checking Value Getter
     *
     * Get the Checking Value of Consumer
     *
     * @return checking value of Consumer
     */
    public double getBalChecking() {
        return balChecking;
    }

    /**
     * Savings Value Getter
     *
     * Get the Savings Value of Consumer
     *
     * @return savings value of Consumer
     */
    public double getBalSavings() {
        return balSavings;
    }

    /**
     * Withdraw Boolean Getter
     *
     * Get the withdraw boolean
     *
     * @return if withdraw happened
     */
    public boolean isWithdraw() {
        return isWithdraw;
    }

    /**
     * Message Box Setter
     *
     * Set the message alert after a transaction
     *
     * @param account       The account that is involved in transaction
     */
    private void setMessageBox(String account) {
        messageBox.setOutput("You don't have enough money in " + account + " to withdraw that amount");
        messageBox.setWindow();
    }
}