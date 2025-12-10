public class Student {
    private int roll_no;
    private String name;
    private int age;
    private char grade;

    public Student(int s_rollNo,String s_name,int s_age,char s_grade){
        this.roll_no = s_rollNo;
        this.name = s_name;
        this.age = s_age;
        this.grade = s_grade;
    }

    @Override
    public String toString(){
        return "Roll No : "+ roll_no +" | Name : " + name + " | Age : " + age + " | Grade : " + grade;
    }

    public int getRollNo(){
        return roll_no;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public int getGrade(){
        return grade;
    }

    public void setName(String s_name){
        this.name = s_name;
    }
    public void setAge(int s_age){
        this.age = s_age;
    }
    public void setGrade(char s_grade){
        this.grade = s_grade;
    }

}
