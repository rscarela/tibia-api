package org.rscarela.tibia;

/**
 * Created by rscarela on 7/7/17.
 */
public class TibiaConnectorTimeout {

    private final boolean handleForbiddenStatus;
    private final Long forbiddenStatusDelay;

    public TibiaConnectorTimeout(boolean handleForbiddenStatus, Long forbiddenStatusDelay) {
        this.handleForbiddenStatus = handleForbiddenStatus;
        this.forbiddenStatusDelay = forbiddenStatusDelay;
    }

    public boolean mustHandleForbiddenStatus() {
        return handleForbiddenStatus;
    }

    public Long getForbiddenStatusDelay() {
        return forbiddenStatusDelay;
    }

}
