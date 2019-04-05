package br.com.techis.simcardintegrator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Douglas Souza on 05/04/2019
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SIMCard {
    private String cellNumber;
    private String iccid;
    private String mobileOperator;

    public SIMCard(String cellNumber, String iccid) {
        this.cellNumber = cellNumber;
        this.iccid = iccid;
        this.mobileOperator = "Oi";
    }
}