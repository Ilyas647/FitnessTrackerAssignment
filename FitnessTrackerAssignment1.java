class WorkoutPlan {
    private String name;
    private int durationInMinutes; // Duration of the workout in minutes
    private int caloriesBurned;

    public WorkoutPlan(String name, int durationInMinutes, int caloriesBurned) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.caloriesBurned = caloriesBurned;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    @Override
    public String toString() {
        return "WorkoutPlan{" +
                "name='" + name + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", caloriesBurned=" + caloriesBurned +
                '}';
    }
}

class User {
    private String name;
    private int age;
    private double weight;

    public User(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }
}

class FitnessApp {
    private static final String APP_NAME = "Fitness Tracker";
    public static void main(String[] args) {
        WorkoutPlan workout1 = new WorkoutPlan("Morning Yoga", 30, 150);
        WorkoutPlan workout2 = new WorkoutPlan("Cardio Blast", 45, 300);

        User user1 = new User("Ayanat", 25, 65.0);
        User user2 = new User("Murat", 30, 80.5);

        System.out.println(APP_NAME);
        System.out.println(user1);
        System.out.println(workout1);
        System.out.println(user2);
        System.out.println(workout2);

        System.out.println("Comparing workout plans: " + workout1.equals(workout2));
        System.out.println("Comparing users: " + user1.equals(user2));
    }
}
