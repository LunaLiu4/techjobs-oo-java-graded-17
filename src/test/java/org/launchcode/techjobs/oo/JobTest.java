package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());

    }
    @Test
    public void testJobConstructorSetsAllFields(){
        String name = "Product tester";
        String employer = "ACME";
        String location = "Desert";
        String positionType = "Quality control";
        String coreCompetency = "Persistence";
        Job job = new Job(name, new Employer(employer), new
                Location(location), new PositionType(positionType),
                new CoreCompetency(coreCompetency));
        assertTrue(job instanceof Job);
        assertEquals(employer,job.getEmployer().getValue());
        assertEquals(name,job.getName());
        assertEquals(location,job.getLocation().getValue());
        assertEquals(positionType,job.getPositionType().getValue());
        assertEquals(coreCompetency,job.getCoreCompetency().getValue());
    }
}
