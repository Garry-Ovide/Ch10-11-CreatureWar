/**
 * Represents a CyberDemon creature.
 * CyberDemons inherit their magical attack abilities from Demon.
 * Strength ranges from 20 to 40.
 * Hit points range from 25 to 100.
 *
 * @author Garry Ovide
 * @version 2026-11-15
 */
public class CyberDemon extends Demon
{
    // Maximum and minimum hit points allowed for a CyberDemon.
    private static final int MAX_CYBERDEMON_HP = 100;
    private static final int MIN_CYBERDEMON_HP = 25;

    // Maximum and minimum strength allowed for a CyberDemon.
    private static final int MAX_CYBERDEMON_STR = 40;
    private static final int MIN_CYBERDEMON_STR = 20;

    /**
     * Create a CyberDemon with randomly generated strength
     * and hit points.
     *
     * Strength ranges from 20 to 40.
     * Hit points range from 25 to 100.
     */
    public CyberDemon()
    {
        // Generate random strength between 20 and 40.
        // Generate random hit points between 25 and 100.
        // Pass both values to the Demon constructor.
        super(
            Randomizer.nextInt(MAX_CYBERDEMON_STR - MIN_CYBERDEMON_STR + 1)
                + MIN_CYBERDEMON_STR - 1,

            Randomizer.nextInt(MAX_CYBERDEMON_HP - MIN_CYBERDEMON_HP + 1)
                + MIN_CYBERDEMON_HP - 1
        );
    }
}