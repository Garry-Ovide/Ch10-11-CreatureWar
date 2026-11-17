/**
 * Represents the abstract superclass for all Demon creatures.
 * Demons inherit their basic combat abilities from Creature.
 * CyberDemon and Balrog are subclasses of Demon.
 *
 * @author Garry Ovide
 * @version 2026-11-14
 */
public abstract class Demon extends Creature
{
    /**
     * Create a Demon with the specified strength and hit points.
     *
     * @param str the strength of the Demon
     * @param hp the starting hit points of the Demon
     */
    public Demon(int str, int hp)
    {
        // Pass strength and hit points to the Creature constructor.
        super(str, hp);
    }
    
    /**
     * Calculate the damage caused by a Demon during an attack.
     * A Demon has a 5% chance of causing an additional 50 damage.
     *
     * @return the total damage caused by the Demon
     */
    @Override
    public int attack()
    {
        // Get the normal attack damage from the Creature class.
        int damage = super.attack();

        // Generate a random number between 1 and 20.
        int magicChance = Randomizer.nextInt(20);

        // A roll of 1 gives the Demon a 5% chance of bonus damage.
        if (magicChance == 1)
        {
            // Add 50 points of magical damage.
            damage = damage + 50;
        }
        
        // Return the total damage caused by the Demon.
        return damage;
    }
}