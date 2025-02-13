package org.eclipse.digitaltwin.basyx.v3.clientfacade.registration;

import org.eclipse.digitaltwin.aas4j.v3.model.*;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultAssetAdministrationShellDescriptor;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultEndpoint;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultProtocolInformation;
import org.eclipse.digitaltwin.aas4j.v3.model.impl.DefaultSubmodelDescriptor;
import org.eclipse.digitaltwin.basyx.v3.clients.ApiClient;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class RegistrationUtils {

    private static final String AAS_INTERFACE = "AAS-3.0";

    public static AssetAdministrationShellDescriptor toAasRepositoryDescriptor(AssetAdministrationShell shell, List<String> hrefs) {
        return toDescriptor(shell, hrefs, true);
    }

    public static AssetAdministrationShellDescriptor toAasServiceDescriptor(AssetAdministrationShell shell, List<String> hrefs) {
        return toDescriptor(shell, hrefs, false);
    }

    public static AssetAdministrationShellDescriptor toDescriptor(AssetAdministrationShell shell, List<String> hrefs, boolean hostedOnRepository) {
        AssetAdministrationShellDescriptor descriptor = new DefaultAssetAdministrationShellDescriptor();
        Optional.ofNullable(shell.getId()).ifPresent(descriptor::setId);
        Optional.ofNullable(shell.getIdShort()).ifPresent(descriptor::setIdShort);
        if (hostedOnRepository)
            Optional.of(getEndpoints(hrefs, shell.getId())).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
        else
            Optional.of(getEndpoints(hrefs)).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
        Optional.ofNullable(shell.getDescription()).ifPresent(descriptor::setDescription);
        Optional.ofNullable(shell.getDisplayName()).ifPresent(descriptor::setDisplayName);
        Optional.ofNullable(shell.getExtensions()).ifPresent(descriptor::setExtensions);
        Optional.ofNullable(shell.getAdministration()).ifPresent(descriptor::setAdministration);
        Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetKind).ifPresent(descriptor::setAssetKind);
        Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getAssetType).ifPresent(descriptor::setAssetType);
        Optional.ofNullable(shell.getAssetInformation()).map(AssetInformation::getGlobalAssetId).ifPresent(descriptor::setGlobalAssetId);
        return descriptor;
    }

    public static SubmodelDescriptor toSubmodelRopositoryDescriptor(Submodel sm, List<String> hrefs) {
        return toDescriptor(sm, hrefs, true);
    }

    public static SubmodelDescriptor toSubmodelServiceDescriptor(Submodel sm, List<String> hrefs) {
        return toDescriptor(sm, hrefs, false);
    }

    public static SubmodelDescriptor toDescriptor(Submodel sm, List<String> hrefs, boolean hostedOnRepository) {
        SubmodelDescriptor descriptor = new DefaultSubmodelDescriptor();
        Optional.ofNullable(sm.getId()).ifPresent(descriptor::setId);
        Optional.ofNullable(sm.getIdShort()).ifPresent(descriptor::setIdShort);
        if (hostedOnRepository)
            Optional.of(getEndpoints(hrefs, sm.getId())).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
        else
            Optional.of(getEndpoints(hrefs)).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setEndpoints);
        Optional.ofNullable(sm.getDescription()).ifPresent(sm::setDescription);
        Optional.ofNullable(sm.getDisplayName()).ifPresent(sm::setDisplayName);
        Optional.ofNullable(sm.getExtensions()).ifPresent(sm::setExtensions);
        Optional.ofNullable(sm.getAdministration()).ifPresent(sm::setAdministration);
        Optional.ofNullable(sm.getSemanticId()).ifPresent(sm::setSemanticId);
        Optional.ofNullable(sm.getSupplementalSemanticIds()).filter(Predicate.not(List::isEmpty)).ifPresent(descriptor::setSupplementalSemanticId);
        return descriptor;
    }

    private static List<Endpoint> getEndpoints(List<String> hrefs) {
        List<Endpoint> endpoints = new LinkedList<>();
        for (String eachUrl : hrefs) {
            Endpoint ep = createEndpointItem(eachUrl);
            endpoints.add(ep);
        }
        return endpoints;
    }

    private static List<Endpoint> getEndpoints(List<String> hrefs, String id) {
        List<Endpoint> endpoints = new LinkedList<>();
        for (String eachUrl : hrefs) {
            Endpoint ep = createEndpointItem(eachUrl, id);
            endpoints.add(ep);
        }
        return endpoints;
    }

    private static Endpoint createEndpointItem(String url) {
        Endpoint endpoint = new DefaultEndpoint();
        endpoint.set_interface(AAS_INTERFACE);
        ProtocolInformation protocolInformation = createProtocolInformation(url);
        endpoint.setProtocolInformation(protocolInformation);
        return endpoint;
    }

    private static Endpoint createEndpointItem(String url, String id) {
        Endpoint endpoint = new DefaultEndpoint();
        endpoint.set_interface(AAS_INTERFACE);
        ProtocolInformation protocolInformation = createProtocolInformation(url, id);
        endpoint.setProtocolInformation(protocolInformation);
        return endpoint;
    }

    private static ProtocolInformation createProtocolInformation(String url) {
        ProtocolInformation protocolInformation = new DefaultProtocolInformation();
        protocolInformation.setEndpointProtocol(getProtocol(url));
        protocolInformation.setHref(url);
        return protocolInformation;
    }

    private static ProtocolInformation createProtocolInformation(String url, String id) {
        String href = url + "/" + ApiClient.base64UrlEncode(id);
        ProtocolInformation protocolInformation = new DefaultProtocolInformation();
        protocolInformation.setEndpointProtocol(getProtocol(url));
        protocolInformation.setHref(url);
        return protocolInformation;
    }

    private static String getProtocol(String endpoint) {
        try {
            return new URL(endpoint).getProtocol();
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

}
