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

package assesortron.assesortronTaskerAPI.model;

/**
 * Model definition for SiteWalkDTO.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the assesortronTaskerAPI. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class SiteWalkDTO extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<ChangeOrderDTO> changeOrders;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<DrawRequestDTO> drawRequests;

  static {
    // hack to force ProGuard to consider DrawRequestDTO used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(DrawRequestDTO.class);
  }

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime lastEntry;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private UUID projectID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String projectName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime startDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime timeStarted;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<WalkThroughDTO> walkThroughs;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.util.List<Writeable> writeables;

  static {
    // hack to force ProGuard to consider Writeable used, since otherwise it would be stripped out
    // see http://code.google.com/p/google-api-java-client/issues/detail?id=528
    com.google.api.client.util.Data.nullOf(Writeable.class);
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<ChangeOrderDTO> getChangeOrders() {
    return changeOrders;
  }

  /**
   * @param changeOrders changeOrders or {@code null} for none
   */
  public SiteWalkDTO setChangeOrders(java.util.List<ChangeOrderDTO> changeOrders) {
    this.changeOrders = changeOrders;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<DrawRequestDTO> getDrawRequests() {
    return drawRequests;
  }

  /**
   * @param drawRequests drawRequests or {@code null} for none
   */
  public SiteWalkDTO setDrawRequests(java.util.List<DrawRequestDTO> drawRequests) {
    this.drawRequests = drawRequests;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getLastEntry() {
    return lastEntry;
  }

  /**
   * @param lastEntry lastEntry or {@code null} for none
   */
  public SiteWalkDTO setLastEntry(com.google.api.client.util.DateTime lastEntry) {
    this.lastEntry = lastEntry;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public UUID getProjectID() {
    return projectID;
  }

  /**
   * @param projectID projectID or {@code null} for none
   */
  public SiteWalkDTO setProjectID(UUID projectID) {
    this.projectID = projectID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getProjectName() {
    return projectName;
  }

  /**
   * @param projectName projectName or {@code null} for none
   */
  public SiteWalkDTO setProjectName(java.lang.String projectName) {
    this.projectName = projectName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getStartDate() {
    return startDate;
  }

  /**
   * @param startDate startDate or {@code null} for none
   */
  public SiteWalkDTO setStartDate(com.google.api.client.util.DateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getTimeStarted() {
    return timeStarted;
  }

  /**
   * @param timeStarted timeStarted or {@code null} for none
   */
  public SiteWalkDTO setTimeStarted(com.google.api.client.util.DateTime timeStarted) {
    this.timeStarted = timeStarted;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<WalkThroughDTO> getWalkThroughs() {
    return walkThroughs;
  }

  /**
   * @param walkThroughs walkThroughs or {@code null} for none
   */
  public SiteWalkDTO setWalkThroughs(java.util.List<WalkThroughDTO> walkThroughs) {
    this.walkThroughs = walkThroughs;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.util.List<Writeable> getWriteables() {
    return writeables;
  }

  /**
   * @param writeables writeables or {@code null} for none
   */
  public SiteWalkDTO setWriteables(java.util.List<Writeable> writeables) {
    this.writeables = writeables;
    return this;
  }

  @Override
  public SiteWalkDTO set(String fieldName, Object value) {
    return (SiteWalkDTO) super.set(fieldName, value);
  }

  @Override
  public SiteWalkDTO clone() {
    return (SiteWalkDTO) super.clone();
  }

}
