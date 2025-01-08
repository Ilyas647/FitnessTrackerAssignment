import java.util.*;

class WorkoutPlan {
    String name;
    int duration;
    int calories;

    WorkoutPlan(String name, int duration, int calories) {
        this.name = name;
        this.duration = duration;
        this.calories = calories;
    }

    @Override
    public String toString() {
        return name + " - " + duration + " mins, " + calories + " calories";
    }
}

class User {
    String name;
    int age;
    List<WorkoutPlan> plans = new ArrayList<>();

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void addWorkout(WorkoutPlan plan) {
        plans.add(plan);
    }

    void showPlans() {
        plans.forEach(System.out::println);
    }

    void sortPlansByDuration() {
        plans.sort(Comparator.comparingInt(p -> p.duration));
    }

    WorkoutPlan searchPlanByName(String searchName) {
        return plans.stream().filter(p -> p.name.equalsIgnoreCase(searchName)).findFirst().orElse(null);
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

        System.out.println("User: " + user1.name + ", Age: " + user1.age);
        System.out.println("Workout Plans:");
        user1.showPlans();

        System.out.println("\nUser: " + user2.name + ", Age: " + user2.age);
        System.out.println("Workout Plans:");
        user2.showPlans();

        System.out.println("\nSorted Workout Plans by Duration for " + user1.name + ":");
        user1.sortPlansByDuration();
        user1.showPlans();

        System.out.println("\nSearching for 'Strength Training' for " + user2.name + ":");
        WorkoutPlan foundPlan = user2.searchPlanByName("Strength Training");
        System.out.println(foundPlan != null ? foundPlan : "Plan not found");
    }
}
