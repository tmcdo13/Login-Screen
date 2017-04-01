mport java.io.*;
import java.util.*;

/**
 * csc 3380
 * Supratik Mukhopadhyay
 * @author Tyler McDonald
 * @since 3/31/17
 *  Model
 */
public class Model{
    private String loginText;
    File f = new File("logins.txt");
    static ArrayList<ArrayList<String>> users;
    
    public void compare(String userName, String password) throws FileNotFoundException{
        users = putInArrayLists(f);
        boolean isPresent = false;
        for(int a = 0; a<users.get(0).size(); a++){
            if (userName.equals(users.get(0).get(a))&&password.equals(users.get(1).get(a))){
                loginText = ("Welcome " + users.get(2).get(a));
                isPresent = true;
            }
        }
        if(!isPresent)
            loginText = ("Invalid Username or Password");
    }
    
    public String getlogin(){
        return loginText;
    } 

    public static ArrayList<ArrayList<String>> putInArrayLists(File f) throws FileNotFoundException
    {
        Scanner s = new Scanner(f);
        ArrayList<ArrayList<String>> names = new ArrayList<>();
        for(int a = 0; a < 3; a++)
            names.add(new ArrayList<String>());
        while(s.hasNextLine())
        {
            names.get(0).add(s.next());
            names.get(1).add(s.next());
            String name = s.next() + " " + s.next();
            names.get(2).add(name);
        }
        return names;
    }

    public void addToArrayList(String username, String password, String fullName) throws IOException
    {
        Scanner s = new Scanner(f);
        users.get(0).add(username);
        users.get(1).add(password);
        users.get(2).add(fullName);
        FileWriter fw = new FileWriter(f,true);
        BufferedWriter bw = new BufferedWriter(fw);
        fw.write(username+" "+password+" "+fullName);

    }
}
