package com.ussco.xref.listeners;

import java.util.Iterator;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class SetFocusListener implements PhaseListener {

   	private static final long serialVersionUID = -8724745775308614316L;

    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

     public void beforePhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        String focus = null;
        StringBuilder highlight = new StringBuilder();

        // Iterate over all client ID's with messages.
        Iterator<String> clientIdsWithMessages = facesContext.getClientIdsWithMessages();
        while (clientIdsWithMessages.hasNext()) {
            String clientIdWithMessages = clientIdsWithMessages.next();
     
            if (focus == null) {
                focus = clientIdWithMessages;
            }
            
            highlight.append(clientIdWithMessages);
            
            if (clientIdsWithMessages.hasNext()) {
                highlight.append(",");
            }
            
        }

        // Set ${focus} and ${highlight} in JSP.
        facesContext.getExternalContext().getRequestMap().put("focus", focus);
        facesContext.getExternalContext().getRequestMap().put("highlight", highlight.toString());
        
    }

    public void afterPhase(PhaseEvent event) {
        //Do nothing.
    }

}