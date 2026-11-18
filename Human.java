

/**
 * The Human class implements a wrapper for the base Creature class with the following additions
 * Implements a maximum/minimum strength for the creature type [20/5]
 * Implements a maximum/minimum hitpoint total for the creature type [25/5]
 * 
 * @author Bill Crosbie
 * @version 2025-04 v1.1
 */
public class Human extends Creature
{
    // Constants defining the minimum and maximum
    // hit points and strength allowed for a Human.
    private static final int MAX_HUMAN_HP = 25;
    private static final int MIN_HUMAN_HP = 5;
    private static final int MAX_HUMAN_STR = 20;
    private static final int MIN_HUMAN_STR = 5;

    /**
     * Create a Human with randomly generated strength and hit points.
     * Strength ranges from 5 to 20.
     * Hit points range from 5 to 25.
     */
    public Human()
    {
        // Generate strength within the allowed Human range.
        // Subtract 1 from the minimum because Randomizer starts at 1.
        // This ensures that both the minimum and maximum are included.
        super(
        Randomizer.nextInt(MAX_HUMAN_STR - MIN_HUMAN_STR + 1)
            + MIN_HUMAN_STR - 1,

        // Generate hit points within the allowed Human range.
        Randomizer.nextInt(MAX_HUMAN_HP - MIN_HUMAN_HP + 1)
            + MIN_HUMAN_HP - 1
            );
    }
    
    
    // Humans inherit the attack() method from Creature because
    // they do not have any special attack abilities.

    // Humans inherit takeDamage(int) from Creature because
    // they receive damage without any special protection.
}
