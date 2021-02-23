/**
 * Admin Class
 *
 * The admin of the ATM
 *
 * @author Bradley Lau
 * @version 1.0 September 17 - 2018
 */

/**
 * sample package
 */
package sample;

/**
 * Admin Class
 */
public class Admin {

    /**
     * All personal information of Admin
     */
    String name;
    String id;
    String passcode;

    /**
     * Admin Constructor
     *
     * Constructor class for Admin
     */
    public Admin() {
        this.name = "Admin";
        this.id = "9999";
        this.passcode = "AD-999";
    }

    /**
     * Name Getter
     *
     * Gets the name of Admin
     *
     * @return name of Admin
     */
    public String getName() {
        return name;
    }

    /**
     * ID Getter
     *
     * Gets the ID of Admin
     *
     * @return ID of Admin
     */
    public String getId() {
        return id;
    }

    /**
     * Passcode Getter
     *
     * Gets the Passcode of Admin
     *
     * @return Passcode of Admin
     */
    public String getPasscode() {
        return passcode;
    }
}
