package grymV2.game.server;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Integer> student_numbers;
    private ArrayList<Integer> staff_numbers;
    private ArrayList<Float> international_ratio;

    // rough estimate places income at 48,624,200 a year, cost of building will
    // have to be adjusted along with timescale depending on the simulated time
    // of the game, 200,000,000 should be good starting money? can be adjusted
    // TODO: intial balance settings loading
    private Integer balance = 200000000;

    public float target_international_student_ratio = 0.1333f;


    private Integer get_student_number() {
        return 4000;  // need to check every square on the grid and count
    }

    private Integer get_staff_number() {
        return 50;  // see above
    }

    public void tick(float time) {
        // assuming float time here is meant to represent years?
        // ie 0.5 = 6 months of gameplay


        // update student numbers list average
        student_numbers.add(this.get_student_number());

        if (student_numbers.size() > 256) {
            student_numbers.remove(0);
        }

        // update staff numbers list average
        staff_numbers.add(this.get_staff_number());

        if (staff_numbers.size() > 256) {
            staff_numbers.remove(0);
        }

        // update international ratio number list average
        international_ratio.add(this.target_international_student_ratio);

        if (international_ratio.size() > 256) {
            international_ratio.remove(0);
        }

        // update balance from income
        this.balance += (int)(this.get_current_income() * time);


    }

    private int average_i(ArrayList<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        int sum = 0;

        for (int number : list) {
            sum += number;
        }

        return (int) (sum / list.size());
    }

    private int average_f(ArrayList<Float> list) {
        if (list.isEmpty()) {
            return 0;
        }

        float sum = 0f;

        for (float number : list) {
            sum += number;
        }

        return (int) (sum / list.size());
    }

    // necessary api's for the renderer
    synchronized public float get_student_satisfaction() {
        // this is the main complexity with generating the simulation,
        // what makes students happy? starting simple with ratio between
        // staff and students but long term should take into effect the
        // distance between buildings among over things

        // \frac{2}{\left(px-p\ 3000\right)^{4}+2}
        // where x is students t is teachers and p=0.002 is the lecturer ratio drop off
        // 1, (1 / x) is the affect this has on the satisfaction
        float student_staff_ratio = (float) (this.get_number_staff() / (Math.pow ((0.002 * this.get_number_students()) - (0.002 * 3000), 4) + 1));
        // Students prefer lectures with between

        return student_staff_ratio;
    }

    synchronized public int get_student_satisfaction_trend() { return 0; }

    synchronized public int get_number_students() {
        return average_i(student_numbers);
    }

    synchronized public int get_number_students_trend() {
        return 0;
    }

    synchronized public int get_current_income() {
        int students = this.get_student_number();
        float ratio = this.get_international_ratio();

        // 31100 figure taken from https://www.york.ac.uk/study/undergraduate/courses/bsc-computer-science/
        return (int) ((9250 * (students * ratio)) + (31100 * (students * (1 - ratio))));
    }

    synchronized public int get_current_income_trend() { return 0; }

    synchronized public int get_current_balance () {
        return this.balance;
    }


    // internal things for the maths
    private int get_number_staff() {
        return average_i(staff_numbers);
    }

    private float get_international_ratio() {
        return average_f(this.international_ratio);
    }


    public Simulation() {
        this.student_numbers = new ArrayList<>();
        this.staff_numbers = new ArrayList<>();
        this.international_ratio = new ArrayList<>();

        // initialise lists with default values to prevent early game stat spikes
        for (int i = 0; i < 100; i++) {
            student_numbers.add(0);
            staff_numbers.add(0);

            // 0.133 figure taken from https://www.thecompleteuniversityguide.co.uk/student-advice/where-to-study/international-students-at-uk-universities
            international_ratio.add(0.133f);
        }
    }

}
