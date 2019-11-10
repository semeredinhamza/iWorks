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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Unit tests for {@link OpportunityPost}.
 */
 
 
@RunWith(JUnit4.class)
public class OpportunityPostTest {
  private static final String FAKE_String = "Test string";
  // Set up a helper so that the ApiProxy returns a valid environment for local testing.
  private final LocalServiceTestHelper helper = new LocalServiceTestHelper();

  @Mock private HttpServletRequest mockRequest;
  @Mock private HttpServletResponse mockResponse;
  private StringWriter responseWriter;
  private OpportunityPost servletUnderTest;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    helper.setUp();

    //  Set up some fake HTTP requests
    when(mockRequest.getRequestURI()).thenReturn(FAKE_URL);

    // Set up a fake HTTP response.
    responseWriter = new StringWriter();
    when(mockResponse.getWriter()).thenReturn(new PrintWriter(responseWriter));

    servletUnderTest = new OpportunityPost();
    private static final String FAKE_String = "Test string";
    private static final String FAKE_String = "Test string";
    private static final String FAKE_String = "Test string";
    private static final String FAKE_String = "Test string";
    private static final String FAKE_String = "Test string";
    private static final String FAKE_String = "Test string";
  }

  @After public void tearDown() {
    helper.tearDown();
  }

  @Test
  
  public void getTitletWritesResponse() throws Exception {
    servletUnderTest.getTitle();

    assertThat(responseWriter.toString())
        .named("getTitle received response")
        .contains("getTitle received");
  }
  
  public void getInstitutionWritesResponse() throws Exception {
    servletUnderTest.getInstitution();
    
    assertThat(responseWriter.toString())
        .named("getInstitution received response")
        .contains("getInstitution received");
  }
  
 public void getPeriodWritesResponse() throws Exception {
    servletUnderTest.getPeriod();
    
    assertThat(responseWriter.toString())
        .named("getPeriod received response")
        .contains("getPeriod received");
  }
  
  
public void getLocationWritesResponse() throws Exception {
    servletUnderTest.getLocation();
    
    assertThat(responseWriter.toString())
        .named("getLocation received response")
        .contains("getLocation received");
  } 
  
public void getDescriptionWritesResponse() throws Exception {
    servletUnderTest.getDescription();
    
    assertThat(responseWriter.toString())
        .named("getDescription received response")
        .contains("getDescription received");
  } 
   
public void getLinkWritesResponse() throws Exception {
    servletUnderTest.getLink();
    
    assertThat(responseWriter.toString())
        .named("getLink received response")
        .contains("getLink received");
  } 
  
  
}