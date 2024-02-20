package ua.hillel.stolitnii.glovo.rest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

@Mapper
public interface OrderMapper {

    @Mappings({
            @Mapping(source = "id", target = "orderId"),
            @Mapping(source = "date", target = "orderDate"),
            @Mapping(source = "cost", target = "orderCost"),

    })
    SpringDataJaxb.OrderDto orderToOrderDto(Order order);
}
