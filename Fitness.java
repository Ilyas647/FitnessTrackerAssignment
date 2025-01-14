import java.util.*;

class WorkoutPlan {
    private String name;
    private int duration;
    private int calories;

    public WorkoutPlan(String name, int duration, int calories) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " - " + duration + " mins, " + calories + " calories";
    }
}

class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User: " + name + ", Age: " + age;
    }
}

public class FitnessApp {
    public static void main(String[] args) {
        WorkoutPlan plan1 = new WorkoutPlan("Strength Training", 60, 400);
        WorkoutPlan plan2 = new WorkoutPlan("Cardio Blast", 45, 300);

        User user1 = new User("Murat", 30);
        User user2 = new User("Ayanat", 25);

        System.out.println(user1);
        System.out.println(plan1);
        System.out.println(user2);
        System.out.println(plan2);

        System.out.println("\nComparing workout plans:");
        System.out.println("Are plan1 and plan2 equal? " + plan1.getName().equals(plan2.getName()));
    }
}
