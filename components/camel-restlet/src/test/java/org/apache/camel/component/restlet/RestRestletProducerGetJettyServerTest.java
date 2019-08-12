/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.restlet;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.AvailablePortFinder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.StringHelper;
import org.junit.Test;

public class RestRestletProducerGetJettyServerTest extends CamelTestSupport {
    
    @Test
    public void testRestletProducerGet() throws Exception {
        String out = fluentTemplate.withHeader("id", "123").to("direct:start").request(String.class);
        assertEquals("123;Donald Duck", out);
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // find free port
                int port = AvailablePortFinder.getNextAvailable();

                // configure to use restlet on localhost with the given port
                restConfiguration().component("restlet").host("localhost").port(port);

                from("direct:start")
                    .to("rest:get:users/{id}/basic");

                from("jetty:http://localhost:" + port + "/users/?matchOnUriPrefix=true")
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {
                            String id = exchange.getIn().getHeader(Exchange.HTTP_PATH, String.class);
                            id = StringHelper.before(id, "/");
                            exchange.getOut().setBody(id + ";Donald Duck");
                        }
                    });
            }
        };
    }
}
