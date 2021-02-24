import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class BankAplication {

 

public static void main(String[] args)throws IOException {
List<String> bankAccount=Files.readAllLines(Paths.get("C:\\txt files\\bankaccount.txt"));
List<String> bankTransaction=Files.readAllLines(Paths.get("C:\\txt files\\banktransactions.txt"));
List<String> result=new ArrayList();
result.add("Name,Age,Gender,Bank,CardNumber,TransactionDate,Amount");
bankAccount.remove(0);
bankTransaction.remove(0);
for(String str:bankAccount) {
String[] s=str.split(",");
for(String str2:bankTransaction) {
String[] s1=str2.split(",");
if(Objects.equals(s[4],s1[0])) {
result.add(s[0]+","+s[1]+","+s[2]+","+s[3]+","+s[4]+","+s1[1]+","+s1[2]);
}
}
}
Files.write(Paths.get("C:\\txt files\\banklist.txt"),result);
String string;
Scanner scnr=new Scanner(System.in);
System.out.println("Enter the bank accountholder name: ");
string=scnr.nextLine();
Path path=Paths.get("C:\\txt files\\banklist.txt");
Files.lines(path)
.filter(str->str.contains(string))
.forEach(System.out::println);

 

}

 

}