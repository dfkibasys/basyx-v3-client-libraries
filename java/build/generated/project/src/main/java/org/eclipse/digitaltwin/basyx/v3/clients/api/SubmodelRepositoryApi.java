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
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelElementsResult;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.GetSubmodelsResult;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationRequest;
import org.eclipse.digitaltwin.aas4j.v3.model.OperationResult;
import org.eclipse.digitaltwin.aas4j.v3.model.Result;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.ServiceDescription;
import org.eclipse.digitaltwin.aas4j.v3.model.Submodel;
import org.eclipse.digitaltwin.aas4j.v3.model.SubmodelElement;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelElementValue;
import org.eclipse.digitaltwin.basyx.v3.clients.model.part2.SubmodelMetadata;

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

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2024-09-17T10:24:33.728334100+02:00[Europe/Berlin]", comments = "Generator version: 7.4.0")
public class SubmodelRepositoryApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public SubmodelRepositoryApi() {
    this(new ApiClient());
  }

  public SubmodelRepositoryApi(ObjectMapper mapper, String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), mapper, baseUri));
  }
  
  public SubmodelRepositoryApi(String baseUri) {
    this(new ApiClient(HttpClient.newBuilder(), JSON.getDefault().getMapper(), baseUri));
  }


  public SubmodelRepositoryApi(ApiClient apiClient) {
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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteFileAttachment(String submodelIdentifier, String idShortPath) throws ApiException {
    deleteFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath);
  }

  /**
   * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteFileAttachmentWithHttpInfo(String submodelIdentifier, String idShortPath) throws ApiException {
    return deleteFileAttachmentWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath);
  }


  /**
   * Deletes file content of an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteFileAttachmentWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteFileAttachmentRequestBuilder(submodelIdentifier, idShortPath);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteFileAttachment", localVarResponse);
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

  private HttpRequest.Builder deleteFileAttachmentRequestBuilder(String submodelIdentifier, String idShortPath) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling deleteFileAttachment");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling deleteFileAttachment");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * Deletes a Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteSubmodel(String submodelIdentifier) throws ApiException {
    deleteSubmodelWithHttpInfo(submodelIdentifier);
  }

  /**
   * Deletes a Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelWithHttpInfo(String submodelIdentifier) throws ApiException {
    return deleteSubmodelWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier));
  }


  /**
   * Deletes a Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelWithHttpInfoNoUrlEncoding(String submodelIdentifier) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteSubmodelRequestBuilder(submodelIdentifier);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteSubmodel", localVarResponse);
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

  private HttpRequest.Builder deleteSubmodelRequestBuilder(String submodelIdentifier) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling deleteSubmodel");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteSubmodelElement(String submodelIdentifier, String idShortPath) throws ApiException {
    deleteSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath);
  }

  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelElementWithHttpInfo(String submodelIdentifier, String idShortPath) throws ApiException {
    return deleteSubmodelElementWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath);
  }


  /**
   * Deletes a submodel element at a specified path within the submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> deleteSubmodelElementWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteSubmodelElementRequestBuilder(submodelIdentifier, idShortPath);
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

  private HttpRequest.Builder deleteSubmodelElementRequestBuilder(String submodelIdentifier, String idShortPath) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling deleteSubmodelElement");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling deleteSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return GetSubmodelElementsResult
   * @throws ApiException if fails to make API call
   */
  public GetSubmodelElementsResult getAllSubmodelElements(String submodelIdentifier, Integer limit, String cursor, String level, String extent) throws ApiException {
    ApiResponse<GetSubmodelElementsResult> localVarResponse =  getAllSubmodelElementsWithHttpInfo(submodelIdentifier, limit, cursor, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;GetSubmodelElementsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsResult> getAllSubmodelElementsWithHttpInfo(String submodelIdentifier, Integer limit, String cursor, String level, String extent) throws ApiException {
    return getAllSubmodelElementsWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), limit, cursor, level, extent);
  }


  /**
   * Returns all submodel elements including their hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<GetSubmodelElementsResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelElementsResult> getAllSubmodelElementsWithHttpInfoNoUrlEncoding(String submodelIdentifier, Integer limit, String cursor, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelElementsRequestBuilder(submodelIdentifier, limit, cursor, level, extent);
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

  private HttpRequest.Builder getAllSubmodelElementsRequestBuilder(String submodelIdentifier, Integer limit, String cursor, String level, String extent) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getAllSubmodelElements");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * Returns all Submodels
   * 
   * @param semanticId The value of the semantic id reference (BASE64-URL-encoded) (optional)
   * @param idShort The Asset Administration Shell&#39;s IdShort (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return GetSubmodelsResult
   * @throws ApiException if fails to make API call
   */
  public GetSubmodelsResult getAllSubmodels(String semanticId, String idShort, Integer limit, String cursor, String level, String extent) throws ApiException {
    ApiResponse<GetSubmodelsResult> localVarResponse =  getAllSubmodelsWithHttpInfo(semanticId, idShort, limit, cursor, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns all Submodels
   * 
   * @param semanticId The value of the semantic id reference (BASE64-URL-encoded) (optional)
   * @param idShort The Asset Administration Shell&#39;s IdShort (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;GetSubmodelsResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelsResult> getAllSubmodelsWithHttpInfo(String semanticId, String idShort, Integer limit, String cursor, String level, String extent) throws ApiException {
    return getAllSubmodelsWithHttpInfoNoUrlEncoding(semanticId, idShort, limit, cursor, level, extent);
  }


  /**
   * Returns all Submodels
   * 
   * @param semanticId The value of the semantic id reference (BASE64-URL-encoded) (optional)
   * @param idShort The Asset Administration Shell&#39;s IdShort (optional)
   * @param limit The maximum number of elements in the response array (optional)
   * @param cursor A server-generated identifier retrieved from pagingMetadata that specifies from which position the result listing should continue (optional)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<GetSubmodelsResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<GetSubmodelsResult> getAllSubmodelsWithHttpInfoNoUrlEncoding(String semanticId, String idShort, Integer limit, String cursor, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getAllSubmodelsRequestBuilder(semanticId, idShort, limit, cursor, level, extent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getAllSubmodels", localVarResponse);
        }
        return new ApiResponse<GetSubmodelsResult>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<GetSubmodelsResult>() {}) // closes the InputStream
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

  private HttpRequest.Builder getAllSubmodelsRequestBuilder(String semanticId, String idShort, Integer limit, String cursor, String level, String extent) throws ApiException {

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "semanticId";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("semanticId", semanticId));
    localVarQueryParameterBaseName = "idShort";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("idShort", idShort));
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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return File
   * @throws ApiException if fails to make API call
   */
  public InputStream getFileAttachment(String submodelIdentifier, String idShortPath) throws ApiException {
    ApiResponse<InputStream> localVarResponse =  getFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath);
    return localVarResponse.getData();
  }

  /**
   * Downloads file content from a specific submodel element from the Submodel at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse&lt;File&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<InputStream> getFileAttachmentWithHttpInfo(String submodelIdentifier, String idShortPath) throws ApiException {
    return getFileAttachmentWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath);
  }


  /**
   * Downloads file content from a specific submodel element from the Submodel at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @return ApiResponse<InputStream>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<InputStream> getFileAttachmentWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getFileAttachmentRequestBuilder(submodelIdentifier, idShortPath);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getFileAttachment", localVarResponse);
        }
        return new ApiResponse<InputStream>(localVarResponse.statusCode(), localVarResponse.headers().map(),
				localVarResponse.body() == null ? new ByteArrayInputStream(new byte[0]) : localVarResponse.body());
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

  private HttpRequest.Builder getFileAttachmentRequestBuilder(String submodelIdentifier, String idShortPath) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getFileAttachment");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getFileAttachment");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * Returns a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return Submodel
   * @throws ApiException if fails to make API call
   */
  public Submodel getSubmodel(String submodelIdentifier, String level, String extent) throws ApiException {
    ApiResponse<Submodel> localVarResponse =  getSubmodelWithHttpInfo(submodelIdentifier, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;Submodel&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> getSubmodelWithHttpInfo(String submodelIdentifier, String level, String extent) throws ApiException {
    return getSubmodelWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), level, extent);
  }


  /**
   * Returns a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<Submodel>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> getSubmodelWithHttpInfoNoUrlEncoding(String submodelIdentifier, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelRequestBuilder(submodelIdentifier, level, extent);
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

  private HttpRequest.Builder getSubmodelRequestBuilder(String submodelIdentifier, String level, String extent) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getSubmodel");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement getSubmodelElement(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  getSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> getSubmodelElementWithHttpInfo(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    return getSubmodelElementWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, level, extent);
  }


  /**
   * Returns a specific submodel element from the Submodel at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> getSubmodelElementWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementRequestBuilder(submodelIdentifier, idShortPath, level, extent);
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

  private HttpRequest.Builder getSubmodelElementRequestBuilder(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getSubmodelElement");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return SubmodelElementValue
   * @throws ApiException if fails to make API call
   */
  public SubmodelElementValue getSubmodelElementValue(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    ApiResponse<SubmodelElementValue> localVarResponse =  getSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, level, extent);
    return localVarResponse.getData();
  }

  /**
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse&lt;SubmodelElementValue&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementValue> getSubmodelElementValueWithHttpInfo(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    return getSubmodelElementValueWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, level, extent);
  }


  /**
   * Returns a specific submodel element from the Submodel at a specified path in the ValueOnly representation
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @param extent Determines to which extent the resource is being serialized (optional, default to withoutBlobValue)
   * @return ApiResponse<SubmodelElementValue>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElementValue> getSubmodelElementValueWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelElementValueRequestBuilder(submodelIdentifier, idShortPath, level, extent);
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

  private HttpRequest.Builder getSubmodelElementValueRequestBuilder(String submodelIdentifier, String idShortPath, String level, String extent) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getSubmodelElementValue");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling getSubmodelElementValue");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return SubmodelMetadata
   * @throws ApiException if fails to make API call
   */
  public SubmodelMetadata getSubmodelMetadata(String submodelIdentifier, String level) throws ApiException {
    ApiResponse<SubmodelMetadata> localVarResponse =  getSubmodelMetadataWithHttpInfo(submodelIdentifier, level);
    return localVarResponse.getData();
  }

  /**
   * Returns the metadata attributes of a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;SubmodelMetadata&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelMetadata> getSubmodelMetadataWithHttpInfo(String submodelIdentifier, String level) throws ApiException {
    return getSubmodelMetadataWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), level);
  }


  /**
   * Returns the metadata attributes of a specific Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<SubmodelMetadata>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelMetadata> getSubmodelMetadataWithHttpInfoNoUrlEncoding(String submodelIdentifier, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getSubmodelMetadataRequestBuilder(submodelIdentifier, level);
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

  private HttpRequest.Builder getSubmodelMetadataRequestBuilder(String submodelIdentifier, String level) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling getSubmodelMetadata");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/$metadata"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * Synchronously or asynchronously invokes an Operation at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @param async Determines whether an operation invocation is performed asynchronously or synchronously (optional, default to false)
   * @return OperationResult
   * @throws ApiException if fails to make API call
   */
  public OperationResult invokeOperation(String submodelIdentifier, String idShortPath, OperationRequest operationRequest, Boolean async) throws ApiException {
    ApiResponse<OperationResult> localVarResponse =  invokeOperationWithHttpInfo(submodelIdentifier, idShortPath, operationRequest, async);
    return localVarResponse.getData();
  }

  /**
   * Synchronously or asynchronously invokes an Operation at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @param async Determines whether an operation invocation is performed asynchronously or synchronously (optional, default to false)
   * @return ApiResponse&lt;OperationResult&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<OperationResult> invokeOperationWithHttpInfo(String submodelIdentifier, String idShortPath, OperationRequest operationRequest, Boolean async) throws ApiException {
    return invokeOperationWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, operationRequest, async);
  }


  /**
   * Synchronously or asynchronously invokes an Operation at a specified path
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param operationRequest Operation request object (required)
   * @param async Determines whether an operation invocation is performed asynchronously or synchronously (optional, default to false)
   * @return ApiResponse<OperationResult>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<OperationResult> invokeOperationWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, OperationRequest operationRequest, Boolean async) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = invokeOperationRequestBuilder(submodelIdentifier, idShortPath, operationRequest, async);
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

  private HttpRequest.Builder invokeOperationRequestBuilder(String submodelIdentifier, String idShortPath, OperationRequest operationRequest, Boolean async) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling invokeOperation");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling invokeOperation");
    }
    // verify the required parameter 'operationRequest' is set
    if (operationRequest == null) {
      throw new ApiException(400, "Missing the required parameter 'operationRequest' when calling invokeOperation");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/invoke"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
        .replace("{idShortPath}", ApiClient.urlEncode(idShortPath.toString()));

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "async";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("async", async));

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
   * Updates the value of an existing SubmodelElement
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @throws ApiException if fails to make API call
   */
  public void patchSubmodelElementValue(String submodelIdentifier, String idShortPath, SubmodelElementValue submodelElementValue, String level) throws ApiException {
    patchSubmodelElementValueWithHttpInfo(submodelIdentifier, idShortPath, submodelElementValue, level);
  }

  /**
   * Updates the value of an existing SubmodelElement
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementValueWithHttpInfo(String submodelIdentifier, String idShortPath, SubmodelElementValue submodelElementValue, String level) throws ApiException {
    return patchSubmodelElementValueWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, submodelElementValue, level);
  }


  /**
   * Updates the value of an existing SubmodelElement
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElementValue The SubmodelElement in its ValueOnly representation (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to core)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> patchSubmodelElementValueWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, SubmodelElementValue submodelElementValue, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = patchSubmodelElementValueRequestBuilder(submodelIdentifier, idShortPath, submodelElementValue, level);
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

  private HttpRequest.Builder patchSubmodelElementValueRequestBuilder(String submodelIdentifier, String idShortPath, SubmodelElementValue submodelElementValue, String level) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling patchSubmodelElementValue");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling patchSubmodelElementValue");
    }
    // verify the required parameter 'submodelElementValue' is set
    if (submodelElementValue == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElementValue' when calling patchSubmodelElementValue");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/$value"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * Creates a new Submodel
   * 
   * @param submodel Submodel object (required)
   * @return Submodel
   * @throws ApiException if fails to make API call
   */
  public Submodel postSubmodel(Submodel submodel) throws ApiException {
    ApiResponse<Submodel> localVarResponse =  postSubmodelWithHttpInfo(submodel);
    return localVarResponse.getData();
  }

  /**
   * Creates a new Submodel
   * 
   * @param submodel Submodel object (required)
   * @return ApiResponse&lt;Submodel&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> postSubmodelWithHttpInfo(Submodel submodel) throws ApiException {
    return postSubmodelWithHttpInfoNoUrlEncoding(submodel);
  }


  /**
   * Creates a new Submodel
   * 
   * @param submodel Submodel object (required)
   * @return ApiResponse<Submodel>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Submodel> postSubmodelWithHttpInfoNoUrlEncoding(Submodel submodel) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelRequestBuilder(submodel);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postSubmodel", localVarResponse);
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

  private HttpRequest.Builder postSubmodelRequestBuilder(Submodel submodel) throws ApiException {
    // verify the required parameter 'submodel' is set
    if (submodel == null) {
      throw new ApiException(400, "Missing the required parameter 'submodel' when calling postSubmodel");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodel);
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
   * Creates a new submodel element
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelElement Requested submodel element (required)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement postSubmodelElement(String submodelIdentifier, SubmodelElement submodelElement) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  postSubmodelElementWithHttpInfo(submodelIdentifier, submodelElement);
    return localVarResponse.getData();
  }

  /**
   * Creates a new submodel element
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementWithHttpInfo(String submodelIdentifier, SubmodelElement submodelElement) throws ApiException {
    return postSubmodelElementWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), submodelElement);
  }


  /**
   * Creates a new submodel element
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementWithHttpInfoNoUrlEncoding(String submodelIdentifier, SubmodelElement submodelElement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelElementRequestBuilder(submodelIdentifier, submodelElement);
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

  private HttpRequest.Builder postSubmodelElementRequestBuilder(String submodelIdentifier, SubmodelElement submodelElement) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling postSubmodelElement");
    }
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling postSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return SubmodelElement
   * @throws ApiException if fails to make API call
   */
  public SubmodelElement postSubmodelElementUnderPath(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement) throws ApiException {
    ApiResponse<SubmodelElement> localVarResponse =  postSubmodelElementUnderPathWithHttpInfo(submodelIdentifier, idShortPath, submodelElement);
    return localVarResponse.getData();
  }

  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse&lt;SubmodelElement&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementUnderPathWithHttpInfo(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement) throws ApiException {
    return postSubmodelElementUnderPathWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, submodelElement);
  }


  /**
   * Creates a new submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @return ApiResponse<SubmodelElement>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<SubmodelElement> postSubmodelElementUnderPathWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = postSubmodelElementUnderPathRequestBuilder(submodelIdentifier, idShortPath, submodelElement);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("postSubmodelElementUnderPath", localVarResponse);
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

  private HttpRequest.Builder postSubmodelElementUnderPathRequestBuilder(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling postSubmodelElementUnderPath");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling postSubmodelElementUnderPath");
    }
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling postSubmodelElementUnderPath");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @throws ApiException if fails to make API call
   */
  public void putFileAttachment(String submodelIdentifier, String idShortPath, String fileName, File _file) throws ApiException {
    putFileAttachmentWithHttpInfo(submodelIdentifier, idShortPath, fileName, _file);
  }

  /**
   * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putFileAttachmentWithHttpInfo(String submodelIdentifier, String idShortPath, String fileName, File _file) throws ApiException {
    return putFileAttachmentWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, fileName, _file);
  }


  /**
   * Uploads file content to an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param fileName  (optional)
   * @param _file  (optional)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putFileAttachmentWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, String fileName, File _file) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putFileAttachmentRequestBuilder(submodelIdentifier, idShortPath, fileName, _file);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putFileAttachment", localVarResponse);
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

  private HttpRequest.Builder putFileAttachmentRequestBuilder(String submodelIdentifier, String idShortPath, String fileName, File _file) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling putFileAttachment");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling putFileAttachment");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}/attachment"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
   * Updates an existing Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodel Submodel object (required)
   * @throws ApiException if fails to make API call
   */
  public void putSubmodel(String submodelIdentifier, Submodel submodel) throws ApiException {
    putSubmodelWithHttpInfo(submodelIdentifier, submodel);
  }

  /**
   * Updates an existing Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodel Submodel object (required)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelWithHttpInfo(String submodelIdentifier, Submodel submodel) throws ApiException {
    return putSubmodelWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), submodel);
  }


  /**
   * Updates an existing Submodel
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param submodel Submodel object (required)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelWithHttpInfoNoUrlEncoding(String submodelIdentifier, Submodel submodel) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putSubmodelRequestBuilder(submodelIdentifier, submodel);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putSubmodel", localVarResponse);
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

  private HttpRequest.Builder putSubmodelRequestBuilder(String submodelIdentifier, Submodel submodel) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling putSubmodel");
    }
    // verify the required parameter 'submodel' is set
    if (submodel == null) {
      throw new ApiException(400, "Missing the required parameter 'submodel' when calling putSubmodel");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(submodel);
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
  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @throws ApiException if fails to make API call
   */
  public void putSubmodelElement(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    putSubmodelElementWithHttpInfo(submodelIdentifier, idShortPath, submodelElement, level);
  }

  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse&lt;Void&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelElementWithHttpInfo(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    return putSubmodelElementWithHttpInfoNoUrlEncoding(ApiClient.base64UrlEncode(submodelIdentifier), idShortPath, submodelElement, level);
  }


  /**
   * Updates an existing submodel element at a specified path within submodel elements hierarchy
   * 
   * @param submodelIdentifier The Submodel’s unique id (UTF8-BASE64-URL-encoded) (required)
   * @param idShortPath IdShort path to the submodel element (dot-separated) (required)
   * @param submodelElement Requested submodel element (required)
   * @param level Determines the structural depth of the respective resource content (optional, default to deep)
   * @return ApiResponse<Void>
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Void> putSubmodelElementWithHttpInfoNoUrlEncoding(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = putSubmodelElementRequestBuilder(submodelIdentifier, idShortPath, submodelElement, level);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("putSubmodelElement", localVarResponse);
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

  private HttpRequest.Builder putSubmodelElementRequestBuilder(String submodelIdentifier, String idShortPath, SubmodelElement submodelElement, String level) throws ApiException {
    // verify the required parameter 'submodelIdentifier' is set
    if (submodelIdentifier == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelIdentifier' when calling putSubmodelElement");
    }
    // verify the required parameter 'idShortPath' is set
    if (idShortPath == null) {
      throw new ApiException(400, "Missing the required parameter 'idShortPath' when calling putSubmodelElement");
    }
    // verify the required parameter 'submodelElement' is set
    if (submodelElement == null) {
      throw new ApiException(400, "Missing the required parameter 'submodelElement' when calling putSubmodelElement");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/submodels/{submodelIdentifier}/submodel-elements/{idShortPath}"
        .replace("{submodelIdentifier}", ApiClient.urlEncode(submodelIdentifier.toString()))
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
