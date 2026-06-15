package com.marombit.exception;

import com.marombit.model.Plano;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PlanoNotFoundException extends RuntimeException {
    public PlanoNotFoundException(String planoInformado) {
        super("Plano inválido:"+planoInformado+". Os planos disponíveis são: "+ Arrays
                .stream(Plano.values())
                .map(plano -> plano.name())
                .collect(Collectors.joining(", ")));
    }
}
