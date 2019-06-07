package com.janaldous.codekata.businessrules.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PhysicalOrder extends Order {

	protected PhysicalOrderType type;

}
