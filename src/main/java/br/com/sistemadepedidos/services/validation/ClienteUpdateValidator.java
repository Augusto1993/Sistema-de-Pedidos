/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemadepedidos.services.validation;

import br.com.sistemadepedidos.domain.Cliente;
import br.com.sistemadepedidos.dto.ClienteDTO;
import br.com.sistemadepedidos.repositories.ClienteRepository;
import br.com.sistemadepedidos.resources.exception.FieldMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

/**
 *
 * @author Grazziano Fagundes
 */
public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {
    
    @Autowired
    private HttpServletRequest request;
    
    @Autowired
    private ClienteRepository repo;
    
    @Override
    public void initialize(ClienteUpdate ann) {
    }
    
    @Override
    public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
        
        @SuppressWarnings("unchecked")
        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));
        
        List<FieldMessage> list = new ArrayList<>();
        
        Cliente aux = repo.findByEmail(objDto.getEmail());
        if (aux != null && !aux.getId().equals(uriId)) {
            list.add(new FieldMessage("email", "E-mail já existente"));
        }
        
        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
