/**
 * Represents a Balrog creature.
 * Balrogs inherit their magical attack abilities from Demon.
 * Strength ranges from 50 to 100.
 * Hit points range from 80 to 200.
 *
 * @author Garry Ovide
 * @version 2026-11-15
 */
public class Balrog extends Demon
{
    // Maximum and minimum hit points allowed for a Balrog.
    private static final int MAX_BALROG_HP = 200;
    private static final int MIN_BALROG_HP = 80;

    // Maximum and minimum strength allowed for a Balrog.
    private static final int MAX_BALROG_STR = 100;
    private static final int MIN_BALROG_STR = 50;

    /**
     * Create a Balrog with randomly generated strength
     * and hit points.
     *
     * Strength ranges from 50 to 100.
     * Hit points range from 80 to 200.
     */
    public Balrog()
    {
        // Generate random strength between 50 and 100.
        // Generate random hit points between 80 and 200.
        // Pass both values to the Demon constructor.
        super(
            Randomizer.nextInt(MAX_BALROG_STR - MIN_BALROG_STR + 1)
                + MIN_BALROG_STR - 1,

            Randomizer.nextInt(MAX_BALROG_HP - MIN_BALROG_HP + 1)
                + MIN_BALROG_HP - 1
        );
    }
    
    /**
     * Calculate the total damage caused by a Balrog.
     * A Balrog attacks twice during each round.
     * Each attack has the Demon's 5% chance of
     * causing an additional 50 magical damage.
     *
     * @return the combined damage from both attacks
     */
    @Override
    public int attack()
    {
        // Perform the first attack using the Demon's attack method.
        int firstAttack = super.attack();

        // Perform the second attack using the Demon's attack method.
        int secondAttack = super.attack();

        // Add the damage from both attacks.
        int totalDamage = firstAttack + secondAttack;

        // Return the combined damage.
        return totalDamage;
    }
}