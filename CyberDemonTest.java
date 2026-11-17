

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CyberDemonTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CyberDemonTest
{
    /**
     * Default constructor for test class CyberDemonTest
     */
    public CyberDemonTest()
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
     * Test that a newly created CyberDemon is alive
     * and has not been knocked out.
     */
    @Test
    public void testCyberDemonStartsAlive()
    {
        // Create a CyberDemon with randomly generated strength and health.
        CyberDemon cyberDemon1 = new CyberDemon();

        // Verify that the CyberDemon starts alive.
        assertTrue(cyberDemon1.isAlive());

        // Verify that the CyberDemon has not been knocked out.
        assertFalse(cyberDemon1.isKnockedOut());
    }
    
    /**
     * Test that a CyberDemon becomes knocked out after receiving
     * more damage than its maximum possible hit points.
     */
    @Test
    public void testCyberDemonTakesDamage()
    {
        // Create a CyberDemon with randomly generated hit points.
        CyberDemon cyberDemon1 = new CyberDemon();

        // Inflict 110 damage, exceeding the maximum of 100 HP.
        cyberDemon1.takeDamage(110);

        // Verify that the CyberDemon is no longer alive.
        assertFalse(cyberDemon1.isAlive());

        // Verify that the CyberDemon has been knocked out.
        assertTrue(cyberDemon1.isKnockedOut());
    }
    
    /**
     * Test that a CyberDemon's attack generates damage
     * within the allowed range, including magical bonus damage.
     */
    @Test
    public void testCyberDemonAttack()
    {
        // Create a CyberDemon with randomly generated strength.
        CyberDemon cyberDemon1 = new CyberDemon();

        // Repeat the attack test 100 times.
        for (int i = 0; i < 100; i++)
        {
            // Generate attack damage.
            int damage = cyberDemon1.attack();

            // Verify that damage is at least 1.
            assertTrue(damage >= 1);

            // Verify that damage does not exceed the maximum
            // possible CyberDemon attack of 90.
            assertTrue(damage <= 90);
        }
    }
}