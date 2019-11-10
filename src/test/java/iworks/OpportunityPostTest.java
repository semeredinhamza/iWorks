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