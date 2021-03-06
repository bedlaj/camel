/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.robotframework;

import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
public class RobotFrameworkEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":resourceUri";

    private static final Set<String> PROPERTY_NAMES;
    static {
        Set<String> set = new HashSet<>(71);
        set.add("resourceUri");
        set.add("allowContextMapAll");
        set.add("allowTemplateFromHeader");
        set.add("argumentFile");
        set.add("combinedTagStats");
        set.add("contentCache");
        set.add("criticalTags");
        set.add("debugFile");
        set.add("document");
        set.add("dryrun");
        set.add("excludes");
        set.add("exitOnFailure");
        set.add("includes");
        set.add("listener");
        set.add("listeners");
        set.add("log");
        set.add("logLevel");
        set.add("logTitle");
        set.add("metadata");
        set.add("monitorColors");
        set.add("monitorWidth");
        set.add("name");
        set.add("nonCriticalTags");
        set.add("noStatusReturnCode");
        set.add("output");
        set.add("outputDirectory");
        set.add("randomize");
        set.add("report");
        set.add("reportBackground");
        set.add("reportTitle");
        set.add("runEmptySuite");
        set.add("runFailed");
        set.add("runMode");
        set.add("skipTeardownOnExit");
        set.add("splitOutputs");
        set.add("suites");
        set.add("suiteStatLevel");
        set.add("summaryTitle");
        set.add("tagDocs");
        set.add("tags");
        set.add("tagStatExcludes");
        set.add("tagStatIncludes");
        set.add("tagStatLinks");
        set.add("tests");
        set.add("timestampOutputs");
        set.add("variableFiles");
        set.add("variables");
        set.add("warnOnSkippedFiles");
        set.add("xunitFile");
        set.add("bridgeErrorHandler");
        set.add("sendEmptyMessageWhenIdle");
        set.add("exceptionHandler");
        set.add("exchangePattern");
        set.add("pollStrategy");
        set.add("lazyStartProducer");
        set.add("basicPropertyBinding");
        set.add("synchronous");
        set.add("backoffErrorThreshold");
        set.add("backoffIdleThreshold");
        set.add("backoffMultiplier");
        set.add("delay");
        set.add("greedy");
        set.add("initialDelay");
        set.add("repeatCount");
        set.add("runLoggingLevel");
        set.add("scheduledExecutorService");
        set.add("scheduler");
        set.add("schedulerProperties");
        set.add("startScheduler");
        set.add("timeUnit");
        set.add("useFixedDelay");
        PROPERTY_NAMES = set;
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "robotframework".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "resourceUri", null, true, copy);
        uri = buildQueryParameters(uri, copy);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public boolean isLenientProperties() {
        return false;
    }
}

