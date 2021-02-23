/**
 * ATM Class
 *
 * Stores all banking information.
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * sample package
 */
package sample;

/**
 * ATM Class
 */
public class ATM {

    /**
     * Bills stored in the ATM
     */
    private int billHundred;
    private int billFifty;
    private int billTwenty;
    private int billFive;

    /**
     * Value of each Bill
     */
    private final int VALUE_HUNDRED = 100;
    private final int VALUE_FIFTY = 50;
    private final int VALUE_TWENTY = 20;
    private final int VALUE_FIVE = 5;

    /**
     * Account Database
     */
    private Consumer allConsumers[] = new Consumer[5];
    private Admin mainAdmin;

    /**
     * Current Consumer and Transferee when logged in or making
     * a transfer
     */
    private Consumer currentConsumer;
    private Consumer currentTransferee;

    /**
     * Controller
     */
    private Controller controller;

    /**
     * ATM Constructor
     *
     * Constructor for the ATM Class
     *
     * @param con   Controller class
     */
    public ATM(Controller con) {
        this.controller = con;

        this.billHundred = 100;
        this.billFifty = 100;
        this.billTwenty = 100;
        this.billFive = 100;

        this.allConsumers[0] = new Consumer("James","3556","BP-395",25.00,30.00);
        this.allConsumers[1] = new Consumer("Mary","4532","FN-845",55.00,68.00);
        this.allConsumers[2] = new Consumer("John","8935","JD-467",675.00,356.00);
        this.allConsumers[3] = new Consumer("Owen","4792","LQ-687",731.45,467.67);
        this.allConsumers[4] = new Consumer("Susan","1957","GI-348",73.40,45.10);
        this.mainAdmin = new Admin();
    }

    /**
     * Login Verification Consumer
     *
     * Verifies the login information provided by View.
     * (For Consumer)
     *
     * @param inputID           provided ID
     * @param inputPasscode     provided Passcode
     *
     * @return login verification
     */
    public boolean loginVerifyConsumer(String inputID, String inputPasscode) {
        boolean output = false;
        for(int i = 0; i < allConsumers.length; i++) {
            if(inputID.equals(allConsumers[i].getId()) && inputPasscode.equals(allConsumers[i].getPasscode())) {
                output = true;
                currentConsumer = allConsumers[i]; // Set Current Consumer
                controller.setCurrID(currentConsumer.getId()); // Put Current Consumer ID into Controller
            }
        }
        return output;
    }

    /**
     * Login Verification Admin
     *
     * Verifies the login information provided by View.
     * (For Admin)
     *
     * @param inputID           provided ID
     * @param inputPasscode     provided Passcode
     *
     * @return login verification
     */
    public boolean loginVerifyAdmin(String inputID, String inputPasscode) {
        boolean output = false;
        if (inputID.equals(mainAdmin.getId()) && inputPasscode.equals(mainAdmin.getPasscode())) {
            output = true;
            controller.setCurrID(mainAdmin.getId()); // Put Admin ID into Controller
        }
        return output;
    }

    /**
     * Confirm Transferee
     *
     * Verifies the transferee account
     *
     * @param inputID           provided ID of transferee
     *
     * @return transferee verification
     */
    public boolean transfereeConfirm(String inputID) {
        boolean output = false;
        for(int i = 0; i < allConsumers.length; i++) {
            if(inputID.equals(allConsumers[i].getId()) && !inputID.equals(currentConsumer.getId())) {
                output = true;
                currentTransferee = allConsumers[i]; // Set Current Transferee
            }
        }
        return output;
    }

    /**
     * Admin Getter
     *
     * Get the Admin
     *
     * @return the admin of ATM
     */
    public Admin getMainAdmin() {
        return mainAdmin;
    }

    /**
     * Current Consumer Getter
     *
     * Get the current Consumer that is
     * logged in
     *
     * @return the current consumer logged in
     */
    public Consumer getCurrentConsumer() {
        return currentConsumer;
    }

    /**
     * Current Transferee Getter
     *
     * Get the current Transferee that is
     * receiving the transfer
     *
     * @return current transferee
     */
    public Consumer getCurrentTransferee() {
        return currentTransferee;
    }

    /**
     * Bill Depositor
     *
     * Deposits all bills from the deposit transaction into the ATM
     *
     * @param hundred       bills: Hundred
     * @param fifty         bills: Fifty
     * @param twenty        bills: Twenty
     * @param five          bills: Five
     */
    public void setBillsDeposit(int hundred, int fifty, int twenty, int five) {
        billHundred += hundred;
        billFifty += fifty;
        billTwenty += twenty;
        billFive += five;
    }

    /**
     * Bill Withdraw Action
     *
     * Withdraws all bills from the withdraw transaction out of the ATM
     *
     * @param hundred       bills: Hundred
     * @param fifty         bills: Fifty
     * @param twenty        bills: Twenty
     * @param five          bills: Five
     */
    public void setBillsWithdraw(int hundred, int fifty, int twenty, int five) {
        billHundred -= hundred;
        billFifty -= fifty;
        billTwenty -= twenty;
        billFive -= five;
    }

    /**
     * Value Hundred Count
     *
     * Counts all inputs of Hundred and multiplies them by the bill value
     *
     * @param count       num bills selected
     *
     * @return Value of Hundred * count
     */
    public int getVALUE_HUNDRED(int count) {
        return VALUE_HUNDRED * count;
    }

    /**
     * Value Fifty Count
     *
     * Counts all inputs of Fifty and multiplies them by the bill value
     *
     * @param count       num bills selected
     *
     * @return Value of Fifty * count
     */
    public int getVALUE_FIFTY(int count) {
        return VALUE_FIFTY * count;
    }

    /**
     * Value Twenty Count
     *
     * Counts all inputs of Twenty and multiplies them by the bill value
     *
     * @param count       num bills selected
     *
     * @return Value of Twenty * count
     */
    public int getVALUE_TWENTY(int count) {
        return VALUE_TWENTY * count;
    }

    /**
     * Value Five Count
     *
     * Counts all inputs of Five and multiplies them by the bill value
     *
     * @param count       num bills selected
     *
     * @return Value of Five * count
     */
    public int getVALUE_FIVE(int count) {
        return VALUE_FIVE * count;
    }

    /**
     * Hundred Getter
     *
     * Get all Hundred Bills from ATM
     *
     * @return all hundreds
     */
    public int getBillHundred() {
        return billHundred;
    }

    /**
     * Fifty Getter
     *
     * Get all Fifty Bills from ATM
     *
     * @return all fifties
     */
    public int getBillFifty() {
        return billFifty;
    }

    /**
     * Twenty Getter
     *
     * Get all Twenty Bills from ATM
     *
     * @return all twenties
     */
    public int getBillTwenty() {
        return billTwenty;
    }

    /**
     * Five Getter
     *
     * Get all Five Bills from ATM
     *
     * @return all fives
     */
    public int getBillFive() {
        return billFive;
    }
}
