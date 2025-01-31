import java.sql.*;
import java.util.Scanner;

public class Assignment3 {
    private static final String URL = "jdbc:postgresql://localhost:5433/Assignment3_FitnessTracker";
    private static final String USER = "postgres";
    private static final String PASSWORD = "245862";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Database connected successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed: " + e.getMessage());
        }
        return connection;
    }

    // Insert into Users table
    public static void insertUser(int id, String name, String email, int age, double weight, double height) {
        String sql = "INSERT INTO Users (id, name, email, age, weight, height) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, email);
            pstmt.setInt(4, age);
            pstmt.setDouble(5, weight);
            pstmt.setDouble(6, height);
            pstmt.executeUpdate();
            System.out.println("✅ User inserted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error inserting user: " + e.getMessage());
        }
    }

    // Insert into WorkoutPlan table
    public static void insertWorkoutPlan(int id, int userId, String workoutName, int duration, String intensity) {
        String sql = "INSERT INTO WorkoutPlan (id, user_id, workout_name, duration, intensity_level) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, userId);
            pstmt.setString(3, workoutName);
            pstmt.setInt(4, duration);
            pstmt.setString(5, intensity);
            pstmt.executeUpdate();
            System.out.println("✅ Workout Plan inserted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error inserting workout plan: " + e.getMessage());
        }
    }

    // Insert into FitnessApp table
    public static void insertFitnessApp(int id, int userId, String goal, String subscriptionType) {
        String sql = "INSERT INTO FitnessApp (id, user_id, goal, subscription_type) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, userId);
            pstmt.setString(3, goal);
            pstmt.setString(4, subscriptionType);
            pstmt.executeUpdate();
            System.out.println("✅ Fitness App data inserted successfully!");
        } catch (SQLException e) {
            System.out.println("❌ Error inserting into FitnessApp: " + e.getMessage());
        }
    }

    // Read Users
    public static void readUsers() {
        String sql = "SELECT * FROM Users";
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n📋 Users List:");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " +
                        rs.getString("email") + " | Age: " + rs.getInt("age") +
                        " | Weight: " + rs.getDouble("weight") + " | Height: " + rs.getDouble("height"));
            }
        } catch (SQLException e) {
            System.out.println("❌ Error retrieving users: " + e.getMessage());
        }
    }

    // Update User
    public static void updateUser(int id, String name, double weight, double height) {
        String sql = "UPDATE Users SET name = ?, weight = ?, height = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, weight);
            pstmt.setDouble(3, height);
            pstmt.setInt(4, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ User updated successfully!");
            } else {
                System.out.println("❌ User not found.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error updating user: " + e.getMessage());
        }
    }

    // Delete User
    public static void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("✅ User deleted successfully!");
            } else {
                System.out.println("❌ User not found.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Error deleting user: " + e.getMessage());
        }
    }

    // Main method for testing CRUD operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🏋️ Fitness Tracker Management System 🏋️");

        // Insert Sample Data
        insertUser(1, "Alice Smith", "alice@example.com", 25, 65.2, 1.70);
        insertWorkoutPlan(1, 1, "Morning Yoga", 30, "Medium");
        insertFitnessApp(1, 1, "Lose Weight", "Premium");

        // Read Users
        readUsers();

        // Update User
        System.out.print("\nEnter User ID to Update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter New Weight: ");
        double newWeight = scanner.nextDouble();
        System.out.print("Enter New Height: ");
        double newHeight = scanner.nextDouble();
        updateUser(updateId, newName, newWeight, newHeight);

        // Delete User
        System.out.print("\nEnter User ID to Delete: ");
        int deleteId = scanner.nextInt();
        deleteUser(deleteId);

        scanner.close();
    }
}
