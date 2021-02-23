Description:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

The ATM Simulator is a demonstration of the logic used in an ATM. The simulator contains 5 consumer accounts and an admin account. The consumer accounts can deposit, withdraw, and transfer money amongst other consumer accounts. The admin account has access to the ATM inventory, and can deposit and withdraw bills from the ATM. The ATM contains 100 bills for $100, $50, $20, and $5.

****************************************

Running the Program:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

There are 2 ways you can run this program.

1. Click atmSimulator.jar

2. If the above action does not work, click run_cmd.bat
	This will run the program from the command line.

****************************************

Logging in:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

When the ATM Simulator first boots up, you will be prompted to enter an ID and Passcode. Simply enter the correct ID and Passcode. All login information is provided below.
ID: 3556	Passcode: BP-395 	(James)
ID: 4532 	Passcode: FN-845 	(Mary)
ID: 8935 	Passcode: JD-467 	(John)
ID: 4792 	Passcode: LQ-687 	(Owen)
ID: 1957 	Passcode: GI-348 	(Susan)
ID: 9999	Passcode: AD-999	(Admin)

****************************************

Consumer Page:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

When logged in with a consumer account, you will be presented with a greeting, welcoming you back to the ATM. You will also be given your total Savings and Checking value. Below that, are 6 transaction buttons that include deposit, withdraw, and transfer for the Savings and Checking accounts. Above the transfer buttons, is a text field requesting an ID to a transferee. The final button allows you to log out of the account.

****************************************

Consumer Transactions:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

When you click any of the deposit or withdraw buttons, you will be prompted with a transaction window. In this window, you will have 4 buttons labeled $100, $50, $20, and $5. These buttons control the amount of money you are planning to withdraw or deposit. On the right side of the screen, you will see 4 numbers all labeled “0”. These numbers indicate how many times you have clicked on the dollar buttons, or rather, how many times that value of dollar will be called.

Ex: $155 = ($100 * 1) + ($50 * 1) + ($20 * 0) + ($5 * 1)
Ex: $225 = ($100 * 2) + ($50 * 0) + ($20 * 1) + ($5 * 2)

To submit a transaction, click the submit button. If you are not happy with the current money offering, click the reset button. If you wish to cancel the transaction, click the cancel button.

The same rules apply to the transfer option. However, you will need to enter a valid ID from another registered account. If you attempt to transfer money to the Admin, your own ID, or fail to enter the correct ID of another account, you will be denied the ability to make a transfer until you enter the correct ID.

****************************************

Admin Page:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

The main differences between the Admin and Consumer, is that the Admin not only has direct access to the ATM’s inventory, but also doesn’t have a Savings or Checking account, and can’t transfer money to other Consumer Accounts. The Admin page will show how many bills are currently available in the ATM, based on the bill type. The admin page will also contain buttons that direct the Admin to either deposit or withdraw from the ATM.

****************************************

Admin Transaction:
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

The same rules apply to Admin transactions as do Consumer transactions. The main difference though, is that Admin is depositing and withdrawing from the ATM inventory rather than through a savings or checking account. Admin also can’t transfer money to Consumers, nor can recieve transfers from Consumers.

****************************************