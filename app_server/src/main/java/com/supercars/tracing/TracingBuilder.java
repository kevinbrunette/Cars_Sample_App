/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercars.tracing;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tombatchelor
 */
public class TracingBuilder {

    private static final TracingBuilder traceBuilder = new TracingBuilder();

    private TracingBuilder() {
        
        // No Op
    }

    private static String getZipkinEndpoint() {
        String zipkinEndpoint = System.getenv("ZIPKIN_ENDPOINT");
        if (zipkinEndpoint == null) {
            zipkinEndpoint = "http://localhost:9411/";
        }
        return zipkinEndpoint + "api/v2/spans";
    }

    public static TracingBuilder getInstance() {
        return traceBuilder;
    }

    /*
    public Tracing getTracing(String serviceName) {
        return null;
    }
*/
}
