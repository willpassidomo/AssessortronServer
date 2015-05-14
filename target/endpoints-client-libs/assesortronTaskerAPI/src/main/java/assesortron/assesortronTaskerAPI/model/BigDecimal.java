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
 * Model definition for BigDecimal.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the assesortronTaskerAPI. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class BigDecimal extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer scale;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getScale() {
    return scale;
  }

  /**
   * @param scale scale or {@code null} for none
   */
  public BigDecimal setScale(java.lang.Integer scale) {
    this.scale = scale;
    return this;
  }

  @Override
  public BigDecimal set(String fieldName, Object value) {
    return (BigDecimal) super.set(fieldName, value);
  }

  @Override
  public BigDecimal clone() {
    return (BigDecimal) super.clone();
  }

}
