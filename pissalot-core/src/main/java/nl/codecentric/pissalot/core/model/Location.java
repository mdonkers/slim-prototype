package nl.codecentric.pissalot.core.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
@Getter
@Setter
public class Location {
    private String name;
    private Address locationAddress,billingAddress;
    private boolean enabled;
}
