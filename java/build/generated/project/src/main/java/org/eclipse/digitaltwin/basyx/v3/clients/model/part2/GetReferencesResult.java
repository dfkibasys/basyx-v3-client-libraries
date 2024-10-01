/*******************************************************************************
 * Copyright (C) 2024 DFKI GmbH (https://www.dfki.de/en/web)
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 * SPDX-License-Identifier: MIT
 ******************************************************************************/

package org.eclipse.digitaltwin.basyx.v3.clients.model.part2;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.eclipse.digitaltwin.aas4j.v3.model.Reference;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.PagedResultPagingMetadata;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * GetReferencesResult
 */
@JsonPropertyOrder({
  GetReferencesResult.JSON_PROPERTY_PAGING_METADATA,
  GetReferencesResult.JSON_PROPERTY_RESULT
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-17T10:24:32.871241400+02:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class GetReferencesResult {
  public static final String JSON_PROPERTY_PAGING_METADATA = "paging_metadata";
  private PagedResultPagingMetadata pagingMetadata;

  public static final String JSON_PROPERTY_RESULT = "result";
  private List<Reference> result;

  public GetReferencesResult() { 
  }

  public GetReferencesResult pagingMetadata(PagedResultPagingMetadata pagingMetadata) {
    this.pagingMetadata = pagingMetadata;
    return this;
  }

   /**
   * Get pagingMetadata
   * @return pagingMetadata
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_PAGING_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public PagedResultPagingMetadata getPagingMetadata() {
    return pagingMetadata;
  }


  @JsonProperty(JSON_PROPERTY_PAGING_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPagingMetadata(PagedResultPagingMetadata pagingMetadata) {
    this.pagingMetadata = pagingMetadata;
  }


  public GetReferencesResult result(List<Reference> result) {
    this.result = result;
    return this;
  }

  public GetReferencesResult addResultItem(Reference resultItem) {
    if (this.result == null) {
      this.result = new ArrayList<>();
    }
    this.result.add(resultItem);
    return this;
  }

   /**
   * Get result
   * @return result
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Reference> getResult() {
    return result;
  }


  @JsonProperty(JSON_PROPERTY_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResult(List<Reference> result) {
    this.result = result;
  }


  /**
   * Return true if this GetReferencesResult object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetReferencesResult getReferencesResult = (GetReferencesResult) o;
    return Objects.equals(this.pagingMetadata, getReferencesResult.pagingMetadata) &&
        Objects.equals(this.result, getReferencesResult.result);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pagingMetadata, result);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetReferencesResult {\n");
    sb.append("    pagingMetadata: ").append(toIndentedString(pagingMetadata)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

