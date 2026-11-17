
/**
 * Abstract class Creature - 
 * The creature is the main class from which all other battling creatures derive.
 * It is the creature's job to maintain current health values in response to 
 * requests to takeDamage. It also must report if
 * the creature is alive or knocked out. The creature is also responsible for calculating
 * damage delivered based on the creature's strength (1 to str) 
 * 
 * @author Crosbie
 * @version 2025-04 v1.0
 */
// we will learn what the abstract keyword does in a later chapter
public abstract class Creature
{
    private int str;        // The strength of this creature
    private int max_hp;     // The maximum hit points the creature can have (used if healing enabled)
    private int hp;         // the current numberof hit points the creature has
    
  
    
    /**
     * Create a creature with a given strength and hit point level. 
     * Store max hitpoints to allow for healing to be implemented later
     * Heals must never allow for more hit points than the creature started
     * with
     * @param str the strength of the creature, used to calculate damage
     * @param hp the health of the creature at the start of the simulation, and the current health levels during battle
     */
    public Creature (int str, int hp) {
       this.str = str;
       this.hp = hp;
       max_hp = hp;
    }
    
    /**
     * Calculate the damage caused by this creature during an attack.
     *
     * @return a random damage value between 1 and the creature's strength
     */
    public int attack()
    {
        // Generate random damage between 1 and the creature's strength.
        return Randomizer.nextInt(str);
    }
    
    /**
     * Is this creature still capable of fighting?
     *
     * @return true when current hit points are greater than zero
     */
    public boolean isAlive()
    {
        // A creature is alive only when its health is above zero.
        return hp > 0;
    }
    
    /**
     * Check whether this creature has been knocked out.
     *
     * @return true if the creature's hit points are zero or less
     */
    public boolean isKnockedOut()
    {
        // A creature is knocked out when it has no remaining health.
        return hp <= 0;
    }
    
    /**
     * Reduce the creature's current hit points by the damage received.
     *
     * @param damage the amount of damage inflicted on the creature
     */
    public void takeDamage(int damage)
    {
        // Subtract the damage received from the creature's current health.
        hp = hp - damage;
    }
}
