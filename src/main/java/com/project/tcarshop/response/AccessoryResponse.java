package com.project.tcarshop.response;

import java.util.List;

import com.project.tcarshop.dto.AccessoryDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessoryResponse {
    private List<AccessoryDto> accessories;
    private long totalAccessories;
}
