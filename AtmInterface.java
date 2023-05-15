
import java.util.*;

class BankApp
{
	String acno;
	String name;
	String acType;
	Double balance;
	Scanner in = new Scanner(System.in);

	public void OpenAccount()
	{
		System.out.println("Enter the account Number: ");
		acno = in.next();
		System.out.println("Enter the Holder Name: ");
		name = in.next();
		System.out.println("Enter the Account Type: ");
		acType = in.next();
		System.out.println("Enter the Balance: ");
		balance = in.nextDouble();
		System.out.println("Congrats Your Account is Created and your account number is "+acno);
	}
	public void deposite()
	{
		System.out.println("Enter the amount Do you want to deposite: ");
		double amt = in.nextDouble();
		balance = balance + amt;
		System.out.println("Your "+amt+" deposited");
	}
	public void withdraw()
	{
		System.out.println("Enter the amount..");
		double amt = in.nextDouble();
		if(balance>=amt)
		{
			balance = balance - amt;
		    System.out.println("Your "+amt+" Withdraw");
		}else{
			System.out.println("Your balance is less than "+amt+" Transition faild");
		}
	}
	public void transfer()
	{
		System.out.println("Enter the amount Do You Want to Transfer..");
		double amt = in.nextDouble();
		if(balance>=amt)
		{
			if(amt<=50000)
			{
				balance = balance + amt;
				System.out.println("Your "+amt+" is Successfully Transfer");
			}
			else{
				System.out.println("Sorry...Limit is 50000.0");
			}
		}else{
			System.out.println("Insufficient Balance...");
		}
	}

	public void showAccount()
	{
		System.out.println("----------------------------------------------------------");
		System.out.println("Name of Account Holder: "+name);
		System.out.println("Account Number: "+acno);
		System.out.println("Account Type: "+acType);
		System.out.println("Balance: "+balance);
		System.out.println("----------------------------------------------------------");
	}
	public boolean search(String ac_no)
	{
		if(acno.equals(ac_no))
		{
			showAccount();
			return(true);
		}
		return(false);
	}
}
class AtmInterface
{

	public static void main(String[]args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("How Many Number Of Castomer Do you want to Input");
		int n = in.nextInt();
		BankApp C[] = new BankApp[n];
		for(int i=0;i<C.length;i++)
		{
			C[i] = new BankApp();
			C[i].OpenAccount();
		}
		int choice;
		do
		{
			System.out.println("\n");
			System.out.println("========================");
			System.out.println("Welcome to Atm Interface");
			System.out.println("==========================");
			System.out.println("1.Open Account");
			System.out.println("2.Deposite");
			System.out.println("3.Withdraw");
			System.out.println("4.Transfer");
			System.out.println("5.Display");
			System.out.println("0.Exit");
			System.out.println("Enter your choice here: ");
			choice = in.nextInt();
			if(choice==0)
			{
				break;
			}
			if(choice==1)
			{
				for(int i=0;i<C.length;i++)
				{
					C[i].OpenAccount();
				}
				break;
			}
			else if(choice==2)
			{
				System.out.println("Enter account no: ");
				String ac_no = in.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
					found = C[i].search(ac_no);
					if(found)
					{
						C[i].deposite();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==3)
			{
				System.out.println("Enter account no: ");
				String ac_no = in.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
					found = C[i].search(ac_no);
					if(found)
					{
						C[i].withdraw();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==4)
			{
				System.out.println("Enter account no: ");
				String ac_no = in.next();
				boolean found = false;
				for(int i=0;i<C.length;i++)
				{
				found = C[i].search(ac_no);
					if(found)
					{
						C[i].transfer();
					}
				}
				if(!found)
				{
					System.out.println("Account dosent Exit....");
				}
			}
			else if(choice==5)
			{
				for(int i=0;i<C.length;i++)
				{
					C[i].showAccount();
				}
			}
		}
		while(choice!=0);
	}
}