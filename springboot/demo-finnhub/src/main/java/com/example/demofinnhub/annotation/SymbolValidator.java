package com.example.demofinnhub.annotation;

public class SymbolValidator
    implements ConstraintValidator<SymbolCheck, SymbolReqDTO> {

  @Override
  public boolean isValid(SymbolReqDTO symbol, ConstraintValidatorContext context) {
    return Objects.nonNull(symbol.getSymbol())
        && AppStartRunner.availableStockList.contains(symbol.getSymbol());
  }

}

