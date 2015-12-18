package net.sorted.lights;

//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DatabaseOperation;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
//import com.github.springtestdbunit.annotation.DatabaseTearDown;
//import net.sorted.lights.domain.Schedule;
//import net.sorted.lights.repository.ScheduleRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
//import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//
//import static org.hamcrest.Matchers.is;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertThat;
//
//
//@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = LightsApplication.class)
//@DatabaseSetup(type = DatabaseOperation.INSERT, value = { "classpath:datasets/it-lights.xml", "classpath:datasets/it-schedules.xml"}) // INSERT not CLEAN_INSERT so it does not clean table first
//@DatabaseTearDown(type = DatabaseOperation.DELETE, value = {  "classpath:datasets/it-lights.xml", "classpath:datasets/it-schedules.xml" })
//@DirtiesContext
public class ScheduleRepositoryTest {
//
//    @Autowired
//    private ScheduleRepository scheduleRepository;
//
//    @Test
//    public void testFindOne() {
//        Schedule s = scheduleRepository.findOne(1l);
//        assertNotNull(s);
//        assertThat(s.getName(), is("s1"));
//        assertThat(s.getDescription(), is("schedule one"));
//    }
//
//    @Test
//    public void createEmptySchedule() {
//        int numBefore = getScheduleCount();
//        Schedule s = new Schedule(null, "stest", "test schedule");
//        scheduleRepository.save(s);
//        assertThat(getScheduleCount(), is(numBefore + 1));
//    }
//
//    private int getScheduleCount() {
//        Iterable<Schedule> iter = scheduleRepository.findAll();
//        int size = 0;
//        for(Schedule v : iter) {
//            size++;
//        }
//
//        return size;
//    }
}
