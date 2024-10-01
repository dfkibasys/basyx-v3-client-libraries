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
package org.eclipse.digitaltwin.basyx.v3.clients.api;

import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiException;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiResponse;
import org.eclipse.digitaltwin.basyx.v3.clients.Pair;
import org.eclipse.digitaltwin.basyx.v3.clients.JSON;

import java.io.File;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetPathItemsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsMetadataResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationRequest;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementMetadata;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelMetadata;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelValue;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-17T10:24:34.151064900+02:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class SubmodelServiceApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public SubmodelServiceApi() {
    this(new ApiClient());
  }

  public SubmodelServiceApi(ObjectMapper mapper, String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), mapper, baseUri));
  }
  
  public SubmodelServiceApi(String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), JSON.getDefault().getMapper(), baseUri));
  }


  public SubmodelServiceApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteFileByPath(String idShortPath) throws ApiException {
    deleteFileByPathWithHttpInfo(idShortPath);
  }

  /**
   * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteFileByPathWithHttpInfo(String idShortPath) throws ApiException {
    return deleteFileByPathWithHttpInfoNoUrlEncoding(idShortPath);
  }


  /**
   * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteFileByPathWithHttpInfoNoUrlEncoding(String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteFileByPathRequestBuilder(idShortPath);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteFileByPath", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteFileByPathRequestBuilder(String idShortPath) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling deleteFileByPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/attachment"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteSubmodelElement(String idShortPath) throws ApiException {
    deleteSubmodelElementWithHttpInfo(idShortPath);
  }

  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelElementWithHttpInfo(String idShortPath) throws ApiException {
    return deleteSubmodelElementWithHttpInfoNoUrlEncoding(idShortPath);
  }


  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelElementWithHttpInfoNoUrlEncoding(String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteSubmodelElementRequestBuilder(idShortPath);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteSubmodelElement", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteSubmodelElementRequestBuilder(String idShortPath) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling deleteSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return GetSubmodelElementsResult
   * @throws ApiException if fails to make API call
   */
  public GetSubmodelElementsResult getAllSubmodelElements(Integer limit, String cursor, String level, String extent) throws ApiException {
    ApiResponse<GetSubmodelElementsResult> localVarResponse =  getAllSubmodelElementsWithHttpInfo(limit, cursor, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;GetSubmodelElementsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsResult> getAllSubmodelElementsWithHttpInfo(Integer limit, String cursor, String level, String extent) throws ApiException {
    return getAllSubmodelElementsWithHttpInfoNoUrlEncoding(limit, cursor, level, extent);
  }


  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<GetSubmodelElementsResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsResult> getAllSubmodelElementsWithHttpInfoNoUrlEncoding(Integer limit, String cursor, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelElementsRequestBuilder(limit, cursor, level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllSubmodelElements", localVarResponse);
        }
        return new ApiResponse<GetSubmodelElementsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetSubmodelElementsResult>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAllSubmodelElementsRequestBuilder(Integer limit, String cursor, String level, String extent) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));
    localVarQueryParameterBaseName = "extent";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("extent", extent));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the metadata attributes of all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return GetSubmodelElementsMetadataResult
   * @throws ApiException if fails to make API call
   */
  public GetSubmodelElementsMetadataResult getAllSubmodelElementsMetadata(Integer limit, String cursor, String level) throws ApiException {
    ApiResponse<GetSubmodelElementsMetadataResult> localVarResponse =  getAllSubmodelElementsMetadataWithHttpInfo(limit, cursor, level);
    return localVarResponse.getData();
  }

  /**
   * Returns the metadata attributes of all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;GetSubmodelElementsMetadataResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsMetadataResult> getAllSubmodelElementsMetadataWithHttpInfo(Integer limit, String cursor, String level) throws ApiException {
    return getAllSubmodelElementsMetadataWithHttpInfoNoUrlEncoding(limit, cursor, level);
  }


  /**
   * Returns the metadata attributes of all submodel elements including their hierarchy
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<GetSubmodelElementsMetadataResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsMetadataResult> getAllSubmodelElementsMetadataWithHttpInfoNoUrlEncoding(Integer limit, String cursor, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelElementsMetadataRequestBuilder(limit, cursor, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllSubmodelElementsMetadata", localVarResponse);
        }
        return new ApiResponse<GetSubmodelElementsMetadataResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetSubmodelElementsMetadataResult>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAllSubmodelElementsMetadataRequestBuilder(Integer limit, String cursor, String level) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/$metadata";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns all submodel elements including their hierarchy in the Path notation
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return GetPathItemsResult
   * @throws ApiException if fails to make API call
   */
  public GetPathItemsResult getAllSubmodelElementsPath(Integer limit, String cursor, String level) throws ApiException {
    ApiResponse<GetPathItemsResult> localVarResponse =  getAllSubmodelElementsPathWithHttpInfo(limit, cursor, level);
    return localVarResponse.getData();
  }

  /**
   * Returns all submodel elements including their hierarchy in the Path notation
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;GetPathItemsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetPathItemsResult> getAllSubmodelElementsPathWithHttpInfo(Integer limit, String cursor, String level) throws ApiException {
    return getAllSubmodelElementsPathWithHttpInfoNoUrlEncoding(limit, cursor, level);
  }


  /**
   * Returns all submodel elements including their hierarchy in the Path notation
   * 
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<GetPathItemsResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetPathItemsResult> getAllSubmodelElementsPathWithHttpInfoNoUrlEncoding(Integer limit, String cursor, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelElementsPathRequestBuilder(limit, cursor, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllSubmodelElementsPath", localVarResponse);
        }
        return new ApiResponse<GetPathItemsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetPathItemsResult>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getAllSubmodelElementsPathRequestBuilder(Integer limit, String cursor, String level) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/$path";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ServiceDescription
   * @throws ApiException if fails to make API call
   */
  public ServiceDescription getDescription() throws ApiException {
    ApiResponse<ServiceDescription> localVarResponse =  getDescriptionWithHttpInfo();
    return localVarResponse.getData();
  }

  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ApiResponse&lt;ServiceDescription&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ServiceDescription> getDescriptionWithHttpInfo() throws ApiException {
    return getDescriptionWithHttpInfoNoUrlEncoding();
  }


  /**
   * Returns the self-describing information of a network resource (ServiceDescription)
   * 
   * @return ApiResponse<ServiceDescription>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ServiceDescription> getDescriptionWithHttpInfoNoUrlEncoding() throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getDescriptionRequestBuilder();
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getDescription", localVarResponse);
        }
        return new ApiResponse<ServiceDescription>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ServiceDescription>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getDescriptionRequestBuilder() throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/description";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Downloads file content from a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public File getFileByPath(String idShortPath) throws ApiException {
    ApiResponse<File> localVarResponse =  getFileByPathWithHttpInfo(idShortPath);
    return localVarResponse.getData();
  }

  /**
   * Downloads file content from a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<File> getFileByPathWithHttpInfo(String idShortPath) throws ApiException {
    return getFileByPathWithHttpInfoNoUrlEncoding(idShortPath);
  }


  /**
   * Downloads file content from a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<File>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<File> getFileByPathWithHttpInfoNoUrlEncoding(String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getFileByPathRequestBuilder(idShortPath);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getFileByPath", localVarResponse);
        }
        return new ApiResponse<File>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<File>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getFileByPathRequestBuilder(String idShortPath) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getFileByPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/attachment"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/octet-stream, application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return Submodel
   * @throws ApiException if fails to make API call
   */
  public Submodel getSubmodel(String level, String extent) throws ApiException {
    ApiResponse<Submodel> localVarResponse =  getSubmodelWithHttpInfo(level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns the Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;Submodel&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> getSubmodelWithHttpInfo(String level, String extent) throws ApiException {
    return getSubmodelWithHttpInfoNoUrlEncoding(level, extent);
  }


  /**
   * Returns the Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<Submodel>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> getSubmodelWithHttpInfoNoUrlEncoding(String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelRequestBuilder(level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodel", localVarResponse);
        }
        return new ApiResponse<Submodel>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Submodel>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelRequestBuilder(String level, String extent) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));
    localVarQueryParameterBaseName = "extent";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("extent", extent));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement getSubmodelElement(String idShortPath, String level, String extent) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  getSubmodelElementWithHttpInfo(idShortPath, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> getSubmodelElementWithHttpInfo(String idShortPath, String level, String extent) throws ApiException {
    return getSubmodelElementWithHttpInfoNoUrlEncoding(idShortPath, level, extent);
  }


  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> getSubmodelElementWithHttpInfoNoUrlEncoding(String idShortPath, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementRequestBuilder(idShortPath, level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelElement", localVarResponse);
        }
        return new ApiResponse<SubmodelElement>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelElement>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelElementRequestBuilder(String idShortPath, String level, String extent) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));
    localVarQueryParameterBaseName = "extent";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("extent", extent));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return SubmodelElementMetadata
   * @throws ApiException if fails to make API call
   */
  public SubmodelElementMetadata getSubmodelElementByPathMetadata(String idShortPath, String cursor) throws ApiException {
    ApiResponse<SubmodelElementMetadata> localVarResponse =  getSubmodelElementByPathMetadataWithHttpInfo(idShortPath, cursor);
    return localVarResponse.getData();
  }

  /**
   * Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse&lt;SubmodelElementMetadata&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementMetadata> getSubmodelElementByPathMetadataWithHttpInfo(String idShortPath, String cursor) throws ApiException {
    return getSubmodelElementByPathMetadataWithHttpInfoNoUrlEncoding(idShortPath, cursor);
  }


  /**
   * Returns the matadata attributes of a specific submodel element from the Submodel at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @return ApiResponse<SubmodelElementMetadata>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementMetadata> getSubmodelElementByPathMetadataWithHttpInfoNoUrlEncoding(String idShortPath, String cursor) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementByPathMetadataRequestBuilder(idShortPath, cursor);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelElementByPathMetadata", localVarResponse);
        }
        return new ApiResponse<SubmodelElementMetadata>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelElementMetadata>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelElementByPathMetadataRequestBuilder(String idShortPath, String cursor) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElementByPathMetadata");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/$metadata"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns a specific submodel element from the Submodel at a specified path in the Path notation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return String
   * @throws ApiException if fails to make API call
   */
  public String getSubmodelElementByPathPath(String idShortPath, String level) throws ApiException {
    ApiResponse<String> localVarResponse =  getSubmodelElementByPathPathWithHttpInfo(idShortPath, level);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific submodel element from the Submodel at a specified path in the Path notation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;String&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> getSubmodelElementByPathPathWithHttpInfo(String idShortPath, String level) throws ApiException {
    return getSubmodelElementByPathPathWithHttpInfoNoUrlEncoding(idShortPath, level);
  }


  /**
   * Returns a specific submodel element from the Submodel at a specified path in the Path notation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<String>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<String> getSubmodelElementByPathPathWithHttpInfoNoUrlEncoding(String idShortPath, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementByPathPathRequestBuilder(idShortPath, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelElementByPathPath", localVarResponse);
        }
        return new ApiResponse<String>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<String>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelElementByPathPathRequestBuilder(String idShortPath, String level) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElementByPathPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/$path"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return SubmodelElementValue
   * @throws ApiException if fails to make API call
   */
  public SubmodelElementValue getSubmodelElementValue(String idShortPath, String level, String extent) throws ApiException {
    ApiResponse<SubmodelElementValue> localVarResponse =  getSubmodelElementValueWithHttpInfo(idShortPath, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;SubmodelElementValue&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementValue> getSubmodelElementValueWithHttpInfo(String idShortPath, String level, String extent) throws ApiException {
    return getSubmodelElementValueWithHttpInfoNoUrlEncoding(idShortPath, level, extent);
  }


  /**
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<SubmodelElementValue>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementValue> getSubmodelElementValueWithHttpInfoNoUrlEncoding(String idShortPath, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementValueRequestBuilder(idShortPath, level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelElementValue", localVarResponse);
        }
        return new ApiResponse<SubmodelElementValue>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelElementValue>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelElementValueRequestBuilder(String idShortPath, String level, String extent) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElementValue");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/$value"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));
    localVarQueryParameterBaseName = "extent";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("extent", extent));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the metadata attributes of a specific Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return SubmodelMetadata
   * @throws ApiException if fails to make API call
   */
  public SubmodelMetadata getSubmodelMetadata(String level) throws ApiException {
    ApiResponse<SubmodelMetadata> localVarResponse =  getSubmodelMetadataWithHttpInfo(level);
    return localVarResponse.getData();
  }

  /**
   * Returns the metadata attributes of a specific Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;SubmodelMetadata&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelMetadata> getSubmodelMetadataWithHttpInfo(String level) throws ApiException {
    return getSubmodelMetadataWithHttpInfoNoUrlEncoding(level);
  }


  /**
   * Returns the metadata attributes of a specific Submodel
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<SubmodelMetadata>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelMetadata> getSubmodelMetadataWithHttpInfoNoUrlEncoding(String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelMetadataRequestBuilder(level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelMetadata", localVarResponse);
        }
        return new ApiResponse<SubmodelMetadata>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelMetadata>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelMetadataRequestBuilder(String level) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/$metadata";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Returns the Submodel in the ValueOnly representation
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return SubmodelValue
   * @throws ApiException if fails to make API call
   */
  public SubmodelValue getSubmodelValue(String level, String extent) throws ApiException {
    ApiResponse<SubmodelValue> localVarResponse =  getSubmodelValueWithHttpInfo(level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns the Submodel in the ValueOnly representation
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;SubmodelValue&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelValue> getSubmodelValueWithHttpInfo(String level, String extent) throws ApiException {
    return getSubmodelValueWithHttpInfoNoUrlEncoding(level, extent);
  }


  /**
   * Returns the Submodel in the ValueOnly representation
   * 
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<SubmodelValue>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelValue> getSubmodelValueWithHttpInfoNoUrlEncoding(String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelValueRequestBuilder(level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getSubmodelValue", localVarResponse);
        }
        return new ApiResponse<SubmodelValue>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelValue>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getSubmodelValueRequestBuilder(String level, String extent) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/$value";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));
    localVarQueryParameterBaseName = "extent";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("extent", extent));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Synchronously invokes an Operation at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @return OperationResult
   * @throws ApiException if fails to make API call
   */
  public OperationResult invokeOperation(String idShortPath, OperationRequest operationRequest) throws ApiException {
    ApiResponse<OperationResult> localVarResponse =  invokeOperationWithHttpInfo(idShortPath, operationRequest);
    return localVarResponse.getData();
  }

  /**
   * Synchronously invokes an Operation at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @return ApiResponse&lt;OperationResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<OperationResult> invokeOperationWithHttpInfo(String idShortPath, OperationRequest operationRequest) throws ApiException {
    return invokeOperationWithHttpInfoNoUrlEncoding(idShortPath, operationRequest);
  }


  /**
   * Synchronously invokes an Operation at a specified path
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @return ApiResponse<OperationResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<OperationResult> invokeOperationWithHttpInfoNoUrlEncoding(String idShortPath, OperationRequest operationRequest) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = invokeOperationRequestBuilder(idShortPath, operationRequest);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("invokeOperation", localVarResponse);
        }
        return new ApiResponse<OperationResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<OperationResult>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder invokeOperationRequestBuilder(String idShortPath, OperationRequest operationRequest) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling invokeOperation");
    }
    // verify the required parameter 'operationRequest' is set
    if (operationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'operationRequest' when calling invokeOperation");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/invoke"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(operationRequest);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Updates the metadata attributes an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param getSubmodelElementsMetadataResult Metadata attributes of the SubmodelElement (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @throws ApiException if fails to make API call
   */
  public void patchSubmodelElementByPathMetadata(String idShortPath, GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult, Integer limit, String cursor, String level) throws ApiException {
    patchSubmodelElementByPathMetadataWithHttpInfo(idShortPath, getSubmodelElementsMetadataResult, limit, cursor, level);
  }

  /**
   * Updates the metadata attributes an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param getSubmodelElementsMetadataResult Metadata attributes of the SubmodelElement (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementByPathMetadataWithHttpInfo(String idShortPath, GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult, Integer limit, String cursor, String level) throws ApiException {
    return patchSubmodelElementByPathMetadataWithHttpInfoNoUrlEncoding(idShortPath, getSubmodelElementsMetadataResult, limit, cursor, level);
  }


  /**
   * Updates the metadata attributes an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param getSubmodelElementsMetadataResult Metadata attributes of the SubmodelElement (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementByPathMetadataWithHttpInfoNoUrlEncoding(String idShortPath, GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult, Integer limit, String cursor, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = patchSubmodelElementByPathMetadataRequestBuilder(idShortPath, getSubmodelElementsMetadataResult, limit, cursor, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("patchSubmodelElementByPathMetadata", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder patchSubmodelElementByPathMetadataRequestBuilder(String idShortPath, GetSubmodelElementsMetadataResult getSubmodelElementsMetadataResult, Integer limit, String cursor, String level) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling patchSubmodelElementByPathMetadata");
    }
    // verify the required parameter 'getSubmodelElementsMetadataResult' is set
    if (getSubmodelElementsMetadataResult == null) {
      throw new ApiException(400, "Missing the required parameter 'getSubmodelElementsMetadataResult' when calling patchSubmodelElementByPathMetadata");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/$metadata"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(getSubmodelElementsMetadataResult);
      localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Updates the value of an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @throws ApiException if fails to make API call
   */
  public void patchSubmodelElementValue(String idShortPath, SubmodelElementValue submodelElementValue, Integer limit, String cursor, String level) throws ApiException {
    patchSubmodelElementValueWithHttpInfo(idShortPath, submodelElementValue, limit, cursor, level);
  }

  /**
   * Updates the value of an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementValueWithHttpInfo(String idShortPath, SubmodelElementValue submodelElementValue, Integer limit, String cursor, String level) throws ApiException {
    return patchSubmodelElementValueWithHttpInfoNoUrlEncoding(idShortPath, submodelElementValue, limit, cursor, level);
  }


  /**
   * Updates the value of an existing SubmodelElement
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementValueWithHttpInfoNoUrlEncoding(String idShortPath, SubmodelElementValue submodelElementValue, Integer limit, String cursor, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = patchSubmodelElementValueRequestBuilder(idShortPath, submodelElementValue, limit, cursor, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("patchSubmodelElementValue", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder patchSubmodelElementValueRequestBuilder(String idShortPath, SubmodelElementValue submodelElementValue, Integer limit, String cursor, String level) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling patchSubmodelElementValue");
    }
    // verify the required parameter 'submodelElementValue' is set
    if (submodelElementValue == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElementValue' when calling patchSubmodelElementValue");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/$value"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "limit";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("limit", limit));
    localVarQueryParameterBaseName = "cursor";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("cursor", cursor));
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelElementValue);
      localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Creates a new submodel element
   * 
   * @param submodelElement Requested submodel element (required)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement postSubmodelElement(SubmodelElement submodelElement) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  postSubmodelElementWithHttpInfo(submodelElement);
    return localVarResponse.getData();
  }

  /**
   * Creates a new submodel element
   * 
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementWithHttpInfo(SubmodelElement submodelElement) throws ApiException {
    return postSubmodelElementWithHttpInfoNoUrlEncoding(submodelElement);
  }


  /**
   * Creates a new submodel element
   * 
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementWithHttpInfoNoUrlEncoding(SubmodelElement submodelElement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelElementRequestBuilder(submodelElement);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postSubmodelElement", localVarResponse);
        }
        return new ApiResponse<SubmodelElement>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelElement>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder postSubmodelElementRequestBuilder(SubmodelElement submodelElement) throws ApiException {
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling postSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelElement);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement postSubmodelElementByPath(String idShortPath, SubmodelElement submodelElement) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  postSubmodelElementByPathWithHttpInfo(idShortPath, submodelElement);
    return localVarResponse.getData();
  }

  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementByPathWithHttpInfo(String idShortPath, SubmodelElement submodelElement) throws ApiException {
    return postSubmodelElementByPathWithHttpInfoNoUrlEncoding(idShortPath, submodelElement);
  }


  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementByPathWithHttpInfoNoUrlEncoding(String idShortPath, SubmodelElement submodelElement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelElementByPathRequestBuilder(idShortPath, submodelElement);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postSubmodelElementByPath", localVarResponse);
        }
        return new ApiResponse<SubmodelElement>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<SubmodelElement>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder postSubmodelElementByPathRequestBuilder(String idShortPath, SubmodelElement submodelElement) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling postSubmodelElementByPath");
    }
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling postSubmodelElementByPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelElement);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @throws ApiException if fails to make API call
   */
  public void putFileByPath(String idShortPath, String fileName, File _file) throws ApiException {
    putFileByPathWithHttpInfo(idShortPath, fileName, _file);
  }

  /**
   * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putFileByPathWithHttpInfo(String idShortPath, String fileName, File _file) throws ApiException {
    return putFileByPathWithHttpInfoNoUrlEncoding(idShortPath, fileName, _file);
  }


  /**
   * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putFileByPathWithHttpInfoNoUrlEncoding(String idShortPath, String fileName, File _file) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putFileByPathRequestBuilder(idShortPath, fileName, _file);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putFileByPath", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder putFileByPathRequestBuilder(String idShortPath, String fileName, File _file) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling putFileByPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}/attachment"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    MultipartEntityBuilder multiPartBuilder = MultipartEntityBuilder.create();
    boolean hasFiles = false;
    multiPartBuilder.addTextBody("fileName", fileName.toString());
    multiPartBuilder.addBinaryBody("file", _file);
    hasFiles = true;
    HttpEntity entity = multiPartBuilder.build();
    HttpRequest.BodyPublisher formDataPublisher;
    if (hasFiles) {
        Pipe pipe;
        try {
            pipe = Pipe.open();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            try (OutputStream outputStream = Channels.newOutputStream(pipe.sink())) {
                entity.writeTo(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        formDataPublisher = HttpRequest.BodyPublishers.ofInputStream(() -> Channels.newInputStream(pipe.source()));
    } else {
        ByteArrayOutputStream formOutputStream = new ByteArrayOutputStream();
        try {
            entity.writeTo(formOutputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        formDataPublisher = HttpRequest.BodyPublishers
            .ofInputStream(() -> new ByteArrayInputStream(formOutputStream.toByteArray()));
    }
    localVarRequestBuilder
        .header("Content-Type", entity.getContentType().getValue())
        .method("PUT", formDataPublisher);
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @throws ApiException if fails to make API call
   */
  public void putSubmodelElementByPath(String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    putSubmodelElementByPathWithHttpInfo(idShortPath, submodelElement, level);
  }

  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelElementByPathWithHttpInfo(String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    return putSubmodelElementByPathWithHttpInfoNoUrlEncoding(idShortPath, submodelElement, level);
  }


  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelElementByPathWithHttpInfoNoUrlEncoding(String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putSubmodelElementByPathRequestBuilder(idShortPath, submodelElement, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putSubmodelElementByPath", localVarResponse);
        }
        return new ApiResponse<Void>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          null
        );
      } finally {
        // Drain the InputStream
        while (localVarResponse.body().read() != -1) {
            // Ignore
        }
        localVarResponse.body().close();
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder putSubmodelElementByPathRequestBuilder(String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling putSubmodelElementByPath");
    }
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling putSubmodelElementByPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodel/submodel-elements/{idShortPath}"
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "level";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("level", level));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodelElement);
      localVarRequestBuilder.method("PUT", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }
  
}
