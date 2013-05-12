package nl.codecentric.pissalot.core.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Calendar;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
@Getter
@Setter
@ToString(of = {"displayName"},includeFieldNames = false)
public class User {
    private String email,displayName;
    private Calendar created, updated;
}
