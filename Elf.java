/**
 * Represents an Elf creature with magical abilities.
 * Elves inherit their basic combat behavior from Creature.
 *
 * @author Garry Ovide
 * @version 2026-11-14
 */
public class Elf extends Creature
{
    // Maximum and minimum hit points allowed for an Elf.
    private static final int MAX_ELF_HP = 25;
    private static final int MIN_ELF_HP = 8;

    // Maximum and minimum strength allowed for an Elf.
    private static final int MAX_ELF_STR = 18;
    private static final int MIN_ELF_STR = 5;

    /**
     * Create an Elf with randomly generated strength and hit points.
     * Strength ranges from 5 to 18.
     * Hit points range from 8 to 25.
     */
    public Elf()
    {
        // Generate random strength between 5 and 18.
        // Generate random hit points between 8 and 25.
        // Pass both values to the Creature constructor.
        super(
        Randomizer.nextInt(MAX_ELF_STR - MIN_ELF_STR + 1)
            + MIN_ELF_STR - 1,

        Randomizer.nextInt(MAX_ELF_HP - MIN_ELF_HP + 1)
            + MIN_ELF_HP - 1
            );
    }
    
    /**
     * Calculate the damage caused by an Elf during an attack.
     * An Elf has a 10% chance of dealing double damage.
     *
     * @return the total damage caused by the Elf
     */
    @Override
    public int attack()
    {
        // Get the normal attack damage from the Creature class.
        int damage = super.attack();

        // Generate a random number between 1 and 10.
        int magicChance = Randomizer.nextInt(10);

        // A roll of 1 gives the Elf a 10% chance of double damage.
        if (magicChance == 1)
        {
            damage = damage * 2;
        }
        
        // Return either normal damage or doubled magical damage.
        return damage;
    }
}
