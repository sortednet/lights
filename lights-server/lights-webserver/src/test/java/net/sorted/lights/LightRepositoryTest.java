package net.sorted.lights;

//import com.github.springtestdbunit.DbUnitTestExecutionListener;
//import com.github.springtestdbunit.annotation.DatabaseOperation;
//import com.github.springtestdbunit.annotation.DatabaseSetup;
//import com.github.springtestdbunit.annotation.DatabaseTearDown;
//import net.sorted.lights.domain.Light;
//import net.sorted.lights.repository.LightRepository;
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
//@DatabaseSetup(type = DatabaseOperation.INSERT, value = { "classpath:datasets/it-lights.xml" }) // INSERT not CLEAN_INSERT so it does not clean table first
//@DatabaseTearDown(type = DatabaseOperation.DELETE, value = { "classpath:datasets/it-lights.xml" })
//@DirtiesContext
public class LightRepositoryTest {
//
//    @Autowired
//    private LightRepository lightRepository;
//
//    @Test
//    public void testFindAllGets4Lights() {
//        Iterable<Light> iter = lightRepository.findAll();
//        int size = 0;
//        for(Light v : iter) {
//            size++;
//        }
//
//        assertThat(size, is(4));
//    }
//
//    @Test
//    public void testFindOne() {
//        Light l = lightRepository.findOne(101l);
//        assertNotNull(l);
//        assertThat(l.getName(), is("L2"));
//        assertThat(l.getDescription(), is("Light 2"));
//    }
}
