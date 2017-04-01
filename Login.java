/**
 * csc 3380
 * Supratik Mukhopadhyay
 * @author Tyler McDonald
 * @since 3/31/17
 *  login
 */
public class Login {
    public static void main(String[] args) {
        View theView = new View();
        Model theModel = new Model();
        Controller theController = new Controller(theView, theModel);
        theView.setVisible(true);
    }
}
