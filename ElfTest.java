

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ElfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ElfTest
{
    /**
     * Default constructor for test class ElfTest
     */
    public ElfTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    /**
     * Test that a newly created Elf is alive
     * and has not been knocked out.
     */
    @Test
    public void testElfStartsAlive()
    {
        // Create an Elf with randomly generated strength and health.
        Elf elf1 = new Elf();

        // Verify that the Elf starts alive.
        assertTrue(elf1.isAlive());

        // Verify that the Elf has not been knocked out.
        assertFalse(elf1.isKnockedOut());
    }
    
    /**
     * Test that an Elf becomes knocked out after receiving
     * more damage than its maximum possible hit points.
     */
    @Test
    public void testElfTakesDamage()
    {
        // Create an Elf with randomly generated hit points.
        Elf elf1 = new Elf();

        // Inflict 30 damage, exceeding the Elf's maximum of 25 HP.
        elf1.takeDamage(30);

        // Verify that the Elf is no longer alive.
        assertFalse(elf1.isAlive());

        // Verify that the Elf has been knocked out.
        assertTrue(elf1.isKnockedOut());
    }
    
    /**
     * Test that an Elf's attack generates damage within
     * the allowed range, including magical double damage.
     */
    @Test
    public void testElfAttack()
    {
        // Create an Elf with randomly generated strength.
        Elf elf1 = new Elf();

        // Repeat the attack test 100 times.
        for (int i = 0; i < 100; i++)
        {
            // Generate attack damage.
            int damage = elf1.attack();

            // Verify that damage is at least 1.
            assertTrue(damage >= 1);

            // Verify that damage does not exceed the maximum
            // possible Elf magical attack of 36.
            assertTrue(damage <= 36);
        }
    }
}