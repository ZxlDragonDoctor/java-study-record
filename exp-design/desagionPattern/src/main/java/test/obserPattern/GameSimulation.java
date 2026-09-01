package test.obserPattern;

import java.util.*;

// 观察者接口
interface IObserver {
    void update(String attackedPlayer);
}

// 被观察者接口
interface ISubject {
    void attach(IObserver observer);
    void detach(IObserver observer);
    void notifyObservers(String attackedPlayer);
}

// 战队类，作为被观察者
class Team implements ISubject {
    private List<IObserver> players = new ArrayList<>();

    @Override
    public void attach(IObserver observer) {
        players.add(observer);
    }

    @Override
    public void detach(IObserver observer) {
        players.remove(observer);
    }

    @Override
    public void notifyObservers(String attackedPlayer) {
        for (IObserver observer : players) {
            observer.update(attackedPlayer);
        }
    }

    public void addPlayer(Player player) {
        attach(player);
        player.setTeam(this);
    }
}

// 玩家类，作为观察者
class Player implements IObserver {
    private String name;
    private Team team;

    public Player(String name) {
        this.name = name;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void attackEnemy() {
        System.out.println(name + " is under attack!");
        if (team != null) {
            team.notifyObservers(name);
        }
    }

    @Override
    public void update(String attackedPlayer) {
        if (!attackedPlayer.equals(this.name)) {
            System.out.println(name + " received alert: " + attackedPlayer + " is under attack! Responding...");
        }
    }
}

// 测试类
public class GameSimulation {
    public static void main(String[] args) {
        Team alpha = new Team();

        Player p1 = new Player("Alice");
        Player p2 = new Player("Bob");
        Player p3 = new Player("Charlie");

        alpha.addPlayer(p1);
        alpha.addPlayer(p2);
        alpha.addPlayer(p3);

        // 模拟某个玩家被攻击
        p2.attackEnemy();
    }
}
