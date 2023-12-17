package com.project.tcarshop.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.tcarshop.dto.AccessoryDto;
import com.project.tcarshop.exception.ResourceNotFoundException;
import com.project.tcarshop.form.AccessoryCreateForm;
import com.project.tcarshop.form.AccessoryUpdateForm;


public interface IAccessoryService {
    Page<AccessoryDto> findAll(Pageable pageable);

    AccessoryDto create(AccessoryCreateForm form);

    AccessoryDto update(Long id, AccessoryUpdateForm form) throws ResourceNotFoundException;

    void deleteById(Long id);
}