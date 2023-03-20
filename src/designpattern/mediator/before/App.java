package designpattern.mediator.before;

public class App {

    public static void main(String[] args) {
        Colleague1 colleague1 = new Colleague1("c1");
        Colleague2 colleague2 = new Colleague2("c2");
        Colleague3 colleague3 = new Colleague3("c3");

        colleague1.setColleague2(colleague2);
        colleague1.setColleague3(colleague3);
        colleague2.setColleague1(colleague1);
        colleague2.setColleague3(colleague3);
        colleague3.setColleague1(colleague1);
        colleague3.setColleague2(colleague2);

        colleague1.setMessage("Hi My Name is c1");
        colleague1.send();
    }
}
