import java.util.*;

// Abstract class for different workout types (Data Abstraction)
abstract class ExercisePlan {
    private String name;
    private int duration;

    public ExercisePlan(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() { return name; }
    public int getDuration() { return duration; }

    public abstract int getCaloriesBurned(); // Polymorphism

    @Override
    public String toString() {
        return name + " - " + duration + " mins, " + getCaloriesBurned() + " calories";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ExercisePlan that = (ExercisePlan) obj;
        return duration == that.duration && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, duration);
    }
}

// Subclass for specific workout plans (Inheritance)
class WorkoutPlan extends ExercisePlan {
    private int calories;

    public WorkoutPlan(String name, int duration, int calories) {
        super(name, duration);
        this.calories = calories;
    }

    @Override
    public int getCaloriesBurned() {
        return calories;
    }
}

class User {
    private String name;
    private int age;
    private List<ExercisePlan> plans;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.plans = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public List<ExercisePlan> getPlans() { return plans; }

    public void addWorkout(ExercisePlan plan) {
        plans.add(plan);
    }

    public void showPlans() {
        plans.forEach(System.out::println);
    }

    public void sortPlansByDuration() { // Sort
        plans.sort(Comparator.comparingInt(ExercisePlan::getDuration));
    }

    public ExercisePlan searchPlanByName(String searchName) { // Search
        return plans.stream()
                    .filter(p -> p.getName().equalsIgnoreCase(searchName))
                    .findFirst()
                    .orElse(null);
    }
}

public class Fitness {
    public static void main(String[] args) {
        User user1 = new User("Murat", 30);
        user1.addWorkout(new WorkoutPlan("Strength Training", 60, 400));
        user1.addWorkout(new WorkoutPlan("Cardio Blast", 45, 300));

        User user2 = new User("Ayanat", 25);
        user2.addWorkout(new WorkoutPlan("Morning Yoga", 30, 150));
        user2.addWorkout(new WorkoutPlan("Evening Run", 50, 350));

        System.out.println("User: " + user1.getName() + ", Age: " + user1.getAge());
        System.out.println("Workout Plans:");
        user1.showPlans();

        System.out.println("\nUser: " + user2.getName() + ", Age: " + user2.getAge());
        System.out.println("Workout Plans:");
        user2.showPlans();

        System.out.println("\nSorted Workout Plans by Duration for " + user1.getName() + ":");
        user1.sortPlansByDuration();
        user1.showPlans();

        System.out.println("\nSearching for 'Strength Training' for " + user2.getName() + ":");
        ExercisePlan foundPlan = user2.searchPlanByName("Strength Training");
        System.out.println(foundPlan != null ? foundPlan : "Plan not found");
    }
}
