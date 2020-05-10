package in.shabhushan.cp_trials.logic;

import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

class Robot {

  private String name;
  private int health;
  private int speed;
  private String[] tactics;

  public Robot(String name, int health, int speed, String[] tactics) {
    this.name = name;
    this.health = health;
    this.speed = speed;
    this.tactics = tactics;
  }

  public String getName() {
    return name;
  }

  public int getHealth() {
    return health;
  }

  public int getSpeed() {
    return speed;
  }

  public String[] getTactics() {
    return tactics;
  }
}

public class EightiesKids6 {

  /**
   * Not so elegant but fast solution
   */
  public static String fight(Robot robot1, Robot robot2, Map<String, Integer> tactics) {
    // Which robot will Rock 'em, Sock 'em?!
    Robot firstAttacker = robot1.getSpeed() >= robot2.getSpeed() ? robot1 : robot2;
    Robot secondAttacker = robot1.getSpeed() < robot2.getSpeed() ? robot1 : robot2;

    Robot[] robots = new Robot[]{firstAttacker, secondAttacker};
    int[] health = new int[]{firstAttacker.getHealth(), secondAttacker.getHealth()};

    int turn = 0;
    int totalTurns = 0;
    while (robots[0].getTactics().length > totalTurns || robots[1].getTactics().length > totalTurns) {

      int damagePoints = 0;
      if (robots[turn].getTactics().length > totalTurns) {
        String tactic = robots[turn].getTactics()[totalTurns];
        damagePoints = tactics.get(tactic);
      }

      turn = ((turn + 1) % 2);
      health[turn] -= damagePoints;

      if (health[turn] <= 0) {
        return robots[((turn + 1) % 2)].getName() + " has won the fight.";
      }

      if (turn % 2 == 0)
        totalTurns++;
    }

    if (robots[0].getTactics().length <= totalTurns && robots[1].getTactics().length <= totalTurns) {
      if (health[0] > health[1])
        return firstAttacker.getName() + " has won the fight.";
      else if (health[0] < health[1])
        return secondAttacker.getName() + " has won the fight.";
      else
        return "The fight was a draw.";
    } else
      return null;
  }

  /**
   * Elegant, OOP but slow solution
   */
  public static String fight2(Robot robot1, Robot robot2, Map<String, Integer> tactics) {
    RobotFighter firstBot = new RobotFighter(robot2.getSpeed() > robot1.getSpeed() ? robot2 : robot1);
    RobotFighter secondBot = new RobotFighter(robot2.getSpeed() > robot1.getSpeed() ? robot1 : robot2);

    while (firstBot.isStanding() && secondBot.isStanding() && (firstBot.canAttack() || secondBot.canAttack())) {
      if (firstBot.canAttack()) {
        firstBot.attack(secondBot, tactics);
      }
      if (secondBot.isStanding() && secondBot.canAttack()) {
        secondBot.attack(firstBot, tactics);
      }
    }

    return firstBot.getHealth() == secondBot.getHealth() ? "The fight was a draw." :
        String.format("%s has won the fight.", firstBot.getHealth() > secondBot.getHealth() ? firstBot.getName() : secondBot.getName());
  }

  private static final class RobotFighter {
    private String name;
    private int health;
    private Queue<String> tactics;

    public RobotFighter(Robot robot) {
      this.name = robot.getName();
      this.health = robot.getHealth();
      this.tactics = new ArrayBlockingQueue(robot.getTactics().length + 1, false, Arrays.asList(robot.getTactics()));
    }

    private String getName() {
      return name;
    }

    private int getHealth() {
      return health;
    }

    private void attack(RobotFighter otherFighter, Map<String, Integer> tactics) {
      final String tactic = this.tactics.poll();
      otherFighter.takeDamage(tactics.get(tactic));
    }

    private boolean canAttack() {
      return !this.tactics.isEmpty();
    }

    private void takeDamage(int damage) {
      health -= damage;
    }

    private boolean isStanding() {
      return health > 0;
    }
  }
}
