package designpattern.memento.after;

public class Client {

    public static void main(String[] args) {
        Game game = new Game();
        CareTaker careTaker = new CareTaker();
        game.setBlueTeamScore(10);
        game.setRedTeamScore(20);

        careTaker.add(game.save());

        game.setBlueTeamScore(12);
        game.setRedTeamScore(22);

        game.restore(careTaker.get(0));

        System.out.println(game.getBlueTeamScore());
        System.out.println(game.getRedTeamScore());
    }
}
