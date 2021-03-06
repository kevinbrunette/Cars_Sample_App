/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supercars.rest;

import com.supercars.preferences.Preference;
import com.supercars.preferences.PreferenceException;
import com.supercars.preferences.PreferenceManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tom.batchelor
 */
@Path("/preferences")
public class PreferenceService {
    
    private final static Logger logger = Logger.getLogger(PreferenceService.class.getName());
    
    @Path("/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Preference> getAllPreferences() {
        List<Preference> preferences = null;
        try {
            preferences = PreferenceManager.getAllPreferences(false);
        } catch (PreferenceException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        
        return preferences;
    }
    
    @Path("/all")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveAllPreferences(List<Preference> preferences) {
        try {
            PreferenceManager.setPreferences(preferences);
        } catch (PreferenceException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    @Path("")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void savePreference(Preference preference) {
        try {
            PreferenceManager.updatePreference(preference);
        } catch (PreferenceException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
}
