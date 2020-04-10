package classes_objects;
import java.util.ArrayList;
import java.util.List;

public class GeneratePasswordThread implements Runnable{
	private char[] guessPassword;
	private String password;
    public static boolean found = false;
    List<String> midAns;
	public GeneratePasswordThread(char[] guessPassword,String password,List<String> midAns) {
		this.guessPassword=guessPassword;
		this.password=password;
		this.midAns=midAns;
	}
	public void run() {
		generatePassword(guessPassword,password);
	}
	public void generatePassword(char[] guessPassword,String password){
        generatePassword(guessPassword,0,password);
    }
     
    public void generatePassword(char[] guessPassword,int index,String password){
        if(found)
            return;
        for (short i = '0'; i <= 'z'; i++) {
            char c = (char)i;
            if(!Character.isLetterOrDigit(c))
                continue;
            guessPassword[index] = c;
            if(index!=guessPassword.length-1){
                generatePassword(guessPassword,index+1,password);
            }
            else{
                String guess = new String(guessPassword);
//              System.out.println("穷举出来的密码是：" + guess);
               	midAns.add(guess);
               	try{
               		Thread.sleep(100);
               	}
               	catch(Exception e) {
               		e.printStackTrace();
               	}
                if(guess.equals(password)){
                    System.out.println("找到了，密码是" + guess);
                    found =true;
                    return;
                }
            }
        }
    }
}
