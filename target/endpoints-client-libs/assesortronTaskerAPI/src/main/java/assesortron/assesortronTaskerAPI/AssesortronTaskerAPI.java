/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-01-14 17:53:03 UTC)
 * on 2015-03-07 at 18:23:38 UTC 
 * Modify at your own risk.
 */

package assesortron.assesortronTaskerAPI;

/**
 * Service definition for AssesortronTaskerAPI (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link AssesortronTaskerAPIRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class AssesortronTaskerAPI extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.19.1 of the assesortronTaskerAPI library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://primal-carport-86803.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "assesortronTaskerAPI/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public AssesortronTaskerAPI(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  AssesortronTaskerAPI(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the TaskerAPI collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code AssesortronTaskerAPI assesortronTaskerAPI = new AssesortronTaskerAPI(...);}
   *   {@code AssesortronTaskerAPI.TaskerAPI.List request = assesortronTaskerAPI.taskerAPI().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public TaskerAPI taskerAPI() {
    return new TaskerAPI();
  }

  /**
   * The "taskerAPI" collection of methods.
   */
  public class TaskerAPI {

    /**
     * Create a request for the method "taskerAPI.getStringTests".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link GetStringTests#execute()} method to invoke the remote
     * operation.
     *
     * @return the request
     */
    public GetStringTests getStringTests() throws java.io.IOException {
      GetStringTests result = new GetStringTests();
      initialize(result);
      return result;
    }

    public class GetStringTests extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.StringCollection> {

      private static final String REST_PATH = "stringcollection";

      /**
       * Create a request for the method "taskerAPI.getStringTests".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link GetStringTests#execute()} method to invoke the remote
       * operation. <p> {@link GetStringTests#initialize(com.google.api.client.googleapis.services.Abstr
       * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
       * the constructor. </p>
       *
       * @since 1.13
       */
      protected GetStringTests() {
        super(AssesortronTaskerAPI.this, "GET", REST_PATH, null, assesortron.assesortronTaskerAPI.model.StringCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetStringTests setAlt(java.lang.String alt) {
        return (GetStringTests) super.setAlt(alt);
      }

      @Override
      public GetStringTests setFields(java.lang.String fields) {
        return (GetStringTests) super.setFields(fields);
      }

      @Override
      public GetStringTests setKey(java.lang.String key) {
        return (GetStringTests) super.setKey(key);
      }

      @Override
      public GetStringTests setOauthToken(java.lang.String oauthToken) {
        return (GetStringTests) super.setOauthToken(oauthToken);
      }

      @Override
      public GetStringTests setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetStringTests) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetStringTests setQuotaUser(java.lang.String quotaUser) {
        return (GetStringTests) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetStringTests setUserIp(java.lang.String userIp) {
        return (GetStringTests) super.setUserIp(userIp);
      }

      @Override
      public GetStringTests set(String parameterName, Object value) {
        return (GetStringTests) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "taskerAPI.getWalkThroughs".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link GetWalkThroughs#execute()} method to invoke the remote
     * operation.
     *
     * @return the request
     */
    public GetWalkThroughs getWalkThroughs() throws java.io.IOException {
      GetWalkThroughs result = new GetWalkThroughs();
      initialize(result);
      return result;
    }

    public class GetWalkThroughs extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.WalkThroughDTOCollection> {

      private static final String REST_PATH = "walkthroughdtocollection";

      /**
       * Create a request for the method "taskerAPI.getWalkThroughs".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link GetWalkThroughs#execute()} method to invoke the remote
       * operation. <p> {@link GetWalkThroughs#initialize(com.google.api.client.googleapis.services.Abst
       * ractGoogleClientRequest)} must be called to initialize this instance immediately after invoking
       * the constructor. </p>
       *
       * @since 1.13
       */
      protected GetWalkThroughs() {
        super(AssesortronTaskerAPI.this, "GET", REST_PATH, null, assesortron.assesortronTaskerAPI.model.WalkThroughDTOCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public GetWalkThroughs setAlt(java.lang.String alt) {
        return (GetWalkThroughs) super.setAlt(alt);
      }

      @Override
      public GetWalkThroughs setFields(java.lang.String fields) {
        return (GetWalkThroughs) super.setFields(fields);
      }

      @Override
      public GetWalkThroughs setKey(java.lang.String key) {
        return (GetWalkThroughs) super.setKey(key);
      }

      @Override
      public GetWalkThroughs setOauthToken(java.lang.String oauthToken) {
        return (GetWalkThroughs) super.setOauthToken(oauthToken);
      }

      @Override
      public GetWalkThroughs setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (GetWalkThroughs) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public GetWalkThroughs setQuotaUser(java.lang.String quotaUser) {
        return (GetWalkThroughs) super.setQuotaUser(quotaUser);
      }

      @Override
      public GetWalkThroughs setUserIp(java.lang.String userIp) {
        return (GetWalkThroughs) super.setUserIp(userIp);
      }

      @Override
      public GetWalkThroughs set(String parameterName, Object value) {
        return (GetWalkThroughs) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "taskerAPI.sendProjectExcel".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link SendProjectExcel#execute()} method to invoke the remote
     * operation.
     *
     * @param recipient
     * @param content the {@link assesortron.assesortronTaskerAPI.model.ProjectDTO}
     * @return the request
     */
    public SendProjectExcel sendProjectExcel(java.lang.String recipient, assesortron.assesortronTaskerAPI.model.ProjectDTO content) throws java.io.IOException {
      SendProjectExcel result = new SendProjectExcel(recipient, content);
      initialize(result);
      return result;
    }

    public class SendProjectExcel extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.StringWrapper> {

      private static final String REST_PATH = "sendProjectExcel/{recipient}";

      /**
       * Create a request for the method "taskerAPI.sendProjectExcel".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link SendProjectExcel#execute()} method to invoke the
       * remote operation. <p> {@link SendProjectExcel#initialize(com.google.api.client.googleapis.servi
       * ces.AbstractGoogleClientRequest)} must be called to initialize this instance immediately after
       * invoking the constructor. </p>
       *
       * @param recipient
       * @param content the {@link assesortron.assesortronTaskerAPI.model.ProjectDTO}
       * @since 1.13
       */
      protected SendProjectExcel(java.lang.String recipient, assesortron.assesortronTaskerAPI.model.ProjectDTO content) {
        super(AssesortronTaskerAPI.this, "POST", REST_PATH, content, assesortron.assesortronTaskerAPI.model.StringWrapper.class);
        this.recipient = com.google.api.client.util.Preconditions.checkNotNull(recipient, "Required parameter recipient must be specified.");
      }

      @Override
      public SendProjectExcel setAlt(java.lang.String alt) {
        return (SendProjectExcel) super.setAlt(alt);
      }

      @Override
      public SendProjectExcel setFields(java.lang.String fields) {
        return (SendProjectExcel) super.setFields(fields);
      }

      @Override
      public SendProjectExcel setKey(java.lang.String key) {
        return (SendProjectExcel) super.setKey(key);
      }

      @Override
      public SendProjectExcel setOauthToken(java.lang.String oauthToken) {
        return (SendProjectExcel) super.setOauthToken(oauthToken);
      }

      @Override
      public SendProjectExcel setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (SendProjectExcel) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public SendProjectExcel setQuotaUser(java.lang.String quotaUser) {
        return (SendProjectExcel) super.setQuotaUser(quotaUser);
      }

      @Override
      public SendProjectExcel setUserIp(java.lang.String userIp) {
        return (SendProjectExcel) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.lang.String recipient;

      /**

       */
      public java.lang.String getRecipient() {
        return recipient;
      }

      public SendProjectExcel setRecipient(java.lang.String recipient) {
        this.recipient = recipient;
        return this;
      }

      @Override
      public SendProjectExcel set(String parameterName, Object value) {
        return (SendProjectExcel) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "taskerAPI.submitProject".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link SubmitProject#execute()} method to invoke the remote
     * operation.
     *
     * @param content the {@link assesortron.assesortronTaskerAPI.model.ProjectDTO}
     * @return the request
     */
    public SubmitProject submitProject(assesortron.assesortronTaskerAPI.model.ProjectDTO content) throws java.io.IOException {
      SubmitProject result = new SubmitProject(content);
      initialize(result);
      return result;
    }

    public class SubmitProject extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.StringWrapper> {

      private static final String REST_PATH = "submitProject";

      /**
       * Create a request for the method "taskerAPI.submitProject".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link SubmitProject#execute()} method to invoke the remote
       * operation. <p> {@link SubmitProject#initialize(com.google.api.client.googleapis.services.Abstra
       * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
       * the constructor. </p>
       *
       * @param content the {@link assesortron.assesortronTaskerAPI.model.ProjectDTO}
       * @since 1.13
       */
      protected SubmitProject(assesortron.assesortronTaskerAPI.model.ProjectDTO content) {
        super(AssesortronTaskerAPI.this, "POST", REST_PATH, content, assesortron.assesortronTaskerAPI.model.StringWrapper.class);
      }

      @Override
      public SubmitProject setAlt(java.lang.String alt) {
        return (SubmitProject) super.setAlt(alt);
      }

      @Override
      public SubmitProject setFields(java.lang.String fields) {
        return (SubmitProject) super.setFields(fields);
      }

      @Override
      public SubmitProject setKey(java.lang.String key) {
        return (SubmitProject) super.setKey(key);
      }

      @Override
      public SubmitProject setOauthToken(java.lang.String oauthToken) {
        return (SubmitProject) super.setOauthToken(oauthToken);
      }

      @Override
      public SubmitProject setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (SubmitProject) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public SubmitProject setQuotaUser(java.lang.String quotaUser) {
        return (SubmitProject) super.setQuotaUser(quotaUser);
      }

      @Override
      public SubmitProject setUserIp(java.lang.String userIp) {
        return (SubmitProject) super.setUserIp(userIp);
      }

      @Override
      public SubmitProject set(String parameterName, Object value) {
        return (SubmitProject) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "taskerAPI.submitSiteWalk".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link SubmitSiteWalk#execute()} method to invoke the remote
     * operation.
     *
     * @param content the {@link assesortron.assesortronTaskerAPI.model.SiteWalkDTO}
     * @return the request
     */
    public SubmitSiteWalk submitSiteWalk(assesortron.assesortronTaskerAPI.model.SiteWalkDTO content) throws java.io.IOException {
      SubmitSiteWalk result = new SubmitSiteWalk(content);
      initialize(result);
      return result;
    }

    public class SubmitSiteWalk extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.StringWrapper> {

      private static final String REST_PATH = "submitSiteWalk";

      /**
       * Create a request for the method "taskerAPI.submitSiteWalk".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link SubmitSiteWalk#execute()} method to invoke the remote
       * operation. <p> {@link SubmitSiteWalk#initialize(com.google.api.client.googleapis.services.Abstr
       * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
       * the constructor. </p>
       *
       * @param content the {@link assesortron.assesortronTaskerAPI.model.SiteWalkDTO}
       * @since 1.13
       */
      protected SubmitSiteWalk(assesortron.assesortronTaskerAPI.model.SiteWalkDTO content) {
        super(AssesortronTaskerAPI.this, "POST", REST_PATH, content, assesortron.assesortronTaskerAPI.model.StringWrapper.class);
      }

      @Override
      public SubmitSiteWalk setAlt(java.lang.String alt) {
        return (SubmitSiteWalk) super.setAlt(alt);
      }

      @Override
      public SubmitSiteWalk setFields(java.lang.String fields) {
        return (SubmitSiteWalk) super.setFields(fields);
      }

      @Override
      public SubmitSiteWalk setKey(java.lang.String key) {
        return (SubmitSiteWalk) super.setKey(key);
      }

      @Override
      public SubmitSiteWalk setOauthToken(java.lang.String oauthToken) {
        return (SubmitSiteWalk) super.setOauthToken(oauthToken);
      }

      @Override
      public SubmitSiteWalk setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (SubmitSiteWalk) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public SubmitSiteWalk setQuotaUser(java.lang.String quotaUser) {
        return (SubmitSiteWalk) super.setQuotaUser(quotaUser);
      }

      @Override
      public SubmitSiteWalk setUserIp(java.lang.String userIp) {
        return (SubmitSiteWalk) super.setUserIp(userIp);
      }

      @Override
      public SubmitSiteWalk set(String parameterName, Object value) {
        return (SubmitSiteWalk) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "taskerAPI.submitTestList".
     *
     * This request holds the parameters needed by the assesortronTaskerAPI server.  After setting any
     * optional parameters, call the {@link SubmitTestList#execute()} method to invoke the remote
     * operation.
     *
     * @param stringvalues
     * @return the request
     */
    public SubmitTestList submitTestList(java.util.List<java.lang.String> stringvalues) throws java.io.IOException {
      SubmitTestList result = new SubmitTestList(stringvalues);
      initialize(result);
      return result;
    }

    public class SubmitTestList extends AssesortronTaskerAPIRequest<assesortron.assesortronTaskerAPI.model.StringWrapper> {

      private static final String REST_PATH = "submitTestList/{stringvalues}";

      /**
       * Create a request for the method "taskerAPI.submitTestList".
       *
       * This request holds the parameters needed by the the assesortronTaskerAPI server.  After setting
       * any optional parameters, call the {@link SubmitTestList#execute()} method to invoke the remote
       * operation. <p> {@link SubmitTestList#initialize(com.google.api.client.googleapis.services.Abstr
       * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
       * the constructor. </p>
       *
       * @param stringvalues
       * @since 1.13
       */
      protected SubmitTestList(java.util.List<java.lang.String> stringvalues) {
        super(AssesortronTaskerAPI.this, "POST", REST_PATH, null, assesortron.assesortronTaskerAPI.model.StringWrapper.class);
        this.stringvalues = com.google.api.client.util.Preconditions.checkNotNull(stringvalues, "Required parameter stringvalues must be specified.");
      }

      @Override
      public SubmitTestList setAlt(java.lang.String alt) {
        return (SubmitTestList) super.setAlt(alt);
      }

      @Override
      public SubmitTestList setFields(java.lang.String fields) {
        return (SubmitTestList) super.setFields(fields);
      }

      @Override
      public SubmitTestList setKey(java.lang.String key) {
        return (SubmitTestList) super.setKey(key);
      }

      @Override
      public SubmitTestList setOauthToken(java.lang.String oauthToken) {
        return (SubmitTestList) super.setOauthToken(oauthToken);
      }

      @Override
      public SubmitTestList setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (SubmitTestList) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public SubmitTestList setQuotaUser(java.lang.String quotaUser) {
        return (SubmitTestList) super.setQuotaUser(quotaUser);
      }

      @Override
      public SubmitTestList setUserIp(java.lang.String userIp) {
        return (SubmitTestList) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private java.util.List<java.lang.String> stringvalues;

      /**

       */
      public java.util.List<java.lang.String> getStringvalues() {
        return stringvalues;
      }

      public SubmitTestList setStringvalues(java.util.List<java.lang.String> stringvalues) {
        this.stringvalues = stringvalues;
        return this;
      }

      @Override
      public SubmitTestList set(String parameterName, Object value) {
        return (SubmitTestList) super.set(parameterName, value);
      }
    }

  }

  /**
   * Builder for {@link AssesortronTaskerAPI}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link AssesortronTaskerAPI}. */
    @Override
    public AssesortronTaskerAPI build() {
      return new AssesortronTaskerAPI(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link AssesortronTaskerAPIRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setAssesortronTaskerAPIRequestInitializer(
        AssesortronTaskerAPIRequestInitializer assesortrontaskerapiRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(assesortrontaskerapiRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
