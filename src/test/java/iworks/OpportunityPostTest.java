package iworks;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Unit tests for {@link StudentTimelineProgramsServlet}.
Code Coverage of Tests
We aim to have 100% code coverage of tests. In addition to the test cases mentioned above, we will be creating test cases as needed to ensure 100% code coverage. We cannot provide a complete list of test cases and make a detailed analysis of their code coverage; however, our goal is to achieve 100% code coverage by making test cases on a need basis.

Integration Testing Strategy
We are pursuing "big bang" integration testing strategy. In this approach, all the parts/modules are integrated and tested at one time. This test is done once the whole system is ready for integration testing.
An advantage of a "big bang" integration testing approach is everything is integrated and tested at one time. On the other hand, its disadvantage is that it is hard to identify points of failure.

Non-functional Requirements and User Interface Requirements Testing
Our plan is to test to what extent we have met our non-functional requirements and user interface requirements by using the 1-5 rating scale. We will designate a couple of our team members to conduct the tests manually.
 */
@RunWith(JUnit4.class)
public class OpportunityPostTest {
  private static final String FAKE_STRING = "test string";
  // Set up a helper so that the ApiProxy returns a valid environment for local testing.
  private final LocalServiceTestHelper helper = new LocalServiceTestHelper();

  private OpportunityPost servletUnderTest;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    helper.setUp();

    servletUnderTest = new OpportunityPost(FAKE_STRING, FAKE_STRING, FAKE_STRING, FAKE_STRING, FAKE_STRING, FAKE_STRING);
  }

  @After public void tearDown() {
    helper.tearDown();
  }

  @Test
  public void getTitleTest() throws Exception {
    String result = servletUnderTest.getTitle();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
  
  @Test
  public void getInstitutionTest() throws Exception {
    String result = servletUnderTest.getInstitution();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
  
  @Test
  public void getPeriodTest() throws Exception {
    String result = servletUnderTest.getPeriod();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
  
  @Test
  public void getLocationTest() throws Exception {
    String result = servletUnderTest.getLocation();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
  
  @Test
  public void getDescriptionTest() throws Exception {
    String result = servletUnderTest.getDescription();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
  
  @Test
  public void getLinkTest() throws Exception {
    String result = servletUnderTest.getLink();

    assertThat(result)
        .isEqualTo(FAKE_STRING);
  }
}
