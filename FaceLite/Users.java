import java.util.HashMap;
// import java.io.File;

public class Users {
    protected static HashMap<String, String[]> userData = new HashMap<String, String[]>();
    // private File usersDataBase;
    // private String currentUser;
    public static HashMap<String, String[]> getUserData() {
        return userData;
    }

    public static String getString() {
        return userData.toString();
    }

    public static String[] getUser(String name) {
        return userData.get(name);
    }
    // ADD THE USER INTO THE LIST OF USERS.
    public static void addUser(String name, String[] data) {
        userData.put(name, data);
    }
    // WANT TO CHECK IF THE USER'S NAME IS EXIST OR NOT.
    public static boolean checkUser(String name) {
        if (userData.containsKey(name)) {
            return false;
        } else {
            return true;
        }
    }

    //  WANT TO UPDATE USER'S IMAGE.
    public static void updatePathImage(String userName, String newPathImage) {
        String[] existingData = userData.get(userName);
        existingData[0] = newPathImage;
    }

    //  WANT TO UPDATE USER'S STATUS.
    public static void updateStatus(String userName, String newStatus) {
        String[] existingData = userData.get(userName);
        existingData[1] = newStatus;
    }


}
