import java.util.HashMap;
import java.util.ArrayList;

// import java.io.File;

public class Users {
    protected static HashMap<String, Object[]> userData = new HashMap<String, Object[]>();
    // private File usersDataBase;
    // private String currentUser;
    public static HashMap<String, Object[]> getUserData() {
        return userData;
    }

    public static String getString() {
        return userData.toString();
    }

    public static Object[] getUser(String name) {
        return userData.get(name);
    }
    // ADD THE USER INTO THE LIST OF USERS.
    public static void addUser(String name, Object[] data) {
        userData.put(name, data);
    }
    // WANT TO CHECK IF THE USER'S NAME IS EXIST OR NOT.
    public static boolean checkUser(String name) {
        if (userData.containsKey(name)) {
            return true;
        } else {
            return false;
        }
    }

    //  WANT TO UPDATE USER'S IMAGE.
    public static void updatePathImage(String userName, String newPathImage) {
        Object[] existingData = userData.get(userName);
        existingData[0] = newPathImage;
    }

    //  WANT TO UPDATE USER'S STATUS.
    public static void updateStatus(String userName, String newStatus) {
        Object[] existingData = userData.get(userName);
        existingData[1] = newStatus;
    }
    public static void addingFriends(String userName, String friendName) {
        Object[] existingData1 = userData.get(userName);
        Object[] existingData2 = userData.get(friendName);
        ((ArrayList<String>) existingData1[2]).add(friendName);
        ((ArrayList<String>) existingData2[2]).add(userName);
    }
}
