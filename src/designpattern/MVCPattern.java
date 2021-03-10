package designpattern;

public class MVCPattern {
    public static void main(String[] args) {
        StudentModel model = new StudentModel("Alan", 2);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.setStudentName("Jane");
        controller.updateView();
    }
}

class StudentController {
    StudentModel model;
    StudentView view;

    StudentController(StudentModel model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    void setStudentName(String name) {
        model.setName(name);
    }

    void setStudentRoll(int roll) {
        model.setRoll(roll);
    }

    void updateView() {
        view.printDetails(model.getName(), model.getRoll());
    }
}

class StudentModel {
    private String name;
    private int roll;

    StudentModel(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getRoll() {
        return roll;
    }

    void setRoll(int roll) {
        this.roll = roll;
    }
}

class StudentView {
    void printDetails(String studentName, int studentRoll) {
        System.out.println(studentName + "'s roll is " + studentRoll);
    }
}
