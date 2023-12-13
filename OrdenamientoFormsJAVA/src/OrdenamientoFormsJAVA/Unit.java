package OrdenamientoFormsJAVA;

public class Unit implements Comparable<Unit> {
	// Unit.java
	    private String name;
	    private int level;
	    private int attackPower;
	    private int speed;

	    public Unit(String name, int level, int attackPower, int speed) {
	        this.name = name;
	        this.level = level;
	        this.attackPower = attackPower;
	        this.speed = speed;
	    }

	    public String getName() {
	        return name;
	    }

	    public int getLevel() {
	        return level;
	    }

	    public int getAttackPower() {
	        return attackPower;
	    }

	    public int getSpeed() {
	        return speed;
	    }

	    @Override
	    public int compareTo(Unit other) {
	        // Implement the comparison logic here
	        // For example, compare by level and then by speed if levels are equal
	        int levelComparison = Integer.compare(this.level, other.level);
	        if (levelComparison != 0) {
	            return levelComparison;
	        }

	        return Integer.compare(this.speed, other.speed);
	    }

	    @Override
	    public String toString() {
	        return String.format("%s (Level: %d, Attack: %d, Speed: %d)", name, level, attackPower, speed);
	    }
	}


