package projectsoftt.roles;
import javax.swing.*;
public class UserFactory {
    private static Teacher teacherInstance;
    private static Student studentInstance;
    private static Manager managerInstance;
    public static User createUser(String userType) {
        switch (userType.toLowerCase()) {
            case "teacher":
                if (teacherInstance == null) {
                    teacherInstance = new Teacher();
                }
                return teacherInstance;
            case "student":
                if (studentInstance == null) {
                    studentInstance = new Student();
                }
                return studentInstance;
            case "manager":
                
                if (managerInstance == null) {
                    managerInstance = new Manager();
                }
                return managerInstance;
            default:
                JOptionPane.showMessageDialog(null, "Invalid user type: " + userType,
                        "Error", JOptionPane.ERROR_MESSAGE);
                return null;
        }
    }

}
