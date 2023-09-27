package org.launchcode.techjobs.oo;

import org.junit.Test;

import static java.lang.System.setOut;
import static org.junit.Assert.*;

import static java.lang.System.lineSeparator;

public class JobTest {
    //TODO: Create your unit tests here
    Job job;
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        String name = "Product tester";
        Employer employer = new Employer("ACME");
        Location location = new Location("Desert");
        PositionType positionType = new PositionType("Quality control");
        CoreCompetency coreCompetency = new CoreCompetency("Persistence");
        job = new Job(name, employer, location, positionType, coreCompetency);
        assertTrue(job instanceof Job);
        assertTrue(employer instanceof Employer);
        assertTrue(location instanceof Location);
        assertTrue(positionType instanceof PositionType);
        assertTrue(coreCompetency instanceof CoreCompetency);
        assertEquals(name,job.getName());
        assertEquals(employer.getValue(),job.getEmployer().getValue());
        assertEquals(location.getValue(),job.getLocation().getValue());
        assertEquals(positionType.getValue(),job.getPositionType().getValue());
        assertEquals(coreCompetency.getValue(),job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job job1 =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
        assertFalse(job1.getId() == job2.getId());
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        job =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency(""));
//        System.out.println(job);
        char lineSeparator = System.lineSeparator().charAt(0);
        assertEquals(lineSeparator,job.toString().charAt(0));
        assertEquals(lineSeparator,job.toString().charAt(job.toString().length()-1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        job =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency("Persistence"));
//        System.out.println(job);
        String lineSeparator = System.lineSeparator();
        String expected = lineSeparator + "ID: " + job.getId() + lineSeparator +
                "Name: Product tester" + lineSeparator +
                "Employer: ACME" + lineSeparator +
                "Location: Desert" + lineSeparator +
                "Position Type: Quality control" + lineSeparator +
                "Core Competency: Persistence" + lineSeparator;
        assertEquals(expected, job.toString());
    }
    @Test
    public void testToStringHandlesEmptyField(){
        job =  new Job("Product tester", new Employer("ACME"),
                new Location("Desert"), new PositionType("Quality control"),
                new CoreCompetency(""));
//        System.out.println(job);
        String lineSeparator = System.lineSeparator();
        String expected = lineSeparator + "ID: " + job.getId() + lineSeparator +
                "Name: Product tester" + lineSeparator +
                "Employer: ACME" + lineSeparator +
                "Location: Desert" + lineSeparator +
                "Position Type: Quality control" + lineSeparator +
                "Core Competency: Data not available" + lineSeparator;
        assertEquals(expected, job.toString());
    }

}
