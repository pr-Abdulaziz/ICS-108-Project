import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Users {
    // OUR DATABASE OF USERS
    protected static HashMap<String, Object[]> userData = new HashMap<String, Object[]>(); // OUR DATABASE OF USERS
    static File usersDataBase = new File("FaceLite/assests/usersDataBase.txt"); // OUR DATABASE FILE THAT WE CAN READING FROM AND WRITING INTO.
    public static HashMap<String, Object[]> getUserData() {
        return userData;
    }
    // RETURN USER'S DATA IF NECESSARY.
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
    // ADDING NEW FRIEND INTO SPECIFIC USER.
    public static void addingFriends(String userName, String friendName) {
        Object[] existingData1 = userData.get(userName);
        Object[] existingData2 = userData.get(friendName);
        ((ArrayList<String>) existingData1[2]).add(friendName);
        ((ArrayList<String>) existingData2[2]).add(userName);
    }
    // DELETING A FRIEND FROM SPECIFIC USER.
    public static void deletingFriends(String userName, String friendName) {
        Object[] existingData1 = userData.get(userName);
        Object[] existingData2 = userData.get(friendName);
        ((ArrayList<String>) existingData1[2]).remove(friendName);
        ((ArrayList<String>) existingData2[2]).remove(userName);
    }

    // Using Scanner to read all information about users inside the document
    public static void readFromFile() {
        Scanner input;
        try {
            input = new Scanner(usersDataBase);
            if (!(input.hasNext())) {
                throw new NullPointerException();
            } else {
                while (input.hasNextLine()) {
                    String line = input.nextLine();
                    String[] info = line.split("///");
                    
                    // Check if the array has at least 4 elements
                    if (info.length >= 3) {
                        String name = info[0];
                        String image = info[1];
                        String status = info[2];
                        
                        // Check if the array has at least 4 elements for friends
                        ArrayList<String> friends = new ArrayList<>();
                        if (info.length >= 4) {
                            String[] fString = info[3].split("--->>>");
                            for (int i = 0; i < fString.length; i++) {
                                friends.add(fString[i]);
                            }
                        }
                        // DEFINING A DATA IN OBJECT CLASS, BECAUSE WE HAVE INSIDE AN ARRAY 'STRING' AND ARRAYLIST<STRING>.
                        Object[] data = {image, status, friends};
                        userData.put(name, data);
                    } else {
                        // Handle the case where the line doesn't have enough elements
                        System.err.println("Invalid line: " + line);
                    }
                }

            }
            input.close();
        } catch(FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch(NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
