package com.example.demofinnhub.model.dto.web.req;

import com.example.demofinnhub.annotation.SymbolCheck;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SymbolDTO {
  
  @SymbolCheck
  String symbol;

}
