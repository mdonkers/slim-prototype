package nl.codecentric.pissalot.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

/**
 * Hylke Stapersma (codecentric nl)
 * hylke.stapersma@codecentric.nl
 */
@Getter
@Setter
public class Measurement {
    private User user;
    private Bowl bowl;
    private Calendar start, end;
}
